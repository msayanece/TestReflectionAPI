package com.encoders.eva.testreflectionapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import java.util.ArrayList;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        doReflextionOperation();
        TestModel testModelObject = new TestModel("aa", "bb", "cc", "dd", "ee");
        callAllGetterMethodsInTestModel(testModelObject);
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

    private void callAllGetterMethodsInTestModel(TestModel testModelObject) {
        try {
            Class testModelClass = Class.forName("com.encoders.eva.testreflectionapi.TestModel");
            Method[] methods = testModelClass.getDeclaredMethods();
            ArrayList<String> getterResults = new ArrayList<>();
            for (Method method :
                    methods) {
                if (method.getName().startsWith("get")){
                    getterResults.add((String) method.invoke(testModelObject));
                }
            }
            Log.d("sayanReflextion", "==>: "+getterResults.toString());
        } catch (ClassNotFoundException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
