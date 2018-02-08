package view.merchantsearch;

import android.content.Context;
import android.content.ServiceConnection;

import java.util.List;

import model.MerchSearch;
import view.BasePresenter;
import view.BaseView;

/**
 * Created by kiwic on 1/31/2018.
 */

public interface MSContract {
    interface View extends BaseView {
        void updateMSView(List<MerchSearch> merchSearchList);

        void updateServiceConnection(ServiceConnection CommunicateServiceConnection);
    }

    interface MSPresenter extends BasePresenter<View> {
        void merchantSearch(Context context);

        void initiateConnection(Context context, ServiceConnection CommunicateServiceConnection);

    }
}
