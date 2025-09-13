package com.company.myapplication1.ui.Dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


public class DashboardViewModel extends ViewModel {

    // LiveData for greeting message
    private final MutableLiveData<String> greetingMessage = new MutableLiveData<>();

    // LiveData for card titles
    private final MutableLiveData<String> dietPlanTitle = new MutableLiveData<>();
    private final MutableLiveData<String> progressTitle = new MutableLiveData<>();
    private final MutableLiveData<String> chatbotTitle = new MutableLiveData<>();
    private final MutableLiveData<String> profileTitle = new MutableLiveData<>();

    public DashboardViewModel() {
        // Initialize default values
        loadDashboardData();
    }

    private void loadDashboardData() {
        greetingMessage.setValue("Welcome to AUSADHI.AI");
        dietPlanTitle.setValue("Diet Plan");
        progressTitle.setValue("Progress Tracking");
        chatbotTitle.setValue("AI Chatbot");
        profileTitle.setValue("Profile");
    }

    // Getters for LiveData
    public LiveData<String> getGreetingMessage() {
        return greetingMessage;
    }

    public LiveData<String> getDietPlanTitle() {
        return dietPlanTitle;
    }

    public LiveData<String> getProgressTitle() {
        return progressTitle;
    }

    public LiveData<String> getChatbotTitle() {
        return chatbotTitle;
    }

    public LiveData<String> getProfileTitle() {
        return profileTitle;
    }

    // Optional: Methods to update data dynamically
    public void updateGreeting(String newGreeting) {
        greetingMessage.setValue(newGreeting);
    }
}
