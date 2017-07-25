package com.s16.datatabletest.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import java.util.Calendar;

/**
 * Created by SMM on 6/19/2017.
 */

public class DataProvider extends DataContents {

    @Override
    protected boolean useDistinct(Uri uri) {
        return false;
    }

    @Override
    protected void onCreateHelper(SQLiteDatabase db) {
        Calendar now = Calendar.getInstance();
        ContentValues values = new ContentValues();
        values.put(User.COL_USER_NAME, "Administrator");
        values.put(User.COL_PASSWORD, "");
        values.put(User.COL_EMAIL, "admin@domain.com");
        values.put(User.COL_PHONE, "000");
        values.put(User.COL_CREATED_DATE, now.getTimeInMillis());
        values.put(User.COL_UPDATED_DATE, now.getTimeInMillis());

        User.INSTANCE.from(db).insert(values);
    }

    @Override
    protected void onUpdateHelper(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    protected Cursor queryAny(String methodName, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

}
