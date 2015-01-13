package com.parkingsys.domain;

import java.util.Scanner;

import com.parkingsys.controller.Controller;

public class ParkingSystemLauncher {

	
	
	public static void main(String[] args) throws Exception {
		
		 Controller controller = new Controller();
		int i;
		int addreq[] = new int[3];
		Scanner input = new Scanner(System.in);
		do {
			System.out.println("\n****************************************************");
			System.out.println("1. Add Zone\n");
			System.out.println("2. List\n");
			System.out.println("3. Show Availabilty\n");
			System.out.println("4. Park\n");
			System.out.println("5. Locate vehicle\n");
			System.out.println("6. Unpark\n");
			System.out.println("7. Exit\n");
			System.out.println("Opt your choice !!\n");
			try{
				i = input.nextInt();
			}catch(Exception e)
			{
				throw new Exception("Please choose valid option !!\n");
			}
			switch (i) {
			case 1:
				scan_data(addreq, input);
				controller.AddZone(addreq[0], addreq[1], addreq[2]);
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				System.out.println("Thanks for parking your vehicle :)");
				System.exit(0);
			}
		} while (i<=7);
	}

	private static void scan_data(int[] addreq, Scanner input) {
		System.out.println("No. of Bikes: ");
		addreq[0]=input.nextInt();
		System.out.println("\nNo. of Cars: ");
		addreq[1]=input.nextInt();
		System.out.println("\nNo. of Heavy vehicles: ");
		addreq[2]=input.nextInt();
	}

}
