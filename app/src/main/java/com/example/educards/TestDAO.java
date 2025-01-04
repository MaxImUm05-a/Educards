package com.example.educards;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
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

    @Query("select * from Test")
    public List<Test> getAllTest();

    @Query("select * from Test where Test_id==:Test_id")
    public Test getTest(int Test_id);
}
