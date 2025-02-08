package com.example.educards;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class TestWithQuestions {
    @Embedded
    public Test test;
    @Relation(
            parentColumn = "Test_id",
            entityColumn = "TestId"
    )
    public List<Question> questions;
}
