package view.foreignexchangerate;

import android.content.Context;

/**
 * Created by kiwic on 2/7/2018.
 */

public class FERPresenter implements FERContract.FERPresenter, Interactors {

    Interactors si;
    FERContract.View view;
    Context context;

    @Override
    public void attachView(FERContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void FERSearch() {

        si.
    }

}
