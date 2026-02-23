package com.example.studyspot;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

// Adapter for the Top Rated RecyclerView
public class StudySpotAdapter extends RecyclerView.Adapter<StudySpotAdapter.ViewHolder> {

    private List<StudyLocation> locations;
    private Context context;

    public StudySpotAdapter(List<StudyLocation> locations, Context context) {
        this.locations = locations;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_study_spot, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StudyLocation location = locations.get(position);

        holder.tvSpotId.setText(location.getId());
        holder.tvSpotName.setText(location.getName());
        holder.tvSpotRating.setText(location.getRating());

        // Handling click events to pass all rich data to DetailActivity
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("NAME", location.getName());
            intent.putExtra("DESC", location.getDescription());
            intent.putExtra("DIST", location.getDistance());
            intent.putExtra("HOURS", location.getHours());
            intent.putExtra("CAP", location.getCapacity());
            intent.putExtra("BUSY", location.getBusyness());
            intent.putExtra("NOISE", location.getNoiseLevel());
            intent.putExtra("AMENITIES", location.getAmenities());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return locations.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvSpotId, tvSpotName, tvSpotRating;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSpotId = itemView.findViewById(R.id.tvSpotId);
            tvSpotName = itemView.findViewById(R.id.tvSpotName);
            tvSpotRating = itemView.findViewById(R.id.tvSpotRating);
        }
    }
}