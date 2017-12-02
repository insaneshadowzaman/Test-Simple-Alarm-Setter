package com.learning.insanes.calenderalarm;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class TimePickerActivity extends Activity {
    Button go;
    TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker);
        go = findViewById(R.id.button_go_to_start);
        timePicker = findViewById(R.id.timePicker);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer hour, minute;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    hour = timePicker.getHour();
                    minute = timePicker.getMinute();
                } else {
                    hour = timePicker.getCurrentHour();
                    minute = timePicker.getCurrentMinute();
                }

                Calendar cal = Calendar.getInstance();
                Integer day = getIntent().getIntExtra(MainActivity.DAY, cal.get(Calendar.DAY_OF_MONTH));
                Integer month = getIntent().getIntExtra(MainActivity.MONTH, cal.get(Calendar.MONTH));
                Integer year = getIntent().getIntExtra(MainActivity.YEAR, cal.get(Calendar.YEAR));

                cal.set(Calendar.YEAR, year);
                cal.set(Calendar.MONTH, month);
                cal.set(Calendar.DAY_OF_MONTH, day);
                cal.set(Calendar.HOUR_OF_DAY, hour);
                cal.set(Calendar.MINUTE, minute);

                AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
                Intent intt = new Intent(TimePickerActivity.this, NotificationSender.class);
                PendingIntent pi = PendingIntent.getBroadcast(TimePickerActivity.this, 0, intt, PendingIntent.FLAG_UPDATE_CURRENT);
                if(am != null)
                    am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pi);

                Toast.makeText(TimePickerActivity.this, "Alarm set at " + String.valueOf(hour) + ":" + String.valueOf(minute), Toast.LENGTH_LONG).show();

                Intent intent = new Intent(TimePickerActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }
        });
    }
}
