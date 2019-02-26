package com.comp1601.tipntax;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button mCalButton;
    private Button mVisitButton;
    private Button mSendButton;

    private TextView mWeburlTxt;
    private TextView mAmountTxt;
    private TextView mEmailTxt;
    private TextView mMessageTxt;

    private final static String TAG= "ButtonClick"  ;
    public static final String TIP_N_TAX_MAIN_AMOUNT = "tip_n_tax_main_activity_amount";
    private static final int TIP_N_TAX_TOTAL_RESULT = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCalButton = (Button) findViewById(R.id.calButton);
        mVisitButton = (Button) findViewById(R.id.visitButton);
        mSendButton = (Button) findViewById(R.id.sendButton);


        mWeburlTxt=(TextView) findViewById(R.id.weburl_text);
        mAmountTxt=(TextView) findViewById(R.id.amount_text);
        mEmailTxt=(TextView) findViewById(R.id.email_text);
        mMessageTxt=(TextView) findViewById(R.id.message_text);


        mCalButton.setOnClickListener(v->{
            Log.i(TAG,"CalButton Clicked");
            String amountStr = mAmountTxt.getText().toString();
            Log.i(TAG," value is "+mAmountTxt.getText());

            if (amountStr==""||amountStr==" ") {
                Intent intent =new Intent(MainActivity.this,TipCalcActivity.class);
                startActivityForResult(intent, TIP_N_TAX_TOTAL_RESULT);
            } else {
                double amount = Double.valueOf(amountStr);
                Intent intent =new Intent(MainActivity.this,TipCalcActivity.class);
                intent.putExtra(TIP_N_TAX_MAIN_AMOUNT,amount);
                startActivityForResult(intent, TIP_N_TAX_TOTAL_RESULT);
            }



        });

        mMessageTxt.setOnClickListener(v-> {
            mMessageTxt.setHint(null);
        });

        mAmountTxt.setOnClickListener(v-> {
            mAmountTxt.setHint(null);
        });


    }
    @Override
    protected  void onActivityResult(int requestCode,int resultCode, Intent data){
        if(resultCode!=Activity.RESULT_OK) return;
        if (requestCode == TIP_N_TAX_TOTAL_RESULT){
            if (data == null) return;
            double computedTotal = data.getDoubleExtra(TipCalcActivity.TIP_N_TAX_COMPUTED_TOTAL,TipNTaxCalculator.InvalidResult);
            String retStr = String.format("%.2f",computedTotal);
            mAmountTxt.setText(retStr);
        }

    }

}
