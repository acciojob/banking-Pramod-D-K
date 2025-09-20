package com.driver;

import java.util.Collections;
import java.util.Random;

public class CurrentAccount extends BankAccount{
    private String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name,balance,5000);
        this.tradeLicenseId=tradeLicenseId;
    }

    public  boolean checkIsValid(String upperCaseId){
        boolean isValid=true;
        for(int i = 1; i< upperCaseId.length(); i++){
            if(upperCaseId.charAt(i)==upperCaseId.charAt(i-1)){
                isValid=false;
            }
        }
        return isValid;
    }
    public void validateLicenseId() throws Exception {
        // A trade license id is said to be valid if no two consecutive characters are same
        // If the license id is valid, do nothing
        // If the characters of the license id can be rearranged to create any valid license id
        // If it is not possible, throw "Valid License can not be generated" Exception


        Random random= new Random();
        String id = random.toString();
        String upperCaseId = id.toUpperCase();
        boolean isValid=checkIsValid(upperCaseId);
        if(isValid){
            return;
        }
        Collections.shuffle(Collections.singletonList(upperCaseId));
        isValid=checkIsValid(upperCaseId);
        if(!isValid){
            throw new Exception("Valid License can not be generated");
        }
        else{
            return;
        }
    }
}
