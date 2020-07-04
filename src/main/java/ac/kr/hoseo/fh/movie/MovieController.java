package ac.kr.hoseo.fh.movie;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ac.kr.hoseo.fh.actor.Actor;
import ac.kr.hoseo.fh.actor.ActorRepository;
import ac.kr.hoseo.fh.reviewForum.ReviewForum;
import ac.kr.hoseo.fh.reviewForum.ReviewForumRepository;

@Controller
public class MovieController {
	
	
	@Autowired
	private MovieRepository movieRepo;
	@Autowired
	private ActorRepository actorRepo;
	@Autowired
	private ReviewForumRepository reviewRepo;
	@PostConstruct
	public void init() {
		Movie m = Movie.builder()
				.name("포드 V 페라리")
				.posterUrl("https://movie-phinf.pstatic.net/20191204_91/15754257752042kHvB_JPEG/movie_image.jpg")
				.releaseDate(new Date())
				.madeCon("미국")
				.genre("드라마")
				.runtime(152)
				.director("James Mangold")
				.mainActor("Matt Damon")
				.build();		
		movieRepo.save(m);
		
		Actor a1 = Actor.builder()
				.name("Matt Damon")
				.build();

		
		a1.setMovie(movieRepo.findByNameContains("포드 V 페라리",PageRequest.of(0, 3)).get(0));
		actorRepo.save(a1);
		
		
		ReviewForum r1 = ReviewForum.builder()
				.id(1)
				.title("포드 V 페라리 감상평")
				.writerName("차 덕후")
				.date(new Date())
				.content("포드 V 페라리 정말 재밌게 봤습니다. 나중에 극장가서 한번 더 볼 예정!")
				.build();
				reviewRepo.save(r1);
	}
	
	@RequestMapping("/")
	public String main(ModelMap mm) {
		mm.put("movieList", movieRepo.findAll());
		return "movie_list";
	}
	
	@RequestMapping("/movie_list")
	public String gomList(ModelMap mm) {
		mm.put("movieList", movieRepo.findAll());
		return "movie_list";
	}

	
	@RequestMapping(path="/movie_add",method=RequestMethod.GET)
	public String addForm(Movie movie) {
		return "movie_add";
	}
	
	@RequestMapping(path="/movie_add",method=RequestMethod.POST)
	public String add(Movie movie) {
		movieRepo.save(movie);
		return "redirect:/";
	}
}
