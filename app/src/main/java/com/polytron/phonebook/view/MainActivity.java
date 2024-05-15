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

    private PhonebookViewModel phonebookViewModel;
    public static  final int NEW_PHONEBOOK_ACTIVITY_REQUEST_CODE = 1;
    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = activityMainBinding.getRoot();
        setContentView(view);

        phonebookViewModel = new ViewModelProvider(this).get(PhonebookViewModel.class);

//        RecyclerView recyclerView = findViewById(R.id.home_recyclerView);
        RecyclerView recyclerView = activityMainBinding.homeRecyclerView;
        final PhonebookListAdapter adapter = new PhonebookListAdapter(new
                PhonebookListAdapter.PhonebookDiff(), this.getApplication());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        activityMainBinding.homeRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        ImageButton btnDelete = findViewById(R.id.delete_button_rv);
        ImageButton btnEdit = findViewById(R.id.edit_button_rv);

//        btnDelete.setOnClickListener(v -> {
//            phonebookViewModel.deleteUser(userId);
//        });
        activityMainBinding.fabAdd.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddPhonebookActivity.class);
            startActivityForResult(intent, NEW_PHONEBOOK_ACTIVITY_REQUEST_CODE);
        });

        //  Update the cached copy of the words in the adapter.
        phonebookViewModel.getAllPhonebook().observe(this, adapter::submitList);



//        phonebookViewModel = new ViewModelProvider(this).get(PhonebookViewModel.class);
//        //  Update the cached copy of the words in the adapter.
//        phonebookViewModel.getAllPhonebook().observe(this, adapter::submitList);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == NEW_PHONEBOOK_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {

            ArrayList<String> arrayList;
            arrayList = data.getStringArrayListExtra(AddPhonebookActivity.EXTRA_REPLY);
            assert arrayList != null;
            Phonebook phonebook = new Phonebook(arrayList.get(0), arrayList.get(2), arrayList.get(3), arrayList.get(1), arrayList.get(4), arrayList.get(5));
            phonebookViewModel.insertPhonebook(phonebook);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    "Not saved",
                    Toast.LENGTH_LONG
            ).show();
        }
    }
}