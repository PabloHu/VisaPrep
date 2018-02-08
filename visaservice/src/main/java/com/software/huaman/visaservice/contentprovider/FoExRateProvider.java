package com.software.huaman.visaservice.contentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by kiwic on 2/8/2018.
 */

public class FoExRateProvider extends ContentProvider {

    private static final String AUTHORITY = "com.software.huaman.visaservice.contentprovider.FoExRateProvider";
    private static final String BASE_PATH = "exchangerate";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + BASE_PATH);

    private static final int MERCHSEARCH = 1;

    private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        uriMatcher.addURI(AUTHORITY, BASE_PATH, MERCHSEARCH);
    }


    DatabaseHelper databaseHelper;


    @Nullable
    @Override
    public String getType(Uri uri) {

        switch (uriMatcher.match(uri)) {
            case MERCHSEARCH:
                return "vnd.android.cursor.dir/vnd.com.example.admin.week5monhw/merchantsearch";
            default:
                throw new IllegalArgumentException("This is an Unknown URI " + uri);
        }
    }

    @Override
    public boolean onCreate() {
        databaseHelper = new DatabaseHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings1, String s1) {
        Cursor cursor;

        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
        cursor = sqLiteDatabase.query(BASE_PATH, strings, s, strings1, null, null, s1);
        cursor.setNotificationUri(
                getContext().getContentResolver(), CONTENT_URI);


        return cursor;
    }


    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {

        throw new SQLException("Insertion Failed for URI :" + uri);

    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {


        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {

        return 0;
    }
}