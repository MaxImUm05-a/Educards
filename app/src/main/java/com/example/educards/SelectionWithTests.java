package com.example.educards;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

public class SelectionWithTests {
    @Embedded
    public CardsSelection selection;

    @Relation(
            parentColumn = "Selection_id",
            entityColumn = "Test_id",
            associateBy = @Junction(TestsHaveSelections.class)
    )
    public List<Test> tests;
}
