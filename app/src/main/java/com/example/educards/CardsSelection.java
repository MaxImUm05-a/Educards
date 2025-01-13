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
    String name;

    @ColumnInfo(name="Description")
    String description;

    @ColumnInfo(name="Like")
    boolean like;

    @Ignore
    public CardsSelection(){}

    public CardsSelection(String name, String description) {
        this.name = name;
        this.description = description;
        this.like = false;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isLike() {
        return this.like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }
}
