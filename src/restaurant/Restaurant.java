package restaurant;
import java.util.Scanner;

public class Restaurant {
	Customer[] customers = new Customer[50];
	Scanner sc = new Scanner(System.in);
	public void manageCustomerRecords() {
		int option;
		System.out.print("Enter your name: ");
		String username = sc.next();
		System.out.println("Welcome to EliBee, "+ username +"! Choose from the options below.\n");
		
		while(true) {
			System.out.println("\nCustomer Records Management\n"+
					   "[1] Add customer\n"+
					   "[2] Search customer\n"+
					   "[3] View customer\n"+
					   "[4] Exit\n"+
					   "[5] Bonus: Delete Customer by Id");
			System.out.print("Select an option: ");
			try {
				//use the extra sc.nextline() to eliminate the new line character from input
				option = sc.nextInt();
				sc.nextLine();
			}
			catch(Exception e) {
				//catching the error of NOT inputting a number
				System.out.println("Invalid Input. Please enter a number");
				sc.nextLine();
				continue;
			}
			if(option == 1){
				//code for adding a customer record
				addCustomer();
				}
			//code for searching a customer by customer code
			else if(option == 2) {
				int code = validateIntegerInput();
				boolean customerExist = false;
				if(customers[0]!=null) {
					for(int i = 0; i < customers.length;i++) {
						if((customers[i]!=null)&&(code == customers[i].customerCode)) {
							findCustomer(customers[i].firstName);
							customerExist = true;
							break;
						}
					}
				}
				
				if(!customerExist) {
					System.out.println("Customer not found");
				}
			}
			//code for viewing all customers
			else if(option == 3) {
				if(customers[0]!= null) {
					System.out.println("------ Customer Record ------");
					System.out.println("Customer code      Name         Loyalty points ");
					for(int j = 0; j < customers.length; j++) {
						if(customers[j]==null) {
							break;
						}
						else {
							String fullname = customers[j].firstName + " " + customers[j].lastName;
							System.out.printf("%-15d%-20s%-15d%n", customers[j].customerCode, fullname, customers[j].loyaltyPoints);
						}
					}
				}else {
					System.out.println("There are no customers here");
				}
			}
			// code for updating a song
			else if(option == 4) {
				System.out.println("Goodbye!");
				break;
			}
			//Bonus: Code for deleting a customer by id
			else if(option == 5) {
				if(customers[0]!= null) {
					System.out.println("------ Customer Record ------");
					System.out.println("Customer code      Name         Loyalty points ");
					for(int j = 0; j < customers.length; j++) {
						if(customers[j]==null) {
							break;
						}
						else {
							String fullname = customers[j].firstName + " " + customers[j].lastName;
							System.out.printf("%-15d%-20s%-15d%n", customers[j].customerCode, fullname, customers[j].loyaltyPoints);
						}
					}
					int code = validateIntegerInput();
					boolean customerExist = false;
					if(customers[0]!=null) {
						for(int i = 0; i < customers.length;i++) {
							if((customers[i]!=null)&&(code == customers[i].customerCode)) {
								for(int j = i; j<customers.length;j++) {
									if(customers[j+1]==null) {
										customers[j]=null;
										break;
									}
									else {
										customers[j] = customers[j+1];
									}
								}
								System.out.println("Customer Deleted");
								customerExist = true;
								break;
							}
						}
					}
					
					if(!customerExist) {
						System.out.println("Customer not found");
					}
					
					
				}else {
					System.out.println("There are no customers here");
				}
			}
			else {
				System.out.println("Invalid Input");
			}
		}
		sc.close();
	}
	
	public void findCustomer(String name) {
		for(int i = 0; i<customers.length;i++) {
			if(name.equalsIgnoreCase(customers[i].firstName)) {
				String fullname = customers[i].firstName + " " + customers[i].lastName;
				System.out.println("------ Customer Record ------");
				System.out.println("Customer code      Name         Loyalty points");
				System.out.printf("%-15d%-20s%-20d%n", customers[i].customerCode, fullname, customers[i].loyaltyPoints);
				break;
			}
		}
	}
	public void addCustomer() {
		System.out.println("Create a customer record");
		int code = 0;
		boolean validInput = false;
		while(!validInput) {
			try {
				System.out.println("Enter new customer code:");
				code = sc.nextInt();
				sc.nextLine();
				validInput = true;
			}
			catch(Exception e) {
				System.out.println("Invalid Input. Please enter a number");
				sc.nextLine();
				validInput = false;
				continue;
			}
		}
		if(customers[0]!=null) {
			for(int i = 0;i < customers.length; i++) {
				if((customers[i]!=null)&&(customers[i].customerCode == code)) {
					System.out.println("Customer code already exists");
					return;
				}
			}
		}
		System.out.println("Enter First Name:");
		String first_name = sc.nextLine();
		System.out.println("Enter Last Name:");
		String last_name = sc.nextLine();
		System.out.println("Enter Loyalty Points:");
		int points = 0;
		validInput = false;
		while(!validInput) {
			try {
				points = sc.nextInt();
				sc.nextLine();
				validInput = true;
			}
			catch(Exception e) {
				System.out.println("Invalid Input. Please enter a number");
				sc.nextLine();
				validInput = false;
				continue;
			}
		}
		
		for(int i = 0;i < customers.length; i++) {
			if(customers[i]==null) {
				Customer newcustomer = new Customer(code, first_name, last_name, points);
				customers[i] = newcustomer;
				System.out.println("Customer Added Successfully");
				customers[i].viewState();
				break;
			}
		}
	}
	public int validateIntegerInput() {
		boolean validInput = false;
		int code = 0;
		while(!validInput) {
			try {
				System.out.print("Enter Customer ID: ");
				code = sc.nextInt();
				sc.nextLine();
				validInput = true;
			}
			catch(Exception e) {
				System.out.println("Invalid Input. Please enter a number");
				sc.nextLine();
				validInput = false;
				continue;
			}
		}
		return code;
	}
	
}
