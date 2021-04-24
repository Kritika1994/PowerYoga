package PowerYogaApp.Invigilators;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class InvigilatorController {

	@Autowired
	private InvigilatorService invigilatorService;
	
	@RequestMapping("/invigilator")
	public List<Invigilator> getAllUsers() {
		return invigilatorService.getAllUsers();
		
	}
	
	@RequestMapping("/invigilator/{id}")
	public Invigilator getUser(@PathVariable String id) {
		return invigilatorService.getUser(id);
	}
	
	@RequestMapping(method=RequestMethod.POST , value="/invigilator")
	public void addInvigilator(@RequestBody Invigilator user) {
		invigilatorService.addInvigilator(user);	
	}
	
	@RequestMapping(method=RequestMethod.POST , value="/invigilator/{id}")
	public void updateInvigilator(@RequestBody Invigilator user, @PathVariable String id) {
		invigilatorService.updateInvigilator(user, id);	
	}
	
}
