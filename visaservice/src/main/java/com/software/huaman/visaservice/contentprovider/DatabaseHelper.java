package com.software.huaman.visaservice.contentprovider;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by kiwic on 2/1/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="visaPrepDB";
    private static final int DATABASE_VERSION=1;
    public static final String TABLE_NAME="merchantsearch";

    public static final String MS_ID ="ID";
    public static final String MS_NAME ="Name";
    public static final String MS_CITY ="City";
    public static final String MS_STATE ="State";
    public static final String MS_POSTALCODE ="PostalCode";
    public static final String MS_LOGO ="Logo";
    public static final String MS_TIMESTAMP ="TimeStamp";

    //-----
    public static final String TABLE2_NAME="exchangerate";

    public static final String ER_ID ="ID";
    public static final String ER_ADDRESS ="Address";
    public static final String ER_DESTCURRENCYCODE ="DestCurrencyCode";
    public static final String ER_MARKUPRATE ="MarkupRate";
    public static final String ER_RETRREFNUMBER ="RetrRefNumber";
    public static final String ER_SOURCEAMOUNT ="SourceAmount";
    public static final String ER_SOURCECURRENCYCODE ="SourceCurrencyCode";
    public static final String ER_SYSTRACEAUDITNUM ="SysTraceAuditNumber";

    public static final String ER_TIMESTAMP ="TimeStamp";

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
                MS_LOGO + " CHAR(500)," +
                MS_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP"+
                ")";

        sqLiteDatabase.execSQL(CREATE_TABLE);

        autoFillData(sqLiteDatabase);

        //SECOND TABLE
        CREATE_TABLE = "CREATE TABLE " + TABLE2_NAME + "("+
                ER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ER_ADDRESS + " CHAR(50) NOT NULL," +
                ER_DESTCURRENCYCODE + " CHAR(50)," +
                ER_MARKUPRATE + " CHAR(50)," +
                ER_RETRREFNUMBER + " CHAR(50)," +
                ER_SOURCEAMOUNT + " CHAR(500)," +
                ER_SOURCECURRENCYCODE + " CHAR(500)," +
                ER_SYSTRACEAUDITNUM + " CHAR(500)," +
                ER_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP"+
                ")";

        sqLiteDatabase.execSQL(CREATE_TABLE);

        autoFillData2(sqLiteDatabase);



    }

    private void autoFillData2(SQLiteDatabase sqLiteDatabase) {
        ContentValues values = new ContentValues();
        values.put(ER_ADDRESS, "LA");
        values.put(ER_DESTCURRENCYCODE, "840");
        values.put(ER_MARKUPRATE, "1");
        values.put(ER_RETRREFNUMBER, "201010101031");
        values.put(ER_SOURCEAMOUNT, "100");
        values.put(ER_SOURCECURRENCYCODE, "643");
        values.put(ER_SYSTRACEAUDITNUM, "350421");
        sqLiteDatabase.insert(TABLE2_NAME, null,values);

    }

    public void autoFillData(SQLiteDatabase sqLiteDatabase){
        ContentValues values = new ContentValues();
        values.put(MS_NAME, "cmu edctn materials cntr");
        values.put(MS_CITY, "Mount Pleasant");
        values.put(MS_STATE, "MI");
        values.put(MS_POSTALCODE, "48858");
        values.put(MS_LOGO, "https://www.cmich.edu/office_president/university_communications/PublishingImages/wordmarks/CMU_maroon_300.png");

        sqLiteDatabase.insert(TABLE_NAME, null,values);
        values = new ContentValues();
        values.put(MS_NAME, "cmu edctn materials cntr 2");
        values.put(MS_CITY, "Mount Pleasant 2");
        values.put(MS_STATE, "MI 2");
        values.put(MS_POSTALCODE, "48858 2");
        values.put(MS_LOGO, "https://www.cmich.edu/office_president/university_communications/PublishingImages/wordmarks/CMU_maroon_300.png");

        sqLiteDatabase.insert(TABLE_NAME, null,values);
        values = new ContentValues();
        values.put(MS_NAME, "cmu edctn materials cntr 3");
        values.put(MS_CITY, "Mount Pleasant 3");
        values.put(MS_STATE, "MI 3");
        values.put(MS_POSTALCODE, "48858 3");
        values.put(MS_LOGO, "https://www.cmich.edu/office_president/university_communications/PublishingImages/wordmarks/CMU_maroon_300.png");

        sqLiteDatabase.insert(TABLE_NAME, null,values);
        values = new ContentValues();
        values.put(MS_NAME, "cmu edctn materials cntr 4");
        values.put(MS_CITY, "Mount Pleasant 4");
        values.put(MS_STATE, "MI 4");
        values.put(MS_POSTALCODE, "48858 4");
        values.put(MS_LOGO, "https://www.cmich.edu/office_president/university_communications/PublishingImages/wordmarks/CMU_maroon_300.png");

        sqLiteDatabase.insert(TABLE_NAME, null,values);
        values = new ContentValues();
        values.put(MS_NAME, "cmu edctn materials cntr 5");
        values.put(MS_CITY, "Mount Pleasant 5");
        values.put(MS_STATE, "MI 5");
        values.put(MS_POSTALCODE, "48858 5");
        values.put(MS_LOGO, "https://www.cmich.edu/office_president/university_communications/PublishingImages/wordmarks/CMU_maroon_300.png");

        sqLiteDatabase.insert(TABLE_NAME, null,values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public Cursor readDB(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String query = "SELECT * FROM "+ TABLE_NAME;
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);

        return cursor;


    }
    public void updateDB(int id, String name, String city, String state, String postalCode, String logo){

        Log.d(TAG, "updateTable id: " + id);

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String query = "UPDATE "+ TABLE_NAME+ " SET " + MS_NAME+ " = '"+ name +
                " "+ MS_CITY +" = '" + city+"'"+
                " "+ MS_STATE +" = '" + state+"'"+
                " "+ MS_POSTALCODE +" = '" + postalCode+"'"+
                " "+ MS_LOGO +" = '" + logo+"'"+
                " WHERE " + MS_ID + " = " + id;

        try {
            sqLiteDatabase.execSQL(query);
            Log.d(TAG, "updateDB work");
        }
        catch (Exception e){
            Log.d(TAG, "update err: " + e.toString());
        }


    }

}
