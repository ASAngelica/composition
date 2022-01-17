package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/DD/yyyy");
		
		
		System.out.println("Cliente data:");
		
		System.out.print("Name: ");
		String name = sc.nextLine();
		
		System.out.print("Email: ");
		String email = sc.nextLine();
		
		System.out.print("Birth Date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.nextLine());
		
		System.out.println("Enter order data: ");
		
		System.out.print("Status: ");
		String status = sc.nextLine();
		
		Date date = new Date();
		sdf.format(date);
		
		Order order = new Order( date, OrderStatus.valueOf(status), new Client(name, email, birthDate));
		
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		
		for(int i=0; i<n; i++) {
		System.out.println("Enter #" +(i+1)+" item data:");
		sc.nextLine();
		System.out.print("Product name: ");
		String product = sc.nextLine();
		
		System.out.print("Product price: ");
		Double price = sc.nextDouble();
		
		System.out.print("Quantity: ");
		Integer quantity = sc.nextInt();
		
		OrderItem item = new OrderItem(quantity, price, new Product(product, price));
	  	order.addItem(item);
		}
		
		System.out.println();
		System.out.println(order);
		
		sc.close();

	}

}
