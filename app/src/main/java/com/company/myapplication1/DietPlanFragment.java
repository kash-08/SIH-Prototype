package com.company.myapplication1;
// DietPlanFragment.java

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DietPlanFragment extends Fragment {

    private RecyclerView recyclerView;
    private DietPlanAdapter adapter;

    public DietPlanFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_diet_plan, container, false);

        recyclerView = view.findViewById(R.id.recycler_diet_plan);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Sample data
        List<DietItem> dietItems = new ArrayList<>();
        dietItems.add(new DietItem("Breakfast", "8:00 AM", "Kitchari with vegetables", "Balances all doshas"));
        dietItems.add(new DietItem("Lunch", "1:00 PM", "Brown rice, dal, and seasonal vegetables", "Provides essential nutrients"));
        dietItems.add(new DietItem("Snack", "4:00 PM", "Herbal tea with nuts", "Energizing"));
        dietItems.add(new DietItem("Dinner", "7:00 PM", "Vegetable soup and whole wheat roti", "Light and easy to digest"));

        adapter = new DietPlanAdapter(dietItems);
        recyclerView.setAdapter(adapter);

        return view;
    }
}