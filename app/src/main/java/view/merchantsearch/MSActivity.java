package view.merchantsearch;

import android.content.ServiceConnection;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.software.huaman.visaprep.R;

public class MSActivity extends AppCompatActivity implements MSContract.View {

    MSPresenter mspresenter = new MSPresenter();
    Button btnMerchantSearch;
    ServiceConnection CommunicateServiceConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchant_search);
        mspresenter.attachView(this);




        initConnection();


        btnMerchantSearch = (Button) findViewById(R.id.btnMerchantSearch);
        btnMerchantSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mspresenter.merchantSearch(getBaseContext());
            }
        });
    }

    private void initConnection() {
        mspresenter.initiateConnection(this, CommunicateServiceConnection);
    }

    @Override
    public void showError(String s) {

    }

    @Override
    public void updateResult(String resultName) {
        Toast.makeText(this, resultName, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void updateMS(String resultName) {

    }

    @Override
    public void updateServiceConnection(ServiceConnection CommunicateServiceConnection) {
        this.CommunicateServiceConnection = CommunicateServiceConnection;
    }
}
