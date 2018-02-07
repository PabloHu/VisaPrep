package view.foreignexchangerate;

/**
 * Created by kiwic on 2/7/2018.
 */

public interface Interactors {

    interface FERPResenter{
        public void onLogicButtonPressed(String a);
    }
    interface InteractorOutput{
        public void onSuccess(String user);
        public void onLoginError(String message);
    }
}
