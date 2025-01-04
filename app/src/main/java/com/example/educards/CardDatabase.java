package com.example.educards;

import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = {Card.class, CardsSelection.class, Test.class, Question.class}, version = 1)
public abstract class CardDatabase extends RoomDatabase {

    public abstract  CardDAO getCardDAO();
    public abstract  CardsSelectionDAO getCardsSelectionDAO();
    public abstract  TestDAO getTestDAO();
    public abstract  QuestionDAO getQuestionDAO();
}
