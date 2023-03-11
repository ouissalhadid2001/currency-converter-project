package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Spinner sp1,sp2;
    EditText ed1;
    TextView ed2;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp1 = findViewById(R.id.spfrom);
        sp2 = findViewById(R.id.spto);
        ed1 = findViewById(R.id.amount);
        ed2 = findViewById(R.id.result);

        String[] from = {"MAD","EURO","Dollar"};
        ArrayAdapter ad = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,from);
        sp1.setAdapter(ad);


        String[] to = {"EURO","Dollar","MAD"};
        ArrayAdapter ad1 = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,to);
        sp2.setAdapter(ad1);


        b1 = findViewById(R.id.btn1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Double tot;

                Double amt = Double.parseDouble(ed1.getText().toString());

                if(sp1.getSelectedItem().toString() == "MAD" && sp2.getSelectedItem().toString() == "EURO")
                {
                    tot = amt * 11.01;
                    ed2.setText(tot.toString());
                }
                else if(sp1.getSelectedItem().toString() == "MAD" && sp2.getSelectedItem().toString() == "Dollar")
                {
                    tot = amt * 10.34;
                    ed2.setText(tot.toString());
                } else if (sp1.getSelectedItem().toString()==sp2.getSelectedItem().toString()) {
                    tot = amt;
                    ed2.setText(tot.toString());
                } else if (sp1.getSelectedItem().toString() == "EURO" && sp2.getSelectedItem().toString() == "MAD") {
                    tot = amt / 11.01;
                    ed2.setText(tot.toString());
                }
                else if (sp1.getSelectedItem().toString() == "Dollar" && sp2.getSelectedItem().toString() == "MAD") {
                    tot = amt / 10.34;
                    ed2.setText(tot.toString());
                }
                else if (sp1.getSelectedItem().toString() == "Dollar" && sp2.getSelectedItem().toString() == "EURO") {
                    tot = amt * 0.94;
                    ed2.setText(tot.toString());
                }
                else if (sp1.getSelectedItem().toString() == "EURO" && sp2.getSelectedItem().toString() == "Dollar") {
                    tot = amt * 1.06;
                    ed2.setText(tot.toString());
                }
            }
        });
    }
}