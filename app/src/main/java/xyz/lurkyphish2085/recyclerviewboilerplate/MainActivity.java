package xyz.lurkyphish2085.recyclerviewboilerplate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<PersonModel> personModels;
    PersonAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();
        initRecyclerViewItems();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        adapter = new PersonAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private void initRecyclerViewItems() {
        PersonModel p1 = new PersonModel("Dan", "This is Dan, he is good boy :)");
        PersonModel p2 = new PersonModel("Dong", "This is Dong, he is bad boy >:)");
        PersonModel p3 = new PersonModel("Bing Chilling", "This is Bing, he do be chillin doe B)");
        adapter.setPersonModels(List.of(p1, p2, p3));
    }
}