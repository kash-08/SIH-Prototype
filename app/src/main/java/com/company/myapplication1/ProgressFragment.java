package com.company.myapplication1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import java.util.ArrayList;
import java.util.List;

public class ProgressFragment extends Fragment {

    private LineChart weightChart;

    public ProgressFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_progress, container, false);

        weightChart = view.findViewById(R.id.weight_chart);
        setupWeightChart();

        return view;
    }

    private void setupWeightChart() {
        List<Entry> entries = new ArrayList<>();
        entries.add(new Entry(0, 75f));
        entries.add(new Entry(1, 73f));
        entries.add(new Entry(2, 72f));
        entries.add(new Entry(3, 71f));
        entries.add(new Entry(4, 70f));
        entries.add(new Entry(5, 69f));
        entries.add(new Entry(6, 68f));

        LineDataSet dataSet = new LineDataSet(entries, "Weight (kg)");
        dataSet.setColor(ContextCompat.getColor(requireContext(), R.color.colorPrimary));
        dataSet.setValueTextColor(ContextCompat.getColor(requireContext(), R.color.colorPrimaryDark));
        dataSet.setLineWidth(2f);
        dataSet.setCircleColor(ContextCompat.getColor(requireContext(), R.color.colorPrimary));
        dataSet.setCircleRadius(4f);
        dataSet.setDrawCircleHole(false);

        List<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(dataSet);

        LineData lineData = new LineData(dataSets);
        weightChart.setData(lineData);
        weightChart.getDescription().setText("Weight Progress");
        weightChart.invalidate();
    }
}
