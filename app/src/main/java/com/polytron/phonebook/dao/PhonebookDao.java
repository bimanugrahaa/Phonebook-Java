package com.polytron.phonebook.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.polytron.phonebook.model.Phonebook;

import java.util.List;

@Dao
public interface PhonebookDao {

    //  Create
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertPhoneBook(Phonebook phonebook);

    //  Read
    @Query("SELECT * FROM phonebook_table ORDER BY first_name ASC")
    LiveData<List<Phonebook>> getAllPhonebook();

    @Query("SELECT * FROM phonebook_table WHERE user_id = :userId")
    LiveData<Phonebook> getUserDetail(int userId);

    //  Update
    @Update(onConflict = OnConflictStrategy.IGNORE)
    void updatePhoneBook(Phonebook phonebook);

    //  Delete selected user
//    @Query("DELETE FROM phonebook_table WHERE user_id = :userId")
//    int deleteUser(int userId);
    @Delete()
    void deleteUser(Phonebook phonebook);

    //  Delete all user(s)
    @Query("DELETE FROM phonebook_table")
    void deleteAll();
}
