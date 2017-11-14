package com.betoe.minhasvacinas.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.betoe.minhasvacinas.R;
import com.betoe.minhasvacinas.adapter.PetAdapter;
import com.betoe.minhasvacinas.model.Pet;
import com.betoe.minhasvacinas.rest.APIClient;
import com.betoe.minhasvacinas.rest.PetEndPoint;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_main);

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