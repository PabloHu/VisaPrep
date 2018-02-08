package view.mainselection;

import android.content.Context;

import view.BasePresenter;
import view.BaseView;

/**
 * Created by kiwic on 1/30/2018.
 */

public interface Contract {

    interface View extends BaseView {

    }

    interface Presenter extends BasePresenter<View> {
        void userBtnSelection(Context context, int activitySelected);
    }


}
