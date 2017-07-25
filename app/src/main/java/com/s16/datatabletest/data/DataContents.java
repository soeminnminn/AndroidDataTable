package com.s16.datatabletest.data;

import android.net.Uri;
import android.text.TextUtils;

import com.s16.data.AbstractDataProvider;
import com.s16.datatable.DataTable;
import com.s16.datatable.annotation.Column;
import com.s16.datatable.annotation.PrimaryKey;
import com.s16.datatable.annotation.Table;

/**
 * Created by SMM on 6/19/2017.
 */

public class DataContents extends AbstractDataProvider {

    public static final String DATABASE_NAME = "database";
    public static final int DATABASE_VERSION = 1;

    public static final String AUTHORITY = "com.s16.datatabletest.DataContentProvider";
    public static final String SCHEME = "content://";
    public static final Uri CONTENT_URI = Uri.parse(SCHEME + AUTHORITY);

    @Table(name = "user", contentUrl = SCHEME + AUTHORITY)
    public static class User {

        @PrimaryKey(autoIncrement = true)
        public static String COL_ID = _ID;

        @Column(notNull = true)
        public static String COL_USER_NAME = "username";

        @Column(defaultValue = "")
        public static String COL_PASSWORD = "password";

        @Column(notNull = true)
        public static String COL_EMAIL = "email";

        @Column
        public static String COL_PHONE = "phone";

        @Column(dataType = "INTEGER", notNull = true)
        public static String COL_CREATED_DATE = "createdDate";

        @Column(dataType = "INTEGER", notNull = true)
        public static String COL_UPDATED_DATE = "updatedDate";

        public static DataTable INSTANCE = DataTable.newInstance(User.class);
    }

    @Table(name = "city", contentUrl = SCHEME + AUTHORITY)
    public static class City {

        @PrimaryKey
        public static String COL_ID = _ID;

        @Column(notNull = true)
        public static String COL_NAME = "cityname";

        @Column
        public static String COL_DESC = "description";

        @Column(dataType = "INTEGER", notNull = true)
        public static String COL_CREATED_DATE = "createdDate";

        @Column(dataType = "INTEGER", notNull = true)
        public static String COL_UPDATED_DATE = "updatedDate";

        public static DataTable INSTANCE = DataTable.newInstance(City.class);
    }

    @Override
    protected String getDatabaseName() {
        return DATABASE_NAME;
    }

    @Override
    protected int getDatabaseVersion() {
        return DATABASE_VERSION;
    }

    public static Uri getAnyUri(String method) {
        Uri.Builder builder = Uri.parse(SCHEME + AUTHORITY + "/" + PATH_ANY).buildUpon();
        if (!TextUtils.isEmpty(method)) {
            builder = builder.appendQueryParameter("method", method);
        }
        return builder.build();
    }
}
