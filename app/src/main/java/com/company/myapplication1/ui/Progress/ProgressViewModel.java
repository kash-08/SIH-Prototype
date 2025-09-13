package com.company.myapplication1.ui.Progress;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;
import java.util.List;

public class ProgressViewModel extends ViewModel {

    private final MutableLiveData<List<Entry>> weightEntries = new MutableLiveData<>();

    public ProgressViewModel() {
        loadDummyData(); // Load initial data
    }

    /** LiveData for the weight chart */
    public LiveData<List<Entry>> getWeightEntries() {
        return weightEntries;
    }

    /** Load sample data (replace with real data later) */
    private void loadDummyData() {
        List<Entry> entries = new ArrayList<>();
        entries.add(new Entry(0, 75f));
        entries.add(new Entry(1, 73f));
        entries.add(new Entry(2, 72f));
        entries.add(new Entry(3, 71f));
        entries.add(new Entry(4, 70f));
        entries.add(new Entry(5, 69f));
        entries.add(new Entry(6, 68f));

        weightEntries.setValue(entries);
    }

    /** Add new weight data point */
    public void addWeightEntry(float x, float y) {
        List<Entry> current = weightEntries.getValue();
        if (current == null) {
            current = new ArrayList<>();
        }
        current.add(new Entry(x, y));
        weightEntries.setValue(current);
    }
}
