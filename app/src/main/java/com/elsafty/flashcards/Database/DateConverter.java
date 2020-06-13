package com.elsafty.flashcards.Database;

import java.util.Date;

import androidx.room.TypeConverter;

class DateConverter {
    @TypeConverter
    public static Date toDate(Long timestamp) {
        if (timestamp == null) {
            return null;
        } else {
            return new Date(timestamp);
        }
    }
    @TypeConverter
    public static Long toTimeStamp(Date date) {
        if (date == null) {
            return null;
        } else {
            return date.getTime();
        }
    }
}
