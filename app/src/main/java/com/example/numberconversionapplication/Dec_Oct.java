package com.example.numberconversionapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Dec_Oct extends AppCompatActivity
{
    ImageButton swap4;
    EditText inputbox4;
    TextView intype4, outtype4, outputbox4;
    Button convert4;
    String input_value4;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dec_oct);

        swap4 = findViewById(R.id.swap4);
        inputbox4 = findViewById(R.id.input_box4);
        intype4 = findViewById(R.id.input_type4);
        outtype4 = findViewById(R.id.output_type4);
        outputbox4 = findViewById(R.id.output_box4);
        convert4 = findViewById(R.id.convert_btn4);

        convert4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(TextUtils.isEmpty(inputbox4.getText().toString()))
                {
                    Toast.makeText(Dec_Oct.this, R.string.Enter_The_Numer,Toast.LENGTH_LONG).show();
                }
                else
                {
                    //input is decimal and output is hexadecimal
                    if(intype4.getText().toString().equals("Decimal"))
                    {
                        input_value4 = inputbox4.getText().toString();
                        int dec = Integer.parseInt(input_value4);
                        input_value4 = Integer.toOctalString(dec);
                        outputbox4.setText(input_value4);
                    }
                    else if(intype4.getText().toString().equals("Octal"))
                    {
                        input_value4 = inputbox4.getText().toString();
                        int num = Integer.parseInt(input_value4);
                        while (num > 0)
                        {
                            if (num % 10 > 7)
                            {
                                Toast.makeText(Dec_Oct.this,"Enter a octal number",Toast.LENGTH_LONG).show();
                            }
                            num = num/10;
                        }
                        int oct = Integer.parseInt(input_value4,8);
                        input_value4 = String.valueOf(oct);
                        outputbox4.setText(input_value4);
                    }

                }
            }
        });

        swap4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(intype4.getText().toString().equals("Decimal"))
                {
                    intype4.setText(R.string.octal);
                    outtype4.setText(R.string.decimal);
                }
                else
                {
                    intype4.setText(R.string.decimal);
                    outtype4.setText(R.string.octal);
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