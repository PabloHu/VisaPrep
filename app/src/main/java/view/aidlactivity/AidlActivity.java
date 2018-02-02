package view.aidlactivity;

import android.content.ServiceConnection;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.software.huaman.visaprep.R;

public class AidlActivity extends AppCompatActivity implements AidlContract.View {

    AidlPresenter aidlPresenter = new AidlPresenter();
    private static final String TAG = "AidlActivityTag";
    EditText etName;
    TextView tvResult;

    ServiceConnection CommunicateServiceConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aidl);
        etName = (EditText) findViewById(R.id.etName);
        tvResult = (TextView) findViewById(R.id.tvResult);
        aidlPresenter.attachView(this);
        initConnection();
    }

    private void initConnection() {
        aidlPresenter.initiateConnection(this, CommunicateServiceConnection);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(CommunicateServiceConnection);
        Log.d(TAG, "onDestroy: ");
    }

    public void btnCommunicate(View view) {
        aidlPresenter.userNameInput(this, etName.getText().toString());
    }


    @Override
    public void showError(String s) {
        Log.d(TAG, "showError: " + s.toString());
    }

    @Override
    public void updateResult(String welcomeSomeone) {
        tvResult.setText(welcomeSomeone);
    }

    @Override
    public void updateServiceConnection(ServiceConnection CommunicateServiceConnection) {
        this.CommunicateServiceConnection = CommunicateServiceConnection;
    }
}
