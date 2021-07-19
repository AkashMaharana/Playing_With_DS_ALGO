package com.netcracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
	A company's organizational structure is represented as
	1: 2, 3, 4
	In the above employees with id 2, 3 and 4 report to 1
	Assume the following hierarchy.
	1: 2, 3, 4
	3: 5, 6, 7
	5: 8, 9, 10
	Given an employee Id, return all the employees reporting to him directly or indirectly
*/

public class PrintAllTheDirectAndIndirectReportee {

	public static void main(String[] args) {
		
		//Kirtan(10) -> Akash(1), Chandrama(11), Pranati(3), Arati(4)
		//Chandrama(11) -> Minati(5), Swati(2)
		//Pranati(3) -> Richi(6), Rony(7)
		//Arati(4) -> Janvi(8), Vasudha()9
		
		List<Employee2> employeeList=new ArrayList<>();
		Employee2 emp1=new Employee2("Akash");
		Employee2 emp2=new Employee2("Swati");
		Employee2 emp3=new Employee2("Pranati");
		Employee2 emp4=new Employee2("Arati");
		Employee2 emp5=new Employee2("Minati");
		Employee2 emp6=new Employee2("Richi");
		Employee2 emp7=new Employee2("Rony");
		Employee2 emp8=new Employee2("Janvi");
		Employee2 emp9=new Employee2("Vasudha");
		Employee2 emp10=new Employee2("Kirtan");
		Employee2 emp11=new Employee2("Chandrama");
		
		emp1.addManager(emp10);
		emp11.addManager(emp10);
		emp3.addManager(emp10);
		emp4.addManager(emp10);
		
		emp5.addManager(emp11);
		emp2.addManager(emp11);
		
		emp6.addManager(emp3);
		emp7.addManager(emp3);
		
		emp8.addManager(emp4);
		emp9.addManager(emp4);
		
		employeeList.add(emp1);
		employeeList.add(emp2);
		employeeList.add(emp3);
		employeeList.add(emp4);
		employeeList.add(emp5);
		employeeList.add(emp6);
		employeeList.add(emp7);
		employeeList.add(emp8);
		employeeList.add(emp9);
		employeeList.add(emp10);
		employeeList.add(emp11);
		
		Map<Employee2,List<Employee2>> employeeMap=parseEmployeeData(employeeList);
		
		/*employeeMap.forEach((key,value)->{
			System.out.print(key);
			System.out.print(value);
			System.out.println();
		});*/
		
		printAllSubordinates(employeeMap,emp10);
	}

	private static void printAllSubordinates(Map<Employee2, List<Employee2>> employeeMap, Employee2 emp11) {
		if(!employeeMap.containsKey(emp11)) {
			return;
		}
		List<Employee2> reportersList = employeeMap.get(emp11);
		for(Employee2 emp : reportersList) {
			System.out.print(emp+" ");
			printAllSubordinates(employeeMap,emp);
			
		}
		//System.out.println();
	}

	private static Map<Employee2, List<Employee2>> parseEmployeeData(List<Employee2> employeeList) {
		Map<Employee2,List<Employee2>> employeeMap=new HashMap<>();
		for(Employee2 emp : employeeList) {
			if(!employeeMap.containsKey(emp.manager)) {
				List<Employee2> list=new ArrayList<>();
				list.add(emp);
				employeeMap.put(emp.manager, list);
			}
			else {
				List<Employee2> tempList = employeeMap.get(emp.manager);
				tempList.add(emp);
				employeeMap.put(emp.manager, tempList);
			}
		}
		return employeeMap;
	}
	
}

class Employee2{
	
	String name;
	Employee2 manager;
	
	public Employee2(String name) {
		this.name=name;
	}
	
	public void addManager(Employee2 manager) {
		this.manager=manager;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
