package view.merchantsearch;

import android.content.Intent;
import android.content.ServiceConnection;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.software.huaman.visaprep.R;

import java.util.List;

import model.MerchSearch;

public class MSActivity extends AppCompatActivity implements MSContract.View {

    RecyclerView rvMerchSearch;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.ItemAnimator itemAnimator;

    MSPresenter mspresenter = new MSPresenter();
    Button btnMerchantSearch;
    ServiceConnection CommunicateServiceConnection;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchant_search);
        mspresenter.attachView(this);



        initConnection();
        rvMerchSearch = (RecyclerView) findViewById(R.id.rvMerchSearch);

        btnMerchantSearch = (Button) findViewById(R.id.btnMerchantSearch);
        btnMerchantSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mspresenter.merchantSearch(getBaseContext());
            }
        });


        /*
        //---------test launch other app
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.software.huaman.visaservice");
        if (launchIntent != null) {
            startActivity(launchIntent);//null pointer check in case package name was not found
        }
        */
    }

    private void initConnection() {
        mspresenter.initiateConnection(this, CommunicateServiceConnection);
    }

    @Override
    public void showError(String s) {

    }

    @Override
    public void updateMSView(List<MerchSearch> merchSearchList) {
        MSRVAdapter msrvAdapter = new MSRVAdapter(merchSearchList, this);
        rvMerchSearch.setAdapter(msrvAdapter);
        layoutManager = new LinearLayoutManager(this);
        itemAnimator = new DefaultItemAnimator();
        rvMerchSearch.setLayoutManager(layoutManager);
        rvMerchSearch.setItemAnimator(itemAnimator);
    }

    @Override
    public void updateServiceConnection(ServiceConnection CommunicateServiceConnection) {
        this.CommunicateServiceConnection = CommunicateServiceConnection;
    }
}
