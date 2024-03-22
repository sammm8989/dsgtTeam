package be.kuleuven.foodrestservice.controllers;

import be.kuleuven.foodrestservice.domain.Meal;
import be.kuleuven.foodrestservice.domain.MealOrder;
import be.kuleuven.foodrestservice.domain.MealsRepository;
import be.kuleuven.foodrestservice.exceptions.MealNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
public class MealsRestRpcStyleController {

    private final MealsRepository mealsRepository;

    @Autowired
    MealsRestRpcStyleController(MealsRepository mealsRepository) {
        this.mealsRepository = mealsRepository;
    }

    @GetMapping("/restrpc/meals/{id}")
    Meal getMealById(@PathVariable String id) {
        Optional<Meal> meal = mealsRepository.findMeal(id);

        return meal.orElseThrow(() -> new MealNotFoundException(id));
    }

    @GetMapping("/restrpc/orders/{id}")
    Optional<MealOrder> getOrderById(@PathVariable String id){
        Optional<MealOrder> order = mealsRepository.findOrder(id);
        return order;
    }

    @GetMapping("/restrpc/meals")
    Collection<Meal> getMeals() {
        return mealsRepository.getAllMeal();
    }

    @GetMapping("/restrpc/meals/largest")
    Meal getLargest(){
        Optional<Meal> meal =  mealsRepository.getLargest();
        return meal.orElseThrow(() -> new MealNotFoundException("no meal"));
    }

    @GetMapping("/restrpc/meals/cheapest")
    Meal getCheapest(){
        Optional<Meal> meal =  mealsRepository.getCheapest();
        return meal.orElseThrow(() -> new MealNotFoundException("no meal"));
    }

    @DeleteMapping("/restrpc/meals/{Meal}")
    Optional<Meal> deleteMeal(@PathVariable("Meal") String id){
        return mealsRepository.deleteMeal(id);
    }

    @PostMapping("/restrpc/meals")
    ResponseEntity<Meal> addMeal(@RequestBody Meal meal){
        mealsRepository.add(meal);
        return new ResponseEntity<>(meal, HttpStatus.CREATED);
    }

    @PutMapping("/restrpc/meals/{id}")
    ResponseEntity<Meal> updateMeal(@RequestBody Meal meal, @PathVariable("id") String id){
        mealsRepository.update(id, meal);
        return  new ResponseEntity<>(meal, HttpStatus.OK);
    }

    @GetMapping("/restrpc/orders")
    Collection<MealOrder> getOrder(){
        Collection<MealOrder> orders = mealsRepository.getAllOrders();
        return orders;
    }

    @PostMapping("/restrpc/orders")
    ResponseEntity<MealOrder> placeOrder(@RequestBody MealOrder order){
        mealsRepository.addOrder(order);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @DeleteMapping("/restrpc/orders/{id}")
    Optional<MealOrder> deleteOrder(@PathVariable("id") String id){
            return mealsRepository.deleteOrder(id);
    }

    @PutMapping("/restrpc/orders/{id}")
    ResponseEntity<MealOrder> updateOrder(@RequestBody MealOrder order, @PathVariable("id") String id){
        mealsRepository.updateOrder(id, order);
        return  new ResponseEntity<>(order, HttpStatus.OK);
    }

}