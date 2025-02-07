package com.example.educards;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TestDAO {

    @Insert
    public void addTest(Test test);

    @Update
    public void updateTest(Test test);

    @Delete
    public void deleteTest(Test test);

    @Query("SELECT * FROM Test")
    public List<Test> getAllTest();

    @Query("SELECT * FROM Test WHERE Test_id==:Test_id")
    public Test getTest(int Test_id);

//    @Transaction
//    @Query("SELECT * FROM Test WHERE Test_id==:Test_id")
//    TestWithQuestions getTestWithQuestions(int Test_id);
//
//    @Transaction
//    @Query("SELECT * FROM Test WHERE Test_id==:Test_id")
//    TestWithSelections getTestWithSelections(int Test_id);
}
