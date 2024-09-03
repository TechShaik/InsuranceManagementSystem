package com.InsuranceManagementSystem;

import java.util.*;
import java.util.stream.Collectors;

public class PolicyManager {
    private Set<Policy> policySetHash = new HashSet<>();
    private Set<Policy> policySetLinkedHash = new LinkedHashSet<>();
    private Set<Policy> policySetTree = new TreeSet<>();

    public void addPolicy(Policy policy) {
        policySetHash.add(policy);
        policySetLinkedHash.add(policy);
        policySetTree.add(policy);
    }

    public Set<Policy> getAllUniquePolicies() {
        return policySetHash;
    }

    public Set<Policy> getPoliciesExpiringSoon() {
        Set<Policy> expiringSoon = new HashSet<>();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 30);
        Date thresholdDate = calendar.getTime();

        for (Policy policy : policySetTree) {
            if (policy.getExpiryDate().before(thresholdDate)) {
                expiringSoon.add(policy);
            } else {
                break;  
            }
        }
        return expiringSoon;
    }

    public Set<Policy> getPoliciesByCoverage(String coverageType) {
        return policySetHash.stream()
                .filter(policy -> policy.getCoverageType().equalsIgnoreCase(coverageType))
                .collect(Collectors.toSet());
    }

    public Set<Policy> findDuplicatePolicies() {
        Set<Policy> seen = new HashSet<>();
        return policySetHash.stream()
                .filter(policy -> !seen.add(policy))
                .collect(Collectors.toSet());
    }

    public void comparePerformance() {
        long startTime, endTime;

        // Performance comparison for adding policies
        startTime = System.currentTimeMillis();
        policySetHash.addAll(policySetHash);
        endTime = System.currentTimeMillis();
        System.out.println("HashSet Add Time: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        policySetLinkedHash.addAll(policySetLinkedHash);
        endTime = System.currentTimeMillis();
        System.out.println("LinkedHashSet Add Time: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        policySetTree.addAll(policySetTree);
        endTime = System.currentTimeMillis();
        System.out.println("TreeSet Add Time: " + (endTime - startTime) + " ms");

        // Performance comparison for lookup
        startTime = System.currentTimeMillis();
        policySetHash.containsAll(policySetHash);
        endTime = System.currentTimeMillis();
        System.out.println("HashSet Lookup Time: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        policySetLinkedHash.containsAll(policySetLinkedHash);
        endTime = System.currentTimeMillis();
        System.out.println("LinkedHashSet Lookup Time: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        policySetTree.containsAll(policySetTree);
        endTime = System.currentTimeMillis();
        System.out.println("TreeSet Lookup Time: " + (endTime - startTime) + " ms");
    }
}
