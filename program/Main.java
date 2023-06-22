package program;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many employees will be registered? ");
		
		Integer n = sc.nextInt();
		
		List<Employee> listEmp = new ArrayList<>();
		
		for (int i=1; i <= n; i++) {
			
			System.out.println();
			System.out.println("Employee #" + i);
			System.out.print("Id: ");
			Integer id = sc.nextInt();
			
			while (hasId(listEmp, id)) {
				System.out.print("Id already taken! Try again: ");
				id = sc.nextInt();
			}
			
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			
			System.out.print("Salary: ");
			Double salary = sc.nextDouble();
			
			Employee emp = new Employee(id, name, salary);
			
			listEmp.add(emp);
			
		}
		
		int count = 1;
		
		System.out.println("------------------------------------");
		
		for (Employee x : listEmp) {
			System.out.println("Employee #" + count);
			count += 1;
			System.out.println("Id: " + x.getId());
			System.out.println("Name: " + x.getName());
			System.out.println("Salary: " + x.getSalary());
			System.out.println("------------------------------------");
		}
		
		System.out.print("Enter the employee Id that will have salary increase: ");
		int idIncrease = sc.nextInt();
		
		while (hasId(listEmp, idIncrease) == false) {
			System.out.print("This Id doesn't exist, try again: ");
			idIncrease = sc.nextInt();
		}
		
		System.out.print("Enter the percentage: ");
		double perc = sc.nextFloat();
		
		findAndIncrease(listEmp, idIncrease, perc);
		
		System.out.println("------------------------------------");
		
		for (Employee x : listEmp) {
			System.out.println(x);
		}
		
		sc.close();
	}
	
	public static boolean hasId(List<Employee> list, Integer id) {
		Employee check = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return check != null;
	}
	
	public static void findAndIncrease(List<Employee> list, Integer id, double percentage) {
		for (Employee x : list) {
			if (x.getId() == id) {
				x.increaseSalary(id, percentage);
			}
		}
	}

}
