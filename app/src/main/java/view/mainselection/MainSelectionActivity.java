package view.mainselection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.software.huaman.visaprep.R;

public class MainSelectionActivity extends AppCompatActivity implements Contract.View {

    Presenter presenter = new Presenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_selection);

    }

    public void userSelection(View view) {

        presenter.userBtnSelection(this, view.getId());

    }

    @Override
    public void showError(String s) {

    }
}
