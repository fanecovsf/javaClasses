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
			System.out.print("ID: ");
			Integer id = sc.nextInt();
			
			while (hasId(listEmp, id)) {
				System.out.print("ID already taken! Try again: ");
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
		
		for (Employee x : listEmp) {
			System.out.println(x);
		}
		
		sc.close();
	}
	
	public static boolean hasId(List<Employee> list, Integer id) {
		Employee check = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return check != null;
	}

}
