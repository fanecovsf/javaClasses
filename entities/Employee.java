package entities;

public class Employee {

	private Integer id;
	private String name;
	private Double salary;
	
	public Employee (Integer id, String name, Double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public Double getSalary() {
		return salary;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	public void increaseSalary(Integer id, Double percentage) {
		this.salary += salary * percentage/100;
	}
	
	public String toString() {
		return id + ", " + name + ", " + String.format("%.2f", salary);
	}

}
