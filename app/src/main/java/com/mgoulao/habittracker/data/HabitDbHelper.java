package com.mgoulao.habittracker.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.mgoulao.habittracker.data.HabitContract.HabitEntry;

/**
 * Created by msilv on 7/10/2017.
 */

public class HabitDbHelper extends SQLiteOpenHelper {

    private static final String DATABSE_NAME = "habits.db";
    private static final int DATABASE_VERSION = 1;


    public HabitDbHelper(Context context) {
        super(context, DATABSE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_HABITS_TABLE = "CREATE TABLE " + HabitEntry.TABLE_NAME +
                " (" + HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HabitEntry.COLUMN_HABIT_NAME + " TEXT NOT NULL, "
                + HabitEntry.COLUMN_HABIT_DATE + " TEXT NOT NULL, "
                + HabitEntry.COLUMN_HABIT_TIME + " INTEGER NOT NULL, "
                + HabitEntry.COLUMN_HABIT_TIME_UNIT + " TEXT NOT NULL, "
                + HabitEntry.COLUMN_HABIT_FEELING + " INTEGER NOT NULL DEFAULT 1);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_HABITS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // The database is still at version 1, so there's nothing to do be done here.
    }

    public void insertHabit(String name, String date, int time, String timeUnit, int feeling) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues habitValues = new ContentValues();
        habitValues.put(HabitEntry.COLUMN_HABIT_NAME, name);
        habitValues.put(HabitEntry.COLUMN_HABIT_DATE, date);
        habitValues.put(HabitEntry.COLUMN_HABIT_TIME, time);
        habitValues.put(HabitEntry.COLUMN_HABIT_TIME_UNIT, timeUnit);
        habitValues.put(HabitEntry.COLUMN_HABIT_FEELING, feeling);

        sqLiteDatabase.insert(HabitEntry.TABLE_NAME, null, habitValues);
    }

    public Cursor queryHabits() {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        String[] projection = {
                HabitEntry._ID,
                HabitEntry.COLUMN_HABIT_NAME,
                HabitEntry.COLUMN_HABIT_DATE,
                HabitEntry.COLUMN_HABIT_TIME,
                HabitEntry.COLUMN_HABIT_TIME_UNIT,
                HabitEntry.COLUMN_HABIT_FEELING
        };

        return sqLiteDatabase.query(
                HabitEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
    }
}
