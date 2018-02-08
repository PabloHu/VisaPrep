package view.foreignexchangerate.interactors;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.IBinder;
import android.util.Log;
import com.software.huaman.visaprep.ICommunicate;

import view.foreignexchangerate.FERContract;

import static android.content.Context.BIND_AUTO_CREATE;

/**
 * Created by kiwic on 2/8/2018.
 */

public class ServiceConnectionInteractor implements FERContract.FERInteractor {
    FERContract.FERInteractorOutput ferInteractorOutput;

    private static final String AUTHORITY = "com.software.huaman.visaservice.contentprovider.FoExRateProvider";
    private static final String BASE_PATH = "exchangerate";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + BASE_PATH);
    Context context;

    ICommunicate CommunicateService;
    ServiceConnection CommunicateServiceConnection;

    public static final String TAG = "SCITAG";

    public ServiceConnectionInteractor(FERContract.FERInteractorOutput ferInteractorOutput) {
        this.ferInteractorOutput = ferInteractorOutput;
    }

    @Override
    public void serviceConnection(Context context, ServiceConnection CommunicateServiceConnection) {
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
        //-----

        ferInteractorOutput.onServConnSuccess(CommunicateServiceConnection);
    }
}
