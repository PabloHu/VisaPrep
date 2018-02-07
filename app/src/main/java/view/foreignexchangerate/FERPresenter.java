package view.foreignexchangerate;

import android.content.Context;

import view.checkout.CheckoutContract;

/**
 * Created by kiwic on 2/7/2018.
 */

public class FERPresenter implements FERContract.FERPresenter {


    SearchInteractor searchInteractor;

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

SearchInteractor m = new SearchInteractor((MyListener) this);
m.callback((CheckoutContract.View) this, "Something");

    }


}
