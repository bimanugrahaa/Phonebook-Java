package com.polytron.phonebook.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.polytron.phonebook.dao.PhonebookDao;
import com.polytron.phonebook.database.PhonebookRoomDB;
import com.polytron.phonebook.model.Phonebook;

import java.util.List;

public class PhonebookRepository {
    private final PhonebookDao phonebookDao;
    private final LiveData<List<Phonebook>> allPhonebook;
    public PhonebookRepository(Application application){
        PhonebookRoomDB db = PhonebookRoomDB.getDatabase(application);
        phonebookDao = db.phonebookDao();
        allPhonebook = phonebookDao.getAllPhonebook();
    }
    public LiveData<List<Phonebook>> getAllPhonebook() {
        return this.allPhonebook;
    }
    public LiveData<Phonebook> getUserDetail(int userId) {
        return phonebookDao.getUserDetail(userId);
    }
    public LiveData<List<Phonebook>> getUserByGroup() { return phonebookDao.getUserByGroup(); }
    public void insertPhonebook(Phonebook phonebook) {
        PhonebookRoomDB.databaseWriteExecution.execute(() -> {
            phonebookDao.insertPhoneBook(phonebook);
        });
    }
    public void updatePhonebook(Phonebook phonebook) {
        PhonebookRoomDB.databaseWriteExecution.execute(() -> {
            phonebookDao.updatePhoneBook(phonebook);
        });
    }

    public void deleteUser(Phonebook phonebook) {
        PhonebookRoomDB.databaseWriteExecution.execute(() -> {
            phonebookDao.deleteUser(phonebook);
        });
    }

    public void deleteAll() {
        PhonebookRoomDB.databaseWriteExecution.execute(phonebookDao::deleteAll);
    }
}
