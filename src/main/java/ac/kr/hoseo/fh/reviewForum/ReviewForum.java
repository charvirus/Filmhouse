package ac.kr.hoseo.fh.reviewForum;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import ac.kr.hoseo.fh.movie.Movie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString(exclude ="Movie")
public class ReviewForum {
	@Id
	@GeneratedValue(generator = "gen_review", strategy = GenerationType.AUTO)
	//게시글 번호
	private Integer id;
	//게시글 제목
	private String title;
	//작성자 ID
	private String writerName;	
	//작성일(자동입력될것)
	private Date date;	
	//내용
	private String content;	
	
//	//리뷰달은 영화 제목
//	@ManyToOne
//	@JoinColumn()
//	private Movie movie;
}
