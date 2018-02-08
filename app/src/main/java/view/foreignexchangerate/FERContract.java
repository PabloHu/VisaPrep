package view.foreignexchangerate;

import android.content.Context;

import view.BasePresenter;
import view.BaseView;

/**
 * Created by kiwic on 2/7/2018.
 */

public interface FERContract {
    interface View extends BaseView {
        void updateFER(String n);
    }
    interface FERPresenter extends BasePresenter<View> {
        void onDestroy();
        void onLoginButtonPressed(String user, String pass);
    }

    interface InteactorOutput  extends  BaseView{
        void onLoginSuccess(String saySomething);
        void onLoginError(String msg);
    }
    interface Interactor extends BasePresenter<InteactorOutput>{
        void login(String var1,  String var2);
    }




    public interface Router {
        void unregister();

        void presentHomeScreen();
    }
}
