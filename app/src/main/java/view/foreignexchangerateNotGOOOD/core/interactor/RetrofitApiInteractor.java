package view.foreignexchangerateNotGOOOD.core.interactor;

/**
 * Created by kiwic on 2/5/2018.
 */
public class RetrofitApiInteractor{

}
/*
public class RetrofitApiInteractor<IDC> extends Interactors<IDC>
{

    private static final String QUERY_PARAM_APP_ID = "appid";
    private Retrofit mRetrofit;


    RetrofitApiInteractor()
    {
        this.mRetrofit = getRetrofitBuilder().build();
    }


    private Retrofit.Builder getRetrofitBuilder()
    {
        final Retrofit.Builder retrofitBuilder = new Retrofit.Builder();
        final OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor()
        {
            @Override
            public okhttp3.Response intercept(final Chain chain) throws IOException
            {
                final Request original = chain.request();
                final HttpUrl httpUrl = original.url().newBuilder()
                        .addQueryParameter(QUERY_PARAM_APP_ID, ApiConfig.OPENWEATHER_API_KEY)
                        .build();
                final Request request = original.newBuilder().url(httpUrl).build();
                return chain.proceed(request);
            }
        });
        retrofitBuilder.client(httpClient.build());
        retrofitBuilder.baseUrl(getBaseUrl());
        retrofitBuilder.addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()));
        retrofitBuilder.addConverterFactory(GsonConverterFactory.create());
        return retrofitBuilder;
    }


    private String getBaseUrl()
    {
        return ApiConfig.OPENWEATHER_API_BASE;
    }


    Retrofit getRetrofit()
    {
        return this.mRetrofit;
    }
}
*/