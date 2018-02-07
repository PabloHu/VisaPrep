package view.foreignexchangerate.activity;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

//import com.software.huaman.visaprep.BR;
import com.software.huaman.visaprep.R;
//import com.software.huaman.visaprep.databinding.ActivityFerBinding;

import view.BasePresenter;
import view.foreignexchangerate.core.ViperConfig;
import view.foreignexchangerate.core.presenter.FERActivityPresenter;

public class FERActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fer);
    }
}
/*
public class FERActivity extends BasePresenterActivity<FERActivityPresenter, ActivityFerBinding> {

    @Override
    public int getLayoutId()
    {
        return R.layout.activity_fer;
    }


    @Override
    protected ViperConfig setupViperConfig()
    {
        return new ViperConfig(BR.presenter);
    }


    @Override
    public FERActivityPresenter initPresenter()
    {
        return new FERActivityPresenter();
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setSupportActionBar(getBinding().toolbar);
    }

}
*/