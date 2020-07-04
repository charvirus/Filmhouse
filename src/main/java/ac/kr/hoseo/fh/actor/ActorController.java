package ac.kr.hoseo.fh.actor;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class ActorController {
	@Autowired
	private ActorRepository actorRepo;
	
	@PostConstruct
	public void init() {
	
	}
	
	
	@RequestMapping("/actor_list")
	public String goaList(ModelMap mm) {
		mm.put("ActorList", actorRepo.findAll());
		return "actor_list";
	}
	
	@RequestMapping(path="/actor_add",method=RequestMethod.GET)
	public String addForm(Actor actor) {
		return "actor_add";
	}
	
	@RequestMapping(path="/actor_add",method=RequestMethod.POST)
	public String add(Actor actor) {
		actorRepo.save(actor);
		return "redirect:/";
	}

}
