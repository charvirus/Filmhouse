package ac.kr.hoseo.fh;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import ac.kr.hoseo.fh.movie.Movie;
import ac.kr.hoseo.fh.movie.MovieRepository;
import ac.kr.hoseo.fh.reviewForum.ReviewForum;
import ac.kr.hoseo.fh.reviewForum.ReviewForumRepository;

@SpringBootTest
public class filmhousejpatest {
	
	@Autowired
	private MovieRepository movieRepo;
	@Autowired
	private ReviewForumRepository reviewForumRepo;
	
	@BeforeEach()
	public void init() {
		Movie m = Movie.builder()
					.director("Ridley Scott")
					.build();
		
		ReviewForum r = ReviewForum.builder()
				.title("마션 감상평")
				.build();
		movieRepo.save(m);
		reviewForumRepo.save(r);
		//reviewForumRepo.save(new ReviewForum(null,"마션 감상평","감자동자",new Date(),"마션 정말 재밌게 봤습니다. 나중에 극장가서 한번 더 볼 예정!"));
	}
	
	@Test
	public void testFindDirectorByname() {
		assertEquals(1,movieRepo.findByDirector("Ridley Scott",PageRequest.of(0,1)).size());
	}
	
	@Test
	public void testFindforumByname() {
		assertEquals(1,reviewForumRepo.findByTitleIsContaining("마션").size());
	}
}
