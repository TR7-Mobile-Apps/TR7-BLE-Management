package com.example.sitru.ble_management;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* set onClick listener */
        RelativeLayout relative1 = findViewById(R.id.layout_scanning);
        relative1.setOnClickListener(new HomeScreenClick());
        RelativeLayout relative2 = findViewById(R.id.layout_setting);
        relative2.setOnClickListener(new HomeScreenClick());
    }

    private void ChangeToScanningDevice() {
        startActivity(new Intent(getApplicationContext(), DeviceScanning.class));
    }

    private void ChangeToAppSetting() {

    }

    class HomeScreenClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.layout_scanning:
                    ChangeToScanningDevice();
                    break;

                case R.id.layout_setting:
                    ChangeToAppSetting();
                    break;
            }
        }
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
