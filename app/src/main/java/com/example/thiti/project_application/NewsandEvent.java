package com.example.thiti.project_application;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;


//NewsandEvent layout and class adapted from the below youtube website
//https://www.youtube.com/watch?v=EbcdMxAIr54

public class NewsandEvent extends AppCompatActivity implements ProjectsFragment.OnFragmentInteractionListener {

    private BottomNavigationView mainnav;
    private FrameLayout mainframe;


    private NewsFragment newsFragment;
    private ProjectsFragment projectsFragment;
    private EventsFragment eventsFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsand_event);


        mainframe = (FrameLayout) findViewById(R.id.main_frame);
        mainnav = (BottomNavigationView) findViewById(R.id.main_nav);

        newsFragment = new NewsFragment();
        projectsFragment = new ProjectsFragment();
        eventsFragment = new EventsFragment();

        setFragment(newsFragment);

        mainnav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                // After click the button, set each button link to fragment activity.
                switch (item.getItemId()) {

                    case R.id.nav_news:
                        mainnav.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(newsFragment);
                        return true;



                    case R.id.name_event:
                        mainnav.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(eventsFragment);

                        return true;

                    default:
                        return false;


                }
            }
        });


    }

    private void setFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();


    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
