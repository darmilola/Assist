package ng.assist.UIs;


import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.ArrayList;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ng.assist.Adapters.WalletAdapter;
import ng.assist.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Wallet extends Fragment {


    RecyclerView walletRecyclerview;
    ArrayList<String> walletHistoryList = new ArrayList<>();
    WalletAdapter adapter;
    View view;
    CollapsingToolbarLayout collapsingToolbarLayout;
    Toolbar toolbar;
    AppBarLayout walletAppbar;
    TextView toolbarTitle;

    public Wallet() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_wallet, container, false);

        initView();
        return  view;
    }

    private void  initView(){
        walletRecyclerview = view.findViewById(R.id.wallet_transcations_recyclerview);
        collapsingToolbarLayout = view.findViewById(R.id.wallet_collapsing_toolbar_layout);
        toolbar = view.findViewById(R.id.wallet_toolbar);
        walletAppbar = view.findViewById(R.id.wallet_app_bar);
        toolbarTitle = view.findViewById(R.id.wallet_toolbar_title);

        for(int  i = 0; i < 15; i++){
            walletHistoryList.add("");
        }

        adapter = new WalletAdapter(walletHistoryList,getContext());
        walletRecyclerview.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        walletRecyclerview.setLayoutManager(layoutManager);
        walletRecyclerview.setAdapter(adapter);


        walletAppbar.addOnOffsetChangedListener(new AppBarLayout.BaseOnOffsetChangedListener() {

            boolean isShown = true;
            int scrollRange = -1;
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if(scrollRange == -1){
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if(scrollRange + verticalOffset == 0){

                    toolbarTitle.setText("Transactions");
                    isShown = true;
                    return;
                }
                else if(isShown){


                    isShown = false;
                    toolbarTitle.setText("");
                    return;
                }
            }
        });


    }

}
