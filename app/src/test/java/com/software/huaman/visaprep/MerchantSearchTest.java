package com.software.huaman.visaprep;

import android.content.Context;
import android.content.ServiceConnection;

import org.junit.Before;

import java.util.List;

import model.MerchSearch;
import view.merchantsearch.MSContract;
import view.merchantsearch.MSPresenter;

import static org.junit.Assert.assertEquals;

/**
 * Created by kiwic on 2/6/2018.
 */

public class MerchantSearchTest  implements MSContract.View{

    ServiceConnection CommunicateServiceConnection;
    Context context;
    private MSPresenter msPresenter;
    @Before
    public void setup(){
        msPresenter = new MSPresenter();
        msPresenter.attachView(this);
    }

    public void initTest(){
        msPresenter.initiateConnection(context, CommunicateServiceConnection);
        assertEquals("Fail", CommunicateServiceConnection, CommunicateServiceConnection);
    }

    @Override
    public void showError(String s) {

    }

    @Override
    public void updateMSView(List<MerchSearch> merchSearchList) {

    }

    @Override
    public void updateServiceConnection(ServiceConnection CommunicateServiceConnection) {
        this.CommunicateServiceConnection = CommunicateServiceConnection;
    }
}
