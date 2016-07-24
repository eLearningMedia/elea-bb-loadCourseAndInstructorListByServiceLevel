package es.elearningmedia.loadcourseandinstructorlistbyservicelevel;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import blackboard.data.BbAttribute;
import blackboard.data.BbAttributes;
import blackboard.data.course.Course;
import blackboard.data.course.CourseMembership;
import blackboard.data.user.User;
import blackboard.persist.Id;
import blackboard.persist.PersistenceException;
import blackboard.persist.course.CourseDbLoader;
import blackboard.persist.course.CourseMembershipDbLoader;

@Service
public class BbService {
	
	public List<String> getInstructorsWithCourse(String courseId) {
		
		List<String> result = new ArrayList<String>();
		
		try {
			List<Course> courses = CourseDbLoader.Default.getInstance().loadCourseAndInstructorListByServiceLevel(Course.ServiceLevel.FULL);
			
			for(Course course:courses) {
				if(course.getId().getExternalString().equalsIgnoreCase(courseId)) {
					BbAttributes attributes = course.getBbAttributes();  
					BbAttribute attrList = attributes.getBbAttribute("Instructors");  
					List<User> instructors = (List<User>) attrList.getValue();
					for(User instructor:instructors) {
						result.add(instructor.getUserName());
					}
				}
			}
			
		} catch (PersistenceException e) {
			e.printStackTrace();
		}  
		
		return result;
	}

	public List<String> getInstructorsWithMembership(String courseId) {

		List<String> result = new ArrayList<String>();
		
		try {
			List<CourseMembership> memberships = CourseMembershipDbLoader.Default.getInstance().loadByCourseIdAndInstructorFlag(Id.generateId(Course.DATA_TYPE, Long.parseLong(courseId.split("_")[1])), null, true);
			
			for(CourseMembership membership:memberships) {
				result.add(membership.getUser().getUserName());
			}
		} catch (NumberFormatException | PersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

}
