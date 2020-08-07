package com.example.thirdhw;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterOfBooks extends RecyclerView.Adapter<AdapterOfBooks.ViewHolder> {
    ArrayList<ModelOfBooks> booksArrayList;
    OnItemForInfoCLick onItemForInfoCLick;


    public AdapterOfBooks(ArrayList<ModelOfBooks> booksArrayList) {
        this.booksArrayList = booksArrayList;
    }
    public void setOnItemForInfoCLick(OnItemForInfoCLick onItemForInfoCLick){
        this.onItemForInfoCLick=onItemForInfoCLick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_books, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
           holder.bind(booksArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return booksArrayList.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        TextView booksName;
        TextView booksAuthor;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            booksName= itemView.findViewById(R.id.nameOfBook);
            booksAuthor=itemView.findViewById(R.id.authorOfBook);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                onItemForInfoCLick.onInfoCLick(getAdapterPosition());

                }
            });
        }

        public void bind(ModelOfBooks modelOfBooks) {
            booksName.setText(modelOfBooks.getName());
            booksAuthor.setText(modelOfBooks.getAuthor());
        }
    }
}


