package com.encoders.eva.testreflectionapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        doReflextionOperation();
    }

    private void doReflextionOperation() {
        Class systemClock = null;
        try {
            systemClock = Class.forName("android.telephony.TelephonyManager");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Method[] methods = systemClock.getDeclaredMethods();
        for (Method method :
                methods) {
            Log.d("sayanReflextion",method.getName());
        }
    }
}
