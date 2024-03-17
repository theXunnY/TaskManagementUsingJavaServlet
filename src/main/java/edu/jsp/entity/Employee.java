package edu.jsp.entity;
import edu.jsp.entity.*;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private int age;	
	private LocalDate DoJ;
	private double salary;
	
	@ManyToMany
	@JoinTable(joinColumns = @JoinColumn(name="emp_Id"), inverseJoinColumns = @JoinColumn(name = "task_Id"))
	private List<Task>tasks;


	
	public int getId() {
		return id;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public LocalDate getDoJ() {
		return DoJ;
	}

	public void setDoJ(LocalDate doJ) {
		DoJ = doJ;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}



	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
