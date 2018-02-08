package view.merchantsearch;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.util.Log;

import com.software.huaman.visaprep.ICommunicate;

import java.util.ArrayList;
import java.util.List;

import model.MerchSearch;


import static android.content.Context.BIND_AUTO_CREATE;

/**
 * Created by kiwic on 1/31/2018.
 */

public class MSPresenter implements MSContract.MSPresenter {
    public static final String MS_ID = "ID";
    public static final String MS_NAME = "Name";
    public static final String MS_CITY = "City";
    public static final String MS_STATE = "State";
    public static final String MS_POSTALCODE = "PostalCode";
    public static final String MS_LOGO = "Logo";

    private static final String AUTHORITY = "com.software.huaman.visaservice.contentprovider.MerchSearchProvider";
    private static final String BASE_PATH = "merchantsearch";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + BASE_PATH);
    Uri contentURI = CONTENT_URI;
    MerchSearch merchSearch;

    Context context;

    ICommunicate CommunicateService;
    ServiceConnection CommunicateServiceConnection;

    private static final String TAG = "MSPresenterTag";
    MSContract.View view;

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

        Cursor cursor = context.getContentResolver().query(contentURI, null, null, null, null);

        List<MerchSearch> merchSearchList = new ArrayList<>();

        while (cursor.moveToNext()) {
            merchSearch = new MerchSearch();

            int dbGetId = cursor.getInt(cursor.getColumnIndex(MS_ID));
            String dbGetName = cursor.getString(cursor.getColumnIndex(MS_NAME));
            String dbGetCity = cursor.getString(cursor.getColumnIndex(MS_CITY));
            String dbGetState = cursor.getString(cursor.getColumnIndex(MS_STATE));
            String dbGetPostalCode = cursor.getString(cursor.getColumnIndex(MS_POSTALCODE));
            String dbGetLogo = cursor.getString(cursor.getColumnIndex(MS_LOGO));

            merchSearch.setId(dbGetId);
            merchSearch.setName(dbGetName);
            merchSearch.setCity(dbGetCity);
            merchSearch.setState(dbGetState);
            merchSearch.setPostalCode(dbGetPostalCode);
            merchSearch.setLogo(dbGetLogo);

            merchSearchList.add(merchSearch);


        }
        for (int i = 0; i < merchSearchList.size(); i++) {
            Log.d(TAG, "onCreate: " + merchSearchList.get(i).getId()
                    + " - " + merchSearchList.get(i).getName()
                    + " - " + merchSearchList.get(i).getCity()
                    + " - " + merchSearchList.get(i).getState()
                    + " - " + merchSearchList.get(i).getPostalCode()
                    + " - " + merchSearchList.get(i).getLogo()
            );

        }

        view.updateMSView(merchSearchList);
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
