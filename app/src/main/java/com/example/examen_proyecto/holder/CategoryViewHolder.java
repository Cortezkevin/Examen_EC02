package com.example.examen_proyecto.holder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.NetworkImageView;
import com.example.examen_proyecto.R;

public class CategoryViewHolder extends RecyclerView.ViewHolder {

    //declaramos los componentes donde mostraremos la informacion, que estan en el card
    public NetworkImageView category_image;
    public TextView category_name;
    public TextView category_stock;

    public CategoryViewHolder(@NonNull View itemView) {
        super(itemView);

        //enlazamos los componentes declarados con los de la vista por su id
        category_image = itemView.findViewById(R.id.category_image);
        category_name = itemView.findViewById(R.id.category_name);
        category_stock = itemView.findViewById(R.id.category_stock);
    }
}
