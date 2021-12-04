package com.example.examen_proyecto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class ContainerActivity extends AppCompatActivity implements NavigationHost{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        //agregamos el fragmnento inicial que se vera, al crear el activity
        if(savedInstanceState == null){
            getSupportFragmentManager() //configuramos la transaccion
                    .beginTransaction() //iniciamos las operaciones de la transaccion
                    .add(R.id.container, new LoginFragment()) //usamos el add para agregar el fragmento
                    .commit();//aplicamos la configuracion del transaccion
        }

    }

    //metodo para navegar entre fragmentos
    @Override
    public void navigateTo(Fragment fragment, boolean addToBackStack) {
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment);
        if(addToBackStack == true){
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }


}