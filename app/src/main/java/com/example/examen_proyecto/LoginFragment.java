package com.example.examen_proyecto;

import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        View view = inflater.inflate(R.layout.login_fragment, container, false);

        //declarando y enlazando componentes a la vista
        final TextInputLayout passwordTextInput = view.findViewById(R.id.password_text_input);
        final TextInputEditText passwordTextInputEditText = view.findViewById(R.id.password_edit_text);
        final TextInputEditText usernameTextInputEditText = view.findViewById(R.id.username_edit_text);
        MaterialButton nextButton = view.findViewById(R.id.login_button);


        //evento onclick
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isPasswordValid(passwordTextInputEditText.getText())){
                    passwordTextInput.setError("El password debe contener 5 caracteres como minimo.");
                }else{
                    passwordTextInput.setError(null);
                    ((NavigationHost) getActivity()).navigateTo(new MenuFragment(), false);
                    }
            }
        });

        passwordTextInputEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(isPasswordValid(passwordTextInputEditText.getText())){
                    passwordTextInput.setError(null);
                }
                return false;
            }
        });

        return view;
    }

    //metodo para validar que el password tenga mas de 5 caracteres
    private boolean isPasswordValid(@Nullable Editable text){
        return text != null && text.length() >= 5;
    }


}
