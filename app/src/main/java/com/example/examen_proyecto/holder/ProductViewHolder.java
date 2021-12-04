package com.example.examen_proyecto.holder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.NetworkImageView;
import com.example.examen_proyecto.R;

public class ProductViewHolder extends RecyclerView.ViewHolder {

    public NetworkImageView product_image;
    public TextView product_name;
    public TextView product_mark;
    public TextView product_price;
    public TextView product_discount;

    public ProductViewHolder(@NonNull View itemView) {
        super(itemView);

        product_image = itemView.findViewById(R.id.product_image);
        product_name = itemView.findViewById(R.id.product_name);
        product_mark = itemView.findViewById(R.id.product_mark);
        product_price = itemView.findViewById(R.id.product_price);
        product_discount = itemView.findViewById(R.id.product_discount);
    }
}
