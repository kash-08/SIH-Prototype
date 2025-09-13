package com.company.myapplication1;
// ProfileFragment.java
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    private TextView tvName, tvEmail, tvDosha, tvPrakriti;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        // Initialize views
        tvName = view.findViewById(R.id.tv_name);
        tvEmail = view.findViewById(R.id.tv_email);
        tvDosha = view.findViewById(R.id.tv_dosha);
        tvPrakriti = view.findViewById(R.id.tv_prakriti);

        // Set sample data (replace with actual user data)
        tvName.setText("Rahul Sharma");
        tvEmail.setText("rahul@example.com");
        tvDosha.setText("Vata-Pitta");
        tvPrakriti.setText("Dual Dosha");

        return view;
    }
}