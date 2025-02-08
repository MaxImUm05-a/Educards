package com.example.educards;

import androidx.room.Embedded;
import androidx.room.Relation;
import androidx.room.Junction;

import java.util.List;

public class SelectionWithTests {
    @Embedded
    public CardsSelection selection;
    @Relation(
            parentColumn = "CardsSelection_id",
            entityColumn = "Test_id",
            associateBy = @Junction(TestsHaveSelections.class)
    )
    public List<Test> tests;
}
