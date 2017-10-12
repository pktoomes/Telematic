package com.company;

public class VehicleInfo {
    int vinNumber;
    double odometer;
    double consumption;
    double lastOil;
    double engineSize;

    public VehicleInfo() {
    }

    public int getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(int vinNumber) {
        this.vinNumber = vinNumber;
    }

    public double getOdometer() {
        return odometer;
    }

    public void setOdometer(double odometer) {
        this.odometer = odometer;
    }

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public double getLastOil() {
        return lastOil;
    }

    public void setLastOil(double lastOil) {
        this.lastOil = lastOil;
    }

    public double getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(double engineSize) {
        this.engineSize = engineSize;
    }
    public static final String htmlAvg = "<!DOCTYPE html>"
            + "<head>"
            + "<html>"
            + "<meta charset=\"utf-8\">"
            + "<title>Vehicle Telematics Dashboard</title>"
            + "</head>"
            + "<body>"
            + "<h1 align=\"center\">Averages for {{count}}️ vehicles</h1>"
            + "<table align=\"center\">"
            + "<tr>"
            + "<th>Odometer (miles) |</th><th>Consumption (gallons) |</th><th>Last Oil Change |</th><th>Engine Size (liters)</th>"
            + "</tr>"
            + "<tr>"
            + "<td align=\"center\">{{avgOdo}}</td><td align=\"center\">{{avgCons}}️</td><td align=\"center\">{{avgLastOil}}️</td align=\"center\"><td align=\"center\">{{avgEngSize}}️</td>"
            + "</tr>"
            + "</table>"
            + "<h1 align=\"center\">History</h1>"
            + "<table align=\"center\" border=\"1\">"
            + "<tr>"
            + "<th>VIN</th><th>Odometer (miles)</th><th>Consumption (gallons)</th><th>Last Oil Change</th><th>Engine Size (liters)</th>"
            + "</tr>";
    public static final String htmlSingleV = "<tr>"
            + "<td align=\"center\">{{vin}}️</td><td align=\"center\">{{odo}}️</td><td align=\"center\">{{fuelCons}}️</td><td align=\"center\">{{lastOil}}</td align=\"center\"><td align=\"center\">{{engSize}}️</td>"
            + "</tr>";
    public static final String bottomDoc = "</table>"
            + "</body>"
            + "</html>";

}
