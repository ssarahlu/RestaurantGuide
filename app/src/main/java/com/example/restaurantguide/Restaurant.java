package com.example.restaurantguide;

import java.util.ArrayList;

public class Restaurant {
    private String name;
    private String cuisine;
    private String location;
    private String rating;
    private String phone;
    private String tradingHours;
    private String address;
    private int thumbnail;
    private int menu;
    private String cost;
    private String recommended;
    private String site;


    private int drinks;

    public Restaurant() {

    }

    public Restaurant(String name, String cuisine, String location, String rating, String phone, String tradingHours, String address, int thumbnail, int menu, String cost, String recommended, String site, int drinks) {
        this.name = name;
        this.cuisine = cuisine;
        this.location = location;
        this.rating = rating;
        this.phone = phone;
        this.tradingHours = tradingHours;
        this.address = address;
        this.thumbnail = thumbnail;
        this.menu = menu;
        this.cost = cost;
        this.recommended = recommended;
        this.site = site;
        this.drinks = drinks;
    }


    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTradingHours() {
        return tradingHours;
    }

    public void setTradingHours(String tradingHours) {
        this.tradingHours = tradingHours;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getMenu() {
        return menu;
    }

    public void setMenu(int menu) {
        this.menu = menu;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getRecommended() {
        return recommended;
    }

    public void setRecommended(String recommended) {
        this.recommended = recommended;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public int getDrinks() {
        return drinks;
    }

    public void setDrinks(int drinks) {
        this.drinks = drinks;
    }

    public static ArrayList<Restaurant> getRestaurant() {
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant("Cre Asion", "Cafe Food, Desserts", "Sydney CBD", "4.8/5", "02 8317 6312",
                "Mon - Fri: 8am - 4pm; Sat - Sun: 9am - 4pm", "21 Alberta St, Sydney NSW 2000", R.drawable.creasion,
                R.drawable.creasion_menu, "$15 per person", "Matcha Fondant, Cheesecake, Matcha Latte",
                "http://www.creasion.com.au/", R.drawable.creasion_drinks));

        restaurants.add(new Restaurant("Chi Koko", "Korean Food, Fried Chicken", "Hurstville", "4.7/5", "+61 289 372 978",
                "Mon - Sun: 11:30am - 10pm ", "378-380 Forest Rd, Hurstville NSW 2220", R.drawable.chikoko,
                R.drawable.chikoko_menu, "$30 per person", "Korean Fried Chicken, Dumplings, Tteokbokki",
                "https://www.facebook.com/hurstvillekokochicken/", R.drawable.chikoko_drinks));

        restaurants.add(new Restaurant("Revolver", "Cafe Food", "Annandale", "4.6/5", "02 8318 0753",
                "Mon - Sun: 8am - 4pm ", "291 Annandale Street, Annandale", R.drawable.revolver,
                R.drawable.revolver_menu, "$25 per person", "Big Breakfast, Poached Eggs, Iced Latte",
                "https://revolver.com.au/", R.drawable.revolver_drinks));

        restaurants.add(new Restaurant("Five Points Burgers", "Casual Dining - Burgers", "North Sydney", "4.5/5", "+61 289 040 276",
                "Mon - Sun: 11:30am - 9pm ", "124 Walker Street, North Sydney, Sydney", R.drawable.fivepoints,
                R.drawable.fivepoints_menu, "$25 per person", "Beef Burger, Fries, Vanilla Milkshake",
                "http://fivepointsburgers.com.au/", R.drawable.fivepoints_drinks));

        restaurants.add(new Restaurant("Social Hideout", "Cafe Food", "Parramatta", "4.4/5", "+61 286 775 226",
                "Mon - Sun: 7:30am - 3pm ", "Shop 2a, 20 Victoria Road, Parramatta, Sydney", R.drawable.social_hideout,
                R.drawable.social_hideout_food, "$30 per person", "Red Velvet Cake, French Toast, Coffee",
                "https://www.socialhideout.com.au/parramatta", R.drawable.social_hideout_drinks));

        restaurants.add(new Restaurant("Ramen Toriichi", "Ramen", "Neutral Bay", "4.4/5", "+61 299 041 551",
                "Mon - Sun: 11:30am - 9pm ", "Shop 6, 2A Waters Road, Neutral Bay, Sydney", R.drawable.ramen,
                R.drawable.ramen_menu, "$25 per person", "Shio Ramen, Curry Ramen, Pork Gyoza",
                "https://www.facebook.com/Ramen-Toriichi-Neutral-Bay-159252081340118/", R.drawable.ramen_drink));

        restaurants.add(new Restaurant("Concrete Jungle", "Cafe Food", "Chippendale", "4.3/5", "+61 434 366 322",
                "Mon - Sun: 7am - 3pm ", "15 Kensington Street, Chippendale", R.drawable.concrete_jungle,
                R.drawable.concrete_jungle_menu, "$30 per person", "Smoothie Bowl, Fries, Coffee",
                "https://www.concretejunglecafe.com/", R.drawable.concrete_jungle_drinks));

        restaurants.add(new Restaurant("Bar Ume", "Casual Dining - Burgers", "Surry Hills", "4.2/5", "+61 481 951 920",
                "Mon - Sun: 5pm - 9pm", "478 Bourke St, Surry Hills", R.drawable.ume,
                R.drawable.ume_menu, "$25 per person", "Burgers, Chips, Onion Rings",
                "https://www.umeburger.com/surryhills/", R.drawable.ume_drinks));

        restaurants.add(new Restaurant("Le Monde", "Cafe Food", "Surry Hills", "4.1/5", "+61 292 113 568",
                "Mon - Sun: 6:30am - 4pm", "83 Foveaux Street, Surry Hills, Sydney", R.drawable.lemonde,
                R.drawable.lemonde_food, "$30 per person", "Potato Roesti, Pancakes, Pasta",
                "https://www.lemondecafe.com.au/", R.drawable.lemonde_drinks));

        restaurants.add(new Restaurant("The Bellevue Hotel", "Modern Australian", "Paddington", "4.0/5", "+61 293 632 293",
                "Mon - Sun: 11:30am - Midnight", "159 Hargrave Street, Paddington, Sydney", R.drawable.bv,
                R.drawable.bv_menu, "$50 per person", "Chicken Schnitzel, Burgers, Wine",
                "https://www.bellevuehotel.com.au/", R.drawable.bv_drink));



        return restaurants;
    }

    //searches the restaurant arraylist with restaurant name
    public static Restaurant searchRestaurant(String search) {
        Restaurant restaurant = new Restaurant();
        for (Restaurant r : getRestaurant()) {
            if (r.getName().equals(search)) {
                restaurant = r;
            }
        }
        return restaurant;
    }

}
