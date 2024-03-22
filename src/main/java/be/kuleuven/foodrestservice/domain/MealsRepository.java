package be.kuleuven.foodrestservice.domain;

import be.kuleuven.foodrestservice.exceptions.MealNotFoundException;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import java.lang.reflect.Array;
import java.util.*;

@Component
public class MealsRepository {
    // map: id -> meal
    private static final Map<String, Meal> meals = new HashMap<>();
    private static final Map<String, MealOrder> orders = new HashMap<>()    ;
    @PostConstruct
    public void initData() {

        Meal a = new Meal();
        a.setId("5268203c-de76-4921-a3e3-439db69c462a");
        a.setName("Steak");
        a.setDescription("Steak with fries");
        a.setMealType(MealType.MEAT);
        a.setKcal(1100);
        a.setPrice((10.00));

        meals.put(a.getId(), a);

        Meal b = new Meal();
        b.setId("4237681a-441f-47fc-a747-8e0169bacea1");
        b.setName("Portobello");
        b.setDescription("Portobello Mushroom Burger");
        b.setMealType(MealType.VEGAN);
        b.setKcal(637);
        b.setPrice((7.00));

        meals.put(b.getId(), b);

        Meal c = new Meal();
        c.setId("cfd1601f-29a0-485d-8d21-7607ec0340c8");
        c.setName("Fish and Chips");
        c.setDescription("Fried fish with chips");
        c.setMealType(MealType.FISH);
        c.setKcal(950);
        c.setPrice(5.00);

        meals.put(c.getId(), c);

        MealOrder m = new MealOrder();
        m.setAddress("Maria Theresiastraat 12");
        m.setId("1234");
        ArrayList<Meal> meals12 = new ArrayList<>();
        meals12.add(c);
        m.setMeals(meals12);

        orders.put(m.getId(), m);
    }

    public Optional<Meal> findMeal(String id) {
        Assert.notNull(id, "The meal id must not be null");
        Meal meal = meals.get(id);
        return Optional.ofNullable(meal);
    }

    public Optional<MealOrder> findOrder(String id) {
        Assert.notNull(id, "The meal id must not be null");
        MealOrder order = orders.get(id);
        return Optional.ofNullable(order);
    }

    public Collection<Meal> getAllMeal() {
        return meals.values();
    }

    public Collection<MealOrder> getAllOrders() {return orders.values();}

    public Optional<Meal> getLargest(){
        Collection<Meal> mealsCollection= getAllMeal();
        Assert.notNull(mealsCollection, "The meals are empty");
        int kcal = 0;
        Meal meal= null;
        for(Meal m: mealsCollection){
            if(m.getKcal()>kcal){
                kcal = m.getKcal();
                meal = m;
            }
        }
        return (Optional.ofNullable(meal));
    }

    public Optional<Meal> getCheapest(){
        Collection<Meal> mealsCollection = getAllMeal();
        Assert.notNull(mealsCollection, "The meals are empty");
        Double  price = 1000d;
        Meal meal = null;
        for (Meal m: mealsCollection){
            if(m.getPrice() < price){
                price = m.getPrice();
                meal = m;
            }
        }
        return (Optional.ofNullable(meal));
    }

    public Optional<Meal> deleteMeal(String toDelete){
        Meal meal = meals.get(toDelete);
        meals.remove(toDelete);
        return Optional.ofNullable(meal);
    }

    public ResponseEntity<Meal> add(Meal meal){
        meals.put(meal.getId(), meal);
        return ResponseEntity.status(HttpStatus.CREATED).body(meal);

    }

    public ResponseEntity<MealOrder> addOrder(MealOrder order){
        orders.put(order.getId(), order);
        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }

    public ResponseEntity<Meal> update(String id, Meal meal){
        Optional<Meal> m = findMeal(id);
        if(m.isPresent()){
            meals.put(id, meal);
        }
        return ResponseEntity.status(HttpStatus.OK).body(meal);
    }

    public ResponseEntity<MealOrder> updateOrder(String id, MealOrder order){
        Optional<MealOrder> mo = findOrder(id);
        if(mo.isPresent()){
            orders.put(id, order);
        }
        return ResponseEntity.status(HttpStatus.OK).body(order);
    }


    public Optional<MealOrder> deleteOrder(String id) {
        MealOrder order = orders.get(id);
        orders.remove(id);
        return Optional.ofNullable(order);

    }
}
