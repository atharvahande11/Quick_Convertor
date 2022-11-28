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

public class Bin_Oct extends AppCompatActivity
{
    ImageButton swap2;
    EditText inputbox2;
    TextView intype2, outtype2, outputbox2;
    Button convert2;

    String input_value2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_bin_oct);

        swap2 = findViewById(R.id.swap2);
        inputbox2 = findViewById(R.id.input_box2);
        intype2 = findViewById(R.id.input_type2);
        outtype2 = findViewById(R.id.output_type2);
        outputbox2 = findViewById(R.id.output_box2);
        convert2 = findViewById(R.id.convert_btn2);

        convert2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(TextUtils.isEmpty(inputbox2.getText().toString()))
                {
                    Toast.makeText(Bin_Oct.this, R.string.Enter_The_Numer,Toast.LENGTH_LONG).show();
                }
                else
                {
                    //input is binary and output is octal
                    if(intype2.getText().toString().equals("Binary"))
                    {
                        int r=0,c = 0,b;
                        input_value2 = inputbox2.getText().toString();
                        int num = Integer.parseInt(input_value2);
                        b = num;
                        while(num > 0)
                        {
                            if((num % 10 == 0)||(num % 10 == 1))
                            {
                                c++;
                                r++;
                                num=num/10;
                            }
                        }
                        if (c != r) {
                            Toast.makeText(Bin_Oct.this,"Enter a binary number",Toast.LENGTH_LONG).show();
                        } else {
                            int oct = Integer.parseInt(input_value2,2);
                            input_value2 = Integer.toOctalString(oct);
                            outputbox2.setText(input_value2);
                        }


                    }
                    else
                    {
                        if(intype2.getText().toString().equals("Octal"))
                        {
                            input_value2 = inputbox2.getText().toString();
                            int num = Integer.parseInt(input_value2);
                            while (num > 0)
                            {
                                if (num % 10 > 7)
                                {
                                    Toast.makeText(Bin_Oct.this,"Enter a octal number",Toast.LENGTH_LONG).show();
                                }
                                num = num/10;
                            }
                            int bin = Integer.parseInt(input_value2,8);
                            input_value2 = Integer.toBinaryString(bin);
                            outputbox2.setText(input_value2);
                        }
                    }
                }
            }
        });

        swap2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(intype2.getText().toString().equals("Binary"))
                {
                    intype2.setText(R.string.octal);
                    outtype2.setText(R.string.binary);
                }
                else
                {
                    intype2.setText(R.string.binary);
                    outtype2.setText(R.string.octal);
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