package com.company.myapplication1.ui.DietPlan;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class DietPlanViewModel extends ViewModel {

    // LiveData for diet plan items
    private final MutableLiveData<List<String>> dietPlanItems = new MutableLiveData<>();

    public DietPlanViewModel() {
        // Initialize with sample data
        loadDietPlan();
    }

    // Expose LiveData to UI
    public LiveData<List<String>> getDietPlanItems() {
        return dietPlanItems;
    }

    // Load or fetch diet plan items
    private void loadDietPlan() {
        // This could later be replaced with API call or database query
        List<String> sampleDietPlan = new ArrayList<>();
        sampleDietPlan.add("Morning: Warm water with lemon");
        sampleDietPlan.add("Breakfast: Oats porridge with nuts");
        sampleDietPlan.add("Mid-Morning Snack: Fresh fruit");
        sampleDietPlan.add("Lunch: Brown rice with vegetables");
        sampleDietPlan.add("Evening Snack: Herbal tea");
        sampleDietPlan.add("Dinner: Kitchari or lentil soup");

        dietPlanItems.setValue(sampleDietPlan);
    }

    // Function to update diet plan dynamically
    public void updateDietPlan(List<String> newPlan) {
        dietPlanItems.setValue(newPlan);
    }
}
