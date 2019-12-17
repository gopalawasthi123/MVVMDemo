package com.example.mvvmdemo.Activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.mvvmdemo.Adapters.MyDataAdapter;
import com.example.mvvmdemo.Model.Posts;
import com.example.mvvmdemo.Model.User;
import com.example.mvvmdemo.R;
import com.example.mvvmdemo.ViewModel.PostsViewModel;
import com.example.mvvmdemo.ViewModel.UserViewModel;
import com.example.mvvmdemo.di.Component.ApplicationComponent;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private PostsViewModel model;
    private RecyclerView.LayoutManager layoutManager;
    private MyDataAdapter adapter;
    private UserViewModel usermodel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        recyclerView = findViewById(R.id.recyclerview);

        model = ViewModelProviders.of(this).get(PostsViewModel.class);
//        model.getPosts().observe(this, new Observer<List<Posts>>() {
//            @Override
//            public void onChanged(@Nullable List<Posts> posts) {
//                prepareRecyclerView(posts);
//            }
//        });

        usermodel = ViewModelProviders.of(this).get(UserViewModel.class);
        usermodel.getUsers().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {
                prepareRecyclerView(users);
            }
        });
    }

//    private void prepareRecyclerView(List<Posts> posts) {
//        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
//        adapter = new MyDataAdapter(this,posts);
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(layoutManager);
//
//    }

    private void prepareRecyclerView(List<User> users) {
        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        adapter = new MyDataAdapter(this,users);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
