package view.foreignexchangerate;

import android.util.Log;

/**
 * Created by kiwic on 2/8/2018.
 */

public class LoginInteractor implements FERContract.Interactor{
    public static final String TAG = "LoginInteractorTAG";
FERContract.InteactorOutput inteactorOutput = new FERContract.InteactorOutput() {
    @Override
    public void onLoginSuccess(String saySomething) {
        Log.d(TAG, "onLoginSuccess: ");
;
    }

    @Override
    public void onLoginError(String msg) {

    }

    @Override
    public void showError(String s) {

    }
};




    @Override
    public void attachView(FERContract.InteactorOutput view) {
        this.inteactorOutput = view;
    }

    @Override
    public void detachView() {
        this.inteactorOutput = null;
    }


    @Override
    public void login(String var1, String var2) {
        Log.d(TAG, "login: "+var1 + var2);
        inteactorOutput.onLoginSuccess("done!!!");

    }
}
