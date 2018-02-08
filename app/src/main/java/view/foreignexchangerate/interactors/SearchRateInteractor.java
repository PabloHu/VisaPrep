package view.foreignexchangerate.interactors;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

import view.foreignexchangerate.FERContract;
import view.foreignexchangerate.model.Address;
import view.foreignexchangerate.model.CardAcceptor;
import view.foreignexchangerate.model.FERResponse;

/**
 * Created by kiwic on 2/8/2018.
 */

public class SearchRateInteractor implements FERContract.SearchInteractor {
    public static final String ER_ID = "ID";
    public static final String ER_ADDRESS = "Address";
    public static final String ER_DESTCURRENCYCODE = "DestCurrencyCode";
    public static final String ER_MARKUPRATE = "MarkupRate";
    public static final String ER_RETRREFNUMBER = "RetrRefNumber";
    public static final String ER_SOURCEAMOUNT = "SourceAmount";
    public static final String ER_SOURCECURRENCYCODE = "SourceCurrencyCode";
    public static final String ER_SYSTRACEAUDITNUM = "SysTraceAuditNumber";

    private static final String AUTHORITY = "com.software.huaman.visaservice.contentprovider.FoExRateProvider";
    private static final String BASE_PATH = "exchangerate";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + BASE_PATH);
    Uri contentURI = CONTENT_URI;

    private static final String TAG = "SRITAG";


    FERContract.SearchInteractorOutput searchInteractorOutput;

    public SearchRateInteractor(FERContract.SearchInteractorOutput searchInteractorOutput) {
        this.searchInteractorOutput = searchInteractorOutput;
    }


    @Override
    public void searchFER(Context context) {
        String result = "-->>";

        Cursor cursor = context.getContentResolver().query(contentURI, null, null, null, null);

        FERResponse ferResponse = new FERResponse();
        while (cursor.moveToNext()) {

            int dbGetId = cursor.getInt(cursor.getColumnIndex(ER_ID));
            String dbGetAddress = cursor.getString(cursor.getColumnIndex(ER_ADDRESS));
            String dbGetDestCurrencyCode = cursor.getString(cursor.getColumnIndex(ER_DESTCURRENCYCODE));
            String dbGetMarkupRate = cursor.getString(cursor.getColumnIndex(ER_MARKUPRATE));
            String dbGetRetrRefNumber = cursor.getString(cursor.getColumnIndex(ER_RETRREFNUMBER));
            String dbGetSourceAmount = cursor.getString(cursor.getColumnIndex(ER_SOURCEAMOUNT));
            String dbGetSourceCurrencyCode = cursor.getString(cursor.getColumnIndex(ER_SOURCECURRENCYCODE));
            String dbGetSysTraceAuditnum = cursor.getString(cursor.getColumnIndex(ER_SYSTRACEAUDITNUM));

            Address address = new Address();
            address.setState(dbGetAddress);
            CardAcceptor cardAcceptor = new CardAcceptor();
            cardAcceptor.setAddress(address);

            ferResponse.setCardAcceptor(cardAcceptor);
            ferResponse.setDestinationCurrencyCode(dbGetDestCurrencyCode);
            ferResponse.setMarkUpRate(dbGetMarkupRate);
            ferResponse.setRetrievalReferenceNumber(dbGetRetrRefNumber);
            ferResponse.setSourceAmount(dbGetSourceAmount);
            ferResponse.setSourceCurrencyCode(dbGetSourceCurrencyCode);
            ferResponse.setSystemsTraceAuditNumber(dbGetSysTraceAuditnum);

        }
        Log.d(TAG, "onCreate: " + ferResponse.getCardAcceptor().getAddress().getState()
                + " - " + ferResponse.getDestinationCurrencyCode()
                + " - " + ferResponse.getMarkUpRate()
                + " - " + ferResponse.getRetrievalReferenceNumber()
                + " - " + ferResponse.getSourceCurrencyCode()
                + " - " + ferResponse.getSystemsTraceAuditNumber()
        );

        searchInteractorOutput.onSearchSuccess(ferResponse);
    }
}
