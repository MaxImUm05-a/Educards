package com.example.educards;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "CardsSelection")
public class CardsSelection {

    @ColumnInfo(name="CardsSelection_id")
    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name="Name")
    String Name;

    @ColumnInfo(name="Description")
    String Description;

    @ColumnInfo(name="Like")
    boolean Like;

    @Ignore
    public CardsSelection(){}

    public CardsSelection(String name, String description) {
        Name = name;
        Description = description;
        Like = false;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public boolean isLike() {
        return Like;
    }

    public void setLike(boolean like) {
        Like = like;
    }
}
