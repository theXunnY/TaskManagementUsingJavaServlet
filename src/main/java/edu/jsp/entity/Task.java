package edu.jsp.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private int id;
	private String tName;
	private LocalDate startDate;
	private LocalDate endDate;
	
	
	@ManyToMany(mappedBy = "tasks")
	private List<Employee> employees;


	public int getId() {
		return id;
	}



	public String getName() {
		return tName;
	}


	public void settName(String tName) {
		this.tName = tName;
	}


	public LocalDate getStartDate() {
		return startDate;
	}


	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}


	public LocalDate getEndDate() {
		return endDate;
	}


	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}


	public List<Employee> getEmployees() {
		return employees;
	}


	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}



	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}




	
	
	


}
