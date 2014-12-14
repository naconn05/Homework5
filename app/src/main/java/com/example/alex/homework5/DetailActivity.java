package com.example.alex.homework5;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


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
            getMenuInflater().inflate(R.menu.actionbar, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            int id = item.getItemId();
            switch (id) {
                case R.id.action_settings:
                    settings();
                    return true;
                case R.id.action_search:
                    search();
                    return true;
                case R.id.action_add:
                    add();
                    return true;
            }
            return super.onOptionsItemSelected(item);
        }

        private void add() {
            Toast toast = Toast.makeText(this, "Adding", Toast.LENGTH_SHORT);
            toast.show();
        }

        private void search() {
            /*SearchFragment frag = new SearchFragment();
            FragmentManager manager = getFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.my_layout, frag);
            transaction.commit();*/

            startActivity(new Intent(DetailActivity.this, MainActivity.class));
            Intent intent = new Intent(DetailActivity.this, MainActivity.class);
            startActivity(intent);

            Toast toast = Toast.makeText(this, "Search", Toast.LENGTH_SHORT);
            toast.show();
        }

        private void settings() {
            Toast toast = Toast.makeText(this, "Settings", Toast.LENGTH_SHORT);
            toast.show();
        }
}