package com.s16.data;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;

import com.s16.datatable.DataTable;


/**
 * Created by SMM on 9/7/2016.
 */
public class DataChangeObserver extends ContentObserver {

    private NotifyDataSetChangedListener mListener;
    private ContentResolver mResolver;

    public DataChangeObserver(ContentResolver resolver, Uri uri,
                              NotifyDataSetChangedListener listener) {
        super(new Handler());
        mListener = listener;
        mResolver = resolver;
        if (mResolver != null && uri != null) {
            mResolver.registerContentObserver(uri, true, this);
        }
    }

    public DataChangeObserver(ContentResolver resolver, DataTable table,
                              NotifyDataSetChangedListener listener) {
        super(new Handler());
        mListener = listener;
        mResolver = resolver;
        if (mResolver != null && table != null) {
            mResolver.registerContentObserver(table.getUri(), true, this);
        }
    }

    @Override
    public void onChange(boolean selfChange) {
        if (mListener != null) {
            mListener.notifyDataSetChanged();
        }
    }

    public void destroy() {
        if (mResolver != null) {
            mResolver.unregisterContentObserver(this);
        }
    }
}
