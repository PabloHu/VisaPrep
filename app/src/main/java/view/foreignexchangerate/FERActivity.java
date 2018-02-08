package view.foreignexchangerate;

import android.content.ServiceConnection;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.software.huaman.visaprep.R;

import view.foreignexchangerate.adapter.FERVAdapter;
import view.foreignexchangerate.model.FERResponse;

public class FERActivity extends AppCompatActivity implements FERContract.View {
    RecyclerView rvFerSearch;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.ItemAnimator itemAnimator;

    Button btnFER;
    ServiceConnection CommunicateServiceConnection;

    public static final String TAG ="FERActivityTAG";
    FERPresenter ferpresenter = new FERPresenter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fer2);
        ferpresenter.attachView(this);

        initConnection();
        rvFerSearch = (RecyclerView) findViewById(R.id.rvFER);

        btnFER = (Button) findViewById(R.id.btnFER);
        btnFER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ferpresenter.FERSearch(getBaseContext());
            }
        });

    }

    private void initConnection() {
        ferpresenter.initiateConnection(this, CommunicateServiceConnection);
    }

    @Override
    public void showError(String s) {

    }

    @Override
    public void updateFERView(FERResponse ferResponse) {
        Log.d(TAG, "updateFERView: " + ferResponse.getCardAcceptor().getAddress().getState());

        FERVAdapter fervAdapter = new FERVAdapter(ferResponse, this);
        rvFerSearch.setAdapter(fervAdapter);
        layoutManager = new LinearLayoutManager(this);
        itemAnimator = new DefaultItemAnimator();
        rvFerSearch.setLayoutManager(layoutManager);
        rvFerSearch.setItemAnimator(itemAnimator);
    }

    @Override
    public void updateServiceConnection(ServiceConnection CommunicateServiceConnection) {
        this.CommunicateServiceConnection = CommunicateServiceConnection;
        Log.d(TAG, "updateServiceConnection: successul Activity");
    }


    @Override
    protected void onDestroy() {
        ferpresenter.detachView();
        super.onDestroy();
    }



}
