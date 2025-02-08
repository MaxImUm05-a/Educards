package com.example.educards;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "TestsHaveSelections",
        primaryKeys = {"Relation_id", "CardsSelection_id", "Test_id"}
//        foreignKeys = {
//                @ForeignKey(entity = CardsSelection.class,
//                        parentColumns = "CardsSelection_id", childColumns = "CardsSelection_id"),
//                @ForeignKey(entity = Test.class,
//                        parentColumns = "Test_id", childColumns = "Test_id")
//        }
)
public class TestsHaveSelections {
    @ColumnInfo(name="Relation_id")
    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name="CardsSelection_id")
    public int cardsselection_id;

    @ColumnInfo(name="Test_id")
    public int test_id;
}
