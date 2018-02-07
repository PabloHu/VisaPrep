package view.foreignexchangerate;

import android.util.Log;

/**
 * Created by kiwic on 2/7/2018.
 */

public class SearchInteractor implements Interactors {

    Interactors interactors;
    SearchInteractor(Interactors interactors){
        this.interactors = interactors;
    }

    public void loginLogic(String user){
        Log.d(TAG, "loginLogic: ");
    }
}
