package com.elsafty.flashcards.Database;


import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
interface SubjectDao {
    @Query("SELECT * FROM subjects")
    LiveData<List<SubjectEntity>> getAllSubject();

    @Query("SELECT * FROM subjects WHERE subject_id= :id")
    LiveData<SubjectEntity> getCardById(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSubject(SubjectEntity subjectEntity);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateSubject(SubjectEntity subjectEntity);

    @Delete
    void deleteSubject(SubjectEntity subjectEntity);

    @Query("DELETE FROM subjects")
    void deleteAll();
}
