package com.example.thiti.project_application;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends Fragment {

    //a list to store all the products
    FirebaseDatabase mydatabase;
    DatabaseReference databaseref;

    List<Information> productList;
    RecyclerView recyclerView;

    FirebaseAuth mAuth;

    private FirebaseAuth.AuthStateListener mAuthListener;

    private FirebaseStorage firebaseStorage;


    //Variable
    private Integer currentId;
    private String currenttitle;

    private String shortDes;
    private String longDes;
    private String imgLink;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        //getting the recyclerview from xml
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));


        mydatabase = FirebaseDatabase.getInstance();
        //FirebaseUser user = mAuth.getCurrentUser();

        databaseref = FirebaseDatabase.getInstance().getReference().child("Information").child("News");

        databaseref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                productList = new ArrayList<>();

                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    Information value = dataSnapshot1.getValue(Information.class);

                    //Variable
                    Long currentId = value.getID();
                    System.out.println("This is my ID   " + currentId);
                    String currenttitle = value.getTopic();

                    String currentshortDes = value.getShortDesc();
                    String currentlongDes = value.getLongDesc();
                    String currentimgLink = value.getLinkImg();
                    Information addValue = new Information(currentId, currenttitle, currentshortDes, currentlongDes, currentimgLink);
                    productList.add(addValue);

                }

                //creating recyclerview adapter
                Adapter adapter = new Adapter(getContext(), productList);

                //setting adapter to recyclerview
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("Error", databaseError.toException());
            }
        });


        return view;
    }
}
