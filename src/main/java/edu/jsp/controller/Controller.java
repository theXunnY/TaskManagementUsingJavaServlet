package edu.jsp.controller;

import java.util.Iterator;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpServletResponse;

import edu.jsp.entity.Employee;
import edu.jsp.entity.Task;

public class Controller {

	EntityManagerFactory factory =Persistence.createEntityManagerFactory("empTaskManagement");
	EntityManager manager =factory.createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	
	
	
	public Employee saveEmployee(Employee employee) {
		
		if (employee!=null) {
			transaction.begin();
			manager.persist(employee);
			transaction.commit();
			return employee;
		}
		else {
			return null;
		}
	}
	
	public Task saveTask(Task task) {
		
		if (task!=null) {
			transaction.begin();
			manager.persist(task);
			transaction.commit();
			System.out.println("task saved");
			return task;
		}else {
			System.out.println("task not saved");
			return null;
		}
	}

	public Employee searchEmployee(int id) {
		
		Employee employee=manager.find(Employee.class, id);
		
		if (employee!=null) {
			
			return employee;
		}
		else {
			return null;
		}
		
	}
	
	
	public List<Employee> getAllEmployees(){

		String sql="select s from Employee s";
		Query query=manager.createQuery(sql);
		
		List<Employee> employees=(List<Employee>) query.getResultList();
		 
		if (employees!=null) {
			return employees;
		}else {
		return null;
		}
	}
	
	public List<Task> getAllTasks(){
		String sql="select s from Task s";
		Query query= manager.createQuery(sql);
		List<Task> tasks=(List<Task>)query.getResultList();
		
		if(tasks!=null) {
			return tasks;
		}else {
			return null;
		}
	}
	
	public Employee assignTasks(int tid, int eid) {
		
		Employee employee= manager.find(Employee.class, eid);
		Task task= manager.find(Task.class, tid);
		
		if (employee!=null && task!=null) {
			employee.getTasks().add(task);
			task.getEmployees().add(employee);
			
			transaction.begin();
			manager.merge(employee);
			manager.merge(task);
			transaction.commit();
			return employee;
		}else {
			return null;
		}
		
		
		
		
	} 
	
	public Employee  removeEmployee(int id){
		Employee employee= manager.find(Employee.class, id);
		
		for (Employee employees : getAllEmployees()) {
			if (employee==employees) {
				if (employee!=null) {
					transaction.begin();
					manager.remove(employee);
					transaction.commit();
					 return employee;
				}
				else {
					 System.out.println("employee not found");
				}
			}
		}
		return null;
		
		
	}


	public Employee updateEmployee(Employee employee) {
		if (employee!=null) {
			transaction.begin();
			manager.merge(employee);
			transaction.commit();
			System.out.println("updated");
			return employee;
		}else {
			System.out.println("employee not found");
			return null;
		}
	}

	public Task removeTask(int id) {
		Task task= manager.find(Task.class, id);
		
		if (task!=null) {
			
			for(Employee employee: task.getEmployees()) {
				employee.getTasks().remove(task);
			}
			transaction.begin();
			manager.remove(task);
			transaction.commit();
			System.out.println("Task Removed");
			return task;
		}else {
			System.out.println("Task not found");
			return null;
		}		
	}

	public Task searchTask(int id) {
		Task task =manager.find(Task.class, id);
		if (task!=null) {
			return task;
		}
		else {
			return null;
		}
		
	}
	
}




