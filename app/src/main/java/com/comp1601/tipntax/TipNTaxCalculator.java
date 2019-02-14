package com.comp1601.tipntax;

public class TipNTaxCalculator {
    protected static final double DefaultTaxRate =13.0;
    protected static final double DefaultTipPercentage =15.0;
    protected static final double InvalidResult =-1;
    protected static final double tooLargeNum = 100000;

    private double mTaxRate;
    private double mTipPercentage;

    public double getTaxRate(){
        return mTaxRate;
    }

    public double getTipPercentage(){
        return mTipPercentage;
    }


    public TipNTaxCalculator(){
        mTaxRate = DefaultTaxRate;
        mTipPercentage = DefaultTipPercentage;
    }

    public TipNTaxCalculator(double aTaxRate,double aTipPercentage){
        mTaxRate = aTaxRate;
        mTipPercentage = aTipPercentage;
    }

    public double calculate(double amount){

        if (amount <0 || amount>100000){
            return InvalidResult;
        }
        if (this.mTaxRate < 0 || this.mTipPercentage<0){
            return InvalidResult;
        }
        if (this.mTaxRate >= 100 || this.mTipPercentage >= 100){
            return InvalidResult;
        }
        return amount * (1.0+mTaxRate/100)*(1.0+mTipPercentage/100);

    }

}
