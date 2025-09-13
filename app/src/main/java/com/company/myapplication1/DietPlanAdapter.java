package com.company.myapplication1;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class DietPlanAdapter extends RecyclerView.Adapter<DietPlanAdapter.ViewHolder> {

    private List<DietItem> dietItems;

    public DietPlanAdapter(List<DietItem> dietItems) {
        this.dietItems = dietItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_diet_plan, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DietItem item = dietItems.get(position);
        holder.mealType.setText(item.getMealType());
        holder.time.setText(item.getTime());
        holder.food.setText(item.getFood());
        holder.benefits.setText(item.getBenefits());
    }

    @Override
    public int getItemCount() {
        return dietItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mealType, time, food, benefits;

        public ViewHolder(View itemView) {
            super(itemView);
            mealType = itemView.findViewById(R.id.meal_type);
            time = itemView.findViewById(R.id.meal_time);
            food = itemView.findViewById(R.id.meal_food);
            benefits = itemView.findViewById(R.id.meal_benefits);
        }
    }
}
