package view.checkout;

import view.BasePresenter;
import view.BaseView;

/**
 * Created by kiwic on 1/31/2018.
 */

public interface CheckoutContract {

    interface View extends BaseView{
        void updateView(String str);
    }

    interface CheckoutPresenter extends BasePresenter<View> {
        void validateInput(String inputString);
    }
}
