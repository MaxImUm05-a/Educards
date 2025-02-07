package com.example.educards;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CardsSelectionDAO {

    @Insert
    public void addCardsSelection(CardsSelection selection);

    @Update
    public void updateCardsSelection(CardsSelection selection);

    @Delete
    public void deleteCardsSelection(CardsSelection selection);

    @Query("SELECT * FROM CardsSelection")
    public List<CardsSelection> getAllCardsSelection();

    @Query("SELECT * FROM CardsSelection WHERE CardsSelection_id==:CardsSelection_id")
    public CardsSelection getCardsSelection(int CardsSelection_id);

    @Transaction
    @Query("SELECT * FROM CardsSelection")
    public List<SelectionWithCards> getSelectionWithCards();
}
