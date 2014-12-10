package com.parkingsys.domain;

import java.util.Scanner;

public class ParkingSystemLauncher {

	public static void main(String[] args) throws Exception {
		int i;
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
				System.out.println("\nheloo !!!");
				break;
			case 7:
				System.out.println("Thanks for parking your vehicle :)");
				System.exit(0);
			}
		} while (i<=7);
	}

}
