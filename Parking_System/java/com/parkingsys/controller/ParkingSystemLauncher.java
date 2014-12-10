package com.parkingsys.controller;

import java.util.Scanner;

import com.parkingsys.domain.Vo;


public class ParkingSystemLauncher {

	
	
	public static void main(String[] args) throws Exception{
		int user_input;
		
		
		do{
		System.out.println("***************************************************************** \n");
		System.out.println("1.Add zone\n");
		System.out.println("2.List\n");
		System.out.println("3. Show availabilty\n");
		System.out.println("4.Park\n");
		System.out.println("5.Locate my vehicle\n");
		System.out.println("6.Unpark\n");
		System.out.println("7.Exit\n");
		System.out.println("Opt your choice !");
		Scanner input = new Scanner(System.in);
		if(input.hasNextInt())
		{
			user_input =input.nextInt();
		}
		else{
			throw new Exception("Please choose valid input !!");
		}
		
			switch (user_input) {
			case 1:
				methodCall(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
				break;
			case 7:
				System.out.println("Thanks for comming to parking");
				System.exit(0);
			}
		}while(user_input<=7);
	}

	private static void methodCall(int noOfBike, int noOfCar) {
		Vo vo = new Vo();
		vo.setCap_Bike(noOfBike);
		vo.setCap_Car(noOfCar);
		System.out.println(vo.getCap_Bike()+" " +vo.getCap_heavyVehicle());
	}
}
