package project;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class TeacherDemo {
	Teacher teacher;
	Scanner in = new Scanner(System.in);
	
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
	private void putMark(Student s,Course c) {
		    System.out.println("1)First attestation\n2)Second attestation\n3)Final exam");
		    int i = in.nextInt();
    		if(i == 1) {
    			System.out.println("Enter mark");
    			double mark = in.nextDouble();
    			s.courses.get(c).FirstAtt = mark;
    		}
    		else if(i == 2) {
    			System.out.println("Enter mark");
    			double mark = in.nextDouble();
    			s.courses.get(c).SecondAtt = mark;
    		}
    		else if(i == 3) {
    			System.out.println("Enter mark");
    			double mark = in.nextDouble();
    			s.courses.get(c).FinalExam = mark;
    		}
	}
	public boolean showCourses(){
		if(teacher.course.isEmpty()) {
			System.out.println("No courses yet...");
			return false;
		}
		printList(teacher.course);
		return true;
	}
	public boolean showStudents(Course c){
		if(c.students.isEmpty()) {
			System.out.println("No students yet...");
			return false;
		}
		printList(c.students);
		return true;
	}
	public void run(Teacher t) throws Exception {
		teacher = t;
		try {
			System.out.println("Welcome!");
			menu : while(true){
				System.out.println("What do you want to do?\n 1)Put marks \n 2)View courses \n 3) Exit");
				int choice = in.nextInt();
				if(choice==1){
					putMarks: while(true){
						System.out.println("Choose course to which you want to put marks:(Enter number)");
						if(!showCourses()) continue menu;
						Course c  = teacher.course.get(in.nextInt()-1);
						if(!showStudents(c)) continue menu;
						Student s  = c.students.get(in.nextInt()-1);
						//System.out.println(c.students.get(0).courses.get(c));
						putMark(s,c);
						System.out.println("\n 1) put mark again  \n 2) Return back \n 3) Exit");
						choice = in.nextInt();
						if(choice==1) continue putMarks;
						if(choice==2) continue menu;
						if(choice==3) {exit(); break menu;}
					}
				}
				else if (choice==2){
					addCourse: while(true){
						for(Course c:t.course) {
						    System.out.println(c);
						}
						System.out.println("\n 1)Return back \n 2) Exit");
						choice = in.nextInt();
						if(choice==-1) continue addCourse;
						if(choice==1) continue menu;
						if(choice==2) {exit();  break menu;}
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

