package com.example.educards;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "Question")
public class Question {

    @ColumnInfo(name="Question_id")
    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name="Type")
    String Type;

    @ColumnInfo(name="Rightness")
    int Rightness;

    @ColumnInfo(name="Content")
    String Content;

    @Ignore
    public Question(){}

    public Question(String type, int rightness, String content) {
        Type = type;
        Rightness = rightness;
        Content = content;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public int getRightness() {
        return Rightness;
    }

    public void setRightness(int rightness) {
        Rightness = rightness;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
