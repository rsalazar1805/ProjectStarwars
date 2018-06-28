package com.ronald.projectstarwars.fragments;


import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.ronald.projectstarwars.R;
import com.ronald.projectstarwars.modelos.Film;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

/**
 * A simple {@link Fragment} subclass.
 */
public class FilmsFragment extends Fragment {

    private String urlAPI = "https://swapi.co/api/films";
    private RequestQueue mQueue;
    private View vista;
    private List<Film> films;
    private ArrayList<String> arrayAux;
    private Spinner spinnerFilms;
    private Spinner spinnerPlanets;
    private TextView txtDirector;
    private TextView txtProducer;
    private TextView txtReleaseDate;
    private Button btnOpeningText;
    private String urlFilm;

    public FilmsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        vista = inflater.inflate(R.layout.fragment_films, container, false);
        mQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        films = new ArrayList<>();
        arrayAux= new ArrayList<String>();
        spinnerFilms = vista.findViewById(R.id.spinner);
        spinnerPlanets = vista.findViewById(R.id.spplanets);
        txtDirector = vista.findViewById(R.id.txt_Director);
        txtProducer = vista.findViewById(R.id.txt_Producer);
        txtReleaseDate = vista.findViewById(R.id.txt_ReleaseDate);
        btnOpeningText = vista.findViewById(R.id.btnOpeningText);

        btnOpeningText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (urlFilm != "")
                {
                    Fragment movieTextFrament = new MovieTextFragment(urlFilm);
                    mostrarFragment(movieTextFrament);

                }
                else
                {
                    Toast.makeText(getActivity(), "Debe de seleccionar una pelicula primero", Toast.LENGTH_SHORT).show();
                }

            }
        });

        getFilmsData();

        spinnerFilms.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(final AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(getActivity(), "This is " + adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();

                try {
                    //Your task here
                    //Film aFilm2 = films.stream().filter(f -> adapterView.getItemAtPosition(i).toString().equals(f.getTitle())).findAny().orElse(null);
                    for (Film aux : films) {
                        if(aux.getTitle() == adapterView.getItemAtPosition(i).toString())
                        {
                            txtDirector.setText(aux.getDirector());
                            txtDirector.getPaint().setUnderlineText(true);
                            txtProducer.setText(aux.getProducer());
                            txtProducer.getPaint().setUnderlineText(true);
                            txtReleaseDate.setText(aux.getRelease_date());
                            txtReleaseDate.getPaint().setUnderlineText(true);

                            ArrayList<String> planets = new ArrayList<>();
                            for (int x = 0; x < aux.getPlanetsUrls().size(); x++) {
                                planets.add(aux.getPlanetsUrls().get(x).toString());
                            }
                            try {
                                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item, planets);
                                adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spinnerPlanets.setAdapter(adapter);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            urlFilm = aux.getUrl();

                        }

                    }

                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return vista;
    }



    public void getFilmsData() {
        //final ProgressBar spinner = vista.findViewById(R.id.progressBar);

        JsonObjectRequest request = null;

        request = new JsonObjectRequest(Request.Method.GET, urlAPI, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray jsonArray = response.getJSONArray("results");

                            for (int i = 0; i < jsonArray.length(); i++){
                                JSONObject jsonResult = jsonArray.getJSONObject(i);

                                Film newFilmItem = new Film();
                                newFilmItem.setTitle(jsonResult.getString("title"));
                                //newFilmItem.setEpisodeId(jsonResult.getString("episode_id"));
                                newFilmItem.setOpeningCrawl(jsonResult.getString("opening_crawl"));
                                newFilmItem.setDirector(jsonResult.getString("director"));
                                newFilmItem.setProducer(jsonResult.getString("producer"));
                                newFilmItem.setRelease_date(jsonResult.getString("release_date"));
                                newFilmItem.setUrl(jsonResult.getString("url"));
                                newFilmItem.setCreated(jsonResult.getString("created"));
                                newFilmItem.setEdited(jsonResult.getString("edited"));

                                for (int pos = 0; pos < jsonResult.getJSONArray("species").length(); pos++) {
                                    arrayAux.add(jsonResult.getJSONArray("species").get(pos).toString());
                                }
                                newFilmItem.setSpeciesUrls(arrayAux);
                                arrayAux = null;
                                arrayAux= new ArrayList<String>();

                                for (int pos = 0; pos < jsonResult.getJSONArray("starships").length(); pos++) {
                                    arrayAux.add(jsonResult.getJSONArray("starships").get(pos).toString());
                                }
                                newFilmItem.setStarshipsUrls(arrayAux);
                                arrayAux = null;
                                arrayAux= new ArrayList<String>();


                                for (int pos = 0; pos < jsonResult.getJSONArray("vehicles").length(); pos++) {
                                    arrayAux.add(jsonResult.getJSONArray("vehicles").get(pos).toString());
                                }
                                newFilmItem.setVehiclesUrls(arrayAux);
                                arrayAux = null;
                                arrayAux= new ArrayList<String>();

                                for (int pos = 0; pos < jsonResult.getJSONArray("planets").length(); pos++) {
                                    arrayAux.add(jsonResult.getJSONArray("planets").get(pos).toString());
                                }
                                newFilmItem.setPlanetsUrls(arrayAux);
                                arrayAux = null;
                                arrayAux= new ArrayList<String>();

                                for (int pos = 0; pos < jsonResult.getJSONArray("characters").length(); pos++) {
                                    arrayAux.add(jsonResult.getJSONArray("characters").get(pos).toString());
                                }
                                newFilmItem.setCharactersUrls(arrayAux);
                                arrayAux = null;
                                arrayAux= new ArrayList<String>();

                                films.add(newFilmItem);

                            }
                            ControlPopulations();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

            }
        });

        mQueue.add(request);





    }

    private void ControlPopulations() {
//        for (int i = 0; i < films.size(); i++) {
//
//            for (int pos = 0; pos < films.get(i).getVehiclesUrls().size();pos++) {
//                Toast.makeText(getActivity(), films.get(i).getVehiclesUrls().get(pos), Toast.LENGTH_SHORT).show();
//            }
//        }

        ArrayList<String> titles = new ArrayList<>();
        for (int i = 0; i < films.size(); i++) {
            titles.add(films.get(i).getTitle());
        }
        try {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item, titles);
            adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
            spinnerFilms.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
        }




    }

    private void mostrarFragment(Fragment fragment) {
        FragmentTransaction transaccion = getFragmentManager().beginTransaction();
        transaccion.replace(R.id.contedorFragments, fragment);
        transaccion.commit();

    }

}
