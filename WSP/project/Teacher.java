package project;

import java.util.Objects;
import java.util.Vector;

public class Teacher extends Employee {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6740572034039557483L;
	TeacherType teacherType;
	Faculty faculty;
	Vector<Course> course = new Vector<Course>();
	public Teacher(){
		
	}
	
	public Teacher(String name, String surname, String id, String login, String password, double salary) {
		super(name, surname, id, login, password, salary);
	}

	public Teacher(String name, String surname, String id, String login, String password) {
		super(name, surname, id, login, password);
	}

	public Teacher(TeacherType teacherType) {
		super();
		this.teacherType = teacherType;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(course, teacherType);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teacher other = (Teacher) obj;
		return Objects.equals(course, other.course) && teacherType == other.teacherType;
	}
	
}
