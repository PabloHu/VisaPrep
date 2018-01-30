package view.aidlactivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.widget.Toast;

import com.software.huaman.visaprep.ICommunicate;

import view.mainselection.Contract;

import static android.content.Context.BIND_AUTO_CREATE;


/**
 * Created by kiwic on 1/30/2018.
 */

public class AidlPresenter implements AidlContract.Presenter {
    private static final String TAG = "AidlPresenterTag";
    AidlContract.View view;
    Context context;

    ICommunicate CommunicateService;
    ServiceConnection CommunicateServiceConnection;




    @Override
    public void attachView(Contract.View view) {
        
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void userNameInput(Context context, String name) {

        String result = "";
        Log.d(TAG, "btnCommunicate: " + "Starting");

        try {
            result = CommunicateService.concatWelcome(name);
            Log.d(TAG, "btnCommunicate: " + "done adding");
        } catch (RemoteException e) {
            Log.d(TAG, "initConnection: " + e.toString());
        }

        view.updateResult(result);
    }

    @Override
    public void initiateConnection(Context context) {
        this.context = context;
        CommunicateServiceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                CommunicateService = ICommunicate.Stub.asInterface((IBinder) iBinder);

               // Toast.makeText(context, "Communicate Service Connected", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onServiceConnected: Binding is done - Service Connected");
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {

                CommunicateService = null;
             //   Toast.makeText(context, "Service disconnected", Toast.LENGTH_SHORT).show();
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
    }

}
