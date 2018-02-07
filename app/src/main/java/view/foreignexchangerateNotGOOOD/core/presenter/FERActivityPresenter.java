package view.foreignexchangerateNotGOOOD.core.presenter;

//import com.software.huaman.visaprep.databinding.ActivityFerBinding;

/*
public class FERActivityPresenter{

}
*/
/**
 * Created by kiwic on 2/3/2018.
 */
public class FERActivityPresenter{

}
/*
public class FERActivityPresenter extends Presenter<FERActivityViewModel, ActivityFerBinding> implements FERActivityViewInteractor, FERPresenterViewModelContract {


    @Override
    public FERActivityViewModel initViewModel()
    {
        return new FERActivityViewModel(this);
    }


    @Override
    public void onPresenterCreated()
    {
        super.onPresenterCreated();

        getBinding().weatherLocation.setText(getViewModel().getLastLocation());

        refreshWeatherData();
    }


    @Override
    public void onLocationSubmit()
    {
        refreshWeatherData();
    }


    @Override
    public void onWeatherInformationReady(boolean successfully)
    {
        getBinding().requestState.setText(successfully ?
                getContext().getString(R.string.success) : getContext().getString(R.string.errr));
    }


    private void refreshWeatherData()
    {
        getViewModel().setupWeatherInformation(getBinding().weatherLocation.getText().toString());
    }
}
*/
