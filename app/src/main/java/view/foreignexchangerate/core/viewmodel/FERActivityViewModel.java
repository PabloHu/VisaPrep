package view.foreignexchangerate.core.viewmodel;

import android.databinding.Bindable;
import android.databinding.ObservableField;

//import com.android.databinding.library.baseAdapters.BR;

import retrofit2.Response;
import view.foreignexchangerate.core.entity.api.FERResponse;
import view.foreignexchangerate.core.interactor.FERInteractor;
import view.foreignexchangerate.core.interactor.contract.FERViewModelInteractorContract;
import view.foreignexchangerate.core.viewinteractor.FERPresenterViewModelContract;

/**
 * Created by kiwic on 2/3/2018.
 */
public class FERActivityViewModel{

}
/*
public class FERActivityViewModel extends ViewModel<FERInteractor, FERViewModelInteractorContract>
    {

        public final ObservableField<StatefulLayout.State> state = new ObservableField<>(StatefulLayout.State.CONTENT);
        private final FERPresenterViewModelContract mPresenterViewModelContract;

        private FERResponse mCurrentWeatherEntity;


	public FERActivityViewModel(FERPresenterViewModelContract contract)
        {
            this.mPresenterViewModelContract = contract;
        }


        @Override
        public FERInteractor initInteractor()
        {
            return new FERInteractor();
        }


    public void setupWeatherInformation(final String location)
    {
        if(state.get() != StatefulLayout.State.PROGRESS)
            state.set(StatefulLayout.State.CONTENT);

        getInteractor().loadCurrentWeather(location).subscribe(new Action1<Response<CurrentWeatherEntity>>()
        {
            @Override
            public void call(Response<FERResponse> ferResponseResponse)
            {
                if(ferResponseResponse.isSuccessful())
                {
                    setCurrentWeatherEntity(ferResponseResponse.body());
                    getInteractor().setLastLocation(location);
                }

                state.set(ferResponseResponse.isSuccessful() ? StatefulLayout.State.CONTENT : StatefulLayout.State.EMPTY);

                FERActivityViewModel.this.mPresenterViewModelContract.onWeatherInformationReady(ferResponseResponse.isSuccessful());
            }
        });


    }


    public String getLastLocation()
    {
        return this.getInteractor().getLastLocation();
    }




    @Bindable
    public CurrentWeatherEntity getCurrentWeatherEntity()
    {
        return this.mCurrentWeatherEntity;
    }


    private void setCurrentWeatherEntity(final CurrentWeatherEntity currentWeatherEntity)
    {
        this.mCurrentWeatherEntity = currentWeatherEntity;
        notifyPropertyChanged(BR.currentWeatherEntity);
    }


}*/