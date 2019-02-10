package com.udemy.toolbar;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recyclerView;
    private static final int PERMISSIONS_CALL_CONTACT = 100;
    RecyclerAdapter recyclerAdapter;
    List<User> userList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] contactName = {"name1", "RAMA KRISHNA ASHRAM MARG", "RAMA KRISHNA ASHRAM MARG Hostel Warden RAMA KRISHNA ASHRAM MARG", "Boys Hostel Warden Sir", "Hostel Director ", "name6", "name7", "name8"};
        String[] contactNumber = {"9876543210", "9876543210", "9876543210", "9876543210", "9876543210", "9876543210", "9876543210", "9876543210"};
         userList = new ArrayList<>();
        for (int i = 0; i < contactName.length; i++) {

            User obj = new User();
            obj.setContactImage(R.drawable.user);
            obj.setContactName(contactName[i]);
            obj.setContactNumber(contactNumber[i]);
            userList.add(obj);

        }
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.Contacts);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_id);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerAdapter=new RecyclerAdapter(getBaseContext(), userList);
        recyclerView.setAdapter(recyclerAdapter);

        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {

        } else {


            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, PERMISSIONS_CALL_CONTACT);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
            MenuItem mSearch = menu.findItem(R.id.search_id);

            SearchView mSearchView = (SearchView) mSearch.getActionView();
            mSearchView.setQueryHint("Search Contacts");
            mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    recyclerAdapter.getFilter().filter(newText);
                    return false;
                }
            });

            return super.onCreateOptionsMenu(menu);
        }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.search_id) {

        } else if (id == android.R.id.home) {

            finish();
        }

        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == PERMISSIONS_CALL_CONTACT) {


            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            }


        }


    }

    class FetchContacts extends AsyncTask<Void,Void,Void>{


        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }




}
