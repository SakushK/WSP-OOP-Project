package project;

public class Admin extends Employee {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4605138157314021899L;
	int mode;

//	 {
//	   login = "login_admin01";
//	   password = "password_admin01";
//	 }
	public Admin(String login, String password) {
		super(login, password);
	}

	public boolean deleteUser(String login) {
		for (User u : Data.getData().users) {
			if (u.getLogin().equals(login)) {
				Data.getData().loginPassword.remove(login);
				Data.getData().users.remove(u);
				if (u instanceof Student)
					Data.getData().students.remove((Student) u);
				if (u instanceof Teacher)
					Data.getData().teachers.remove((Teacher) u);
				return true;
			}
		}
		return false;
	}

	public boolean addUser(String type, String name, String surname, String id, String password, String login) {
		String hashPassword = super.hashFunc(password);
		if (type.equals("Student")) {
			Student s1 = new Student(name, surname, id, login, password);
			Data.getData().users.add(s1);
			Data.getData().students.add(s1);
		} else if (type.equals("ORManager")) {
			Data.getData().users.add(new ORManager(name, surname, id, login, password));
		} else if (type.equals("Teacher")) {
			Teacher t1 = new Teacher(name, surname, id, login, password);
			Data.getData().users.add(t1);
			Data.getData().teachers.add(t1);
		} else {
			return false;
		}
		Data.getData().loginPassword.put(login, hashPassword);

		return true;
	}

}
