package view.foreignexchangerate;

import android.util.Log;

import view.checkout.CheckoutContract;

/**
 * Created by kiwic on 2/7/2018.
 */

public class SearchInteractor  {

MyListener myListener;
    // constructor
    SearchInteractor(MyListener ml) {
        this.myListener = ml;
    }
    public void callback(CheckoutContract.View view, String result) {
        myListener.callback((CheckoutContract.View) this, "success");
    }
}
