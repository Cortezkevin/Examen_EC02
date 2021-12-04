package com.example.examen_proyecto;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examen_proyecto.adapter.CategoryGridItemDecoration;
import com.example.examen_proyecto.adapter.CategoryRecyclerViewAdapter;
import com.example.examen_proyecto.adapter.ProductGridItemDecoration;
import com.example.examen_proyecto.adapter.ProductRecyclerViewAdapter;
import com.example.examen_proyecto.network.Category;
import com.example.examen_proyecto.network.Product;
import com.google.android.material.navigation.NavigationView;

public class MenuFragment extends Fragment{

    //declaramos los componentes
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.menu_fragment, container, false);

        //instanciamos o enlazamos los componentes con la vista
        drawerLayout = view.findViewById(R.id.drawer_layout);
        navigationView = view.findViewById(R.id.nav_view);


        //AGREGANDO LOS CARDS AL RECYCLER VIEW DE PRODUCTOS
        RecyclerView recyclerViewProducts = view.findViewById(R.id.recycler_view_products);
        recyclerViewProducts.setHasFixedSize(true); //fixiar tamaño segun la pantalla

                                                //configuramos el recycler -> contexto, cuantas columnas, orientacion
        recyclerViewProducts.setLayoutManager(new GridLayoutManager(getContext(), 1, RecyclerView.HORIZONTAL, false));
        ProductRecyclerViewAdapter adapterProducts = new ProductRecyclerViewAdapter(//instanciamos la clase adapter y le mandamos un parametro
                    Product.initProductList(getResources()));//inicializamos la lista de productos que estan en el json
        recyclerViewProducts.setAdapter(adapterProducts);//añadimos el adapter(informacion) al recycler

        //configuracion la separacion entre los cards
        int largePaddingProduct = getResources().getDimensionPixelSize(R.dimen.product_grid_spacing);
        int smallPaddingProduct = getResources().getDimensionPixelSize(R.dimen.product_grid_spacing_small);
        recyclerViewProducts.addItemDecoration(new ProductGridItemDecoration(largePaddingProduct, smallPaddingProduct));


        //AGREGANDO LOS CARDS AL RECYCLER VIEW DE CATEGORIAS
        RecyclerView recyclerViewCategories = view.findViewById(R.id.recycler_view_categories);
        recyclerViewCategories.setHasFixedSize(true);
        recyclerViewCategories.setLayoutManager(new GridLayoutManager(getContext(), 1, RecyclerView.HORIZONTAL, false));
        CategoryRecyclerViewAdapter adapterCategories = new CategoryRecyclerViewAdapter(
                Category.initCategoryList(getResources()));
        recyclerViewCategories.setAdapter(adapterCategories);


        int largePaddingCategory = getResources().getDimensionPixelSize(R.dimen.category_grid_spacing);
        int smallPaddingCategory = getResources().getDimensionPixelSize(R.dimen.category_grid_spacing_small);
        recyclerViewCategories.addItemDecoration(new CategoryGridItemDecoration(largePaddingCategory,smallPaddingCategory));



        return view;
    }


}
