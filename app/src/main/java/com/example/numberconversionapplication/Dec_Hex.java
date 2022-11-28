package com.example.numberconversionapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Dec_Hex extends AppCompatActivity {

    ImageButton swap3;
    EditText inputbox3;
    TextView intype3, outtype3, outputbox3;
    Button convert3;
    String input_value3;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dec_hex);

        swap3 = findViewById(R.id.swap3);
        inputbox3 = findViewById(R.id.input_box3);
        intype3 = findViewById(R.id.input_type3);
        outtype3 = findViewById(R.id.output_type3);
        outputbox3 = findViewById(R.id.output_box3);
        convert3 = findViewById(R.id.convert_btn3);

        convert3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(TextUtils.isEmpty(inputbox3.getText().toString()))
                {
                    Toast.makeText(Dec_Hex.this, R.string.Enter_The_Numer,Toast.LENGTH_LONG).show();
                }
                else
                {
                    //input is decimal and output is hexadecimal
                    if(intype3.getText().toString().equals("Decimal"))
                    {
                        input_value3 = inputbox3.getText().toString();
                        int bin = Integer.parseInt(input_value3);
                        input_value3 = Integer.toHexString(bin);
                        outputbox3.setText(input_value3.toUpperCase());
                    }
                    else if(intype3.getText().toString().equals("Hexadecimal"))
                    {
                        input_value3 = inputbox3.getText().toString();
                        // Size of string
                        int n = input_value3.length();

                        // Iterate over string
                        for (int i = 0; i < n; i++) {

                            char ch = input_value3.charAt(i);

                            // Check if the character is invalid
                            if ((ch < '0' || ch > '9') && (ch < 'A' || ch > 'F'))
                            {
                                Toast.makeText(Dec_Hex.this,"Enter a hexadecimal number",Toast.LENGTH_LONG).show();
                            }
                        }
                        int hex = Integer.parseInt(input_value3,16);
                        input_value3 = String.valueOf(hex);
                        outputbox3.setText(input_value3);
                    }

                }
            }
        });

        swap3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(intype3.getText().toString().equals("Decimal"))
                {
                    intype3.setText(R.string.hexadecimal);
                    outtype3.setText(R.string.decimal);
                    inputbox3.setInputType(InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS);
                }
                else
                {
                    intype3.setText(R.string.decimal);
                    outtype3.setText(R.string.hexadecimal);
                    inputbox3.setInputType(InputType.TYPE_CLASS_NUMBER);
                }
            }
        });


    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
    }
}