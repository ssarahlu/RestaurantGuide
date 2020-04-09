package com.example.restaurantguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailFragment extends Fragment {
    private TextView name, cuisine, location, rating, phone, address, tradingHours, cost, recommended;
    private ImageView myImage;
    private ImageButton menuButton, drinkButton;
    private Restaurant restaurant;
    private String restaurantSelected;
    public static final String ARG_ITEM_ID = "restaurant_name";


    public DetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //gets the restaurant name that is clicked on
        if (getArguments().containsKey(ARG_ITEM_ID)) {
            restaurant = restaurant.searchRestaurant(getArguments().getString(ARG_ITEM_ID));
            this.getActivity().setTitle(restaurant.getName());
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        //populates the textfields, imageviews and imagebuttons in the DetailFragment
        if (restaurant != null) {
            restaurantSelected = restaurant.getName();

            name = rootView.findViewById(R.id.name);
            name.setText(restaurant.getName());

            cuisine = rootView.findViewById(R.id.cuisine);
            cuisine.setText(restaurant.getCuisine());

            location = rootView.findViewById(R.id.location);
            location.setText(restaurant.getLocation());

            rating = rootView.findViewById(R.id.rating);
            rating.setText(" " + restaurant.getRating() + "  ");

            phone = rootView.findViewById(R.id.phone);
            //underlines the phone number so it looks clickable
            SpannableString content = new SpannableString(restaurant.getPhone());
            content.setSpan(new UnderlineSpan(), 0, restaurant.getPhone().length(), 0);
            phone.setText(content);

            address = rootView.findViewById(R.id.address);
            //underlines the address so it looks clickable
            SpannableString content2 = new SpannableString(restaurant.getAddress());
            content2.setSpan(new UnderlineSpan(), 0, restaurant.getAddress().length(), 0);
            address.setText(content2);

            tradingHours = rootView.findViewById(R.id.tradingHours);
            tradingHours.setText(restaurant.getTradingHours());

            cost = rootView.findViewById(R.id.cost);
            cost.setText(restaurant.getCost());

            recommended = rootView.findViewById(R.id.recommended);
            recommended.setText(restaurant.getRecommended());

            myImage = rootView.findViewById(R.id.myImage);
            setImage(restaurant.getThumbnail());

            menuButton = rootView.findViewById(R.id.menuButton);
            setImageButton(restaurant.getMenu(), menuButton);

            drinkButton = rootView.findViewById(R.id.drinkButton);
            setImageButton(restaurant.getDrinks(), drinkButton);

            rootView.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goSite(restaurant.getSite());
                }
            });

            //on clicking the little menu icons it goes into the menu activity where users can see the food menu
            rootView.findViewById(R.id.menuButton).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), Menu.class);
                    intent.putExtra("Menu", restaurantSelected);
                    startActivity(intent);
                }
            });

            //on clicking the little menu icons it goes into the menu activity where users can see the drink menu
            rootView.findViewById(R.id.drinkButton).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), Menu.class);
                    intent.putExtra("Drinks", restaurantSelected);
                    startActivity(intent);
                }
            });

            //on clicking the location icon it goes into google maps with the address prefilled
            rootView.findViewById(R.id.locationButton).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goDirection(restaurant.getAddress());
                }
            });

            //on clicking the address it goes into google maps with the address prefilled
            rootView.findViewById(R.id.address).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goDirection(restaurant.getAddress());
                }
            });

            //on clicking the phone icon it goes into the phone app with the phone
            rootView.findViewById(R.id.call).setOnClickListener(new View.OnClickListener() {
                public void onClick(View arg) {
                    dialContactPhone();
                }
            });

            rootView.findViewById(R.id.phone).setOnClickListener(new View.OnClickListener() {
                public void onClick(View arg) {
                    dialContactPhone();
                }
            });

        }

        return rootView;
    }

    //allows users to click on the phone number or icon and goes straight to the phone app so they can call up the restaurant
    private void dialContactPhone() {
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", restaurant.getPhone(), null)));
    }

    //sets the restaurant food image at the top of the activity
    public void setImage(int thumbnail) {
        if (thumbnail != 0) {
            myImage.setImageResource(thumbnail);
        } else {
            Intent intent2 = new Intent(getActivity(), MainActivity.class);
            startActivity(intent2);

        }
    }

    //allows users to click on the little menu icon and goes to a new activity that displays the menu as a larger image
    public void setImageButton(int thumbnail, ImageButton img) {
        if (thumbnail != 0) {
            img.setImageResource(thumbnail);
        } else {
            Intent intent2 = new Intent(getActivity(), MainActivity.class);
            startActivity(intent2);

        }
    }

    //allows users to go straight to the restaurant site when clicking on the search icon
    public void goSite(String site) {
        Intent implicit = new Intent(Intent.ACTION_VIEW, Uri.parse(site));
        startActivity(implicit);
    }

    //opens google maps with directions to the restaurant after clicking on the address
    public void goDirection(String address) {
        Intent implicit = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/" + address));
        startActivity(implicit);
    }
}
