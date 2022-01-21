package com.example.user.moneymaker1;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AfterCalcScr extends Activity implements View.OnClickListener
{
    private Button DoneBtn;
    private EditText ET1, ET2;
    private double tips=0 , cuts = 0;
    public static double salary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aftercalc);
        salary = MainActivity.salary;
        ET1 = (EditText) findViewById(R.id.ET1);
        ET2 = (EditText) findViewById(R.id.ET2);
        DoneBtn = (Button) findViewById(R.id.done);
        DoneBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (ET1.getText() != null) {
            tips = Double.parseDouble(ET1.getText().toString());
        } else {
            tips = 0.0;
        }
        if (ET2.getText() != null) {
            cuts = Double.parseDouble(ET2.getText().toString());
        } else {
            cuts = 0.0;
        }
        salary += tips;
        salary -= cuts;
        Log.i("checkS", Double.toString(salary));
        Intent intent = new Intent(AfterCalcScr.this, TotalPage.class);
        startActivity(intent);


    }
}
