package com.udemy.toolbar;

import android.Manifest;
import android.app.Dialog;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.design.bottomnavigation.LabelVisibilityMode;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    SearchView mSearchView;
    FloatingActionButton floatingActionButton;
    RecyclerView recyclerView;
    private static final int PERMISSIONS_CALL_CONTACT = 100;
    ComplainAdapter recyclerAdapter;
    List<Complain> userList;
    BottomNavigationView navigation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.show();}
//        floatingActionButton=(FloatingActionButton) findViewById(R.id.myFAB);
//        navigation=(BottomNavigationView) findViewById(R.id.navigation);
//        navigation.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_LABELED);
//        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//
//                switch (menuItem.getItemId()) {
//                    case R.id.navigation_shop:
//                        Toast.makeText(getApplicationContext(), "navigaion shop", Toast.LENGTH_LONG).show();
//                        return true;
//                    case R.id.navigation_gifts:
//                        Toast.makeText(getApplicationContext(), "navigaion gift", Toast.LENGTH_LONG).show();
//                        return true;
//                }
//
//                return true;
//            }});
//        String[] contactName = {"new", "RAMA KRISHNA ASHRAM MARG", "RAMA KRISHNA ASHRAM MARG Hostel Warden RAMA KRISHNA ASHRAM MARG", "Boys Hostel Warden Sir", "Hostel Director ", "name6", "name7", "name8","name9","name10"};
//        String complain = "Hello i have added new suggestion in suggestion layout please enable it";
//        String suggestionDate = "Jan 14,2019";
//        String departmentName="Management";
//        String subject="Employing minors";
//        String description="Test description";
//        String status="long term work";
//        userList = new ArrayList<>();
//        for (int i = 0; i < contactName.length; i++) {
//
//            Complain obj = new Complain();
//            obj.setComplain_id(i);
//            obj.setComplaint_date(suggestionDate);
//            obj.setComplaint(complain);
//            obj.setComplaint_subject(subject);
//            obj.setDepartment_name(departmentName);
//            obj.setComplaint_status(status);
//            obj.setDescription(description);
//            userList.add(obj);
//        }
//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeAsUpIndicator(R.drawable.back);
//        getSupportActionBar().setTitle(R.string.Contacts);
//        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_id);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(linearLayoutManager);
//        recyclerAdapter = new ComplainAdapter(MainActivity.this, userList);
//        recyclerView.setAdapter(recyclerAdapter);
//
//        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
//        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
//
//        } else {
//
//
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, PERMISSIONS_CALL_CONTACT);
//        }
//
//        mSearchView = (SearchView) findViewById(R.id.search_id);
//        mSearchView.setFocusable(false);
//        mSearchView.setQueryHint(Html.fromHtml("<font color = #000000>" + getResources().getString(R.string.searchComplains) + "</font>"));
//        EditText editText = (EditText) mSearchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
//        editText.setTextColor(Color.BLACK);
//        editText.bringToFront();
//        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/sansation_bold.ttf");
//        editText.setTypeface(typeface);
//        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                recyclerAdapter.getFilter().filter(newText);
//                return false;
//            }
//        });
//
//        floatingActionButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//    }
//
//
//
//
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
//        if (requestCode == PERMISSIONS_CALL_CONTACT) {
//
//
//            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//            }
//
//
//        }
//
//
//    }
//
//    class FetchContacts extends AsyncTask<Void, Void, Void> {
//
//
//        @Override
//        protected Void doInBackground(Void... voids) {
//            return null;
//        }
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//        }
//
//        @Override
//        protected void onPostExecute(Void aVoid) {
//            super.onPostExecute(aVoid);
//        }
//    }


}
