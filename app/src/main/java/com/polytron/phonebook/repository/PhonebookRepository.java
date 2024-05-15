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

//    public int deleteUser(int userId) {
////        PhonebookRoomDB.databaseWriteExecution.execute(() -> {
////            phonebookDao.deleteUser(userId);
////        });
//
//        return phonebookDao.deleteUser(userId);
//    }
public void deleteUser(Phonebook phonebook) {
        PhonebookRoomDB.databaseWriteExecution.execute(() -> {
//            phonebookDao.deleteUser(userId);
            phonebookDao.deleteUser(phonebook);
        });

//    phonebookDao.deleteUser(phonebook);
}

    public void deleteAll() {
        PhonebookRoomDB.databaseWriteExecution.execute(phonebookDao::deleteAll);
    }
}
