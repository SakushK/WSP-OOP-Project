package project;


import java.util.Objects;
import java.util.Vector;

public class ORManager extends Employee {
   public ORManager() {
		super();
	}
   public ORManager(String name, String surname, String id, String login, String password) {
		super(name, surname, id, login, password);
	}
   public boolean addCourse(Course c) {
	   if(Data.getData().courses.contains(c)) {
		   return false;
	   }
	   Data.getData().courses.add(c);
	   return true;
   }
   public boolean addCourseToTeacher(Teacher t, Course c) {
	   if(!t.course.contains(c)) {
			t.course.add(c);
            return true;
	   }
	    return false;
   }
}


