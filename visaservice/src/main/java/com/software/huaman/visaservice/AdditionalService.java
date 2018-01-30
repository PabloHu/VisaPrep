package com.software.huaman.visaservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.software.huaman.visaprep.ICommunicate;


public class AdditionalService extends Service {

    private static final String TAG = "AdditionalServiceTag";

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //   log("Received start command.");
        return START_STICKY;
    }

    public AdditionalService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        // throw new UnsupportedOperationException("Not yet implemented");
        return mbinder;
    }

    ICommunicate.Stub mbinder = new ICommunicate.Stub(){

        @Override
        public String concatWelcome(String name) throws RemoteException {
            Log.d(TAG, "concatWelcome: c");
            String a = "Welcome "+ name +"!";
            return a;
        }
    };


   // ICommunicate.Stub mbinder
}
