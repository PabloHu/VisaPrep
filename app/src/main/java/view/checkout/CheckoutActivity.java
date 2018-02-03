package view.checkout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.software.huaman.visaprep.R;

import javax.inject.Inject;

import butterknife.ButterKnife;
import injection.checkout.DaggerCheckoutActivityComponent;

public class CheckoutActivity extends AppCompatActivity implements CheckoutContract.View {

    @Inject
    CheckoutPresenter checkoutPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        ButterKnife.bind(this);
        setupDaggerComponent();
        checkoutPresenter.attachView(this);
    }

    private void setupDaggerComponent() {
    DaggerCheckoutActivityComponent.create().inject(this);
    }

    @Override
    public void showError(String s) {

    }

    @Override
    public void updateView(String str) {

    }
}
