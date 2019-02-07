package com.udemy.toolbar;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recyclerView;
    private static final int PERMISSIONS_CALL_CONTACT = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] contactName = {"name1", "name2", "name3", "name4", "name5", "name6", "name7", "name8"};
        String[] contactNumber = {"9876543210", "9876543210", "9876543210", "9876543210", "9876543210", "9876543210", "9876543210", "9876543210"};
        List<User> userList = new ArrayList<>();
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
        getSupportActionBar().setTitle("Contacts");
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_id);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new RecyclerAdapter(getBaseContext(), userList));

        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {

        } else {


            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, PERMISSIONS_CALL_CONTACT);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.search_id) {

            Toast.makeText(getApplicationContext(), "search", Toast.LENGTH_SHORT).show();

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
}
