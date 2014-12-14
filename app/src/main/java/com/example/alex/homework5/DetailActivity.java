package com.example.alex.homework5;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class DetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Notice that setContentView() is not used, because we use the root
        // android.R.id.content as the container for each fragment

        // setup action bar for tabs
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setDisplayShowTitleEnabled(false);

        ActionBar.Tab tab = actionBar.newTab()
                .setText("Details")
                .setTabListener(new TabListener<DetailFragment>(
                        this, "artist", DetailFragment.class));
        actionBar.addTab(tab);

        tab = actionBar.newTab()
                .setText("More Music")
                .setTabListener(new TabListener<MoreMusicFragment>(
                        this, "album", MoreMusicFragment.class));
        actionBar.addTab(tab);

        tab = actionBar.newTab()
                .setText("Events")
                .setTabListener(new TabListener<EventsFragment>(
                        this, "album", EventsFragment.class));
        actionBar.addTab(tab);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}