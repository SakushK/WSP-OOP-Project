package project;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class ORManagerDemo {
	Scanner in = new Scanner(System.in);
	ORManager orManager;
	private void printList(List list) {
		for(int i=0; i<list.size(); i++)
			System.out.println(i+1+ ")" +list.get(i));
	}

	private void save() throws Exception {
		Data.saveData();;
	}
	private void exit() throws Exception {
		System.out.println("Bye bye");
		try {
			save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean showCourses(){
		if(Data.getData().courses.isEmpty()) {
			System.out.println("No courses yet...");
			return false;
		}
		printList(Data.getData().courses);
		return true;
	}
	
	public boolean showStudents(){
		if(Data.getData().students.isEmpty()) {
			System.out.println("No students yet...Try adding one");
			return false;
		}
		printList(Data.getData().students);
		return true;
	}
	
	public boolean showTeachers(){
		if(Data.getData().teachers.isEmpty()) {
			System.out.println("No teachers yet...Try adding one");
			return false;
		}
		printList(Data.getData().teachers);
		return true;
	}
	private void addCourseToTeacher(Teacher t) {
		int i = in.nextInt()-1;
		Course c = Data.getData().courses.get(i);
		if(orManager.addCourseToTeacher(t,c)) {
			System.out.println("Course "+Data.getData().courses.get(i) +" added to  "+t.name);	
		}
		else System.out.println("Teacher " + t.name+ " already have this course "+c);
	}
	
	private void addCourse() {
//		System.out.println("Enter faculty name");
//		String fac=in.next();
		System.out.println("Enter name of the course: ");
		String name = in.next();
        if (orManager.addCourse(new Course(name))) {
    		System.out.println("Course added! ");		
        }
        else {
		    System.out.println("Course already exists  ");
		}		
	}
	
	public void run(ORManager orManager) throws Exception {
		this.orManager = orManager;
		try {
			System.out.println("Welcome!");
			menu : while(true){
				System.out.println("What do you want to do?\n1) Add course  \n2)View students \n3) Assign course to a teacher \n4)Exit");
				int choice = in.nextInt();
				if(choice==1){
					addCourse: while(true){
						addCourse();
						System.out.println("\n 1) Add another course\n 2) Return back \n 3) Exit");
						choice = in.nextInt();
						if(choice==1) continue addCourse;
						if(choice==2) continue menu;
						if(choice==3) {exit(); break menu;}
						break;
					}
				}
				else if (choice==2){
				   while(true){
						showStudents();
						System.out.println("1) Return back \n2) Exit");
						choice = in.nextInt();
						if(choice==1) continue menu;
						if(choice==2) {exit();  break menu;}
						break;
					}
				}
				else if (choice==3){
					addCourseToTeacher: while(true){
						System.out.println("Choose teacher to which you want to add course: (Enter number)");
						if(!showTeachers()) continue menu;
						Teacher t = Data.getData().teachers.get(in.nextInt()-1);
						System.out.println("Choose course: (Enter number)");
						if(!showCourses()) continue menu;
						addCourseToTeacher(t);
						System.out.println("\n 1) Add another course to some teacher  \n 2) Return back \n 3) Exit");
						choice = in.nextInt();
						if(choice==1) continue addCourseToTeacher;
						if(choice==2) continue menu;
						if(choice==3) {exit(); break menu;}
						break;
					}
				}
				else if (choice==4){
					exit();
					break menu;
				}
			}
		} catch (Exception e) {
			System.out.println("Something bad happened... \n Saving resources...");
			e.printStackTrace();
			save();
		}
	}

}
