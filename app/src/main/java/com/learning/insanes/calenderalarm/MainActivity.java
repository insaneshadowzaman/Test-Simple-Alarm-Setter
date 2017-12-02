package com.learning.insanes.calenderalarm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends Activity {

    Button go;
    DatePicker datePicker;

    public static final String DAY = "DAY";
    public static final String MONTH = "MONTH";
    public static final String YEAR = "YEAR";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        go = findViewById(R.id.button_go_to_time);
        datePicker = findViewById(R.id.datePicker);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer day = datePicker.getDayOfMonth();
                Integer month = datePicker.getMonth();
                Integer year = datePicker.getYear();

                Intent intent = new Intent(MainActivity.this, TimePickerActivity.class);
                intent.putExtra(DAY, day);
                intent.putExtra(MONTH, month);
                intent.putExtra(YEAR, year);
                startActivity(intent);
            }
        });
    }
}
