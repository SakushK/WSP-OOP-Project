package project;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class StudentDemo {
	Scanner in = new Scanner(System.in);
	Student student;
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
	private void viewCourseMarks() {
        for(Course c : student.courses.keySet()) {
        	System.out.println(c.name + "  " +  student.courses.get(c));
        }
	}
	private void regToCourse( Course course) {
           if(student.addCourse(course)) System.out.println("Register was succesful");
           else {
        	   System.out.println("Please try again");
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
	
	public void run(Student s) throws Exception {
		student = s;
		try {
			System.out.println("Welcome!");
			menu : while(true){
				System.out.println("What do you want to do?\n1)View course-marks\n2)Registration for a Course\n3)Exit");
				int choice = in.nextInt();
				if(choice==1){
					while(true){
						viewCourseMarks();
						System.out.println("1)Return back \n2) Exit");
						choice = in.nextInt();
						if(choice==1) continue menu;
						if(choice==2) {exit(); break menu;}
						break;
					}
				}
				else if (choice==2){
					registr: while(true){
						System.out.println("Choose course to which you want to register: (Enter number)");
						if(!showCourses()) continue menu;
						Course course = Data.getData().courses.get(in.nextInt()-1);
						regToCourse(course);
						System.out.println("\n1)Registrate to another course  \n2) Return back \n3) Exit");
						choice = in.nextInt();
						if(choice==1) continue registr;
						if(choice==2) continue menu;
						if(choice==3) {exit();  break menu;}
						break;
					}
				}
				else if (choice==3){
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