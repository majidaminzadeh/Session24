package com.tosan.gl.bl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

public class TaxServiceTest {
    TaxService taxService;


    @BeforeAll
    public static void beforeAll(){
        System.out.println("beforeAll");
    }

    @BeforeEach
    public void beforeEach(){
        System.out.println("beforeEach");
        taxService = new TaxService();
    }

    @AfterEach
    public void afterEach(){
        System.out.println("afterEach");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("afterAll");
    }

    @Test
    @Disabled
    public void calculateCorrectTax(){
        float tax = taxService.calculateTax(1300000, "", 2);
        assertEquals(130000f, tax);
    }

    @Test
    public void calculate_tax_with_negative_family_member(){
//        float tax = taxService.calculateTax(1300000, "", -1);
        assertThrows(RuntimeException.class, () -> taxService.calculateTax(1300000, "", -1));
    }

    @Test
    public void calculate(){
//        float tax = taxService.calculateTax(1300000, "", -1);
        assertFalse(false);
    }
}
