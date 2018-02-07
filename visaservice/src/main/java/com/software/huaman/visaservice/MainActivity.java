package com.software.huaman.visaservice;

import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.software.huaman.visaservice.contentprovider.DatabaseHelper;

public class MainActivity extends AppCompatActivity {

    public static final String MS_NAME = "Name";
    private static final String AUTHORITY = "com.software.huaman.visaservice.contentprovider.MerchSearchProvider";
    private static final String BASE_PATH = "merchantsearch";
    private static final String BASE_CHECKOUT_PATH = "checkout";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + BASE_PATH);
    public static final Uri CONTENT_CHECKOUT_URI = Uri.parse("content://" + AUTHORITY + "/" + BASE_CHECKOUT_PATH);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void dbAccess() {
        DatabaseHelper starterDB = new DatabaseHelper(this);
        starterDB.readDB();

        Uri contentURI = CONTENT_URI;


        Cursor cursor = getContentResolver().query(contentURI, null, null, null, null);

        while (cursor.moveToNext()) {
            String result = cursor.getString(cursor.getColumnIndex(MS_NAME));
            Log.d("TAG", "DB: " + result);
        }
    }

    public void dbCheckoutAccess() {
        DatabaseHelper starterDB = new DatabaseHelper(this);
        starterDB.readDB();

        Uri contentURI = CONTENT_CHECKOUT_URI;


        Cursor cursor = getContentResolver().query(contentURI, null, null, null, null);

        while (cursor.moveToNext()) {
            String result = cursor.getString(cursor.getColumnIndex(MS_NAME));
            Log.d("TAG", "DB: " + result);
        }
    }
}
