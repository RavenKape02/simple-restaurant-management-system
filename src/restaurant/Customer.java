package restaurant;


public class Customer {
	int customerCode;
	String firstName;
	String lastName;
	int loyaltyPoints;
	
	public Customer(int customerCode, String firstName, String lastName, int loyaltyPoints){
		this.customerCode = customerCode;
		this.firstName = firstName;
		this.lastName = lastName;
		this.loyaltyPoints = loyaltyPoints; 
	}
	
	public void viewState() {
		System.out.println("Customer Code: "+ customerCode);
		System.out.println("First Name: "+ firstName);
		System.out.println("Last Name: "+ lastName);
		System.out.println("Loyalty Points: "+ loyaltyPoints);
	}
}
