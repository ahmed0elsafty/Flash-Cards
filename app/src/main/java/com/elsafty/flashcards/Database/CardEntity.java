package com.elsafty.flashcards.Database;

import java.util.Date;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "cards",
        foreignKeys = {
                @ForeignKey(entity = SubjectEntity.class,
                        parentColumns = "subject_id",
                        childColumns = "card_parent_id",
                        onDelete = ForeignKey.CASCADE)},
        indices = @Index(value = "card_parent_id")
)
class CardEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "card_id")
    int mId;
    @ColumnInfo(name = "card_parent_id")
    int mParentId;
    String mFrontScreen;
    String mBackScreen;
    Date mDate;

    public CardEntity(int mId, int mParentId, String mFrontScreen, String mBackScreen, Date mDate) {
        this.mId = mId;
        this.mParentId = mParentId;
        this.mFrontScreen = mFrontScreen;
        this.mBackScreen = mBackScreen;
        this.mDate = mDate;
    }

    @Ignore
    public CardEntity(int mParentId, String mFrontScreen, String mBackScreen, Date mDate) {
        this.mParentId = mParentId;
        this.mFrontScreen = mFrontScreen;
        this.mBackScreen = mBackScreen;
        this.mDate = mDate;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public int getmParentId() {
        return mParentId;
    }

    public void setmParentId(int mParentId) {
        this.mParentId = mParentId;
    }

    public String getmFrontScreen() {
        return mFrontScreen;
    }

    public void setmFrontScreen(String mFrontScreen) {
        this.mFrontScreen = mFrontScreen;
    }

    public String getmBackScreen() {
        return mBackScreen;
    }

    public void setmBackScreen(String mBackScreen) {
        this.mBackScreen = mBackScreen;
    }

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }
}
