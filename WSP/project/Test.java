package project;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Test {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static User login() throws IOException, InvalidPasswordException {	
		System.out.println("Welcome to the page WSP\nPlease write your login and password");
		String login = in.readLine();
		String password = in.readLine();
		return User.enterSystem(login, password);
	}
	
	public static void main(String[] args) throws Exception {
		Data.getData().courses.clear();
		Data.getData().teachers.clear();
		Data.getData().students.clear();

		while(true) {
			User u = login();
//			System.out.println(u);
		try {
			if(u instanceof ORManager) {
				(new ORManagerDemo()).run((ORManager)u);
			}
			if(u instanceof Admin) {
				(new AdminDemo()).run((Admin)u);
			}
			if(u instanceof Student) {
				(new StudentDemo()).run((Student)u);
			}
			if(u instanceof Teacher) {
				(new TeacherDemo()).run((Teacher)u);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		}
	}

}