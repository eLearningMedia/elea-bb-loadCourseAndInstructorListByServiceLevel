package es.elearningmedia.loadcourseandinstructorlistbyservicelevel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

/**
 * Entry point for the application
 * 
 * @author albertoruiz
 *
 */
@Controller
public class HomeController {

	@Autowired
	BbService bbService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(@RequestParam("course_id") String courseId, Model model) {
		
		List<String> instructorsCourse = bbService.getInstructorsWithCourse(courseId);
		List<String> instructorsMembership = bbService.getInstructorsWithMembership(courseId);

		model.addAttribute("instructors_course", instructorsCourse);
		model.addAttribute("instructors_membership", instructorsMembership);
		model.addAttribute("course_id", courseId);

		return "report";

	}
	
}
