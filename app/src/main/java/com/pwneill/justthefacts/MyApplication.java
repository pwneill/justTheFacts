package com.pwneill.justthefacts;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {
    private static com.pwneill.justthefacts.MyApplication mInstance;
    private static Context mAppContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        this.setAppContext(getApplicationContext());
    }

    public static com.pwneill.justthefacts.MyApplication getInstance(){
        return mInstance;
    }
    public static Context getAppContext() {
        return mAppContext;
    }
    public void setAppContext(Context mAppContext) {
        this.mAppContext = mAppContext;
    }
}
