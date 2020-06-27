package ac.kr.hoseo.fh.movie;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import ac.kr.hoseo.fh.actor.Actor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="movie",uniqueConstraints = {
		@UniqueConstraint(name="uc_movie_name",columnNames = {"movie_name"})
})
public class Movie {
	@Id	//id 컬럼을 Primary Key로 선언함
	@GeneratedValue(generator = "gen_movie",strategy = GenerationType.AUTO)
	@Column(length = 10) //컬럼의 길이는 최대 10자
	//영화 아이디
	private Integer id;	
	
	@Column(name ="movie_name",nullable = false)//name은 null값이 들어가면 안됌 	
	//영화 제목
	private String name;	
	
	//영화 포스터
	private String posterUrl;
	
	@Temporal(TemporalType.DATE)
	//개봉일
	private Date releaseDate;	
	//제작국가
	private String madeCon;		
	//장르
	private String genre;		
	//런타임
	private Integer runtime;	
	//영화 감독
	private String director;	
	//영화 배우
	private String mainActor;

	@OneToMany(mappedBy = "movie")
	private List<Actor> castactor;
	
	
	
}
