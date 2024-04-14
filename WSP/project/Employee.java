package project;

import java.util.Objects;

public  class Employee  extends User  {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7217430103422620616L;
	private double salary;
	public Employee() {
        super();
	}
	public Employee( String name,String surname,String id ,String login, String password) {
		super(name,surname,id,login,password);
	}
	public Employee( String name,String surname,String id ,String login, String password,  double salary) {
		super(name,surname,id,login,password);
		this.salary = salary;
	}
	public Employee(String login, String password) {
		super(login,password);
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(salary);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(!super.equals(obj)) {
			return false;
		}
		Employee other = (Employee) obj;
		return Double.doubleToLongBits(salary) == Double.doubleToLongBits(other.salary);
	}

	@Override
	public String toString() {
		return super.toString()+  "salary=" + salary + " ";
	}


}
