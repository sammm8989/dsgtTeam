package be.kuleuven.foodrestservice.controllers;

import be.kuleuven.foodrestservice.domain.Meal;
import be.kuleuven.foodrestservice.domain.MealOrder;
import be.kuleuven.foodrestservice.domain.MealsRepository;
import be.kuleuven.foodrestservice.exceptions.MealNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
public class MealsRestController {

    private final MealsRepository mealsRepository;

    @Autowired
    MealsRestController(MealsRepository mealsRepository) {
        this.mealsRepository = mealsRepository;
    }

    @GetMapping("/rest/meals/{id}")
    EntityModel<Meal> getMealById(@PathVariable String id) {
        Meal meal = mealsRepository.findMeal(id).orElseThrow(() -> new MealNotFoundException(id));

        return mealToEntityModel(id, meal);
    }

    @GetMapping("/rest/order/{id}")
    EntityModel<MealOrder> getOrderById(@PathVariable String id){
        MealOrder order = mealsRepository.findOrder(id).orElseThrow(() ->new MealNotFoundException(id));

        return orderToEntityModel(id, order);
    }

    @GetMapping("/rest/meals")
    CollectionModel<EntityModel<Meal>> getMeals() {
        Collection<Meal> meals = mealsRepository.getAllMeal();

        List<EntityModel<Meal>> mealEntityModels = new ArrayList<>();
        for (Meal m : meals) {
            EntityModel<Meal> em = mealToEntityModel(m.getId(), m);
            mealEntityModels.add(em);
        }
        return CollectionModel.of(mealEntityModels,
                linkTo(methodOn(MealsRestController.class).getMeals()).withSelfRel());
    }

    @GetMapping("/rest/orders")
    CollectionModel<EntityModel<MealOrder>> getOrders(){
        Collection<MealOrder> orders = mealsRepository.getAllOrders();

        List<EntityModel<MealOrder>> orderEntityModels = new ArrayList<>();
        for (MealOrder mo: orders){
            EntityModel<MealOrder> em = orderToEntityModel(mo.getId(), mo);
            orderEntityModels.add(em);
        }

        return CollectionModel.of(orderEntityModels,
                linkTo(methodOn(MealsRestController.class).getOrders()).withSelfRel());
    }

    private EntityModel<Meal> mealToEntityModel(String id, Meal meal) {
        return EntityModel.of(meal,
                linkTo(methodOn(MealsRestController.class).getMealById(id)).withSelfRel(),
                linkTo(methodOn(MealsRestController.class).getMeals()).withRel("rest/meals"));
    }

    private EntityModel<MealOrder> orderToEntityModel(String id, MealOrder order){
        return EntityModel.of(order,
                linkTo(methodOn(MealsRestController.class).getOrderById(id)).withSelfRel(),
                linkTo(methodOn(MealsRestController.class).getOrders()).withRel("rest/orders"));
    }

    @GetMapping("/rest/meals/largest")
    Optional<Meal> getLargest(){
        Optional<Meal> meal= mealsRepository.getLargest();
        return meal;
    }

    @GetMapping("/rest/meals/cheapest")
    Optional<Meal> getCheapest(){
        Optional<Meal> meal= mealsRepository.getCheapest();
        return meal;
    }


    @DeleteMapping("/rest/meals/{Meal}")
    Optional<Meal> deleteMeal(@PathVariable("Meal") String id){
        return mealsRepository.deleteMeal(id);
    }

    @PostMapping("/rest/meals")
    EntityModel<Meal> addMeal(@RequestBody Meal meal){
        mealsRepository.add(meal);
        return mealToEntityModel(meal.getId(), meal);
    }

    @PutMapping("/rest/meals/{id}")
    EntityModel<Meal> updateMeal(@PathVariable("id")String id, @RequestBody Meal meal){
        mealsRepository.update(id, meal);
        return mealToEntityModel(id, meal);
    }

    @PostMapping("/rest/orders")
    EntityModel<MealOrder> addOrder(@RequestBody MealOrder order){
        mealsRepository.addOrder(order);
        return orderToEntityModel(order.getId(), order);
    }

    @DeleteMapping("/rest/orders/{order}")
    Optional<MealOrder> deleteOrder(@PathVariable("order") String id){
        return mealsRepository.deleteOrder(id);
    }

    @PutMapping("/rest/orders/{order}")
    EntityModel<MealOrder> updateOrder(@PathVariable("order") String id, @RequestBody MealOrder order){
        mealsRepository.updateOrder(id, order);
        return orderToEntityModel(id, order);
    }




}
