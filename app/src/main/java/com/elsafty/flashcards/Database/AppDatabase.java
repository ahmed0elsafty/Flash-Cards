package com.elsafty.flashcards.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {SubjectEntity.class,CardEntity.class},version = 1,exportSchema = false)
@TypeConverters(DateConverter.class)
abstract class AppDatabase extends RoomDatabase {
    private static final String TAG= AppDatabase.class.getSimpleName();
    private static final String DATABASE_NAME="flashcardsdp";
    private static final Object LOCK = new Object();
    private static AppDatabase sInstance ;

    public static AppDatabase getsInstance(Context context) {
        if (sInstance==null){
            synchronized (LOCK){
                Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class,DATABASE_NAME).build();
            }
        }
        return sInstance;
    }

    public abstract SubjectDao subjectDao();
    public abstract CardDao cardDao();
}
