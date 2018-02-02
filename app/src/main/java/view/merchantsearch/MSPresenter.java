package view.merchantsearch;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.software.huaman.visaprep.ICommunicate;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

import static android.content.Context.BIND_AUTO_CREATE;

/**
 * Created by kiwic on 1/31/2018.
 */

public class MSPresenter implements MSContract.MSPresenter {
    public static final String MS_NAME ="Name";
    public static final String MS_CITY ="City";
    private static final String AUTHORITY = "com.software.huaman.visaservice.contentprovider.ContactsProvider";
    private static final String BASE_PATH = "merchantsearch";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + BASE_PATH );
    Uri contentURI = CONTENT_URI;
    ContactObj contactObj;

    private static final String TAG = "MSPresenterTag";
    MSContract.View view;
    Context context;

    ICommunicate CommunicateService;
    ServiceConnection CommunicateServiceConnection;

    @Override
    public void attachView(MSContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void merchantSearch(Context context) {
        String result = "-->>";



        Cursor cursor = context.getContentResolver().query(contentURI, null, null, null, null);

        List<ContactObj> contactObjList = new ArrayList<>();

        while(cursor.moveToNext()){
            contactObj = new ContactObj();


            String dbGetName = cursor.getString(cursor.getColumnIndex(MS_NAME));
            String dbGetPhone = cursor.getString(cursor.getColumnIndex(MS_CITY));

            contactObj.setName(dbGetName);
            contactObj.setPhone(dbGetPhone);

            contactObjList.add(contactObj);

//            Log.d("TAG", "DBreq: " + result);


        }
        for (int i = 0; i <contactObjList.size() ; i++) {
            Log.d(TAG, "onCreate: "+contactObjList.get(i).getName() + " " + contactObjList.get(i).getPhone());

        }
/*
        RequestAppFragment requestAppFragment  = RequestAppFragment.newInstance(contactObjList);
        this.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.flFragHolderCarOptions, requestAppFragment, CAR_OPTIONS_FRAGMENT_TAG)
                .addToBackStack(CAR_OPTIONS_FRAGMENT_TAG)

                .commit();
     */
        view.updateResult(result);
    }

    @Override
    public void initiateConnection(Context context, ServiceConnection CommunicateServiceConnection) {
        this.context = context;
        this.CommunicateServiceConnection = CommunicateServiceConnection;
        CommunicateServiceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                CommunicateService = ICommunicate.Stub.asInterface((IBinder) iBinder);

                Log.d(TAG, "onServiceConnected: Binding is done - Service Connected!");
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {

                CommunicateService = null;
                Log.d(TAG, "onServiceDisconnected: Binding - Service Disconnected");
            }
        };
        if (CommunicateService == null) {

            Intent serviceIntent = new Intent().
                    setComponent(new ComponentName(
                            "com.software.huaman.visaservice",
                            "com.software.huaman.visaservice.AdditionalService"));
            context.startService(serviceIntent);
            context.bindService(serviceIntent, CommunicateServiceConnection, BIND_AUTO_CREATE);
        }
        view.updateServiceConnection(CommunicateServiceConnection);
    }
}
