package com.capg.emsapp.ui;


import java.util.List;
import java.util.Scanner;

import com.capg.emsapp.beans.Employee;
import com.capg.emsapp.service.EmployeeServiceImpl;
import com.capg.emsapp.service.IEmployeeService;

public class MainUIClass {
	static Scanner sc;
	IEmployeeService empService;
	
	public MainUIClass() {
		empService = new EmployeeServiceImpl();
		sc = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		MainUIClass obj = new MainUIClass();
		
		
		// menu based program
		
		obj.displayAllEmployee();
		
		while(true) {
			System.out.println("================================Enter the option================================");
			System.out.println("1.Insert employee information : \n2.Display employee details based on salary : \n3.Display employee details based on id : ");
			int op=sc.nextInt();
			switch(op) {
			case 1: 
			obj.insertEmployeeInforamtion();
			obj.displayAllEmployee();
			break;
			
			case 2: obj.DisplayEmpDetailsBasedOnSalary();
			break;
			
			case 3: obj.DisplayEmpDetailsBasedOnID();
			break;
			
			}	
		}	
	}
	
	public void DisplayEmpDetailsBasedOnSalary() {
		System.out.println("Enter the range of salary : ");
		System.out.println("Enter the lower limit : ");
		int r1=sc.nextInt();
		System.out.println("Enter the upper limit : ");
		int r2=sc.nextInt();
		List<Employee>empList=empService.getAllEmployeesBySalary(r1, r2);
		for (Employee employee : empList) {
			displayEmployee(employee);
		}
	}
	
	public void DisplayEmpDetailsBasedOnID() {
		System.out.println("Enter the employee id : ");
		int id=sc.nextInt();
		Employee e=empService.getEmployeeById(id);
		displayEmployee(e);

	}
		
	
	
	public void insertEmployeeInforamtion()
	{
		System.out.println(" \n Enter Employee Information \n");
		System.out.println(" Enter Employee Name : ");
		String empName = sc.next();
		
		System.out.println(" Enter Employee Id : ");
		int id = sc.nextInt();
		
		System.out.println(" Enter Employee Salary : ");
		int salary = sc.nextInt();
		
		System.out.println(" Enter Project  Name : ");
		String projectName = sc.next();
		
		Employee e = new Employee(empName, id, salary, projectName);
		
		try
		{
			boolean isInserted = empService.insertEmployee(e);
			
			// -----
		}
		catch(Exception excep)
		{
			
			System.out.println(" Contact HR "+excep);
		}
		
		
	}
	
	public void displayAllEmployee()
	{
		System.out.println("\n=========== Employees Information ===========\n");
		List<Employee> empList = empService.getAllEmployees();
		
		for (Employee employee : empList) {
			displayEmployee(employee);
		}
	}
	
	public void displayEmployee(Employee e)
	{
		System.out.println(" Name "+e.getEmpName());
		System.out.println(" ID "+e.getId());
		System.out.println(" Salary "+e.getSalary());
		System.out.println("\n---------------------------------------------\n");
		
		
	}

}
