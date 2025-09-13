package com.company.myapplication1;
// DashboardFragment.java
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.cardview.widget.CardView;

public class DashboardFragment extends Fragment {

    private CardView cardDietPlan, cardProgress, cardChatbot, cardProfile;

    public DashboardFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        // Initialize views
        cardDietPlan = view.findViewById(R.id.card_diet_plan);
        cardProgress = view.findViewById(R.id.card_progress);
        cardChatbot = view.findViewById(R.id.card_chatbot);
        cardProfile = view.findViewById(R.id.card_profile);

        // Set click listeners
        cardDietPlan.setOnClickListener(v -> navigateToFragment(new DietPlanFragment()));
        cardProgress.setOnClickListener(v -> navigateToFragment(new ProgressFragment()));
        cardChatbot.setOnClickListener(v -> navigateToFragment(new ChatbotFragment()));
        cardProfile.setOnClickListener(v -> navigateToFragment(new ProfileFragment()));

        return view;
    }

    private void navigateToFragment(Fragment fragment) {
        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit();
    }
}