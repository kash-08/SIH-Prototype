package com.company.myapplication1;
public class DietItem {
    private String mealType;
    private String time;
    private String food;
    private String benefits;

    public DietItem(String mealType, String time, String food, String benefits) {
        this.mealType = mealType;
        this.time = time;
        this.food = food;
        this.benefits = benefits;
    }

    public String getMealType() {
        return mealType;
    }

    public String getTime() {
        return time;
    }

    public String getFood() {
        return food;
    }

    public String getBenefits() {
        return benefits;
    }
}