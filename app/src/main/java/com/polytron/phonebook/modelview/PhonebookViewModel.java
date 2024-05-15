package com.polytron.phonebook.modelview;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.polytron.phonebook.model.Phonebook;
import com.polytron.phonebook.repository.PhonebookRepository;

import java.util.List;

public class PhonebookViewModel extends AndroidViewModel {
    private final PhonebookRepository phonebookRepository;
    private final LiveData<List<Phonebook>> allPhonebook;
    public PhonebookViewModel(@NonNull Application application) {
        super(application);

        phonebookRepository = new PhonebookRepository(application);
        allPhonebook = phonebookRepository.getAllPhonebook();
    }
    public LiveData<List<Phonebook>> getAllPhonebook() { return allPhonebook; }
    public LiveData<Phonebook> getUserDetail(int userId) { return phonebookRepository.getUserDetail(userId); }
    public void insertPhonebook(Phonebook phonebook) { phonebookRepository.insertPhonebook(phonebook); }
    public void updatePhonebook(Phonebook phonebook) { phonebookRepository.updatePhonebook(phonebook); }
//    public int deleteUser(int userId) { return phonebookRepository.deleteUser(userId); }
    public void deleteUser(Phonebook phonebook) { phonebookRepository.deleteUser(phonebook); }
    public void deleteAll() { phonebookRepository.deleteAll(); }

}
