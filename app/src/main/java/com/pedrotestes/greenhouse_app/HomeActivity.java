package com.pedrotestes.greenhouse_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    //a list to store all the products
    List<Greenhouse> greenhousesList;

    //the recyclerview
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        greenhousesList = new ArrayList<>();


        //adding some items to our list
        for(int i = 0; i<6; i++) {
            greenhousesList.add(
                    new Greenhouse(
                            i,
                            "Apple MacBook Air Core i5 5th Gen - (8 GB/128 GB SSD/Mac OS Sierra)",
                            "13.3 inch, Silver, 1.35 kg",
                            4.3,
                            60000,
                            R.mipmap.gh1));
        }


        //creating recyclerview adapter
        GreenhouseAdapter greenhouseAdapter = new GreenhouseAdapter(this, greenhousesList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(greenhouseAdapter);


    }
}
