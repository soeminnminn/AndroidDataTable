package com.s16.datatabletest;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.s16.datatabletest.data.DataProvider;
import com.s16.logger.Log;
import com.s16.logger.LogFragment;
import com.s16.logger.LogWrapper;
import com.s16.logger.MessageOnlyLogFilter;

public class MainActivity extends AppCompatActivity {

    protected static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeLogging();
    }

    /** Set up targets to receive log data */
    public void initializeLogging() {
        // Using Log, front-end to the logging chain, emulates android.util.log method signatures.
        // Wraps Android's native log framework
        LogWrapper logWrapper = new LogWrapper();
        Log.setLogNode(logWrapper);

        // Filter strips out everything except the message text.
        MessageOnlyLogFilter msgFilter = new MessageOnlyLogFilter();
        logWrapper.setNext(msgFilter);

        // On screen logging via a fragment with a TextView.
        LogFragment logFragment = (LogFragment) getSupportFragmentManager().findFragmentById(R.id.log_fragment);
        msgFilter.setNext(logFragment.getLogView());

        Log.i(TAG, "Ready");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.menu_run_test:
                performRunTest();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void performRunTest() {
        Log.i(TAG, "Starting Run Test ...");
        Cursor cursor = getContentResolver().query(DataProvider.User.INSTANCE.getUri(), null, null, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                int colIdx = cursor.getColumnIndex(DataProvider.User.COL_USER_NAME);
                if (colIdx != -1) {
                    Log.i(TAG, "User Name = " + cursor.getString(colIdx));
                }
            }
            Log.i("TEST", "Success");
            cursor.close();
        }

        Log.i(TAG, "Finish Run Test.");
    }
}
