package com.example.educards;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CardDAO {

    @Insert
    public void addCard(Card card);

    @Update
    public void updateCard(Card card);

    @Delete
    public void deleteCard(Card card);

    @Query("select * from Card")
    public List<Card> getAllCard();

    @Query("select * from Card where Card_id==:Card_id")
    public Card getCard(int Card_id);
}
