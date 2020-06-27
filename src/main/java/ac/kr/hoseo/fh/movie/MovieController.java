package ac.kr.hoseo.fh.movie;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MovieController {
	
	
	@Autowired
	private MovieRepository movieRepo;
	
//	@PostConstruct
//	public void init() {
//		
//	}
	
	@RequestMapping("/")
	public String main(ModelMap mm) {
		mm.put("MovieList", movieRepo.list());
		return "Movie_list";
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
