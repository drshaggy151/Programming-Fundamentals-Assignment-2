import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;
	
	
	//*********************************************************************************************************
	// Assignment 2 Flyers' Fast Food        Author: Carlos Fernandez/L30031020
	//
	// Order from Flyers' with Pick-up or Delivery
	//*********************************************************************************************************


	enum Delivery { Delivery_Available, Delivery_with_Extra_Cost, Delivery_Not_Available}

	public class Flyers {

	    private static Scanner scan1;
		private static Scanner scan2;
		private static Scanner scan3;

		public static int flyersMenu()

	       {

	             int items;

	             scan1 = new Scanner(System.in);

	             System.out.println("Pick-up or Delivery: ");

	             System.out.println("1. Pick-Up");

	             System.out.println("2. Delivery");

	             System.out.print("Please choose (1 or 2) to proceed: ");

	             items = Integer.parseInt(scan1.nextLine());

	             while(items<1 || items>2)

	             {

	                    System.out.print("\nInvalid choice .\nPlease choose (1 or 2) to proceed: ");

	                    items = Integer.parseInt(scan1.nextLine());

	             }

	             return items;
	       }


	       public static double itemsMenu()

	       {

	    	     

	             int items,qty;

	             double total = 0;

	             scan2 = new Scanner(System.in);

	             System.out.println("Menu Items: ");

	             System.out.println("1. Flyers' Burger: $4.50");

	             System.out.println("2. Flyers' Drink: $1.50");

	             System.out.println("3. Flyers' Fries: $2.50");

	             System.out.println("4. Flyers' Desert: $3.00");

	             System.out.print("Please select an item (1-4) : ");

	             items = Integer.parseInt(scan2.nextLine());

	             while(items<1 || items>4)

	             {

	                    System.out.print("Invalid choice .\nPlease select an item (1-4) : ");

	                    items = Integer.parseInt(scan2.nextLine());

	             }

	            

	             System.out.print("Enter desired quantity : ");

	             qty = Integer.parseInt(scan2.nextLine());

	             switch(items)

	             {

	                    case 1: total = (double)(qty * 4.5);

	                                 break;

	                    case 2: total = (double)(qty * 1.5);

	                                 break;

	                    case 3:total = (double)(qty * 2.5);

	                                 break;

	                    case 4:total = (double)(qty * 3);

	                                 break;

	             }

	            

	             return total;

	       }

	      

	       public static void main(String[] args) {

	            

	             int delivery;

	             int flyersZipCode = 60446, orderZipCode;

	             Delivery type =null;

	             String itemsChoices = "y";

	             double total = 0;

	             scan3 = new Scanner(System.in);

	             System.out.println("Welcome to Flyers'");

	            

	             delivery = flyersMenu();


	             if(delivery == 2 )

	             {

	                    System.out.print("Please enter your zip code : ");

	                    orderZipCode = Integer.parseInt(scan3.nextLine());

	                    if(Math.abs(flyersZipCode - orderZipCode) < 5)

	                           {

	                                 System.out.println("Delivery available." );

	                                 type = Delivery.Delivery_Available;

	                           }

	                    else if(Math.abs(flyersZipCode - orderZipCode) == 5)

	                           {

	                                 System.out.println("Delivery available with extra cost." );

	                                 type = Delivery.Delivery_with_Extra_Cost;

	                           }

	                    else

	                           {

	                                 System.out.println("Delivery Not Available");

	                                 System.exit(0);

	                           }                  

	             }

	           

	             while(itemsChoices.equalsIgnoreCase("y"))

	             {

	                    total += itemsMenu();

	                    System.out.print("Would you like to add another item your order (y/n) ? ");

	                    itemsChoices = scan3.nextLine();

	                    if(itemsChoices.equalsIgnoreCase("n"))

	                           break;

	             }


	             total += 0.05*total;

	             if(delivery == 2 )

	             {

	                    if(type == Delivery.Delivery_Available)

	                           total += 5;

	                    else if(type == Delivery.Delivery_with_Extra_Cost)

	                           total += 7;

	             }

	             NumberFormat f = new DecimalFormat("#,##0.00");

	  
	             System.out.println("Your total bill = $" + f.format(total) );

	            

	       }

	}
