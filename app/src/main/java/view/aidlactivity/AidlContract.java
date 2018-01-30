package view.aidlactivity;

import android.content.Context;

import view.BasePresenter;
import view.BaseView;

/**
 * Created by kiwic on 1/30/2018.
 */

public interface AidlContract {
    interface View extends BaseView {
        void updateResult(String resultName);
    }

    interface Presenter extends BasePresenter<view.mainselection.Contract.View> {
        void userNameInput(Context context, String name);
        void initiateConnection(Context context);
    }
}
