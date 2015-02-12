package com.parkingsys.domain;

import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.omg.CosNaming.IstringHelper;

import com.parkingsys.controller.Controller;
import com.parkingsys.vo.Bike_master;
import com.parkingsys.vo.Car_master;
import com.parkingsys.vo.HV_master;
import com.parkingsys.vo.ParkingMaster;

public class ParkingSystemLauncher {

	//	final static Logger log =Logger.getLogger(ParkingSystemLauncher.class);

	public static void main(String[] args) throws Exception {

		Controller controller = new Controller();

		int i;
		int addreq[] = new int[3];
		String parking_detail[] = new String[4];
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
				Boolean bayCheck = controller.manage_Parking(parking_detail[1],parking_detail[2],parking_detail[0],parking_detail[3],true);
				if(!bayCheck){
					System.out.println("Given parking location is not vacant !");
				}
				break;
			case 5:
				System.out.println("Please enter the vehicle Reg_No ??");
				LocateVehicle(input.next(),controller);
				break;
			case 6:
				getVehicleDetails(parking_detail, input);
				Boolean isValidVehicle = controller.manage_Parking(parking_detail[1],parking_detail[2],parking_detail[0],parking_detail[3],false);
				if(!isValidVehicle){
					System.out.println("Please come out of hangover, your vehicle is not at the location given !");
				}
				break;
			case 7:
				System.out.println("Thanks for parking your vehicle :)");
				System.exit(0);
			}
		} while (i<=7);
	}

	private static void LocateVehicle(String reg_no,Controller controller) {
		List return_list = new ArrayList();
		return_list = controller.locateVehcile(reg_no);
		if(return_list!=null){
			Object obj = return_list.get(0);
			if(obj instanceof Bike_master)
			{
				Bike_master bike_master = new Bike_master();
				bike_master =(Bike_master) return_list.get(0);
				displayLocation(bike_master.getFloor_id(),bike_master.getParking_bay());
			}else if (obj instanceof Car_master) {
				Car_master car_master = new Car_master();
				car_master =(Car_master)return_list.get(0);
				displayLocation(car_master.getFloor_id(), car_master.getParking_bay());
			}else if (obj instanceof HV_master) {
				HV_master hv_master = new HV_master();
				hv_master = (HV_master) return_list.get(0);
				displayLocation(hv_master.getFloor_id(), hv_master.getParking_bay());
			}else {
				System.out.println("Reg_no of vehicle not found, please check reg_no correctly and try again ?");
			}
		}else {
			System.out.println("Reg_no of vehicle not found, please check reg_no correctly and try again ?");
		}

	}

	private static void displayLocation(int floor_id, String parking_bay) {
		System.out.println("******************************************\n");
		System.out.println("Vehicle is parked in "+parking_bay+" on "+floor_id+"-floor ");
		System.out.println("\n******************************************");
	}

	private static void getVehicleDetails(String[] parking_detail, Scanner input) {
		Boolean validationFlag = false;
		do{
			System.out.println("Which vehicle is parked(bike,car,heavy_vehicle)?");
			parking_detail[3] = input.next();
			if(parking_detail[3].equalsIgnoreCase("bike") || parking_detail[3].equalsIgnoreCase("car") || parking_detail[3].equalsIgnoreCase("heavy_vehicle") ){
				validationFlag = true;
			}
		}while(!validationFlag);

		System.out.println("Enter the vehicle Reg_no ?");
		parking_detail[0] = input.next();
		System.out.println("Enter the floor_no ?");
		parking_detail[1] = input.next();
		System.out.println("Enter the Parking_bay ?");
		parking_detail[2] = input.next();
	}

	private static void parking_details(String[] parking_detail, Scanner input) {
		Boolean validationFlag = false;
		do{
			System.out.println("Which vehicle to park(bike,car,heavy_vehicle)?");
			parking_detail[3] = input.next();
			if(parking_detail[3].equalsIgnoreCase("bike") || parking_detail[3].equalsIgnoreCase("car") || parking_detail[3].equalsIgnoreCase("heavy_vehicle") ){
				validationFlag = true;
			}
		}while(!validationFlag);

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
