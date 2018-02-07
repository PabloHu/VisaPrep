package view.foreignexchangerate;

import view.checkout.CheckoutContract;

/**
 * Created by kiwic on 2/7/2018.
 */

public interface MyListener {
    // you can define any parameter as per your requirement
    public void callback(CheckoutContract.View view, String result);
}
