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

public class Product {

    private static final String TAG = Product.class.getSimpleName();

    public final String name;
    public final String mark;
    public final Uri dynamicUrl;
    public final String url;
    public final String price;
    public final String discount;

    public Product(String name,String mark, String dynamicUrl, String url, String price, String discount) {
        this.name = name;
        this.mark = mark;
        this.dynamicUrl = Uri.parse(dynamicUrl);
        this.url = url;
        this.price = price;
        this.discount = discount;
    }

    public static List<Product> initProductList(Resources resources){
        InputStream inputStream = resources.openRawResource(R.raw.product);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];

        try {
            Reader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
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
        String jsonProductsToString = writer.toString();
        Gson gson = new Gson();
        Type productList = new TypeToken<ArrayList<Product>>() {
        }.getType();

        return gson.fromJson(jsonProductsToString, productList);
    }
}
