package com.example.examen_proyecto.application;

import android.app.Application;
import android.content.Context;

import androidx.appcompat.app.AppCompatDelegate;

public class ExamenProyectoApplication extends Application {

    ///declaramos la instacia y el contexto
    private static ExamenProyectoApplication instance;
    private static Context appContext;

    //metodo para obtener la instancia
    public static ExamenProyectoApplication getInstance(){
        return instance;
    }

    //metodo para obtener el contexto
    public static Context getAppContext(){
        return appContext;
    }

    //metodo para agregar un contexto
    public void setAppContext(Context mAppContext){this.appContext = mAppContext;}


    @Override
    public void onCreate(){
        super.onCreate();
        //asignamos la instancia con el contexto actual
        instance = this;

        //y luego le aplicamos el contexto
        this.setAppContext(getApplicationContext());
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }
}
