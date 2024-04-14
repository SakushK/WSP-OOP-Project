package project;

import java.io.*;
import java.util.HashMap;
import java.util.Vector;


public final class Data implements Serializable{
	private static final long serialVersionUID = 7235959055955147049L;
	private static Data DATA;
    Vector<User> users;
    Vector<Course> courses;
    Vector<Student> students;
    Vector<Teacher> teachers;
    HashMap<String,String> loginPassword;
	static {
		if(new File("data.out").exists()) {
			try {
				DATA = readData();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else { 
			DATA = new Data();
			DATA.teachers = new Vector<Teacher>();
			DATA.students = new Vector<Student>();
			DATA.courses = new Vector<Course>();
			DATA.users = new Vector<User>();
			DATA.loginPassword = new HashMap<String,String>();
			DATA.users.add(new Admin("login_admin01", "password_admin02"));
			DATA.loginPassword.put("login_admin01", "password_admin02");
		}
	}
	private Data() {

	}
	static Data getData() {
		return DATA;
	}
	static Data readData() throws Exception{
		FileInputStream fis = new FileInputStream("data.out");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Data data = (Data)ois.readObject();
		fis.close();
		ois.close();
		return data;
	}
	static void saveData() throws Exception {
		FileOutputStream fos = new FileOutputStream("data.out");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(DATA);
		fos.close();
		oos.close();
	}
}