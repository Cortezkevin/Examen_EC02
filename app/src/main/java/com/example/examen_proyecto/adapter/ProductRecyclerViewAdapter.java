package com.example.examen_proyecto.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examen_proyecto.R;
import com.example.examen_proyecto.holder.ProductViewHolder;
import com.example.examen_proyecto.network.ImageRequester;
import com.example.examen_proyecto.network.Product;

import java.util.List;

public class ProductRecyclerViewAdapter extends RecyclerView.Adapter<ProductViewHolder> {

    private List<Product> productList;
    private ImageRequester imageRequester;

    public ProductRecyclerViewAdapter(List<Product> productList){
        this.productList = productList;
        imageRequester = ImageRequester.getInstance();
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_card, parent, false);

        return new ProductViewHolder(viewLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        if(productList != null && position < productList.size()){
            Product product = productList.get(position);
            holder.product_name.setText(product.name);
            holder.product_mark.setText(product.mark);
            holder.product_price.setText(product.price);
            holder.product_discount.setText(product.discount);
            imageRequester.setImageFromUrl(holder.product_image, product.url);
        }
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}
