package project;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

public abstract class User implements Serializable {
	private static final long serialVersionUID = 823900426191773105L;
	public String name, surname;
	private String id, login, password, hashPassword;

	// constructors:
	public User() {

	}

	public User(String name, String surname, String id) {
		this.name = name;
		this.surname = surname;
		this.id = id;
	}

	public User(String name, String surname, String id, String login, String password) {
		this(name, surname, id);
		this.login = login;
		this.hashPassword = hashFunc(password);
	}

	public User(String login2, String password2) {
		this.login = login2;
		this.hashPassword = hashFunc(password2);
	}

	// default methods :
	public static User enterSystem(String login_, String password_) throws InvalidPasswordException {
		String hashp = hashFunc(password_);
		for (User u : Data.getData().users) {
			try {
			if (u.getHashPassword().equals(hashp) && u.login.equals(login_))
				return u;
			else {
				throw new InvalidPasswordException("Password is invalid");
			}
			}
			catch(InvalidPasswordException e) {
				System.out.println("Invalid login or Password,please repeat again");
			}
		}
		return null;
	}

	public void outSystem() {

	}

	// getters and setters:
	public String getHashPassword() {
		return hashPassword;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int hashCode() {
		return Objects.hash(id, login, name, password, surname);
	}

	static String hashFunc(String password) {
		String generatedPassword = null;
		try {
			// Create MessageDigest instance for MD5
			MessageDigest md = MessageDigest.getInstance("MD5");

			// Add password bytes to digest
			md.update(password.getBytes());

			// Get the hash's bytes
			byte[] bytes = md.digest();

			// This bytes[] has bytes in decimal format. Convert it to hexadecimal format
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}

			// Get complete hashed password in hex format
			generatedPassword = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return generatedPassword;

	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id) && Objects.equals(login, other.login) && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password) && Objects.equals(surname, other.surname);
	}

	public String toString() {
		return "User:  name=" + name + ", surname=" + surname + ", id=" + id + ", login=" + login + " ";
	}
}
