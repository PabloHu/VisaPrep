package com.software.huaman.visaservice.contentprovider;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kiwic on 2/1/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    List<ContactObj> contactObjList=new ArrayList<>();

    private static final String DATABASE_NAME="visaPrepDB";
    private static final int DATABASE_VERSION=1;
    public static final String TABLE_NAME="merchantsearch";

    public static final String MS_ID ="ID";
    public static final String MS_NAME ="Name";
    public static final String MS_CITY ="City";
    public static final String MS_STATE ="State";
    public static final String MS_POSTALCODE ="PostalCode";
    public static final String MS_TIMESTAMP ="TimeStamp";
    private static final String TAG = "DatabaseTAG";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("+
                MS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                MS_NAME + " CHAR(50) NOT NULL," +
                MS_CITY + " CHAR(50)," +
                MS_STATE + " CHAR(50)," +
                MS_POSTALCODE + " CHAR(50)," +
                MS_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP"+
                ")";

        sqLiteDatabase.execSQL(CREATE_TABLE);

        autoFillData(sqLiteDatabase);


    }

    public void autoFillData(SQLiteDatabase sqLiteDatabase){
        ContentValues values = new ContentValues();
        values.put(MS_NAME, "cmu edctn materials cntr");
        values.put(MS_CITY, "Mount Pleasant");
        values.put(MS_STATE, "MI");
        values.put(MS_POSTALCODE, "48858");
        sqLiteDatabase.insert(TABLE_NAME, null,values);
        values = new ContentValues();
        values.put(MS_NAME, "cmu edctn materials cntr 2");
        values.put(MS_CITY, "Mount Pleasant 2");
        values.put(MS_STATE, "MI 2");
        values.put(MS_POSTALCODE, "48858 2");
        sqLiteDatabase.insert(TABLE_NAME, null,values);
        values = new ContentValues();
        values.put(MS_NAME, "cmu edctn materials cntr 3");
        values.put(MS_CITY, "Mount Pleasant 3");
        values.put(MS_STATE, "MI 3");
        values.put(MS_POSTALCODE, "48858 3");
        sqLiteDatabase.insert(TABLE_NAME, null,values);
        values = new ContentValues();
        values.put(MS_NAME, "cmu edctn materials cntr 4");
        values.put(MS_CITY, "Mount Pleasant 4");
        values.put(MS_STATE, "MI 4");
        values.put(MS_POSTALCODE, "48858 4");
        sqLiteDatabase.insert(TABLE_NAME, null,values);
        values = new ContentValues();
        values.put(MS_NAME, "cmu edctn materials cntr 5");
        values.put(MS_CITY, "Mount Pleasant 5");
        values.put(MS_STATE, "MI 5");
        values.put(MS_POSTALCODE, "48858 5");
        sqLiteDatabase.insert(TABLE_NAME, null,values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public long createDB(String name, String phone ){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues  contentValues = new ContentValues();
        contentValues.put(MS_NAME, name);
        contentValues.put(MS_CITY, phone);
        contentValues.put(MS_STATE, phone);
        contentValues.put(MS_POSTALCODE, phone);
        //contentValues.put(KIWI_LASTNAME,lastName);
        //contentValues.put(KIWI_CELL,cell);
        //contentValues.put(KIWI_NOTE,note);

        //sqLiteDatabase.insert(TABLE_NAME,null,contentValues);//null is if you are passing no values
        long rowNumber = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        Log.d(TAG, "saveNewContact: "+rowNumber);
        return rowNumber;
    }

    public Cursor readDB(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String query = "SELECT * FROM "+ TABLE_NAME;
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);

        return cursor;


    }
    public void updateDB(int id, String name, String city, String state, String postalCode){

        Log.d(TAG, "updateKiwi id: " + id);

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String query = "UPDATE "+ TABLE_NAME+ " SET " + MS_NAME+ " = '"+ name +
                " "+ MS_CITY +" = '" + city+"'"+
                " "+ MS_STATE +" = '" + state+"'"+
                " "+ MS_POSTALCODE +" = '" + postalCode+"'"+
                " WHERE " + MS_ID + " = " + id;

        try {
            sqLiteDatabase.execSQL(query);
            Log.d(TAG, "updateKiwi work");
        }
        catch (Exception e){
            Log.d(TAG, "updateKiwi err: " + e.toString());
        }


    }

}
