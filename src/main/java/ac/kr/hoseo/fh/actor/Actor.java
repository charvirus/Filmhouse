package ac.kr.hoseo.fh.actor;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import ac.kr.hoseo.fh.movie.Movie;
import ac.kr.hoseo.fh.reviewForum.ReviewForum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Actor {
	@Id
	@GeneratedValue(generator = "gen_review", strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "Movie")
	private String movie;
	
	
	
	
}
