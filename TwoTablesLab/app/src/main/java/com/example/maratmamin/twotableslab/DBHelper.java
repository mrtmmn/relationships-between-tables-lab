package com.example.maratmamin.twotableslab;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by maratmamin on 3/24/16.
 */
public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "db", null, 0);
    }

    private static DBHelper INSTANCE;

    public static synchronized DBHelper getINSTANCE(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new DBHelper(context.getApplicationContext());
        }
        return INSTANCE;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_FOR_EMPLOYEE);
        db.execSQL(CREATE_TABLE_FOR_JOB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(CREATE_TABLE_FOR_EMPLOYEE);
        db.execSQL(CREATE_TABLE_FOR_JOB);
        onCreate(db);
    }

    public static abstract class DataEntryEmployee implements BaseColumns {
        public static final String TABLE_NAME = "employee";
        public static final String COL_SSN = "ssn";
        public static final String COL_FIRST = "first";
        public static final String COL_LAST = "last";
        public static final String COL_YEAR = "year of birth";
        public static final String COL_CITY = "city";
    }

    public static abstract class DataEntryJob implements BaseColumns {
        public static final String TABLE_NAME = "job";
        public static final String COL_SSN = "ssn";
        public static final String COL_COMPANY = "company";
        public static final String COL_SALARY = "salary";
        public static final String COL_EXPERIENCE = "experience";
    }

    private static final String CREATE_TABLE_FOR_EMPLOYEE = "create table" + DataEntryEmployee.TABLE_NAME
            + " (" + DataEntryEmployee._ID + " integer primary key autoincrement "
            + DataEntryEmployee.COL_SSN + " text "
            + DataEntryEmployee.COL_FIRST + " text "
            + DataEntryEmployee.COL_LAST + " text "
            + DataEntryEmployee.COL_YEAR + " text "
            + DataEntryEmployee.COL_CITY + " text" + ") ";

    private static final String CREATE_TABLE_FOR_JOB = "create table" + DataEntryJob.TABLE_NAME
            + " (" + DataEntryJob._ID + " integer primary key autoincrement "
            + DataEntryJob.COL_SSN + " text "
            + DataEntryJob.COL_COMPANY + " text "
            + DataEntryJob.COL_SALARY + " text "
            + DataEntryJob.COL_EXPERIENCE + " text) ";

    private static final String SQL_DELETE_ENTRIES_EMPLOYEE = "DROP TABLE IF EXISTS " +
            DataEntryEmployee.TABLE_NAME;

    private static final String SQL_DELETE_ENTRIES_Job = "DROP TABLE IF EXISTS " +
            DataEntryJob.TABLE_NAME;

    public void insertRow(Employee employee) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DataEntryEmployee.COL_FIRST, employee.getmFirst());
        values.put(DataEntryEmployee.COL_LAST, employee.getmLast());
        values.put(DataEntryEmployee.COL_SSN, employee.getmSSN());
        values.put(DataEntryEmployee.COL_YEAR, employee.getmYear());
        values.put(DataEntryEmployee.COL_CITY, employee.getmCity());
        db.insertOrThrow(DataEntryEmployee.TABLE_NAME, null, values);
    }

    public void insertRowDepartment(Job job) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DataEntryJob.COL_COMPANY, job.getmCompany());
        values.put(DataEntryJob.COL_SSN, job.getmSSN());
        values.put(DataEntryJob.COL_SALARY, job.getmSalary());
        values.put(DataEntryJob.COL_EXPERIENCE, job.getmExperience());
        db.insertOrThrow(DataEntryJob.TABLE_NAME, null, values);
    }
}
