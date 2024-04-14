package project;

import java.util.HashMap;
import java.util.Objects;

public class Student extends User{
	HashMap<Course,Mark> courses;
	private Faculty fac;
	private StudentType type;
	public int year;
	{
	   courses = new HashMap<Course,Mark>();
	}
	public Student() {
		super();
	}
    public Student (String name,String surname,String id,String login,String password) {
    	super(name,surname,id,login,password);
    }
	public boolean addCourse(Course c){
        courses.put(c, new Mark());
        c.students.add(this);
        return true;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(courses, fac, type, year);
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
		Student other = (Student) obj;
		return Objects.equals(courses, other.courses) && fac == other.fac && type == other.type && year == other.year;
	}
	@Override
	public String toString() {
		return super.toString()+" " + " courses=" + courses + ", fac=" + fac + ", type=" + type + ", year=" + year + "]";
	} 
}
