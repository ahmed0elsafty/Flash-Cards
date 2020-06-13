package com.elsafty.flashcards.Database;

import android.content.Context;
import android.os.AsyncTask;

import java.util.Date;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {SubjectEntity.class, CardEntity.class}, version = 1, exportSchema = false)
@TypeConverters(DateConverter.class)
abstract class AppDatabase extends RoomDatabase {
    private static final String TAG = AppDatabase.class.getSimpleName();
    private static final String DATABASE_NAME = "flashcardsdp";
    private static final Object LOCK = new Object();
    private static AppDatabase sInstance;
    static RoomDatabase.Callback callback = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDb(sInstance).execute();
        }

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
        }
    };

    public static AppDatabase getsInstance(Context context) {
        if (sInstance == null) {
            synchronized (LOCK) {
                Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class,
                        DATABASE_NAME)
                        .addCallback(callback)
                        .build();
            }
        }
        return sInstance;
    }

    public abstract SubjectDao subjectDao();

    public abstract CardDao cardDao();
}

class PopulateDb extends AsyncTask<Void, Void, Void> {
    private SubjectDao mSubjectDoa;
    private CardDao mCardDao;

    public PopulateDb(AppDatabase dp) {
        mSubjectDoa = dp.subjectDao();
        mCardDao = dp.cardDao();
    }

    @Override
    protected Void doInBackground(final Void... voids) {
        SubjectEntity subjectEntity = new SubjectEntity("Data Structures", new Date(), 1);
        SubjectEntity subjectEntity1 = new SubjectEntity("Algorithms", new Date(), 1);
        mSubjectDoa.insertSubject(subjectEntity);
        mSubjectDoa.insertSubject(subjectEntity1);
        return null;
    }
}