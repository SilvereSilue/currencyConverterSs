package com.example.currencyconverterss;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText dollarText;
    TextView resulttext;
    Button convertBtn;
    Spinner currencySpinner;

    double dollars;
    double result;
    String symbol;
    String[] currency = {"Select","EUR","YEN","XOF","POUNDS","ROU"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dollarText = findViewById(R.id.dollartext);
        resulttext = findViewById(R.id.resulttext);
        convertBtn = findViewById(R.id.convertBtn);
        currencySpinner = findViewById(R.id.spinnerCurreny);

        ArrayAdapter currencyAdapter = new ArrayAdapter(this,R.layout.spinner_item,currency);

        currencyAdapter.setDropDownViewResource(R.layout.spinner_item);
        currencySpinner.setAdapter(currencyAdapter);


        convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String rupees1 = dollarText.getText().toString();
                String toCurrency = currencySpinner.getSelectedItem().toString();
                System.out.println("to..."+toCurrency);

                if (rupees1.length()==0){
                    Toast.makeText(getApplicationContext(),"Please enter amount",Toast.LENGTH_LONG).show();

                }
                else {
                    dollars=Double.parseDouble(rupees1);
                    if (toCurrency.equals("Select")) {
                        Toast.makeText(getApplicationContext(),"Please select the conversion unit",Toast.LENGTH_LONG).show();

                    }
                    else {

                        switch (toCurrency) {

                            case "EUR":
                                result = 0.89*dollars;
                                symbol = "€";
                                break;

                            case "YEN":
                                result = 111.06*dollars;
                                symbol = "¥";
                                break;

                            case "XOF":
                                result = 581.79*dollars;
                                symbol = "CFA";
                                break;

                            case "POUNDS":
                                result = 0.77*dollars;
                                symbol = "£";
                                break;

                            case "ROU":
                                result = 69.16*dollars;
                                symbol = "₹";
                                break;

                            default:
                                Toast.makeText(getApplicationContext(),"Please select the conversion unit",Toast.LENGTH_SHORT).show();

                        }

                        resulttext.setText("Result: "+symbol+result);
                    }
                }


            }
        });



    }
}

