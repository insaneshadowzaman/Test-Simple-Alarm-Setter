package com.learning.insanes.calenderalarm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ChooseType extends Activity {

    public static final String IS_NORMAL = "IS_NORMAL";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_type);


        findViewById(R.id.normal_cal_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseType.this, TimePickerActivity.class);
                intent.putExtras(getIntent());
                intent.putExtra(IS_NORMAL, true);
                startActivity(intent);
            }
        });
        findViewById(R.id.book_reminder_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseType.this, TimePickerActivity.class);
                intent.putExtras(getIntent());
                intent.putExtra(IS_NORMAL, false);
                startActivity(intent);
            }
        });
    }
}
