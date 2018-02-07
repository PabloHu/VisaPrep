package view.foreignexchangerateNotGOOOD.core.router;

import android.content.Context;
import android.content.Intent;

import view.foreignexchangerateNotGOOOD.activity.FERActivity;

/**
 * Created by kiwic on 2/5/2018.
 */

public class FERRouter {
    public static void startActivity(Context context)
    {
        Intent intent = getActivityIntent(context);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }


    public static Intent getActivityIntent(Context context)
    {
        return new Intent(context, FERActivity.class);
    }
}

