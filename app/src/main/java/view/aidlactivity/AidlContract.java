package view.aidlactivity;

import android.content.Context;
import android.content.ServiceConnection;

import view.BasePresenter;
import view.BaseView;

/**
 * Created by kiwic on 1/30/2018.
 */

public interface AidlContract {
    interface View extends BaseView {
        void updateResult(String resultName);
        void updateServiceConnection(ServiceConnection CommunicateServiceConnection);
    }

    interface AidlPresenter extends BasePresenter<View> {
        void userNameInput(Context context, String name);
        void initiateConnection(Context context, ServiceConnection CommunicateServiceConnection);
    }
}
