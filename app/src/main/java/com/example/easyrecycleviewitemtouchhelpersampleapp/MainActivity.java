package com.example.easyrecycleviewitemtouchhelpersampleapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import static androidx.recyclerview.widget.ItemTouchHelper.*;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private List<String> dataset = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.my_recycler_view);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        int i = 0;
        while(i<20){
            String str = String.format(Locale.US, "Data_0%d",i);
            dataset.add(str);
            i++;
        }

        adapter = new MyAdapter(dataset);
        recyclerView.setAdapter(adapter);

        ItemTouchHelper mIth  = new ItemTouchHelper(
                new SimpleCallback(UP | DOWN , LEFT) {

                    @Override
                    public boolean onMove(@NonNull RecyclerView recyclerView,
                                          @NonNull RecyclerView.ViewHolder viewHolder,
                                          @NonNull RecyclerView.ViewHolder target) {

                        final int fromPos = viewHolder.getAdapterPosition();
                        final int toPos = target.getAdapterPosition();
                        adapter.notifyItemMoved(fromPos, toPos);
                        return true;// true if moved, false otherwise
                    }

                    @Override
                    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                        final int fromPos = viewHolder.getAdapterPosition();
                        dataset.remove(fromPos);
                        adapter.notifyItemRemoved(fromPos);
                    }
                });

        mIth.attachToRecyclerView(recyclerView);
    }

}
