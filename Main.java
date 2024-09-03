package com.InsuranceManagementSystem;

import java.text.SimpleDateFormat;
 
public class Main {
    public static void main(String[] args) throws Exception {
        PolicyManager manager = new PolicyManager();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // Adding sample policies
        manager.addPolicy(new Policy("P001", "Alice", sdf.parse("2024-10-15"), "Health", 1200.00));
        manager.addPolicy(new Policy("P002", "Bob", sdf.parse("2024-09-10"), "Auto", 800.00));
        manager.addPolicy(new Policy("P003", "Charlie", sdf.parse("2024-09-25"), "Home", 950.00));
        manager.addPolicy(new Policy("P004", "David", sdf.parse("2024-12-05"), "Health", 1500.00));

     
        System.out.println("All Unique Policies: " + manager.getAllUniquePolicies());

         System.out.println("Policies Expiring Soon: " + manager.getPoliciesExpiringSoon());

         System.out.println("Health Coverage Policies: " + manager.getPoliciesByCoverage("Health"));

         System.out.println("Duplicate Policies: " + manager.findDuplicatePolicies());

         manager.comparePerformance();
    }
}
