package view.checkout;

/**
 * Created by kiwic on 1/31/2018.
 */

public class CheckoutPresenter implements CheckoutContract.CheckoutPresenter {

    CheckoutContract.View view;

    @Override
    public void attachView(CheckoutContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
this.view = null;
    }

    @Override
    public void validateInput(String inputString) {

        view.updateView(inputString);
    }
}
