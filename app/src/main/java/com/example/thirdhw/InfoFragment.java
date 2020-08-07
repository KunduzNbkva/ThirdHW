package com.example.thirdhw;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class InfoFragment extends Fragment {

    TextView name,author,desc;
    ModelOfBooks book;
    ArrayList<ModelOfBooks> list=new ArrayList<>();

    public InfoFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Bundle bundle=this.getArguments();
        if(bundle!=null){
            book= (ModelOfBooks) bundle.getSerializable("bookInfo");
            list.add(book);}
        return inflater.inflate(R.layout.fragment_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
     name=view.findViewById(R.id.nameOfBook);
     author=view.findViewById(R.id.authorOfBook);
     desc=view.findViewById(R.id.descOfBook);

        if(book!=null){
            name.setText(book.getName());
            author.setText(book.getAuthor());
            desc.setText(book.getDescription());
        }

    }
}