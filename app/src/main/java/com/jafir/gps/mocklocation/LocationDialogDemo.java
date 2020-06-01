package com.jafir.gps.mocklocation;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;

import com.jafir.mockgps.LocationBean;
import com.jafir.mockgps.LocationDialog;

public class LocationDialogDemo extends Activity {
    LocationBean mLocationBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initMockLocationData();
        createLocationDialog();
    }

    private void initMockLocationData() {
        double latitude;
        double longitude;
        try {
            latitude = getIntent().getDoubleExtra("latitude", 0.0);
            longitude = getIntent().getDoubleExtra("longitude", 0.0);

        } catch (Exception e) {
            latitude = 0;
            longitude = 0;
        }
        mLocationBean = new LocationBean();
        mLocationBean.setLatitude(latitude);
        mLocationBean.setLongitude(longitude);
    }

    /**
     * 创建模拟定位对话框
     */
    private void createLocationDialog() {
        LocationDialog.Builder builder = new LocationDialog.Builder(this);
        builder.setLatitude(mLocationBean.getLatitude());
        builder.setLongitude(mLocationBean.getLongitude());
        builder.setPositiveButton("知道了", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
