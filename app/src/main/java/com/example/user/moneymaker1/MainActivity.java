package com.example.user.moneymaker1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.Calendar;


public class MainActivity extends Activity implements View.OnClickListener {

    private Button StartBtn,EndBtn;
    private EditText ET;
    public static double salary, money, TotTime;
    private Calendar c1,c2;
    private long start_time,end_time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ET=(EditText)findViewById(R.id.ET);
        EndBtn= (Button) findViewById(R.id.fin_b);
        StartBtn= (Button) findViewById(R.id.start_b);
        StartBtn.setOnClickListener(this);
        EndBtn.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.start_b:
                start_time=System.currentTimeMillis();
                //c1=Calendar.getInstance();
                if(ET.getText()!=null) {
                    money = Double.parseDouble(ET.getText().toString());
                }
                else
                {
                    money =0.0;
                }
            break;
            case R.id.fin_b:
                end_time=System.currentTimeMillis();
                //c2=Calendar.getInstance();
                //int hours1 = c1.get(Calendar.HOUR);
                //int hours2 = c2.get(Calendar.HOUR);
               // int min1 = c1.get(Calendar.MINUTE);
                //int min2 = c2.get(Calendar.MINUTE);
                //double TotHrs, TotMin;
                /*if (c1.get(Calendar.DAY_OF_MONTH) == c2.get(Calendar.DAY_OF_MONTH))
                {
                    if(min2>min1) {
                        TotMin = min2 - min1;
                        TotMin = TotMin/60;
                        TotHrs = hours2- hours1;
                        TotTime = TotHrs+TotMin;
                    }
                    else
                    {
                        if (min2==min1)
                            TotTime = hours2-hours1;
                        if (min1>min2)
                        {
                            TotHrs = hours2-hours1-1;
                            TotMin = min2-min1+60;
                            TotMin = TotMin/60;
                            TotTime = TotHrs+TotMin;
                        }
                    }
                }
                else
                {
                    if(min2>min1) {
                        TotMin = min2 - min1;
                        TotMin = TotMin/60;
                        TotHrs = 24-(hours1- hours2);
                        TotTime = TotHrs+TotMin;
                    }
                    if (min2==min1)
                        TotTime = 24-(hours1-hours2);
                    if (min1>min2)
                    {
                        TotHrs = 23-(hours1- hours2);
                        TotMin = min2-min1+60;
                        TotMin = TotMin/60;
                        TotTime = TotHrs+TotMin;
                    }
                }*/
               // TotTime=hours2+min2/60;
                TotTime=(double) ((end_time-start_time)/3600000.0);
                Log.d("myTag",Double.toString(TotTime));
                salary=TotTime*money;
                Intent intent= new Intent(MainActivity.this, AfterCalcScr.class);
                startActivity(intent);
                Log.i("zagzag", Double.toString(money));
                Log.i("CheckSA", Double.toString(salary));
        }
    }
}
