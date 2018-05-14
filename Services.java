package com.example.admin.simplified;

public class Services {
    String serviceid;
    String serviceGenre;
    String softwareGenre;
    String businessesid;
    String locationid;

    public Services(){


    }

    public Services(String serviceid,String serviceGenre, String softwareGenre, String businessesid, String locationid) {
        this.serviceGenre = serviceGenre;
        this.softwareGenre = softwareGenre;
        this.businessesid = businessesid;
        this.locationid = locationid;
        this.serviceid=serviceid;
    }

    public String getServiceGenre() {
        return serviceGenre;
    }

    public String getSoftwareGenre() {
        return softwareGenre;
    }

    public String getBusinessesid() {
        return businessesid;
    }

    public String getLocationid() {
        return locationid;
    }
    public String getServiceid() {
        return serviceid;
    }
}
