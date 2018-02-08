package view.foreignexchangerate;

import android.content.Context;
import android.content.ServiceConnection;
import android.util.Log;


import view.foreignexchangerate.interactors.SearchRateInteractor;
import view.foreignexchangerate.interactors.ServiceConnectionInteractor;
import view.foreignexchangerate.model.FERResponse;

/**
 * Created by kiwic on 2/7/2018.
 */

public class FERPresenter implements FERContract.FERPresenter, FERContract.FERInteractorOutput, FERContract.SearchInteractorOutput {
    public static final String TAG = "FERPresenterTAG";
    FERContract.View view;
    Context context;
    FERContract.FERInteractor ferInteractor;
    FERContract.SearchInteractor searchInteractor;


    @Override
    public void attachView(FERContract.View view) {
        this.view = view;
        this.ferInteractor = new ServiceConnectionInteractor((FERContract.FERInteractorOutput) this);
        this.searchInteractor = new SearchRateInteractor((FERContract.SearchInteractorOutput) this);
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
    public void FERSearch(Context context) {
        searchInteractor.searchFER(context);
    }

    @Override
    public void initiateConnection(Context context, ServiceConnection CommunicateServiceConnection) {
        ferInteractor.serviceConnection(context, CommunicateServiceConnection);
    }

    @Override
    public void onServConnSuccess(ServiceConnection CommunicateServiceConnection) {
        view.updateServiceConnection(CommunicateServiceConnection);
        Log.d(TAG, "onServConnSuccess: ");
    }

    @Override
    public void onSearchSuccess(FERResponse ferResponse) {
        view.updateFERView(ferResponse);
    }
}
