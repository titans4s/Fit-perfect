package com.example.cart1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner mySpinner=findViewById(R.id.spinner3);

        ArrayAdapter<String> myAdapter=new ArrayAdapter<String>(MainActivity.this,
            android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.names));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);


        Spinner mspin=(Spinner) findViewById(R.id.spinner5);
        Integer[] items = new Integer[]{1,2,3,4};
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this,android.R.layout.simple_spinner_item, items);
        mspin.setAdapter(adapter);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.drawable.ic_baseline_menu_24);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_new,menu);

        MenuItem.OnActionExpandListener onActionExpandListener=new MenuItem.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem menuItem) {

                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem menuItem) {
                return false;
            }
        };

        menu.findItem(R.id.search).setOnActionExpandListener(onActionExpandListener);
        SearchView searchView=(SearchView) menu.findItem(R.id.search).getActionView();
        //searchView.setQueryHint("Search Items Here");
        return true;


    }

}