package com.example.batterycheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv_current_battery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // for full screen
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );

        tv_current_battery = findViewById(R.id.current_battery);

        this.registerReceiver(this.broadcastReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

    }

    private final BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int lvl = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
            String s_lvl = String.valueOf(lvl) + "%";
            tv_current_battery.setText(s_lvl);
        }
    };

}