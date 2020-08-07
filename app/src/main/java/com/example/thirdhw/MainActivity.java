package com.example.thirdhw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<ModelOfBooks> list;
RecyclerView recyclerView;
AdapterOfBooks adapterOfBooks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.listOfBooks);
        list=new ArrayList<>();
        list.add(new ModelOfBooks("Book1","very cool book","someone is author"));
        list.add(new ModelOfBooks("Book1","very cool book","someone is author"));
        list.add(new ModelOfBooks("Book1","very cool book","someone is author"));
        list.add(new ModelOfBooks("Book1","very cool book","someone is author"));
        list.add(new ModelOfBooks("Book1","very cool book","someone is author"));
        list.add(new ModelOfBooks("Book1","very cool book","someone is author"));
        adapterOfBooks=new AdapterOfBooks(list);
        recyclerView.setAdapter(adapterOfBooks);


        adapterOfBooks.setOnItemForInfoCLick(new OnItemForInfoCLick() {
            @Override
            public void onInfoCLick(int position) {
                InfoFragment infoFragment=new InfoFragment();
                Bundle bundle=new Bundle();
                bundle.putSerializable("bookInfo",list.get(position));
                infoFragment.setArguments(bundle);
                FragmentManager manager=getSupportFragmentManager();
                FragmentTransaction transaction=manager.beginTransaction();
                transaction.add(R.id.frame,infoFragment);
                transaction.commit();
            }
        });

    }


}