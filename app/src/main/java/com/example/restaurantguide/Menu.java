package com.example.restaurantguide;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

//activity that displays the menus when clicked on in the DetailActivity
public class Menu extends AppCompatActivity {
    private ImageView imageView;
    private Restaurant restaurant;
    private static boolean mTwoPane;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Intent intent = getIntent();
        String message = intent.getStringExtra("Menu");
        //sends the food menu intent as "Menu" in the key. If it is not null, it will populate the ImageView with the food menu
        if (message != null) {
            restaurant = Restaurant.searchRestaurant(message);
            imageView = findViewById(R.id.imageView);
            imageView.setImageResource(restaurant.getMenu());
            setTitle(restaurant.getName() + " Menu");

        } else {
            //else if it is null, it is not the food menu. It is the drink menu
            // the intent sends the drink menu as  "Drinks" in the key
            String drink = intent.getStringExtra("Drinks");
            restaurant = Restaurant.searchRestaurant(drink);
            imageView = findViewById(R.id.imageView);
            imageView.setImageResource(restaurant.getDrinks());
            setTitle(restaurant.getName() + " Menu");
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }


    //gets whether it is two pane in the detail activity
    public void getTwoPane(boolean mTwoPane) {
        this.mTwoPane = mTwoPane;
    }


    //created my own back button in the toolbar
    public boolean onOptionsItemSelected(MenuItem item) {
        //if it is on one phone screen go back to detail activity
        if (mTwoPane == false) {
            Intent intent = new Intent(this, DetailActivity.class);
            //goes back to the DetailActivity with the correct restaurant populated
            intent.putExtra(DetailFragment.ARG_ITEM_ID, restaurant.getName());
            startActivity(intent);
            startActivityForResult(intent, 0);
            return true;
            //else if it is on a tablet, it will go back to main activity
        } else {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra(DetailFragment.ARG_ITEM_ID, restaurant.getName());
            startActivity(intent);
            startActivityForResult(intent, 0);
            return true;
        }

    }

}