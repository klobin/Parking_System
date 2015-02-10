package com.parkingsys.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.parkingsys.controller.Controller;
import com.parkingsys.vo.ParkingMaster;

public class ParkingSystemLauncher {

	//	final static Logger log =Logger.getLogger(ParkingSystemLauncher.class);

	public static void main(String[] args) throws Exception {

		Controller controller = new Controller();

		int i;
		int addreq[] = new int[3];
		String parking_detail[] = new String[3];
		Scanner input = new Scanner(System.in);
		do {
			System.out.println("\n1. Add Zone\n");
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
				displayList(controller);
				break;
			case 3:
				availability(controller);
				break;
			case 4:
				parking_details(parking_detail, input);
				Boolean bayCheck = controller.park(parking_detail[1],parking_detail[2],parking_detail[0]);
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

	private static void parking_details(String[] parking_detail, Scanner input) {
		Boolean validationFlag = false;
		do{
			System.out.println("Which vehicle to park(bike,car,heavy_vehicle)?");
			parking_detail[4] = input.next();
			if(parking_detail[4].equalsIgnoreCase("bike") || parking_detail[4].equalsIgnoreCase("car") || parking_detail[4].equalsIgnoreCase("heavy_vehicle") ){
				validationFlag = true;
			}
		}while(validationFlag);
		
		System.out.println("Enter the vehicle Reg_no ?");
		parking_detail[0] = input.next();
		System.out.println("Enter the floor_no ?");
		parking_detail[1] = input.next();
		System.out.println("Enter the Parking_bay ?");
		parking_detail[2] = input.next();
	}

	private static void availability(Controller controller) throws Exception {
		List result_list = controller.showAvailability();
		for (int i = 0; i <=(result_list.size()-1); i++) {
			List intermident_list = new ArrayList();
		}
	}

	private static void displayList(Controller controller) throws Exception {
		List result = controller.showOverview();
		for (int j = 0;j<=(result.size()-1);j++) {

			ParkingMaster parkingMaster = (ParkingMaster) result.get(j);
			System.out.println("\n***********************************************");
			System.out.println("Floor no: "+parkingMaster.getFloor_id());
			System.out.println("No of bikes: "+parkingMaster.getCap_bike());
			System.out.println("No of cars: "+parkingMaster.getCap_car());
			System.out.println("no of heavy vehicles: "+parkingMaster.getCap_heavyVehicle());
			System.out.println("*************************************************\n");
		}
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
