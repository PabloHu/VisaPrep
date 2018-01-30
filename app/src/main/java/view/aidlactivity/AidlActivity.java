package view.aidlactivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.software.huaman.visaprep.ICommunicate;
import com.software.huaman.visaprep.R;

public class AidlActivity extends AppCompatActivity implements AidlContract.View{

    AidlPresenter presenter = new AidlPresenter();
    private static final String TAG = "AidlActivityTag";
    EditText etName;
    TextView tvResult;


    ICommunicate CommunicateService;
    ServiceConnection CommunicateServiceConnection;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aidl);
        etName = (EditText) findViewById(R.id.etName);
        tvResult = (TextView) findViewById(R.id.tvResult);

        initConnection();
    }

    private void initConnection() {

        CommunicateServiceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                CommunicateService = ICommunicate.Stub.asInterface((IBinder) iBinder);
                Toast.makeText(AidlActivity.this, "Communicate Service Connected", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onServiceConnected: Binding is done - Service Connected");
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {

                CommunicateService = null;
                Toast.makeText(AidlActivity.this, "Service disconnected", Toast.LENGTH_SHORT).show();
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
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(CommunicateServiceConnection);
    }

    public void btnCommunicate(View view) {

        String result = "";
        Log.d(TAG, "btnCommunicate: " + "Starting");

        try {
            result = CommunicateService.concatWelcome(etName.getText().toString());
            Log.d(TAG, "btnCommunicate: " + "done adding");
        } catch (RemoteException e) {
            Log.d(TAG, "initConnection: " + e.toString());
        }

        tvResult.setText(result);
    }


    @Override
    public void showError(String s) {

    }

    @Override
    public void updateResult(String resultName) {

    }
}
