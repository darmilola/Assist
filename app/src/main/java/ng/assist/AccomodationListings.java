package ng.assist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ng.assist.Adapters.AccomodationListingsAdapter;

import android.os.Bundle;

import java.util.ArrayList;

public class AccomodationListings extends AppCompatActivity {

    RecyclerView recyclerView;
    AccomodationListingsAdapter adapter;
    ArrayList<String> accomdationList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accomodation_listings);
        initView();
    }

    private void initView(){

        recyclerView = findViewById(R.id.accomodation_recyclerview);

        for(int i = 0; i < 20; i++){
            accomdationList.add("");
        }
        adapter = new AccomodationListingsAdapter(accomdationList,AccomodationListings.this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
}
