package com.InsuranceManagementSystem;

import java.util.Date;
  
public class Policy implements Comparable<Policy> {
    private String policyNumber;
    private String policyholderName;
    private Date expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(String policyNumber, String policyholderName, Date expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
     }

    public String getPolicyholderName() {
        return policyholderName;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }
 
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

     
    public String toString() {
        return
                "policyNumber=" + policyNumber + '\n' +
                " policyholderName=" + policyholderName + '\n' +
                " expiryDate=" + expiryDate +"\n"+
                " coverageType=" + coverageType + '\n' +
                " premiumAmount=" + premiumAmount +"\n";
    }
}
