package com.example.restaurantguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.detailContainer) != null) {
            mTwoPane = true;
        }

        //gives menu activity whether it is twopane or not
        Menu menu = new Menu();
        menu.getTwoPane(mTwoPane);

        /** if it is two pane, after the user clicks on the restaurant menu and clicks the back button,
         it will populate the detail fragment with the restaurant that was previously selected */
        Intent intent = getIntent();
        String message = intent.getStringExtra(DetailFragment.ARG_ITEM_ID);
        if (message != null && mTwoPane == true){
            Bundle arguments = new Bundle();
            arguments.putString(DetailFragment.ARG_ITEM_ID, getIntent().getStringExtra(DetailFragment.ARG_ITEM_ID));
            DetailFragment fragment = new DetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.detailContainer, fragment)
                    .commit();
        }

        //implementing a recyclerview for a list of restaurants
        RecyclerView mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        RecyclerView.Adapter mAdapter = new MyAdapter(this, Restaurant.getRestaurant(), mTwoPane);
        mRecyclerView.setAdapter(mAdapter);

        //sets the title of the app
        setTitle("Hungry Hippo");





    }



}
