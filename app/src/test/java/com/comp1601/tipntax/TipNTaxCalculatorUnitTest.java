package com.comp1601.tipntax;

import  org.junit.Test;

import  static org.junit.Assert.*;


public class TipNTaxCalculatorUnitTest {

    public static double toleranceForReals= 0.01;

    @Test
    public void negativeAmountTest() throws Exception{
        TipNTaxCalculator calculator= new TipNTaxCalculator();
        double amount = -100;
        double tolerance = toleranceForReals;
        double result = calculator.calculate(amount);
        assertEquals(result,TipNTaxCalculator.InvalidResult,tolerance);

    }

    @Test
    public void largeAmountTest() throws Exception{
        TipNTaxCalculator calculator= new TipNTaxCalculator();
        double amount = 9999999;
        double tolerance = toleranceForReals;
        double result = calculator.calculate(amount);
        assertEquals(result,TipNTaxCalculator.InvalidResult,tolerance);

    }

    @Test
    public void negativeTaxPercentageTest() throws Exception{
        TipNTaxCalculator calculator= new TipNTaxCalculator(-1,20);
        double tolerance = toleranceForReals;
        double amount = 100;
        double result = calculator.calculate(amount);
        assertEquals(result,TipNTaxCalculator.InvalidResult,tolerance);

    }
    @Test
    public void largeTaxPercentageTest() throws Exception{
        TipNTaxCalculator calculator= new TipNTaxCalculator(200,20);
        double tolerance = toleranceForReals;
        double amount = 100;
        double result = calculator.calculate(amount);
        assertEquals(result,TipNTaxCalculator.InvalidResult,tolerance);

    }


    @Test
    public void negativeTipPercentageTest() throws Exception{
        TipNTaxCalculator calculator= new TipNTaxCalculator(13,-1);
        double tolerance = toleranceForReals;
        double amount = 100;
        double result = calculator.calculate(amount);
        assertEquals(result,TipNTaxCalculator.InvalidResult,tolerance);

    }
    @Test
    public void largeTipPercentageTest() throws Exception{
        TipNTaxCalculator calculator= new TipNTaxCalculator(13,200);
        double tolerance = toleranceForReals;
        double amount = 100;
        double result = calculator.calculate(amount);
        assertEquals(result,TipNTaxCalculator.InvalidResult,tolerance);

    }

    @Test
    public void onlyTipCorrectTest() throws Exception{
        TipNTaxCalculator calculator= new TipNTaxCalculator(13,10);
        double tolerance = toleranceForReals;
        double amount = 100;
        double result = calculator.calculate(amount);
        assertNotEquals(result,amount*(1.0+calculator.getTipPercentage()),tolerance);

    }

    @Test
    public void onlyTaxCorrectTest() throws Exception{
        TipNTaxCalculator calculator= new TipNTaxCalculator(13,10);
        double tolerance = toleranceForReals;
        double amount = 100;
        double result = calculator.calculate(amount);
        assertNotEquals(result,amount*(1.0+calculator.getTaxRate()),tolerance);

    }


    @Test
    public void retCorrectTest() throws Exception{
        TipNTaxCalculator calculator= new TipNTaxCalculator(13,10);
        double tolerance = toleranceForReals;
        double amount = 100;
        double result = calculator.calculate(amount);
        assertEquals(amount*(1.0+calculator.getTaxRate()/100)*(1.0+calculator.getTipPercentage()/100),result,tolerance);

    }

}
