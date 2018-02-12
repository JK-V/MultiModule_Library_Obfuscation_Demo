package com.example.obfuscationexample;

import android.app.Activity;

import com.example.core.CoreInterface;
import com.example.middleware.CoreImpl;
import com.example.middleware.MiddlewareInterface;


public class SdkManager {

    public String getCoreData(Activity activity){
        CoreInterface coreInterface = new CoreImpl();
        return  coreInterface.getData(activity);
    }

    public String getmiddlewareData(){
        MiddlewareInterface anInterface = new MiddlewareImpl();
        return anInterface.getMiddlewareData();
    }
}
