package com.ronald.projectstarwars.fragments;


import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.ronald.projectstarwars.R;
import com.ronald.projectstarwars.servicios.HttpCliente;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieTextFragment extends Fragment {
    private String urlAPI = "https://swapi.co/api/films";
    private TextView mTitle;
    private TextView mFilmtext;
    private RequestQueue mQueue;
    private View vista;

    public MovieTextFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public MovieTextFragment(int movieIndex)
    {
        urlAPI+= "/" + String.valueOf(movieIndex);

    }

    @SuppressLint("ValidFragment")
    public MovieTextFragment(String url)
    {
        urlAPI = url;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        Bundle bundle = this.getArguments();
//        Toast.makeText(getActivity(), bundle.getString("message"), Toast.LENGTH_LONG).show();

        vista = inflater.inflate(R.layout.fragment_movie_text, container, false);

        mTitle = vista.findViewById(R.id.Title);
        mFilmtext = vista.findViewById(R.id.Filmtext);
        mQueue = Volley.newRequestQueue(getActivity().getApplicationContext());

//        Button buttonParse = vista.findViewById(R.id.button_parse);
//        buttonParse.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                jsonParse();
//            }
//        });

        jsonParse();

        return vista;
    }


    private void jsonParse() {

        final ProgressBar spinner = vista.findViewById(R.id.progressBar);

        new AsyncTask<Void,Void,Void>(){

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                spinner.setVisibility(View.VISIBLE);
            }

            @Override
            protected Void doInBackground(Void... voids) {
//                int cont = 0;
//
//                for(int i = 0;i<10000000; i++)
//                {
//                    cont++;
//                }
                JsonObjectRequest request = null;
                try {
                    request = new JsonObjectRequest(Request.Method.GET, urlAPI, null,
                            new Response.Listener<JSONObject>() {
                                @Override
                                public void onResponse(JSONObject response) {

                                    try {
                                        String title = (String) response.get("title");
                                        String opening = (String) response.get("opening_crawl");
                                        mTitle.append(title);
                                        mFilmtext.append(opening);
                                        //Toast.makeText(getActivity(), tit, Toast.LENGTH_LONG).show();

                                        //JSONArray jsonArray = response.getJSONArray("characters");
    //                            for (int i = 0; i < jsonArray.length(); i++){
    //                                String character = jsonArray.getString(i);
    //                                Toast.makeText(getActivity(), character, Toast.LENGTH_LONG).show();
    //                            }

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
                } catch (Exception e) {
                    e.printStackTrace();
                }

                mQueue.add(request);

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                spinner.setVisibility(View.GONE);
                //Toast.makeText(vista.getContext(),"Done", Toast.LENGTH_LONG).show();
            }

        }.execute();

    }

    private void jsonParseBK() {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, urlAPI, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("results");

                            for (int i = 0; i < jsonArray.length(); i++){
                                JSONObject jsonResult = jsonArray.getJSONObject(i);
                                String title = jsonResult.getString("title");
                                mTitle.append(title);
                            }
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



}
