package view.checkout2;

import android.databinding.DataBindingUtil;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.software.huaman.visaprep.R;
import com.software.huaman.visaprep.databinding.ActivityCheckout2Binding;

import view.checkout2.model.PartialShippingAddress;
import view.checkout2.viewmodel.CheckoutResponse;

public class Checkout2Activity extends AppCompatActivity {

    private ActivityCheckout2Binding activityCheckout2Binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_checkout2);

        activityCheckout2Binding = DataBindingUtil.setContentView(this,R.layout.activity_checkout2 );

        CheckoutResponse checkoutResponse = new CheckoutResponse(new PartialShippingAddress("t","g",""));
    }
}
