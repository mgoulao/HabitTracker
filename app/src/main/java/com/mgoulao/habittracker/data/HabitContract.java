package com.mgoulao.habittracker.data;

import android.provider.BaseColumns;

/**
 * Created by msilv on 7/10/2017.
 */

public class HabitContract {

    private HabitContract() {}

    public static final class HabitEntry implements BaseColumns {

        public static final String TABLE_NAME = "habits";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_HABIT_NAME = "name";
        public static final String COLUMN_HABIT_DATE = "date";
        public static final String COLUMN_HABIT_TIME = "time";
        public static final String COLUMN_HABIT_TIME_UNIT = "time_unit";
        public static final String COLUMN_HABIT_FEELING = "feeling";

        public static final String DURATION_MINUTE = "min";
        public static final String DURATION_HOUR = "hr";

        public static final int FEELING_BAD = 0;
        public static final int FEELING_NORMAL = 1;
        public static final int FEELING_GOOD = 2;

    }
}
