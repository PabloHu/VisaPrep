package view.foreignexchangerate;

import android.content.Context;
import android.content.ServiceConnection;

import java.util.List;

import model.MerchSearch;
import view.BasePresenter;
import view.BaseView;
import view.foreignexchangerate.model.FERResponse;

/**
 * Created by kiwic on 2/7/2018.
 */

public interface FERContract {
    interface View extends BaseView {
        void updateFERView(FERResponse ferResponse);
        void updateServiceConnection(ServiceConnection CommunicateServiceConnection);
    }
    interface FERPresenter extends BasePresenter<View> {
        void onDestroy();
        void FERSearch(Context context);
        void initiateConnection(Context context, ServiceConnection CommunicateServiceConnection);
    }

    interface FERInteractorOutput  {
        void onServConnSuccess(ServiceConnection CommunicateServiceConnection);
    }
    interface FERInteractor {
        void serviceConnection(Context context, ServiceConnection CommunicateServiceConnection);
    }
    interface SearchInteractorOutput  {
        void onSearchSuccess(FERResponse ferResponse);
    }
    interface SearchInteractor {
        void searchFER(Context context);
    }




}
