package ng.assist.UIs;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import ng.assist.Accomodation;
import ng.assist.GroceryLanding;
import ng.assist.R;
import ng.assist.ServicesLanding;
import ng.assist.Transportation;


public class HomeFragment extends Fragment {


    View view;
    LinearLayout transportationLayout;
    LinearLayout groceryLayout;
    LinearLayout accomodationLayout;
    LinearLayout homeServicesLayout;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_home, container, false);
        initView();
        return  view;
    }

    private void initView(){
        transportationLayout = view.findViewById(R.id.home_transportation_layout);
        groceryLayout = view.findViewById(R.id.home_grocery_layout);
        accomodationLayout = view.findViewById(R.id.home_accomodation_layout);
        homeServicesLayout = view.findViewById(R.id.home_services_layout);

        transportationLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), Transportation.class));
            }
        });

        homeServicesLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ServicesLanding.class));
            }
        });
        groceryLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), GroceryLanding.class));
            }
        });
        accomodationLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), Accomodation.class));
            }
        });
    }

}
