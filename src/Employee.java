
public class Employee {
	@ChangeId(value="empno")
	private int id;
	
	@ChangeId(value="empName")
	private String name;
	
	@ChangeId(value="empSalary")
	private int salary;
	
	public Employee() {
		
		this.name = "";
        this.id = 0;
        //this.designation = "";
        this.salary = 0;
	}

	//@ChangeId(value="empDesignation")
	private String designation;


	public Employee(int id, String name, int salary, String designation) {
		
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.designation = designation;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", designation=" + designation + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

}
