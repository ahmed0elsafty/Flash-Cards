package com.elsafty.flashcards.Database;

import java.util.Date;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "subjects")
class SubjectEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "subject_id")
    int mId;
    String mTitle;
    Date mDate;
    Integer mColor;

    public SubjectEntity(@NonNull int mId, String mTitle, Date mDate, Integer mColor) {
        this.mId = mId;
        this.mTitle = mTitle;
        this.mDate = mDate;
        this.mColor = mColor;
    }

    @Ignore
    public SubjectEntity(String mTitle, Date mDate, Integer mColor) {
        this.mTitle = mTitle;
        this.mDate = mDate;
        this.mColor = mColor;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    public Integer getmColor() {
        return mColor;
    }

    public void setmColor(Integer mColor) {
        this.mColor = mColor;
    }
}
