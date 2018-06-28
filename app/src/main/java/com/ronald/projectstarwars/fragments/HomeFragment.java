package com.ronald.projectstarwars.fragments;


import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ronald.projectstarwars.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private View vista;
    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_home, container, false);


        Button btnFilms = (Button) vista.findViewById(R.id.btnFilms);
        btnFilms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Fragment movieTextFragment = new MovieTextFragment(1);
//                mostrarFragment(movieTextFragment);

                Fragment filmsFragment = new FilmsFragment();
                mostrarFragment(filmsFragment);

            }
        });

        return vista;
    }

    private void mostrarFragment(Fragment fragment) {
        FragmentTransaction transaccion = getFragmentManager().beginTransaction();
        transaccion.replace(R.id.contedorFragments, fragment);
        transaccion.commit();

    }

}
