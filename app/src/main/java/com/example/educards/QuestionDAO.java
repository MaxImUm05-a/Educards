package com.example.educards;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface QuestionDAO {

    @Insert
    public void addQuestion(Question question);

    @Update
    public void updateQuestion(Question question);

    @Delete
    public void deleteQuestion(Question question);

    @Query("select * from Question")
    public List<Question> getAllQuestion();

    @Query("select * from Question where Question_id==:Question_id")
    public Question getQuestion(int Question_id);
}
