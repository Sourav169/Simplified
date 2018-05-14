package com.example.admin.simplified;

public class UserProfile {

    public String name;
    public String addressid;
    public String emailid;
    public String pincode;
    public String ph;
    public String designationid;

    public UserProfile(String name, String addressid, String emailid, String ph, String pincode, String designationid) {

        this.addressid = addressid;
        this.name = name;
        this.emailid = emailid;
        this.ph = ph;
        this.pincode = pincode;
        this.designationid = designationid;


    }

    public String getName() {
        return name;
    }

    public String getAddressid() {
        return addressid;
    }

    public String getEmailid() {
        return emailid;
    }

    public String getPincode() {
        return pincode;
    }

    public String getPh() {
        return ph;
    }

    public String getDesignationid() {
        return designationid;
    }
}
