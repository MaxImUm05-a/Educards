package com.example.educards;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

public class TestWithSelections {
    @Embedded
    public Test test;

    @Relation(
            parentColumn = "Test_id",
            entityColumn = "CardsSelection_id",
            associateBy = @Junction(TestsHaveSelections.class)
    )
    public List<CardsSelection> selections;
}
