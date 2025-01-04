package com.example.educards;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class SelectionWithCards {
    @Embedded public CardsSelection cardsSelection;
    @Relation(
            parentColumn = "CardsSelection_id",
            entityColumn = "SelectionId"
    )
    public List<Card> cards;
}
