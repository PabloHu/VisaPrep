package view.foreignexchangerateNotGOOOD.util;

import android.support.annotation.NonNull;

import java.util.Locale;

/**
 * Created by kiwic on 2/5/2018.
 */

public class StringUtils {
    public static String parseTemperature(@NonNull final Double value)
    {
        return String.format(Locale.getDefault(), "%.1f", value).replace(",", ".").concat("°C");
    }
}
