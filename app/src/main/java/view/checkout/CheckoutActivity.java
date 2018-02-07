package view.checkout;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.software.huaman.visaprep.ICommunicate;
import com.software.huaman.visaprep.R;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import injection.checkout.DaggerCheckoutActivityComponent;
import model.MerchSearch;
import view.checkout2.model.CheckoutResponse;
import view.checkout2.model.PaymentInstrument;
import view.checkout2.model.ShippingAddress;
//import injection.checkout.DaggerCheckoutActivityComponent;

public class CheckoutActivity extends AppCompatActivity implements CheckoutContract.View {


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
    //   MerchSearch merchSearch;
    @Inject
    CheckoutPresenter checkoutPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        ButterKnife.bind(this);
        setupDaggerComponent();
        checkoutPresenter.attachView(this);

        initConnection();
    }

    private void initConnection() {

        //CommunicateServiceConnection = CommunicateServiceConnection;
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


        //------------------------
        String result = "-->>";


        Cursor cursor = getContentResolver().query(contentURI, null, null, null, null);

        List<MerchSearch> merchSearchList = new ArrayList<>();

        while (cursor.moveToNext()) {
            checkoutResponse = new CheckoutResponse();
            // merchSearch = new MerchSearch();

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

            checkoutResponse.setShippingAddress(shippingAddress);


        }
        //  for (int i = 0; i < checkoutResponselist.size(); i++) {
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

        // }
    }

    private void setupDaggerComponent() {
        DaggerCheckoutActivityComponent.create().inject(this);
    }

    @Override
    public void showError(String s) {

    }

    @Override
    public void updateView(String str) {

    }
}
