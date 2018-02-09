package com.software.huaman.visaprep;

import android.app.Instrumentation;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.util.Log;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import model.MerchSearch;
import view.merchantsearch.MSActivity;
import view.merchantsearch.MSContract;
import view.merchantsearch.MSPresenter;

import static android.content.Context.BIND_AUTO_CREATE;
import static org.junit.Assert.assertEquals;

/**
 * Created by kiwic on 2/6/2018.
 */

public class MSPresenterTest extends MSActivity implements MSContract.View{
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
    ServiceConnection CommunicateServiceConnection;
    ICommunicate CommunicateService;
    private MSPresenter msPresenter;
    MerchSearch merchSearch;
    List<MerchSearch> merchSearchList = new ArrayList<>();

    @Before
    public void setup(){

        msPresenter = new MSPresenter();
        msPresenter.attachView(this);
    }

    @Test
    public void initTest(){
        msPresenter.initiateConnection(createDeviceProtectedStorageContext(), CommunicateServiceConnection);



        //-------------
        ServiceConnection CommunicateServiceConnectionExpected = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                CommunicateService = ICommunicate.Stub.asInterface((IBinder) iBinder);

           //     Log.d(TAG, "onServiceConnected: Binding is done - Service Connected!");
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {

                CommunicateService = null;
              //  Log.d(TAG, "onServiceDisconnected: Binding - Service Disconnected");
            }
        };
        if (CommunicateService == null) {

            Intent serviceIntent = new Intent().
                    setComponent(new ComponentName(
                            "com.software.huaman.visaservice",
                            "com.software.huaman.visaservice.AdditionalService"));


            createDeviceProtectedStorageContext().startService(serviceIntent);
            createDeviceProtectedStorageContext().bindService(serviceIntent, CommunicateServiceConnectionExpected, BIND_AUTO_CREATE);
        }





        assertEquals("Fail", CommunicateServiceConnectionExpected, CommunicateServiceConnection);
       // view.updateServiceConnection(CommunicateServiceConnection);
    }

    @Test
    public void merchantSearchTest(){
        Cursor cursor = createDeviceProtectedStorageContext().getContentResolver().query(contentURI, null, null, null, null);

        List<MerchSearch> merchSearchListExpected = new ArrayList<>();

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

            merchSearchListExpected.add(merchSearch);


        }
        /*
        for (int i = 0; i < merchSearchList.size(); i++) {
            Log.d(TAG, "onCreate: " + merchSearchList.get(i).getId()
                    + " - " + merchSearchList.get(i).getName()
                    + " - " + merchSearchList.get(i).getCity()
                    + " - " + merchSearchList.get(i).getState()
                    + " - " + merchSearchList.get(i).getPostalCode()
                    + " - " + merchSearchList.get(i).getLogo()
            );


        }
*/
        msPresenter.merchantSearch(createDeviceProtectedStorageContext());
        assertEquals("Fail", merchSearchListExpected, CommunicateServiceConnection);

    }
    @Override
    public void showError(String s) {

    }

    @Override
    public void updateMSView(List<MerchSearch> merchSearchList) {
        this.merchSearchList =merchSearchList;
    }

    @Override
    public void updateServiceConnection(ServiceConnection CommunicateServiceConnection) {
        this.CommunicateServiceConnection = null;
        this.CommunicateServiceConnection = CommunicateServiceConnection;
    }
}
