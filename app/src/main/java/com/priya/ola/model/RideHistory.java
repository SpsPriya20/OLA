package com.priya.ola.model;

public class RideHistory {

   private int id;
   private String SourceAddress;
   private String DestinationAddress;
   private String DriverName;
    private String VehicleType;
    private String InvoiceReference;
    private String TotalFare;

    public RideHistory (int id,String SourceAddress,String DestinationAddress,String DriverName,String VehicleType,String InvoiceReference,String TotalFare){
        this.id=id;
        this.SourceAddress=SourceAddress;
        this.DestinationAddress=DestinationAddress;
        this.DriverName=DriverName;
        this.VehicleType=VehicleType;
        this.InvoiceReference=InvoiceReference;
        this.TotalFare=TotalFare;
    }


    public int getId() {
        return id;
    }

    public String getSourceAddress() {
        return SourceAddress;
    }

    public String getDestinationAddress() {
        return DestinationAddress;
    }

    public String getTotalFare() {
        return TotalFare;
    }

    public String getDriverName() {
        return DriverName;
    }

    public String getInvoiceReference() {
        return InvoiceReference;
    }

    public String getVehicleType() {
        return VehicleType;
    }
}
