package com.example.numberconversionapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.*;

public class Hex_Oct extends AppCompatActivity {

    ImageButton swap5;
    EditText inputbox5;
    TextView intype5, outtype5, outputbox5;
    Button convert5;
    String input_value5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_hex_oct);

        swap5 = findViewById(R.id.swap5);
        inputbox5 = findViewById(R.id.input_box5);
        intype5 = findViewById(R.id.input_type5);
        outtype5 = findViewById(R.id.output_type5);
        outputbox5 = findViewById(R.id.output_box5);
        convert5 = findViewById(R.id.convert_btn5);

        convert5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(TextUtils.isEmpty(inputbox5.getText().toString()))
                {
                    Toast.makeText(Hex_Oct.this, R.string.Enter_The_Numer,Toast.LENGTH_LONG).show();
                }
                else
                {
                    //input is decimal and output is hexadecimal
                    if(intype5.getText().toString().equals("Hexadecimal"))
                    {
                        input_value5 = inputbox5.getText().toString().toUpperCase();
                        // Size of string
                        int n = input_value5.length();

                        // Iterate over string
                        for (int i = 0; i < n; i++) {

                            char ch = input_value5.charAt(i);

                            // Check if the character is invalid
                            if ((ch < '0' || ch > '9') && (ch < 'A' || ch > 'F'))
                            {
                                Toast.makeText(Hex_Oct.this,"Enter a hexadecimal number",Toast.LENGTH_LONG).show();
                            }
                        }
                        int hex = Integer.parseInt(input_value5,16);
                        input_value5 = Integer.toOctalString(hex);
                        outputbox5.setText(input_value5);
                    }
                    else if(intype5.getText().toString().equals("Octal"))
                    {
                        input_value5 = inputbox5.getText().toString();
                        int num = Integer.parseInt(input_value5);
                        while (num > 0)
                        {
                            if (num % 10 > 7)
                            {
                                Toast.makeText(Hex_Oct.this,"Enter a octal number",Toast.LENGTH_LONG).show();
                            }
                            num = num/10;
                        }
                        int oct = Integer.parseInt(input_value5,8);
                        input_value5 = Integer.toHexString(oct);
                        outputbox5.setText(input_value5.toUpperCase());
                    }

                }
            }
        });

        swap5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(intype5.getText().toString().equals("Hexadecimal"))
                {
                    intype5.setText(R.string.octal);
                    outtype5.setText(R.string.hexadecimal);
                }
                else
                {
                    intype5.setText(R.string.hexadecimal);
                    outtype5.setText(R.string.octal);
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