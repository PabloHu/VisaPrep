package view.mainselection;

import android.content.Context;
import android.content.Intent;

import com.software.huaman.visaprep.R;

import view.aidlactivity.AidlActivity;
import view.foreignexchangerateNotGOOOD.activity.FERActivity;
import view.merchantsearch.MSActivity;

/**
 * Created by kiwic on 1/30/2018.
 */

public class Presenter implements Contract.Presenter {

    Contract.View view;


    @Override
    public void attachView(Contract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;

    }

    @Override
    public void userBtnSelection(Context context, int activitySelected) {

        switch (activitySelected) {
            case R.id.btnAidl:
                Intent intent = new Intent(context, AidlActivity.class);
                context.startActivity(intent);
                break;
            case R.id.btnMerchantSearch:
                Intent merchantIntent = new Intent(context, MSActivity.class);
                context.startActivity(merchantIntent);
                break;

            case R.id.btnForeignExchange:
                Intent fer = new Intent(context, view.foreignexchangerate.FERActivity.class);
                context.startActivity(fer);
                break;
        }


    }
}
