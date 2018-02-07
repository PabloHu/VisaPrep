package view.foreignexchangerate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.software.huaman.visaprep.R;

public class FERActivity extends AppCompatActivity implements FERContract.View {

    FERPresenter ferpresenter = new FERPresenter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fer2);
        ferpresenter.attachView(this);

        //ferpresenter.FERSearch();
    }

    @Override
    public void showError(String s) {

    }

    @Override
    public void updateFER(String n) {

    }

    @Override
    protected void onDestroy() {
        ferpresenter.detachView();
        super.onDestroy();
    }



}
