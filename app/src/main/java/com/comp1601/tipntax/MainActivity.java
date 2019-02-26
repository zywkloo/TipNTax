package com.comp1601.tipntax;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button calButton;
    private Button visitButton;
    private Button sendButton;

    private final static String TAG= "ButtonClick"  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mCalButton = (Button) findViewById(R.id.calButton);
        Button visitButton = (Button) findViewById(R.id.visitButton);
        Button sendButton = (Button) findViewById(R.id.sendButton);


        TextView weburlTxt=(TextView) findViewById(R.id.weburl_text);
        TextView amountTxt=(TextView) findViewById(R.id.amount_text);
        TextView emailTxt=(TextView) findViewById(R.id.email_text);
        TextView messageTxt=(TextView) findViewById(R.id.message_text);


        mCalButton.setOnClickListener(v->{
            Log.i(TAG,"CalButton Clicked");
            TipNTaxCalculator cal= new TipNTaxCalculator(13,20);
            double amount = Double.valueOf(amountTxt.getText().toString());
            double ret = cal.calculate(amount);
            Log.i(TAG,"Amount =" + amount);
            String retStr = String.format("%.2f",ret);
            Log.i(TAG,"Total"+retStr);
            amountTxt.setText(retStr);

        });

        messageTxt.setOnClickListener(v-> {
            messageTxt.setHint(null);
        });

        amountTxt.setOnClickListener(v-> {
            amountTxt.setHint(null);
        });
    }

}
