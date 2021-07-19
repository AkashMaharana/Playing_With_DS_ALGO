package com.netcracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
	Implement the closest manager function with adding the employees to an appropriate DS
	
	Bill -> Dom, Samir, Michael
	Dom -> Bob, Peter, Porter
	Peter -> Milton, Nina
	
	Sample Data:
	CEO Bill has 3 employees reporting to him: {Dom, Samir, Michael}
	Dom has three reports { Peter, Bob, Porter}
	Samir has no reports {}
	Michael has no reports {}
	Peter has 2 reports {Milton, Nina}
	Bob has no reports {}
	Porter has no reports {}
	Milton has no reports {}
	Nina has no reports {}
	
	Sample calls:
	closestCommonManager(Milton, Nina) = Peter
	closestCommonManager(Nina, Porter) = Dom
	closestCommonManager(Nina, Samir) = Bill
	closestCommonManager(Peter, Nina) = Peter
	
	This question is similar to lowest common ancestor in binary tree
	
*/

public class ClosetManagerOfTwoEmployees {

	public static void main(String[] args) {
		Employee1 samir = new Employee1("samir");
		Employee1 dom = new Employee1("dom");
		Employee1 michael = new Employee1("michael");
		Employee1 peter = new Employee1("peter");
		Employee1 porter = new Employee1("porter");
		Employee1 bob = new Employee1("bob");
		Employee1 milton = new Employee1("milton");
		Employee1 nina = new Employee1("nina");
		Employee1 bill = new Employee1("bill");

		dom.addReporters(bob);
		dom.addReporters(peter);
		dom.addReporters(porter);

		peter.addReporters(milton);
		peter.addReporters(nina);

		bill.addReporters(dom);
		bill.addReporters(samir);
		bill.addReporters(michael);

		System.out.println("ClosestCommonManager(milton, nina) : " + closestCommonManager(milton, nina));
		System.out.println("ClosestCommonManager(nina, porter) : " + closestCommonManager(nina, porter));
		System.out.println("ClosestCommonManager(nina, samir) : " + closestCommonManager(nina, samir));
		System.out.println("ClosestCommonManager(peter, milton) : " + closestCommonManager(peter, milton));

		printEmployeeDetails(bill);
	}

	private static String closestCommonManager(Employee1 emp1, Employee1 emp2) {
		Stack<Employee1> stack1 = new Stack<>();
		Stack<Employee1> stack2 = new Stack<>();
		while (emp1 != null || emp2 != null) {
			if (emp1 != null) {
				stack1.push(emp1);
				emp1 = emp1.manager;
			}
			if (emp2 != null) {
				stack2.push(emp2);
				emp2 = emp2.manager;
			}
		}
		while (!stack1.isEmpty() && !stack2.isEmpty()) {
			if (stack1.peek() != stack2.peek()) {
				break;
			}
			emp1 = stack1.pop();
			stack2.pop();
		}
		return emp1.name;
	}

	private static void printEmployeeDetails(Employee1 emp) {
		System.out.println("Employee name : " + emp.name);
		if (emp.manager != null) {
			System.out.println("Manager name : " + emp.manager.name);
		}
		System.out.println("Reporters : " + emp.reporters);
		for (Employee1 report : emp.reporters) {
			System.out.println();
			printEmployeeDetails(report);
		}

	}

}

class Employee1 {
	String name;
	List<Employee1> reporters;
	Employee1 manager;

	public Employee1(String name) {
		this.name = name;
		this.reporters = new ArrayList<>();
	}

	public void setManager(Employee1 manager) {
		this.manager = manager;
	}

	public void addReporters(Employee1 employee) {
		this.reporters.add(employee);
		employee.manager = this;
	}

	@Override
	public String toString() {
		return this.name;
	}

}
