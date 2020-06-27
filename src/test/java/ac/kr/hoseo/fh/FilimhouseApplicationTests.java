package ac.kr.hoseo.fh;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import ac.kr.hoseo.fh.actor.Actor;
import ac.kr.hoseo.fh.actor.ActorRepository;
import ac.kr.hoseo.fh.movie.*;
import ac.kr.hoseo.fh.reviewForum.*;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class FilimhouseApplicationTests {

	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private ReviewForumRepository reviewforumRepository;
	
	@Autowired
	private ActorRepository actorRepository;
	@Test
	void contextLoads() {
		
		Movie m1 = Movie.builder()
		.name("포드 V 페라리")
		.posterUrl("https://movie-phinf.pstatic.net/20191204_91/15754257752042kHvB_JPEG/movie_image.jpg")
		.releaseDate(new Date())
		.madeCon("미국")
		.genre("Action, Drama")
		.runtime(152)
		.director("James Mangold")
		.mainActor("Matt Damon")
		.build();		
		movieRepository.save(m1);		
		assertEquals(1, movieRepository.count());
		
		
		ReviewForum r1 = ReviewForum.builder()
		.id(1)
		.title("포드 V 페라리 감상평")
		.writerName("차 덕후")
		.reg_date(new Date())
		.content("포드 V 페라리 정말 재밌게 봤습니다. 나중에 극장가서 한번 더 볼 예정!")
		.build();
		reviewforumRepository.save(r1);
		assertEquals(1, reviewforumRepository.findByTitleIsContaining("포드").size());
		
		
		
		Actor a1 = Actor.builder()
				.id(1)
				.name("Matt Damon")
				.build();

		
		a1.setMovie(movieRepository.findByNameContains("포드 V 페라리",PageRequest.of(0, 3)).get(0));
		actorRepository.save(a1);
		
		
		assertEquals(1,actorRepository.findByNameContains("Matt").size());
		
		
	}

}
