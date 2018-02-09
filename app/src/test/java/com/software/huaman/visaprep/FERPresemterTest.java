package com.software.huaman.visaprep;

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

import view.foreignexchangerate.FERActivity;
import view.foreignexchangerate.FERContract;
import view.foreignexchangerate.FERPresenter;
import view.foreignexchangerate.interactors.SearchRateInteractor;
import view.foreignexchangerate.interactors.ServiceConnectionInteractor;
import view.foreignexchangerate.model.Address;
import view.foreignexchangerate.model.CardAcceptor;
import view.foreignexchangerate.model.FERResponse;

import static org.junit.Assert.assertEquals;

/**
 * Created by kiwic on 2/9/2018.
 */

public class FERPresemterTest extends FERActivity implements FERContract.View{
    public static final String ER_ID = "ID";
    public static final String ER_ADDRESS = "Address";
    public static final String ER_DESTCURRENCYCODE = "DestCurrencyCode";
    public static final String ER_MARKUPRATE = "MarkupRate";
    public static final String ER_RETRREFNUMBER = "RetrRefNumber";
    public static final String ER_SOURCEAMOUNT = "SourceAmount";
    public static final String ER_SOURCECURRENCYCODE = "SourceCurrencyCode";
    public static final String ER_SYSTRACEAUDITNUM = "SysTraceAuditNumber";

    private static final String AUTHORITY = "com.software.huaman.visaservice.contentprovider.FoExRateProvider";
    private static final String BASE_PATH = "exchangerate";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + BASE_PATH);
    Uri contentURI = CONTENT_URI;
    ServiceConnection CommunicateServiceConnection;
    ICommunicate CommunicateService;
    private FERPresenter ferPresenter;
    FERContract.View view;
    FERContract.FERInteractor ferInteractor;
    FERContract.SearchInteractor searchInteractor;
    FERResponse ferResponse;
    @Before
    public void setup(){

      // f//erPresenter = new FERPresemterTest();
       // ferPresenter.attachView(this);
        this.view = view;
        this.ferInteractor = new ServiceConnectionInteractor((FERContract.FERInteractorOutput) this);
        this.searchInteractor = new SearchRateInteractor((FERContract.SearchInteractorOutput) this);
    }

    @Test
    public void initiateConnectionTest() {

        ServiceConnection CommunicateServiceConnectionExpected;

        CommunicateServiceConnectionExpected = new ServiceConnection() {
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
            createDeviceProtectedStorageContext().startService(serviceIntent);
            createDeviceProtectedStorageContext().bindService(serviceIntent, CommunicateServiceConnectionExpected, BIND_AUTO_CREATE);
        }
        //-------------
        ferInteractor.serviceConnection(createDeviceProtectedStorageContext(), CommunicateServiceConnection);
        assertEquals("Fail", createDeviceProtectedStorageContext(), CommunicateServiceConnection);
    }


    public void FERSearchTest()
    {

        Cursor cursor = createDeviceProtectedStorageContext().getContentResolver().query(contentURI, null, null, null, null);

        FERResponse ferResponseExpected = new FERResponse();
        while (cursor.moveToNext()) {

            int dbGetId = cursor.getInt(cursor.getColumnIndex(ER_ID));
            String dbGetAddress = cursor.getString(cursor.getColumnIndex(ER_ADDRESS));
            String dbGetDestCurrencyCode = cursor.getString(cursor.getColumnIndex(ER_DESTCURRENCYCODE));
            String dbGetMarkupRate = cursor.getString(cursor.getColumnIndex(ER_MARKUPRATE));
            String dbGetRetrRefNumber = cursor.getString(cursor.getColumnIndex(ER_RETRREFNUMBER));
            String dbGetSourceAmount = cursor.getString(cursor.getColumnIndex(ER_SOURCEAMOUNT));
            String dbGetSourceCurrencyCode = cursor.getString(cursor.getColumnIndex(ER_SOURCECURRENCYCODE));
            String dbGetSysTraceAuditnum = cursor.getString(cursor.getColumnIndex(ER_SYSTRACEAUDITNUM));

            Address address = new Address();
            address.setState(dbGetAddress);
            CardAcceptor cardAcceptor = new CardAcceptor();
            cardAcceptor.setAddress(address);

            ferResponseExpected.setCardAcceptor(cardAcceptor);
            ferResponseExpected.setDestinationCurrencyCode(dbGetDestCurrencyCode);
            ferResponseExpected.setMarkUpRate(dbGetMarkupRate);
            ferResponseExpected.setRetrievalReferenceNumber(dbGetRetrRefNumber);
            ferResponseExpected.setSourceAmount(dbGetSourceAmount);
            ferResponseExpected.setSourceCurrencyCode(dbGetSourceCurrencyCode);
            ferResponseExpected.setSystemsTraceAuditNumber(dbGetSysTraceAuditnum);

        }

        searchInteractor.searchFER(createDeviceProtectedStorageContext());

        assertEquals("Fail", ferResponseExpected, ferResponse);

    }
    @Override
    public void showError(String s) {

    }

    @Override
    public void updateFERView(FERResponse ferResponse) {
this.ferResponse = ferResponse;
    }

    @Override
    public void updateServiceConnection(ServiceConnection CommunicateServiceConnection) {
        this.CommunicateServiceConnection = null;
        this.CommunicateServiceConnection = CommunicateServiceConnection;
    }
}
