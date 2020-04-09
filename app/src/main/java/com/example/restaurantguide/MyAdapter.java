package com.example.restaurantguide;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

//adapter class for recyclerview
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.RestaurantViewHolder> {
    private MainActivity mParentActivity;
    private List<Restaurant> restaurantList;
    private boolean mTwoPane;
    public String mRestaurant;


    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Restaurant restaurant = (Restaurant) v.getTag();
            if (mTwoPane) {
                Bundle arguments = new Bundle();
                arguments.putString(DetailFragment.ARG_ITEM_ID, restaurant.getName());
                DetailFragment fragment = new DetailFragment();
                fragment.setArguments(arguments);
                mParentActivity.getSupportFragmentManager().beginTransaction().replace(R.id.detailContainer, fragment).commit();
            } else {
                Context context = v.getContext();
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(DetailFragment.ARG_ITEM_ID, restaurant.getName());
                context.startActivity(intent);
            }
        }
    };


    public MyAdapter(MainActivity parent, ArrayList<Restaurant> restaurant, boolean twoPane) {
        mParentActivity = parent;
        restaurantList = Restaurant.getRestaurant();
        mTwoPane = twoPane;
    }

    public static class RestaurantViewHolder extends RecyclerView.ViewHolder {
        public TextView name, location, rating, cuisine;
        public ImageView imageView;
        public CardView cv;

        public RestaurantViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            cv = view.findViewById(R.id.cardView);
            cuisine = view.findViewById(R.id.cuisine);
            location = view.findViewById(R.id.location);
            rating = view.findViewById(R.id.rating);
            imageView = view.findViewById(R.id.imageView);
        }
    }

    @Override
    public MyAdapter.RestaurantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_list_row, parent, false);
        return new RestaurantViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RestaurantViewHolder holder, int position) {
        Restaurant restaurant = restaurantList.get(position);
        mRestaurant = restaurantList.get(position).getName();
        holder.name.setText(restaurant.getName());
        holder.location.setText(restaurant.getLocation());
        holder.cuisine.setText(restaurant.getCuisine());
        holder.rating.setText(" "+ restaurant.getRating() + "  ");
        holder.imageView.setImageResource(restaurant.getThumbnail());
        holder.itemView.setTag(restaurant);
        holder.itemView.setOnClickListener(mOnClickListener);
    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }


}
