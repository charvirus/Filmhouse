package ac.kr.hoseo.fh.reviewForum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReviewController {

	@Autowired
	private ReviewForumRepository reviewRepo;
	
	@RequestMapping("/review_list")
	public String gorList(ModelMap mm) {
		mm.put("ReviewList", reviewRepo.findAll());
		return "review_list";
	}
	
	@RequestMapping(path="/review_add",method=RequestMethod.GET)
	public String addForm(ReviewForum review) {
		return "review_add";
	}
	
	@RequestMapping(path="/review_add",method=RequestMethod.POST)
	public String add(ReviewForum review) {
		reviewRepo.save(review);
		return "redirect:/";
	}
}
