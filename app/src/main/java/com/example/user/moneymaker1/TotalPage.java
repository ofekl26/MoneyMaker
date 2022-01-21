package com.example.user.moneymaker1;
import android.os.Bundle;
import android.widget.EditText;

public class TotalPage extends AfterCalcScr  {
    private double salary, TotTime;
    private EditText ET3, ET4;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);
        salary = AfterCalcScr.salary;
        TotTime = MainActivity.TotTime;
        ET3 = (EditText) findViewById(R.id.ET3);
        ET4 = (EditText) findViewById(R.id.ET4);
        ET3.setText(Double.toString(salary));
        ET4.setText(Double.toString(TotTime));
    }

}
