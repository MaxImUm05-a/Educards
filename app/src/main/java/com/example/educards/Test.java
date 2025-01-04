package com.example.educards;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "Test")
public class Test {

    @ColumnInfo(name="Test_id")
    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name="Mark")
    int Mark;

    @Ignore
    public Test(){}

    public Test(int mark) {
        Mark = mark;
    }

    public int getMark() {
        return Mark;
    }

    public void setMark(int mark) {
        Mark = mark;
    }
}
