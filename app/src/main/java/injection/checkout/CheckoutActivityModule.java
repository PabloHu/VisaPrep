package injection.checkout;

import dagger.Module;
import dagger.Provides;
import view.checkout.CheckoutContract;
import view.checkout.CheckoutPresenter;

/**
 * Created by kiwic on 1/31/2018.
 */

@Module
public class CheckoutActivityModule {

    @Provides
    CheckoutPresenter getCheckoutPresenter() {
        return new CheckoutPresenter();
    }

}
