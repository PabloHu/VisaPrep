package view.foreignexchangerate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.software.huaman.visaprep.R;

public class FERActivity extends AppCompatActivity implements FERContract.View , FERContract.InteactorOutput{
public static final String TAG ="FERActivityTAG";
    FERPresenter ferpresenter = new FERPresenter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fer2);
        ferpresenter.attachView(this);

        ferpresenter.onLoginButtonPressed("kiwi", "Chito");
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


    @Override
    public void onLoginSuccess(String saySomething) {
        Log.d(TAG, "onLoginSuccess!!!!!: " +saySomething);
    }

    @Override
    public void onLoginError(String msg) {
        Log.d(TAG, "onLoginError: ");
    }
}
