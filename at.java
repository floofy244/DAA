package com.example.myapplication;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.ArrayList;
import android.widget.EditText;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String[] items = { "item1", "item2",
            "item3" };
    private EditText editTextText;
    private Button btn;
    private Button btn1;
    private int cost1=0;
    private int cost2=0;
    private int cost3=0;
    private int avg=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Spinner spin = findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);

        // Create the instance of ArrayAdapter
        // having the list of courses
        ArrayAdapter ad
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                items);

        // set simple layout resource file
        // for each item of spinner
        ad.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);

        // Set the ArrayAdapter (ad) data on the
        // Spinner which binds data to spinner
        spin.setAdapter(ad);
        editTextText = findViewById(R.id.editTextText);
    }


    @Override
    public void onItemSelected(AdapterView parent, View view, int position, long id) {
        btn=findViewById(R.id.button);
        btn1=findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if( position ==0){
                    String temp =editTextText.getText().toString();
                    cost1=Integer.parseInt(temp);

                }
                if( position ==1){
                    String temp =editTextText.getText().toString();
                    cost2=Integer.parseInt(temp);

                }
                if( position ==2){
                    String temp =editTextText.getText().toString();
                    cost3=Integer.parseInt(temp);

                }
            }
        });
        btn1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                 avg=(cost1+cost2+cost3)/3;
                Toast.makeText(getApplicationContext(),String.valueOf(avg),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onNothingSelected(AdapterView parent) {

    }


}



 
