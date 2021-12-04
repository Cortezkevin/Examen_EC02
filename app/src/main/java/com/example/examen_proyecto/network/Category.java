package com.example.examen_proyecto.network;

import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;

import com.example.examen_proyecto.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Category {

    private static final String TAG = Category.class.getSimpleName();

    //declaramos las variables del modelo que tiene el json
    public final String name;
    public final Uri dynamicUrl;
    public final String url;
    public final String stock;

    //constructor
    public Category(String name, String dynamicUrl, String url, String stock) {
        this.name = name;
        this.dynamicUrl = Uri.parse(dynamicUrl);
        this.url = url;
        this.stock = stock;
    }

    //metodo que retorna la lista de objetos que contiene el json, haciendo una conversion
    public static List<Category> initCategoryList(Resources resources){
        InputStream inputStream = resources.openRawResource(R.raw.category); //cargando la informacion del json al inputStream
        Writer writer = new StringWriter(); //inicializamos un writer para leer la informacion del json
        char[] buffer = new char[1024];

        try {
            Reader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8")); // pasamos la informacion a utf-8 y lo leemos con el reader
            int pointer;
            while ((pointer = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, pointer);
            }
        } catch (IOException exception) {
            Log.e(TAG, "Error al leer el archivo JSON", exception);
        } finally {
            try {
                inputStream.close();
            } catch (IOException exception){
                Log.e(TAG, "Error al cerrar la conexion con el archivo", exception);
            }
        }
        String jsonCategoriesToString = writer.toString(); //pasamos los datos a string y lo guardamos
        Gson gson = new Gson(); //inicializamos un gson
        Type categoryList = new TypeToken<ArrayList<Category>>() { //definimos el tipo de conversion
        }.getType();

        return gson.fromJson(jsonCategoriesToString, categoryList); // retornamos la informacion convertida en una lista de categorias
    }
}
