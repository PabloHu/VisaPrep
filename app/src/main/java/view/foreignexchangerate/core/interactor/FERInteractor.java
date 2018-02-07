package view.foreignexchangerate.core.interactor;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import retrofit2.Response;
import view.foreignexchangerate.api.FERAPIEndpoint;
import view.foreignexchangerate.core.entity.api.FERResponse;
import view.foreignexchangerate.core.interactor.contract.FERViewModelInteractorContract;

/**
 * Created by kiwic on 2/5/2018.
 */
public class FERInteractor{

}
/*
public class FERInteractor  extends RetrofitApiInteractor<FERViewModelInteractorContract>
{
    private static final String UNITS_METRIC = "metric";


    @Override
    public FERViewModelInteractorContract initDataContract()
    {
        return new FERViewModelInteractorContract()
        {
            @Override
            public String getLastLocation()
            {
                SharedPreferences mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                return mSharedPreferences.getString(PREF_KEY_LAST_WEATHER_LOCATION, DEFAULT_LAST_WEATHER_LOCATION_VALUE);
            }


            @Override
            public void setLastLocation(String location)
            {
                SharedPreferences mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                mSharedPreferences.edit().putString(PREF_KEY_LAST_WEATHER_LOCATION, location).apply();
            }


            @Override
            public Observable<Response<FERResponse>> loadCurrentWeather(String location)
            {
                return getRetrofit().create(FERAPIEndpoint.class)
                        .getCurrentWeather(location, UNITS_METRIC)
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}
*/