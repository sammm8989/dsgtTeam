package be.kuleuven.foodrestservice.domain;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MealOrder {
    protected  String id;
    protected  String address;
    protected List<Meal> meals;

    public String getId(){return id;}

    public String getAddress(){return address;}

    public List<Meal> getMeals(){return meals;}

    public void setId(String newid ){id=newid;}

    public void setAddress(String newAddress){address=newAddress;}

    public void setMeals(ArrayList<Meal> newMeals){meals = newMeals;}

}
