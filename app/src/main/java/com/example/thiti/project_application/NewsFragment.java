package com.example.thiti.project_application;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends Fragment {

    //a list to store all the products
    List<informationdetail> productList;

    //the recyclerview
    RecyclerView recyclerView;
    private FirebaseAuth mAuth;
    private FirebaseDatabase fdb;
    private DatabaseReference dbrf;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        //getting the recyclerview from xml
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));


        mAuth = FirebaseAuth.getInstance();
        
        //initializing the productlist
        productList = new ArrayList<>();


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


        //creating recyclerview adapter
        Adapter adapter = new Adapter(view.getContext(), productList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
        return view;
    }
}
