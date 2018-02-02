package view.aidlactivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.software.huaman.visaprep.ICommunicate;

import static android.content.Context.BIND_AUTO_CREATE;


/**
 * Created by kiwic on 1/30/2018.
 */

public class AidlPresenter implements AidlContract.AidlPresenter {
    private static final String TAG = "AidlPresenterTag";
    AidlContract.View view;
    Context context;

    ICommunicate CommunicateService;
    ServiceConnection CommunicateServiceConnection;


    @Override
    public void attachView(AidlContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void userNameInput(Context context, String name) {

        String result = "-->>";
        Log.d(TAG, "btnCommunicate: " + "Starting");

        try {
            result = CommunicateService.concatWelcome(name);
            Log.d(TAG, "btnCommunicate: " + "done adding");
        } catch (RemoteException e) {
            Log.d(TAG, "initConnection: " + e.toString());
        }

        view.updateResult(result);
    }

    //Initiate connettion to Server
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
