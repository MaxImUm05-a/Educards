package com.example.educards;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "Question", foreignKeys = @ForeignKey(
        entity = Test.class,
        parentColumns = "Test_id",
        childColumns = "TestId",
        onDelete = ForeignKey.CASCADE),
        indices = @Index(value = "TestId")
)
public class Question {

    @ColumnInfo(name="Question_id")
    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name="Type")
    String type;

    @ColumnInfo(name="Rightness")
    int rightness;

    @ColumnInfo(name="Content")
    String content;

    @ColumnInfo(name="TestId")
    int testId;

    @Ignore
    public Question(){}

    public Question(String type, int rightness, String content) {
        this.type = type;
        this.rightness = rightness;
        this.content = content;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRightness() {
        return this.rightness;
    }

    public void setRightness(int rightness) {
        this.rightness = rightness;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
