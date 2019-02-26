package com.comp1601.tipntax;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class TipCalcActivity extends AppCompatActivity {
    private Button tCalButton;
    private TextView tPriceTxt;
    private TextView tPercentTxt;
    private TextView tTotalTxt;

    private final static String TAG= "ButtonClick"  ;
    public static final String TIP_N_TAX_COMPUTED_TOTAL = "tip_n_tax_computed_total";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calc);

        tCalButton = (Button) findViewById(R.id.tCalButton) ;
        tPriceTxt =(TextView) findViewById(R.id.price);
        tPercentTxt = (TextView) findViewById(R.id.percent);
        tTotalTxt = (TextView) findViewById(R.id.total);

        double price =getIntent().getDoubleExtra(MainActivity.TIP_N_TAX_MAIN_AMOUNT,0.0);
        String priceStrInit=""+price;
        tPriceTxt.setText(priceStrInit);

        tCalButton.setOnClickListener( v->{
            Log.i(TAG,"TipCalcActivity:: CalButton Clicked");
            String priceStr = tPriceTxt.getText().toString();
            String tipStr = tPercentTxt.getText().toString();
            //get the price and tip percentage string.
            double priceAmount = Double.parseDouble(priceStr);
            double tipAmount = Double.parseDouble(tipStr);
            TipNTaxCalculator cal= new TipNTaxCalculator(13,tipAmount);

            double ret = cal.calculate(priceAmount);
            Log.i(TAG,"TipCalcActivity:: Amount =" + priceAmount);
            String retStr = String.format("%.2f",ret);
            Log.i(TAG,"TipCalcActivity:: Total"+retStr);
            tTotalTxt.setText(retStr);

            Intent data= new Intent();
            data.putExtra(TIP_N_TAX_COMPUTED_TOTAL,ret);
            setResult(RESULT_OK,data);

        });
    }
}
