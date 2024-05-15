package com.polytron.phonebook.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "phonebook_table")
public class Phonebook {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")
    public int userId;

    @ColumnInfo(name = "first_name")
    @NonNull()
    public String firstName;

    @ColumnInfo(name = "middle_name")
    @NonNull()
    public String middleName;

    @ColumnInfo(name = "last_name")
    @NonNull()
    public String lastName;

    @ColumnInfo(name = "group")
    @NonNull()
    public String group;

    @ColumnInfo(name = "primary_phone")
    @NonNull()
    public String primaryPhone;

    @ColumnInfo(name = "secondary_phone")
    @NonNull()
    public String secondaryPhone;

    public Phonebook(@NonNull String firstName, @NonNull String lastName, @NonNull String primaryPhone, @NonNull String middleName, @NonNull String group, @NonNull String secondaryPhone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.primaryPhone = primaryPhone;

        this.middleName = middleName;
        this.group = group;
        this.secondaryPhone = secondaryPhone;
    }

    public void PhonebookUpdate(int userId, Phonebook phonebook) {
        this.userId = userId;
        this.firstName = phonebook.firstName;
        this.lastName = phonebook.lastName;
        this.primaryPhone = phonebook.primaryPhone;

        this.middleName = phonebook.middleName;
        this.group = phonebook.group;
        this.secondaryPhone = phonebook.secondaryPhone;
    }

    public int getUserId() {
        return userId;
    }

    @NonNull
    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    @NonNull
    public String getLastName() {
        return lastName;
    }

    public String getGroup() {
        return group;
    }

    @NonNull
    public String getPrimaryPhone() {
        return primaryPhone;
    }

    public String getSecondaryPhone() {
        return secondaryPhone;
    }
}
