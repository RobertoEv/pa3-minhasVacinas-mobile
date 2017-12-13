package com.betoe.minhasvacinas.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.betoe.minhasvacinas.R;
import com.betoe.minhasvacinas.RegisterActivity;
import com.betoe.minhasvacinas.RegisterPetActivity;
import com.betoe.minhasvacinas.adapter.PetAdapter;
import com.betoe.minhasvacinas.model.Pet;
import com.betoe.minhasvacinas.rest.APIClient;
import com.betoe.minhasvacinas.rest.PetEndPoint;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    TextView receivedUsername;
    TextView receivedEmail;
    Button addPet;
    Bundle extras;
    RecyclerView myRecyclerView;
    List<Pet> myDataSource = new ArrayList<>();
    RecyclerView.Adapter myAdapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        extras = getIntent().getExtras();

        receivedUsername = (TextView) findViewById(R.id.mainNameTextId);
        receivedEmail = (TextView) findViewById(R.id.mainEmailTextId);

        receivedUsername.setText(extras.getString("name"));
        receivedEmail.setText(extras.getString("email"));

        myRecyclerView = (RecyclerView) findViewById(R.id.pet_recycler_view);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new PetAdapter(myDataSource, R.layout.pet_item, getApplicationContext());
        myRecyclerView.setAdapter(myAdapter);
        loadPets();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.registerPetButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegisterPetActivity.class);
                startActivity(intent);


            }
        });


    }

    private void loadPets() {
        String user1 = "RobertoEv";
        PetEndPoint apiService = APIClient.getClient().create(PetEndPoint.class);
        Call<List<Pet>> call = apiService.getPet(user1);
        call.enqueue(new Callback<List<Pet>>() {
            @Override
            public void onResponse(Call<List<Pet>> call, Response<List<Pet>> response) {
                myDataSource.clear();
                myDataSource.addAll(response.body());
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Pet>> call, Throwable t) {
                Log.e("Pets", t.toString());
            }
        });
    }

    public void getVacina(View view) {
        Intent intent = new Intent(getApplicationContext(), VacinaActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
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
            Intent intent = new Intent(getApplicationContext(), SobreActivity.class);
            startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_slideshow) {
            Intent intent = new Intent(getApplicationContext(), RegisterPetActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {
            Intent intent = new Intent(getApplicationContext(), SobreActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

//    override fun onCreate(savedInstanceState: Bundle?) {
//    super.onCreate(savedInstanceState)
//    setContentView(R.layout.activity_main)
//
//    var data = intent.extras
//    Toast.makeText(this, data.get("email").toString(), Toast.LENGTH_SHORT).show()
//
//    registerPetButton.setOnClickListener {
//        startActivity(Intent(this, RegisterPetActivity::class.java))
//    }
//
//}