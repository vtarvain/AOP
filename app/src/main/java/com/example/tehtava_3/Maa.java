package com.example.tehtava_3;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "maat_table")
public class Maa {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String nimi;

    public Maa(String nimi) {
        this.nimi = nimi;
    }
}