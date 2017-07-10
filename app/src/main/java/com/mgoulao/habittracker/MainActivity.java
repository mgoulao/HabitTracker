package com.mgoulao.habittracker;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.mgoulao.habittracker.data.HabitContract.HabitEntry;
import com.mgoulao.habittracker.data.HabitDbHelper;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HabitDbHelper habitDbHelper = new HabitDbHelper(this);

        habitDbHelper.insertHabit(
                "Golf",
                "02/7/2017",
                1,
                HabitEntry.DURATION_HOUR,
                1
        );

        habitDbHelper.insertHabit(
                "Artificial Inteligence",
                "02/7/2017",
                6,
                HabitEntry.DURATION_HOUR,
                0
        );

        habitDbHelper.insertHabit(
                "Read",
                "02/7/2017",
                50,
                HabitEntry.DURATION_MINUTE,
                2
        );

        Cursor cursor = habitDbHelper.queryHabits();

        try {
            while (cursor.moveToNext()) {
                String feeling = "";
                switch (cursor.getInt(5)) {
                    case 0:
                        feeling = "Bad";
                        break;
                    case 1:
                        feeling = "Normal";
                        break;
                    case 2:
                        feeling = "Good";
                        break;
                }

                Log.i(TAG,
                        "Id: " + cursor.getInt(0) + " / "
                        +"Name: " + cursor.getString(1) + " / "
                        +"Date: " + cursor.getString(2) + " / "
                        +"Time: " + cursor.getInt(3) + " " + cursor.getString(4) + " / "
                        +"Feeling: " + feeling + " / ");
            }

        } finally {
            cursor.close();
        }

    }
}
