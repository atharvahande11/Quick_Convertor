package com.example.numberconversionapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Bin_Dec extends AppCompatActivity
{
    ImageButton swap;
    EditText inputbox;
    TextView intype, outtype, outputbox;
    Button convert;

    String input_value;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_bin_dec);

        swap = findViewById(R.id.swap);
        inputbox = findViewById(R.id.input_box);
        intype = findViewById(R.id.input_type);
        outtype = findViewById(R.id.output_type);
        outputbox = findViewById(R.id.output_box);
        convert = findViewById(R.id.convert_btn);

        convert.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(TextUtils.isEmpty(inputbox.getText().toString()))
                {
                    Toast.makeText(Bin_Dec.this, R.string.Enter_The_Numer,Toast.LENGTH_SHORT).show();
                }
                else
                {
                    //input is binary and output is decimal
                    if(intype.getText().toString().equals("Binary"))
                    {
                        input_value = inputbox.getText().toString();
                        int num = Integer.parseInt(input_value);
                        while(num > 0)
                        {
                            if(num % 10 > 1)
                            {
                                Toast.makeText(Bin_Dec.this,"Enter a binary number",Toast.LENGTH_SHORT).show();
                            }
                            num = num / 10;
                        }
                        int dec = Integer.parseInt(input_value,2);
                        input_value = String.valueOf(dec);
                        outputbox.setText(input_value);
                    }
                    else if(intype.getText().toString().equals("Decimal"))//input is decimal and output is binary
                    {
                        input_value = inputbox.getText().toString();
                        int bin = Integer.parseInt(input_value);
                        input_value = Integer.toBinaryString(bin);
                        outputbox.setText(input_value);
                    }

                }
            }
        });

        swap.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(intype.getText().toString().equals("Binary"))
                {
                    intype.setText(R.string.decimal);
                    outtype.setText(R.string.binary);
                }
                else
                {
                    intype.setText(R.string.binary);
                    outtype.setText(R.string.decimal);
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