package com.example.studyspot;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Linking UI components using findViewById
        TextView tvDetName = findViewById(R.id.tvDetName);
        TextView tvDetDesc = findViewById(R.id.tvDetDesc);
        TextView tvDetInfo = findViewById(R.id.tvDetInfo);

        // Linking the new visual Progress Bars instead of the old tvDetStats
        ProgressBar progressBusyness = findViewById(R.id.progressBusyness);
        ProgressBar progressNoise = findViewById(R.id.progressNoise);

        Button btnReport = findViewById(R.id.btnReport);
        Button btnNavigate = findViewById(R.id.btnNavigate);

        // Custom Back Button mapped to the UI design
        ImageButton btnBack = findViewById(R.id.btnBack);

        // Extracting Intent data passed from MainActivity
        Intent intent = getIntent();
        if (intent != null) {
            tvDetName.setText(intent.getStringExtra("NAME"));
            tvDetDesc.setText(intent.getStringExtra("DESC"));

            // Combining distance and hours for the info section
            String info = intent.getStringExtra("DIST") + "   •   " + intent.getStringExtra("HOURS");
            tvDetInfo.setText(info);

            // Applying Logic to update the ProgressBars visually based on the mock data
            String busyText = intent.getStringExtra("BUSY");
            if (busyText != null) {
                if (busyText.equals("Empty")) progressBusyness.setProgress(20);
                else if (busyText.equals("Moderate")) progressBusyness.setProgress(50);
                else progressBusyness.setProgress(80);
            }

            String noiseText = intent.getStringExtra("NOISE");
            if (noiseText != null) {
                if (noiseText.equals("Quiet")) progressNoise.setProgress(20);
                else if (noiseText.equals("Normal")) progressNoise.setProgress(50);
                else progressNoise.setProgress(80); // Noisy
            }
        }

        // Event Handling: Implementing the Back button functionality
        btnBack.setOnClickListener(v -> {
            finish();
        });

        // Event Handling for action buttons with visual feedback
        btnReport.setOnClickListener(v ->
                Toast.makeText(this, "Status reporting opened", Toast.LENGTH_SHORT).show()
        );

        btnNavigate.setOnClickListener(v ->
                Toast.makeText(this, "Navigation started", Toast.LENGTH_SHORT).show()
        );
    }
}