package com.example.examen_proyecto.network;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.util.LruCache;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.example.examen_proyecto.application.ExamenProyectoApplication;

public class ImageRequester {

    private static ImageRequester instance = null;
    private final Context context; //contexto
    private final RequestQueue requestQueue; //sirve para configurar red y cache
    private final ImageLoader imageLoader; //cargar imagen y guardar en cache
    private final  int maxByteSize; //maxima tamaño de los bytes

    ImageRequester(){
        context = ExamenProyectoApplication.getAppContext(); //agregamos el contexto
        this.requestQueue = Volley.newRequestQueue(context); //creamos la configuracion con el contexto
        this.requestQueue.start(); //inciamos la configuracion
        this.maxByteSize = getMaxByteSize();
        this.imageLoader = new ImageLoader(
                requestQueue,
                new ImageLoader.ImageCache() {//creamos una instacia para crear el cache
                    //LruCache<clave, valor> -> clave - string url, valor - bitmap imagen en pixeles-> mapa de bits, cantidad de bits, tamaño del cache
                    private final LruCache<String, Bitmap> lruCache = new LruCache<String, Bitmap>(maxByteSize){
                        @Override
                        protected int sizeOf(String url, Bitmap bitmap){ //metodo para traer el tamanño del bitmap (imagen), pixeles
                            return bitmap.getByteCount(); //retornamos el tamaño
                        }
                    };
                    @Override
                    public Bitmap getBitmap(String url) {
                        return lruCache.get(url);
                    } ///traer el bitmap (imagen) por la llave(url)

                    @Override
                    public void putBitmap(String url, Bitmap bitmap) {
                        lruCache.put(url, bitmap);
                    } //guardar bitmap - (imagen) con llave y valor
                }
        );



    }

    public static ImageRequester getInstance(){ ///metodo para instanciar la clase
        if(instance == null){
            instance = new ImageRequester();
        }
        return instance;
    }

    //metodo para buscar imagen por una url y añadirla al cache
    public void setImageFromUrl(NetworkImageView image, String url){
        image.setImageUrl(url, imageLoader);//enviamos o añadimos la imagen y la guardamos al cache
    }

    //calcula la cantidad de bytes de la pantalla
    public int getMaxByteSize(){
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        final int screenByteSize = displayMetrics.widthPixels * displayMetrics.heightPixels * 4;
        return screenByteSize * 3;
    }


}
