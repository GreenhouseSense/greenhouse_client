package com.pedrotestes.greenhouse_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements GreenhouseAdapter.ClickListner {
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
        for (int i = 0; i < 5; i++) {
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
        greenhouseAdapter.setOnClickListner(this);


    }

    @Override
    public void itemClicked(View view, int position) {
        Greenhouse clickedGreenhouse = greenhousesList.get(position);
        Toast.makeText(getApplicationContext(), clickedGreenhouse.getTitle().toString(), Toast.LENGTH_LONG).show();
    }


//    @Override
//    public void itemClicked(View view, int position) {
//        PatientListRow choosenOne = plist.get(position);
//
//        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences(PATIENTDATA, Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPref.edit();
//        editor.putString("patientId", choosenOne.getPatientID());
//        editor.putString("shortName", choosenOne.getShortName());
//        editor.putString("photoPath", choosenOne.getPhotoPath());
//        editor.putString("photoName", choosenOne.getPhotoName());
//        editor.putString("dateOfBirthday", choosenOne.getDateOfBirthday());
//        editor.putString("gender", choosenOne.getGender());
//        editor.putString("historic", choosenOne.getHistoric());
//        editor.putString("phonenumber", choosenOne.getPhonenumber());
//        editor.putString("completename", choosenOne.getCompleteName());
//        editor.putString("ethnicity", choosenOne.getEthnicity());
//
//        editor.apply();
//
//        Intent startPatientActivity = new Intent(HomeActivity.this, PatientActivity.class);
//        startActivity(startPatientActivity);
//
//    }


}
