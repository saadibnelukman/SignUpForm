package com.example.signupform;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText firstNameET,lastNameET,mobileNumberET,emailAddressET;
    private AutoCompleteTextView bloodGroupACTV;
    private RadioButton maleRB,femaleRB;
    private CheckBox acceptCB;
    private Button signUpBTN;

    private String[] bloodGroupList = {"A+","A-","AB+","AB-","B+","B-","O+","O-"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNameET = findViewById(R.id.firstNameET);
        lastNameET = findViewById(R.id.lastNameET);
        mobileNumberET = findViewById(R.id.mobileNumberET);
        emailAddressET = findViewById(R.id.emailAddressET);
        bloodGroupACTV = findViewById(R.id.bloodGroupACTV);
        maleRB = findViewById(R.id.maleRB);
        femaleRB = findViewById(R.id.femaleRB);
        acceptCB = findViewById(R.id.acceptCB);
        signUpBTN = findViewById(R.id.signUpBTN);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,bloodGroupList);

        bloodGroupACTV.setAdapter(arrayAdapter);
        bloodGroupACTV.setThreshold(1);

        acceptCB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked == true){
                    signUpBTN.setVisibility(View.VISIBLE);
                }
                else if (isChecked == false){
                    signUpBTN.setVisibility(View.GONE);
                }
            }
        });

        signUpBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Gender = "" ;


                if (firstNameET.equals("")) {
                    Toast.makeText(MainActivity.this, "Enter First Name", Toast.LENGTH_SHORT).show();
                }else if (lastNameET.equals("")){
                    Toast.makeText(MainActivity.this, "Enter Last Name", Toast.LENGTH_SHORT).show();
                }else if (mobileNumberET.equals("")){
                    Toast.makeText(MainActivity.this, "Enter Mobile Number", Toast.LENGTH_SHORT).show();
                }else if(emailAddressET.equals("")){
                    Toast.makeText(MainActivity.this, "Enter Email Address", Toast.LENGTH_SHORT).show();
                }else if (bloodGroupACTV.equals("")){
                    Toast.makeText(MainActivity.this, "Enter Blood Group", Toast.LENGTH_SHORT).show();
                }else if(maleRB.isChecked() == true){
                    Gender = "Male";
                }else if(femaleRB.isChecked()){
                    Gender = "Female";

                }else
                {
                    Toast.makeText(MainActivity.this, "Sign Up Completed", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
