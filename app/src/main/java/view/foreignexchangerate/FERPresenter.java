package view.foreignexchangerate;

import android.content.Context;
import android.util.Log;

import view.checkout.CheckoutContract;

/**
 * Created by kiwic on 2/7/2018.
 */

public class FERPresenter implements FERContract.FERPresenter, FERContract.InteactorOutput {
    public static final String TAG = "FERPresenterTAG";
    FERContract.View view;
    FERContract.Interactor interactor = new LoginInteractor();
    Context context;



    @Override
    public void attachView(FERContract.View view) {
        this.view = view;

    }

    @Override
    public void detachView() {
        this.view = null;
    }


    @Override
    public void onDestroy() {
        view = null;

    }

    @Override
    public void onLoginButtonPressed(String user, String pass) {
        Log.d(TAG, "onLoginButtonPressed: ");

        interactor.login(user, pass);


    }


    @Override
    public void onLoginSuccess(String saySomething) {
        Log.d(TAG, "onLoginSuccess: ");
    }

    @Override
    public void onLoginError(String msg) {

    }

    @Override
    public void showError(String s) {

    }
}
