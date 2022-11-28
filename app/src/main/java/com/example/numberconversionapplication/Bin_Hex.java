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

public class Bin_Hex extends AppCompatActivity
{

    ImageButton swap1;
    EditText inputbox1;
    TextView intype1, outtype1, outputbox1;
    Button convert1;

    String input_value1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_bin_hex);

        swap1 = findViewById(R.id.swap1);
        inputbox1 = findViewById(R.id.input_box1);
        intype1 = findViewById(R.id.input_type1);
        outtype1 = findViewById(R.id.output_type1);
        outputbox1 = findViewById(R.id.output_box1);
        convert1 = findViewById(R.id.convert_btn1);

        convert1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(TextUtils.isEmpty(inputbox1.getText().toString()))
                {
                    Toast.makeText(Bin_Hex.this,"Enter the number",Toast.LENGTH_LONG).show();
                }
                else
                {
                    if(intype1.getText().toString().equals("Binary"))
                    {
                        input_value1 = inputbox1.getText().toString();
                        int num = Integer.parseInt(input_value1);
                        while(num > 0)
                        {
                            if(num % 10 > 1)
                            {
                                Toast.makeText(Bin_Hex.this,"Enter a binary number",Toast.LENGTH_SHORT).show();
                            }
                            num = num / 10;
                        }
                        int hex = Integer.parseInt(input_value1, 2);
                        input_value1 = Integer.toHexString(hex);
                        outputbox1.setText(input_value1.toUpperCase());

                    }
                    else if(intype1.getText().toString().equals("Hexadecimal"))
                    {
                        input_value1 = inputbox1.getText().toString().toUpperCase();
                        // Size of string
                        int n = input_value1.length();

                        // Iterate over string
                        for (int i = 0; i < n; i++) {

                            char ch = input_value1.charAt(i);

                            // Check if the character is invalid
                            if ((ch < '0' || ch > '9') && (ch < 'A' || ch > 'F'))
                            {
                                Toast.makeText(Bin_Hex.this,"Enter a hexadecimal number",Toast.LENGTH_LONG).show();
                            }
                        }
                        int bin = Integer.parseInt(input_value1,16);
                        input_value1 = Integer.toBinaryString(bin);
                        outputbox1.setText(input_value1);
                    }
                }
            }
        });

        swap1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(intype1.getText().toString().equals("Binary"))
                {
                    intype1.setText(R.string.hexadecimal);
                    outtype1.setText(R.string.binary);
                    inputbox1.setInputType(InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS);
                }
                else
                {
                    intype1.setText(R.string.binary);
                    outtype1.setText(R.string.hexadecimal);
                    inputbox1.setInputType(InputType.TYPE_CLASS_NUMBER);

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