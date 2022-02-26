package com.tosan.gl.bl;

import javax.ejb.Stateless;

@Stateless
public class TaxService {

    public float calculateTax(int income, String city, int familyMember){
        float taxPercent = 0.2f;
        if(city.equals("Tehran")){
            taxPercent = 0.25f;
        } else if(city.equals("Isfehan")){
            taxPercent = 0.21f;
        } else if(city.equals("Kerman")){
            taxPercent = 0.18f;
        }
        if(familyMember <= 0){
            throw new RuntimeException();
        }
        float tax = income * (taxPercent / familyMember);
        return tax;
    }

    public static void main(String[] args) {
        TaxService taxService = new TaxService();
        float tax = taxService.calculateTax(1300000, "", 2);
        System.out.println(tax);
        float tax1 = taxService.calculateTax(1300000, "", -2);
        System.out.println(tax1);
    }
}
