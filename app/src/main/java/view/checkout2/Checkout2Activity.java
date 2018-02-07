package view.checkout2;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.database.Cursor;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.software.huaman.visaprep.ICommunicate;
import com.software.huaman.visaprep.R;
import com.software.huaman.visaprep.databinding.ActivityCheckout2Binding;


import java.util.ArrayList;
import java.util.List;

import model.MerchSearch;
import view.checkout2.model.CheckoutResponse;
import view.checkout2.model.ShippingAddress;
import view.checkout2.viewmodel.CheckoutResponseModel;

public class Checkout2Activity extends AppCompatActivity {

    public static final String CK_ID = "ID";
    public static final String CK_CITY = "City";
    public static final String Ck_COUNTRYCODE = "CountryCode";
    public static final String CK_FIRSTNAME = "FirstName";
    public static final String CK_PERSON_ID = "PersonId";
    public static final String CK_LASTNAME = "LastName";
    public static final String CK_LINE1 = "Line1";
    public static final String CK_PERSONNAME = "PersonName";
    public static final String CK_POSTALCODE = "PostalCode";
    public static final String CK_STATEPROVIDENCECODE = "StateProvidenceCode";
    public static final String CK_VERIFICATIONSTATUS = "VerificationStatus";


    private static final String TAG = "CheckoutActivityTag";
    ServiceConnection CommunicateServiceConnection;
    ICommunicate CommunicateService;
    private static final String AUTHORITY = "com.software.huaman.visaservice.contentprovider.CheckoutProvider";
    private static final String BASE_PATH = "checkoutShipAdd";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + BASE_PATH);
    Uri contentURI = CONTENT_URI;
    CheckoutResponse checkoutResponse;


    ActivityCheckout2Binding activityCheckout2Binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initConnection();

        activityCheckout2Binding = DataBindingUtil.setContentView(this, R.layout.activity_checkout2);

        CheckoutResponseModel checkoutResponseModel = new CheckoutResponseModel(checkoutResponse);
        checkoutResponseModel.setShippingAddress(checkoutResponse.getShippingAddress());

        activityCheckout2Binding.setVisaCheckOut(checkoutResponseModel);
    }

    private void initConnection() {

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
            startService(serviceIntent);
            bindService(serviceIntent, CommunicateServiceConnection, BIND_AUTO_CREATE);
        }

        //--------------------

        Cursor cursor = getContentResolver().query(contentURI, null, null, null, null);

        while (cursor.moveToNext()) {
            ShippingAddress shippingAddress = new ShippingAddress();
            //  int dbGetId = cursor.getInt(cursor.getColumnIndex(CK_ID));
            String dbCity = cursor.getString(cursor.getColumnIndex(CK_CITY));
            String dbCountryCode = cursor.getString(cursor.getColumnIndex(Ck_COUNTRYCODE));
            String dbFirstName = cursor.getString(cursor.getColumnIndex(CK_FIRSTNAME));
            String dbCheckId = cursor.getString(cursor.getColumnIndex(CK_PERSON_ID));
            String dbLastName = cursor.getString(cursor.getColumnIndex(CK_LASTNAME));
            String dbLine1 = cursor.getString(cursor.getColumnIndex(CK_LINE1));
            String dbPersonName = cursor.getString(cursor.getColumnIndex(CK_PERSONNAME));
            String dbPostalCode = cursor.getString(cursor.getColumnIndex(CK_POSTALCODE));
            String dbStateProvidenceCode = cursor.getString(cursor.getColumnIndex(CK_STATEPROVIDENCECODE));
            String dbVerificationStatus = cursor.getString(cursor.getColumnIndex(CK_VERIFICATIONSTATUS));


            shippingAddress.setCity(dbCity);
            shippingAddress.setCountryCode(dbCountryCode);
            shippingAddress.setFirstName(dbFirstName);
            shippingAddress.setId(dbCheckId);
            shippingAddress.setLastName(dbLastName);
            shippingAddress.setLine1(dbLine1);
            shippingAddress.setPersonName(dbPersonName);
            shippingAddress.setPostalCode(dbPostalCode);
            shippingAddress.setStateProvinceCode(dbStateProvidenceCode);
            shippingAddress.setVerificationStatus(dbVerificationStatus);

            checkoutResponse = new CheckoutResponse();
            checkoutResponse.setShippingAddress(shippingAddress);


        }

        Log.d(TAG, "onCreate: " + checkoutResponse.getShippingAddress().getCity()
                + " - " + checkoutResponse.getShippingAddress().getCountryCode()
                + " - " + checkoutResponse.getShippingAddress().getFirstName()
                + " - " + checkoutResponse.getShippingAddress().getId()
                + " - " + checkoutResponse.getShippingAddress().getLastName()
                + " - " + checkoutResponse.getShippingAddress().getLine1()
                + " - " + checkoutResponse.getShippingAddress().getPersonName()
                + " - " + checkoutResponse.getShippingAddress().getPostalCode()
                + " - " + checkoutResponse.getShippingAddress().getStateProvinceCode()
                + " - " + checkoutResponse.getShippingAddress().getVerificationStatus()

        );


    }
}
