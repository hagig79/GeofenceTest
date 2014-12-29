package com.example.geofencetest;

import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMyLocationChangeListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

public class MyMapFragment extends SupportMapFragment {

	private GoogleMap mMap;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_main, container,
				false);
		return rootView;
	}

	@Override
	public void onResume() {
		super.onResume();

		if (mMap == null) {
			// MapFragment Ç©ÇÁ GoogleMap ÇéÊìæÇ∑ÇÈ
			mMap = getMap();
			if (mMap != null) {
				// åªç›ínçXêV
				mMap.setOnMyLocationChangeListener(new OnMyLocationChangeListener() {
					@Override
					public void onMyLocationChange(Location loc) {
						LatLng curr = new LatLng(loc.getLatitude(), loc
								.getLongitude());
						mMap.animateCamera(CameraUpdateFactory.newLatLng(curr));
					}
				});
			}
		}
	}

	public static MyMapFragment newInstance(LatLng posicion) {
		return new MyMapFragment();
	}
}
