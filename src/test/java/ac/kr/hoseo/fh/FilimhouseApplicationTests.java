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
		.releaseDate(new Date())
		.madeCon("미국")
		.genre("Action, Drama")
		.runtime(152)
		.director("James Mangold")
		.actor("Matt Damon, Christian Bale")
		.build();
		
		movieRepository.save(m1);
		
		assertEquals(1, movieRepository.count());
		
		
		ReviewForum r1 = ReviewForum.builder()
		.id(1)
		.title("포드 V 페라리 감상평")
		.writerName("맷 데이먼")
		.reg_date(new Date())
		.content("포드 V 페라리 정말 재밌게 봤습니다. 나중에 극장가서 한번 더 볼 예정!")
		.build();
		
		r1.setMovie(movieRepository.findByNameContains("포드", PageRequest.of(0, 3)).get(0));
		reviewforumRepository.save(r1);
		
		Actor a1 = Actor.builder()
				.id(1)
				.name("Matt Damon")
				.build();
//		영화 리포지토리 질문할것, 영화 리포지토리에 있는 내용으로 배우 출연 영화를 추가하고싶음 
//		a1.setMovie(movieRepository.findByActor("포드 V 페라리",PageRequest.of(0, 3)).get(0));
//		actorRepository.save(a1);
//		reviewforumRepository.findAll().forEach(r ->{
//			log.error(r.toString());
//		});
		assertEquals(1, reviewforumRepository.findByTitleIsContaining("포드").size());

	}

}
