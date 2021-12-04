package com.example.examen_proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    // declaramos los componentes
    private MaterialButton login_button;
    private MaterialButton explore_buttom;

    // declaramos los componentes que tendran las animaciones
    private ImageView logo_image;
    private TextView app_name_text;
    private TextView title_text;
    private TextView subtitle_text;

    //variables de animacion
    Animation topAnin, bottomAnin, rightAnin, leftAnin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Animaciones -- enlazamos las animaciones a las variables declaradas
        topAnin = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnin = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
        rightAnin = AnimationUtils.loadAnimation(this, R.anim.rigth_animation);
        leftAnin = AnimationUtils.loadAnimation(this, R.anim.left_animation);

        //instanciamos las variables con los componentes de la vista(layout - xml)
        logo_image = findViewById(R.id.image_view);
        app_name_text = findViewById(R.id.app_name_text);
        title_text = findViewById(R.id.title_text);
        subtitle_text = findViewById(R.id.subtitle_text);

        login_button = findViewById(R.id.go_login_buttom);
        explore_buttom = findViewById(R.id.explore_button);

        //Le añadimos las animaciones a los componentes
        logo_image.setAnimation(bottomAnin);
        app_name_text.setAnimation(topAnin);
        title_text.setAnimation(topAnin);
        subtitle_text.setAnimation(topAnin);
        login_button.setAnimation(rightAnin);
        explore_buttom.setAnimation(leftAnin);


        //metodo onclick que nos redirecciona a otro activity
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ContainerActivity.class);
                startActivity(intent);
            }
        });
    }
}