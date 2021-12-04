package com.example.examen_proyecto.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examen_proyecto.R;
import com.example.examen_proyecto.holder.CategoryViewHolder;
import com.example.examen_proyecto.network.Category;
import com.example.examen_proyecto.network.ImageRequester;

import java.util.List;

public class CategoryRecyclerViewAdapter extends RecyclerView.Adapter<CategoryViewHolder>{

    //declaramos un listado y un objeto imageRequester
    private List<Category> categoryList;
    private ImageRequester imageRequester;

    //creamos el constructo e instaciamos la lista y el imageRequester
    public CategoryRecyclerViewAdapter(List<Category> categoryList){
        this.categoryList = categoryList;
        imageRequester = ImageRequester.getInstance();
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflamos una vista con el card
        View viewLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_card, parent, false);

        return new CategoryViewHolder(viewLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        //si el listado no es nulo y la posicion es menor al tamaño de la lista
        if(categoryList != null && position < categoryList.size()){
            //traemos un objeto de la lista con un get
            Category category = categoryList.get(position);
            //seteamos la informacion traida del objeto al viewHolder
            holder.category_name.setText(category.name);
            holder.category_stock.setText(category.stock);

            //usamos el emtodo traer Imagen por Url y le enviamos el componente donde se guardara la imagen y la url de donde vendra
            imageRequester.setImageFromUrl(holder.category_image, category.url);
        }

    }

    //metodo que retorna la cantidad de items, con el tamaño de la lista
    @Override
    public int getItemCount() {
        return categoryList.size();
    }
}
