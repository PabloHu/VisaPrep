package view.foreignexchangerateNotGOOOD.core.interactor.contract;

import io.reactivex.Observable;
import retrofit2.Response;
import view.foreignexchangerateNotGOOOD.core.entity.api.FERResponse;

/**
 * Created by kiwic on 2/5/2018.
 */

public interface FERViewModelInteractorContract {
    String PREF_KEY_LAST_WEATHER_LOCATION = "last_weather_location";
    String DEFAULT_LAST_WEATHER_LOCATION_VALUE = "London";

    String getLastLocation();
    void setLastLocation(final String location);

    Observable<Response<FERResponse>> loadCurrentWeather(final String location);
}
