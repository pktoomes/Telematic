package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TelematicsService {

   public void report(VehicleInfo vehicleInfo) {

      //java to json
      String vInfo = "";
      try {
         ObjectMapper mapper = new ObjectMapper();
         vInfo = mapper.writeValueAsString(vehicleInfo);
      } catch (IOException ex) {
         ex.printStackTrace();
      }
      //write vin number as file name
      File vFile = new File(Integer.toString(vehicleInfo.getVinNumber()) + ".json");
      try {
         FileWriter newFile = new FileWriter(vFile);
         newFile.write(vInfo);
         newFile.close();
      } catch (IOException ex) {
         ex.printStackTrace();
      }
      //count
      int total = 0;
      double odometerTot = 0;
      double fuelConTot = 0;
      double oilChangeTot = 0;
      double engineTot = 0;
      String tableData = "";

      File file = new File(".");
      for (File f : file.listFiles()) {
         if (f.getName().endsWith(".json")) {
            total++;
            try {
               //json to java
               ObjectMapper mapper = new ObjectMapper();
               VehicleInfo info = mapper.readValue(f, VehicleInfo.class);

               odometerTot += info.getOdometer();
               fuelConTot += info.getConsumption();
               oilChangeTot += info.getLastOil();
               engineTot += info.getEngineSize();

               String temp = addTableHTML(VehicleInfo.htmlSingleV, info.getVinNumber(), info.getOdometer(), info.getConsumption(), info.getLastOil(), info.getEngineSize());
               tableData += temp;


            } catch (IOException ex) {
               ex.printStackTrace();
            }
         }
      }


        String avgOdometer = calcAvg(odometerTot, total);
        String avgConsumption = calcAvg(fuelConTot, total);
        String avgOilChange = calcAvg(oilChangeTot, total);
        String avgEngine = calcAvg(engineTot, total);
        String jsonTotal = Integer.toString(total);
        String avgData = addHTMLAvg(VehicleInfo.htmlAvg, jsonTotal, avgOdometer, avgConsumption, avgOilChange, avgEngine);
        String htmlDashboard = avgData + tableData + VehicleInfo.bottomDoc;

        try {
            File htmlFile = new File("dashboard.html");
            FileWriter newFile = new FileWriter(htmlFile);

            newFile.write(htmlDashboard);
            newFile.close();
        } catch (IOException ex) {
             ex.printStackTrace();
        }}

    public static String calcAvg(Double input, int count) {
       Double avg = input / count;
       Double roundedAvg = Math.round(avg * 10d) / 10d;
        return Double.toString(roundedAvg);
    }

    public static String addHTMLAvg(String template, String total, String avgOdometer, String avgConsumption, String avgOilChange, String avgEngine) {
       String avgHTML = template.replace("{{count}}", total);
       avgHTML = avgHTML.replace("{{avgOdo}}", avgOdometer);
       avgHTML = avgHTML.replace("{{avgCons}}", avgConsumption);
       avgHTML = avgHTML.replace("{{avgLastOil}}", avgOilChange);
       avgHTML = avgHTML.replace("{{avgEngSize}}", avgEngine);
        return avgHTML;
    }

    public static String addTableHTML(String template, int vinNumber, double odometer, double consumption, double lastOil, double engineSize) {
        String tr = template.replace("{{vin}}", Integer.toString(vinNumber));
        tr = tr.replace("{{odo}}", Double.toString(odometer));
        tr = tr.replace("{{fuelCons}}", Double.toString(consumption));
        tr = tr.replace("{{lastOil}}", Double.toString(lastOil));
        tr = tr.replace("{{engSize}}", Double.toString(engineSize));
        return tr;
   }


}
