package com.company;
import com.company.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
      //add info to vehicleinfo
      Scanner scanner = new Scanner(System.in);
      VehicleInfo newVehicle = new VehicleInfo();
      System.out.println("Vin Number:");
      newVehicle.setVinNumber(scanner.nextInt());
        System.out.println("Odometer:");
      newVehicle.setOdometer(scanner.nextDouble());
        System.out.println("Consumption:");
      newVehicle.setConsumption(scanner.nextDouble());
        System.out.println("Last oil change:");
      newVehicle.setLastOil(scanner.nextDouble());
        System.out.println("Engine Size:");
      newVehicle.setEngineSize(scanner.nextDouble());
        System.out.println("Vin: " + newVehicle.getVinNumber()+ " Odometer: "  + newVehicle.getOdometer() + " Consumption: " + newVehicle.getConsumption() + " Last Oil: "+ newVehicle.getLastOil() + " Engine Size: " + newVehicle.getEngineSize());
        
      TelematicsService telematic = new TelematicsService();
      telematic.report(newVehicle);
    }
}
