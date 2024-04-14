package project;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class AdminDemo {
	Scanner in = new Scanner(System.in);	
	Admin admin;
	String type,name,surname,id,login,password;
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
	private void addUser() throws Exception {
		System.out.println("Enter type of User(ORManager,Teacher,Student): ");
		type = in.next();
		System.out.println("Enter name of User: ");
		name = in.next();
		System.out.println("Enter surname of User: ");
		surname = in.next();
		System.out.println(" Generated id for " + name +" is: "+ type.charAt(0)+name.charAt(0)+"77");
		id = type.charAt(0)+name.charAt(0)+"77";
		System.out.println(" Generated login for " + name +" is: "+ name.toLowerCase().charAt(0)+"_"+surname.toLowerCase()+"@kbtu.kz");
		login = name.toLowerCase().charAt(0)+"_"+surname.toLowerCase()+"@kbtu.kz";
		System.out.println("Enter password  of User: ");
		password = in.next();
		if(admin.addUser( type, name, surname, id, password, login)) {
			System.out.println("User added! ");
			save();
		}
		else {
			System.out.println("This login and password already exist!\nPlease try again...");
		}
	}
	private void deleteUser() throws Exception {
		System.out.println("Enter login of User");
		String login = in.next();
		if (admin.deleteUser(login)) {
			System.out.println("User deleted");
			save();
		}
		else {
			System.out.println("Such user does not exists");
		}
	}
    public void setAdmin(Admin admin) {
    	this.admin = admin;
    }
    private void printAllUser() {
		for(User u:Data.getData().users) {
			System.out.println(u);
		}
		
	}
	public void run(Admin admin) throws Exception {
		setAdmin(admin);
		try {
			System.out.println("Welcome!");
			menu : while(true){
				System.out.println("What do you want to do?\n 1) Add User \n 2) Delete User\n 3) View all users \n 4) Exit");
				int choice = in.nextInt();
				if(choice==1){
					addUser: while(true){
						addUser();
						System.out.println("\n 1) Add another User  \n 2) Return back \n 3) Exit");
						choice = in.nextInt();
						if(choice==1) continue addUser;
						if(choice==2) continue menu;
						if(choice==3) {exit(); break menu;}
						break;
					}
				}
				else if (choice==2){
					deleteUser: while(true){
						deleteUser();
						System.out.println("\n 1) Delete User  \n 2) Return back \n 3) Exit");
						choice = in.nextInt();
						if(choice==1) continue deleteUser;
						if(choice==2) continue menu;
						if(choice==3) {exit();  break menu;}
						break;
					}
				}
				else if (choice ==3) {
					viewUser: while(true){
						printAllUser();
						System.out.println("\n 1) Return back \n 2) Exit");
						choice = in.nextInt();
						if(choice==1) continue menu;
						if(choice==2) {exit();  break menu;}
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