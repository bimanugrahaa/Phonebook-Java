package com.polytron.phonebook.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.polytron.phonebook.dao.PhonebookDao;
import com.polytron.phonebook.model.Phonebook;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Phonebook.class}, version = 1, exportSchema = false)
public abstract class PhonebookRoomDB extends RoomDatabase {

    public abstract PhonebookDao phonebookDao();
    private static volatile PhonebookRoomDB INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecution =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    public static PhonebookRoomDB getDatabase(final Context context){
        if (INSTANCE == null){
            synchronized (PhonebookRoomDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    PhonebookRoomDB.class, "word_database").build();
                }
            }
        }
        return INSTANCE;
    }
}
