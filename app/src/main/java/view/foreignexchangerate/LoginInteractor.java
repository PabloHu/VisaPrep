package view.foreignexchangerate;

import android.util.Log;

/**
 * Created by kiwic on 2/8/2018.
 */

public class LoginInteractor implements FERContract.Interactor {
    public static final String TAG = "LoginInteractorTAG";

    FERContract.InteactorOutput inteactorOutput;


    @Override
    public void login(String var1, String var2) {
        Log.d(TAG, "login: " + var1 + var2);
        inteactorOutput.onLoginSuccess("done!!!");

    }

    @Override
    public void attachView(FERContract.InteactorOutput view) {
        this.inteactorOutput = view;
    }

    @Override
    public void detachView() {
        inteactorOutput = null;
    }
}
