package project;


import java.io.Serializable;
import java.util.Objects;
import java.util.Vector;

public class Course implements Serializable {
	private int numCredits;
	public String name;
	private String codeOfCourse,description;
	public Faculty faculty;
	Vector<Student> students = new Vector<Student>();
	public Course() {
		
	}
	public Course(String name) {
		super();
		this.name = name;
	} 
	public Course(int numCredits, String name, String codeOfCourse, String description, Faculty faculty) {
		super();
		this.numCredits = numCredits;
		this.name = name;
		this.codeOfCourse = codeOfCourse;
		this.description = description;
		this.faculty = faculty;
	}
	public int getNumCredits() {
		return numCredits;
	}
	public void setNumCredits(int numCredits) {
		this.numCredits = numCredits;
	}
	public String getCodeOfCourse() {
		return codeOfCourse;
	}
	public void setCodeOfCourse(String codeOfCourse) {
		this.codeOfCourse = codeOfCourse;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Course [numCredits=" + numCredits + ", name=" + name + ", codeOfCourse=" + codeOfCourse
				+ ", description=" + description + ", faculty=" + faculty + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(codeOfCourse, description, faculty, name, numCredits);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(codeOfCourse, other.codeOfCourse) && Objects.equals(description, other.description)
				&& faculty == other.faculty && Objects.equals(name, other.name) && numCredits == other.numCredits;
	}
	
}
