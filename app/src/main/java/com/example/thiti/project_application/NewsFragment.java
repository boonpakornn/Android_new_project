package com.example.thiti.project_application;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends Fragment {

    //a list to store all the products
    List<informationdetail> productList;


    RecyclerView recyclerView;
    private FirebaseAuth mAuth;
    private FirebaseDatabase firebaseDatabase;
    private  FirebaseAuth.AuthStateListener mAuthListener;

    private DatabaseReference databaseref;
    private FirebaseStorage firebaseStorage;

    private String  currentId;
    private String currenttitle;

    private String  shortDes;
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

        firebaseDatabase = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
       // userId = user.getUid();

        databaseref = FirebaseDatabase.getInstance().getReference().child("Information").child("News");
        //firebaseStorage =  FirebaseStorage.getInstance();

        //initializing the productlist
        productList = new ArrayList<>();


        databaseref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {



                currentId = dataSnapshot.child("ID").getValue().toString().trim();
                Integer.parseInt(currentId);
                currenttitle = dataSnapshot.child("Topic").getValue().toString().trim();
                //currentId = dataSnapshot.child().getValue().toString().trim();
                longDes  = dataSnapshot.child("shortDes").getValue().toString().trim();

                shortDes  = dataSnapshot.child("LongDes").getValue().toString().trim();
                imgLink = dataSnapshot.child("LinkImg").getValue().toString().trim();
                Integer.parseInt(imgLink);



                productList.add(new informationdetail(Integer.parseInt(currentId),currenttitle,shortDes,longDes, Integer.parseInt(imgLink)
 ));

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        //productList.add(new informationdetail());


        /*
        //adding some items to our list
               productList.add(
                new informationdetail(
                        1,
                        "APPLE MacBook Air Core i5 5th Gen - (8 GB/128 GB SSD/Mac OS Sierra)",
                        "13.3 inch, Silver, 1.35 kg",
                        "Wowwwwwwwww",
                        android.R.drawable.ic_input_delete));

        productList.add(
                new informationdetail(
                        1,
                        "Tmr is Friday.",
                        "13.3 inch, Silver, 1.35 kg",
                        "Wowwwwwwwww",
                        android.R.drawable.ic_input_delete));

        */
        //creating recyclerview adapter
        Adapter adapter = new Adapter(view.getContext(), productList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
        return view;
    }
}
