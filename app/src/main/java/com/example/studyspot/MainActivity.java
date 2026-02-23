package com.example.studyspot;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private StudySpotAdapter adapter;
    private List<StudyLocation> locationList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerViewSpots);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Mock Data
        locationList = new ArrayList<>();
        locationList.add(new StudyLocation("#01", "Quiet Zone", "5 stars",
                "The main university library with multiple floors of silent study spaces.",
                "2 min", "8:00 AM - 10:00 PM", "45/200", "Empty", "Quiet", "WiFi, Power, A/C"));

        locationList.add(new StudyLocation("#02", "Study Room A", "5 stars",
                "Private room perfect for group work.",
                "5 min", "9:00 AM - 8:00 PM", "4/6", "Moderate", "Normal", "WiFi, Power, Screen"));

        locationList.add(new StudyLocation("#03", "Law Library", "4.5 stars",
                "Focused environment for law students.",
                "10 min", "8:00 AM - 11:00 PM", "120/150", "Busy", "Quiet", "WiFi, Power"));

        adapter = new StudySpotAdapter(locationList, this);
        recyclerView.setAdapter(adapter);
    }
}