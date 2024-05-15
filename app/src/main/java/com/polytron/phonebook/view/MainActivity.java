package com.polytron.phonebook.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.polytron.phonebook.R;
import com.polytron.phonebook.adapter.PhonebookListAdapter;
import com.polytron.phonebook.databinding.ActivityMainBinding;
import com.polytron.phonebook.model.Phonebook;
import com.polytron.phonebook.modelview.PhonebookViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = activityMainBinding.getRoot();
        setContentView(view);

        RecyclerView recyclerView = activityMainBinding.homeRecyclerView;
        final PhonebookListAdapter adapter = new PhonebookListAdapter(new
                PhonebookListAdapter.PhonebookDiff(), this.getApplication());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        activityMainBinding.homeRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        activityMainBinding.fabAdd.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddPhonebookActivity.class);
            startActivity(intent);
        });

        PhonebookViewModel phonebookViewModel = new ViewModelProvider(this).get(PhonebookViewModel.class);
        phonebookViewModel.getAllPhonebook().observe(this, adapter::submitList);
    }
}