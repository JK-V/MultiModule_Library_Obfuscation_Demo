package com.example.middleware;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import com.example.core.CoreInterface;


public class CoreImpl implements CoreInterface {
    @Override
    public String getData(Activity activity) {
        Log.d("Sandeep","I am CoreImpl");
        DataProvider provider = new DataProvider();
        return provider.getData();
    }
}
