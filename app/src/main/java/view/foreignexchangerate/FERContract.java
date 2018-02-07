package view.foreignexchangerate;

import android.content.Context;

import view.BasePresenter;
import view.BaseView;

/**
 * Created by kiwic on 2/7/2018.
 */

public interface FERContract {
    interface View extends BaseView {
       // void updateMSView(List<MerchSearch> merchSearchList);
        void updateFER(String n);
    }

    interface FERPresenter extends BasePresenter<View> {
        void FERSearch();


    }
}
