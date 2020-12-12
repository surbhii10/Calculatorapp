package com.surbhi100.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import org.mariuszgromada.math.mxparser.*;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.display);
        display.setShowSoftInputOnFocus(false); //to disable the default keyboard from popping up
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(getString(R.string.display).equals(display.getText().toString())) //to clear the default enter a value text
                {
                    display.setText("");
                }


            }
        });
    }
    private void updateText(String strToAdd)
    {
        String oldstr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftstr = oldstr.substring(0,cursorPos);
        String rightstr = oldstr.substring(cursorPos);
        if(getString(R.string.display).equals(display.getText().toString())) //if it is equals to enter a value, update it to whatever user presses
        {
            display.setText(strToAdd);
            display.setSelection(cursorPos + 1);

        }
        else {
            display.setText(String.format("%s%s%s", leftstr, strToAdd, rightstr));
            display.setSelection(cursorPos + 1);
        }

    }
    public void zeroBTN(View view)
    {
        updateText("0");

    }
    public void oneBTN(View view)
    {
        updateText("1");

    }
    public void twoBTN(View view)
    {
        updateText("2");

    }
    public void threeBTN(View view)
    {
        updateText("3");
    }
    public void fourBTN(View view)
    {
        updateText("4");

    }
    public void fiveBTN(View view)
    {
        updateText("5");

    }public void sixBTN(View view)
    {
        updateText("6");


    }public void sevenBTN(View view)
    {
        updateText("7");
    }
    public void eightBTN(View view)
    {
        updateText("8");


    }public void nineBTN(View view)
    {
        updateText("9");

    }
    public void paranthesisBTN(View view)
    {
        int cursorpos = display.getSelectionStart();
        int openPar = 0;
        int closePar = 0;
        int textlen = display.getText().length();
        for(int i= 0; i<cursorpos; i++)
        {
            if(display.getText().toString().substring(i, i+1).equals("("))
            {
                openPar +=1;
            }
            if(display.getText().toString().substring(i, i+1).equals(")"))
            {
                closePar +=1;
            }

        }
        if(openPar==closePar||display.getText().toString().substring(textlen-1, textlen).equals("("))
        {

                updateText("(");
            //display.setSelection(cursorpos+1);

            }
       else if(closePar<openPar&& !display.getText().toString().substring(textlen-1, textlen).equals(")"))
        {
            updateText(")");
            //display.setSelection(cursorpos+1);

        }
        display.setSelection(cursorpos+1);



    }
    public void expBTN(View view)
    {
        updateText("^");

    }
    public void plusminusBTN(View view)
    {
        updateText("-");

    }
    public void addBTN(View view)
    {
        updateText("+");

    }public void substractBTN(View view)
    {
        updateText("-");

    }public void multiplyBTN(View view)
    {
        updateText("*");
    }
    public void divideBTN(View view)
    {
       updateText("/");
    }
    public void clearBTN(View view)
    {
        display.setText("");
    }
    public void backspaceBTN(View view)
    {
    int cursorPos = display.getSelectionStart();
    int textlen = display.getText().length();
    if(cursorPos!=0&&textlen!=0)
    {
        SpannableStringBuilder selection = (SpannableStringBuilder)display.getText();
        selection.replace(cursorPos-1, cursorPos, "");
        display.setText(selection); //upate text
        display.setSelection(cursorPos-1); //update cursor postion

    }

    }
    public void equalsBTN(View view)
    {
        String userExp = display.getText().toString();
        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());
        display.setText(result);
        display.setSelection(result.length());

    }
    public void dotBTN(View view)
    {
        updateText(".");

    }













}
