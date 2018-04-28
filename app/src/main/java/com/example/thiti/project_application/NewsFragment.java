package com.example.thiti.project_application;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
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
    FirebaseDatabase mydatabase;
    DatabaseReference databaseref;

    List<informationdetail> productList;
    RecyclerView recyclerView;

    FirebaseAuth mAuth;

    private  FirebaseAuth.AuthStateListener mAuthListener;

    private FirebaseStorage firebaseStorage;


    //Variable
    private Integer  currentId;
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




        mydatabase = FirebaseDatabase.getInstance();
        //FirebaseUser user = mAuth.getCurrentUser();

        databaseref = FirebaseDatabase.getInstance().getReference().child("Information").child("News");
<<<<<<< HEAD
        //firebaseStorage =  FirebaseStorage.getInstance();
<<<<<<< HEAD
        =
=======

=======
        //firebaseStorage =  FirebaseStorage.getInstance();=
>>>>>>> ede60b8e1cc54f36c449756e4f146e056430ebe0
>>>>>>> parent of 60aaf29... test
        //initializing the productlist

        databaseref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                productList = new ArrayList<>();

                for(DataSnapshot dataSnapshot1 :dataSnapshot.getChildren()){
                    informationdetail value = dataSnapshot1.getValue(informationdetail.class);

                    //Variable
                    Integer  currentId = value.getId() ;
                    System.out.println("This is my ID   "+currentId);
                    String currenttitle = value.getTitle() ;;

                    String  currentshortDes = value.getShortdesc();
                    String currentlongDes = value.getFulldesc();
                    String currentimgLink = value.getImage();
                    informationdetail addValue = new informationdetail(currentId,currenttitle, currentshortDes,currentlongDes,currentimgLink);
                    productList.add(addValue);

                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("Error", databaseError.toException());
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
