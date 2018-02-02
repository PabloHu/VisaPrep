package injection.checkout;

import dagger.Component;
import view.checkout.CheckoutActivity;

/**
 * Created by kiwic on 1/31/2018.
 */

@Component(modules = CheckoutActivityModule.class)
public interface CheckoutActivityComponent {

    void inject(CheckoutActivity createCheckoutActivity);

}