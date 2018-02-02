package com.software.huaman.visaservice;

import android.app.Service;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.software.huaman.visaprep.ICommunicate;
import com.software.huaman.visaservice.contentprovider.DatabaseHelper;


public class AdditionalService extends Service {

    private static final String TAG = "AdditionalServiceTag";

    public static final String KIWI_NAME ="Name";
    private static final String AUTHORITY = "com.example.admin.week5monhw.ContactsProvider";
    private static final String BASE_PATH = "contacts";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + BASE_PATH );

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

    IComDB.Stub mbinderdb = new IComDB.Stub(){


        @Override
        public void shareMerchantSearch() throws RemoteException {
            MainActivity ma = new MainActivity();
            ma.dbAccess();

        }
    };


   // ICommunicate.Stub mbinder
}
