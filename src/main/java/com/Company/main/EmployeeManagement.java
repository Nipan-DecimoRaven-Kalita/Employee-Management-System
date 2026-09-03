package com.Company.main;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.Company.entity.Employee;

public class EmployeeManagement 
{
	
	private static SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.buildSessionFactory();
	
	private static Scanner scan = new Scanner(System.in);
	
    public static void main(String[] args) 
    {
    	
    	while(true) 
    	{
    		System.out.println("EMPLOYEE MANAGEMENT SYSTEM");
    		System.out.println("1. Add Employee");
    		System.out.println("2. View Employee");
    		System.out.println("3. Update Employee");
    		System.out.println("4. Delete Employee");
    		System.out.println("5. Exit");
    		System.out.println("Enter your choice: ");
    		int choice = scan.nextInt();
    		
    		switch(choice) 
    		{
    		case 1:
    		{
    			addEmployee();
    			break; 
    		}
    		case 2:
    		{
    			viewEmployee();
    			break;
    		}
    		case 3:
    		{
    			updateEmployee();
    			break;
    		}
    		case 4:
    		{
    			deleteEmployee();
    			break;
    		}
    		case 5:
    		{
    			System.out.println("Exiting program.");
    			factory.close();
    			return;
    		}
    		default:
    		{
    			System.out.println("Invalid Input! Please, try again.");
    		}
    		}
    	}
    }
    		
    private static void addEmployee() 
    {
    	scan.nextLine();
    	
    	Session session = factory.openSession();
    	Transaction transaction = session.beginTransaction();
    	    	
    	Employee emp = new Employee();
    	System.out.println("Enter the employee Name: ");
    	emp.setName(scan.nextLine());
    	System.out.println("Enter the salary of the employee: ");
    	emp.setSalary(scan.nextDouble());
    	scan.nextLine();
    	System.out.println("Enter the designation of the employee: ");
    	emp.setDesignation(scan.nextLine());
    	System.out.println("Enter the department of the employee: ");
    	emp.setDepartment(scan.nextLine());
    	        
    	session.persist(emp);
    	transaction.commit();
    	session.close();
    	
    	System.out.println("Employee added successfully with ID: " + emp.getId());
    }
    
    private static void viewEmployee() 
    {
    	Session session = factory.openSession();
    	
    	int id = scan.nextInt();
    	Employee emp = session.find(Employee.class, id);
    	session.close();
    	
    	if (emp != null) 
    	{
    	System.out.println("Employee Details: ");
        System.out.println("Employee's Name: " + emp.getName());
        System.out.println("Employee's Designation: " + emp.getDesignation());
        System.out.println("Employee's Salary: " + emp.getSalary());
        System.out.println("Employee's Department: " + emp.getDepartment());
    	} else {
    		System.out.println("Employee not found!");
    	}
    }
    
    private static void updateEmployee() 
    {
    	Session session = factory.openSession();
    	Transaction transaction = session.beginTransaction();
    	
    	System.out.println("Enter Employee ID: ");
    	int id = scan.nextInt();
    	Employee emp = session.find(Employee.class, id);
    	
    	if (emp != null) 
    	{
    		while (true) 
    		{
    		System.out.println("Enter your choice from the following choices:- ");
            System.out.println("If you want to update the Employee's Name, Enter 1.");
            System.out.println("If you want to update the Employee's Designation, Enter 2.");
            System.out.println("If you want to update the Employee's Salary, Enter 3.");
            System.out.println("If you want to update the Employee's Department, Enter 4.");
            System.out.println("If you want dont want to make any changes, Enter 5.");
            
            int choice = scan.nextInt();
            
            switch(choice) 
            {
            case 1: 
				scan.nextLine();
				System.out.println("Enter the Employee's new Name: ");
				emp.setName(scan.nextLine());
				break;
			case 2: 
				scan.nextLine();
				System.out.println("Enter the Employee's new Designation: ");
				emp.setDesignation(scan.nextLine());
				break;
			case 3:
				System.out.println("Enter the Employee's new Salary: ");
				emp.setSalary(scan.nextDouble());
				break;
			case 4:
				scan.nextLine();
				System.out.println("Enter the Employee's new Department: ");
				emp.setDepartment(scan.nextLine());
				break;
			case 5:
				System.out.println("Exiting the Updating Operations...");
				transaction.commit();
				session.close();
				return;
			default: 
				System.out.println("Invalid Option! Please try Again!");
            }
            }
    		
      } else {
    	  System.out.println("Employee not found!");
    	  transaction.rollback();
    	  session.close();
    	  return;
      }
   }
    
    private static void deleteEmployee()
    {
    	Session session = factory.openSession();
    	Transaction transaction = session.beginTransaction();
    	
    	System.out.println("Enter Employee ID: ");
    	int id = scan.nextInt();
    	Employee emp = session.find(Employee.class, id);
    	
		if (emp != null) {
			session.remove(emp);
			transaction.commit();
			System.out.println("Employee deleted succesfully...");
		} else {
			System.out.println("No Employee with that id is found, Operation is terminated!");
			transaction.rollback();
		}
    	session.close();
    }
}
        
    	
