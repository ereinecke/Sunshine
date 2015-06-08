package com.ereinecke.sunshine;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        ArrayAdapter<String> mForecastAdapter;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            // Create some dummy data for the ListView.  Here's a sample weekly forecast
            String[] data = {
                    "Sun 6/7 - Partly Cloudy - 85/57",
                    "Mon 6/8 - Partly Cloudy - 84/50",
                    "Tue 6/9 - Partly Cloudy - 84/50",
                    "Wed 6/10 - Partly Cloudy - 84/53",
                    "Thu 6/11 - Sunny - 85/55",
                    "Fri 6/12 - Thundershowers - 83/56",
                    "Sat 6/13 - Partly Cloudy - 84/53"
            };
            List<String> weekForecast = new ArrayList<String>(Arrays.asList(data));

            /* Create ArrayAdapter to display dummy forecast data */
            mForecastAdapter =
                new ArrayAdapter<String>(
                    getActivity(), // current context, this activity
                    R.layout.list_item_forecast,  // name of layout ID
                    R.id.list_item_forecast_textview  , // the ID of textview
                    weekForecast);

            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            // Get a reference to the ListView, and attach this adapter to it.
            ListView listView = (ListView) rootView.findViewById(R.id.listview_forecast);
            listView.setAdapter(mForecastAdapter);

            return rootView;

        }
    }
}
