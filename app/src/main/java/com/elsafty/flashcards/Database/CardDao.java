package com.elsafty.flashcards.Database;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
interface CardDao {
    @Query("SELECT * FROM cards")
    List<CardEntity> getAllCards();

    @Query("SELECT * FROM cards WHERE card_id=:id")
    CardEntity getCardById(int id);

    @Query("SELECT * FROM cards WHERE card_parent_id=:id")
    List<CardEntity> getCardsParentById(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCard(CardEntity cardEntity);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateCards(CardEntity cardEntity);

    @Delete
    void deleteCard(CardEntity cardEntity);

    @Query("DELETE FROM cards")
    void deleteAll();
}
