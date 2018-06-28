package com.ronald.projectstarwars.servicios;

import android.content.Context;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class HttpCliente {

    private RequestQueue cola;

    public HttpCliente(Context context){
        cola = Volley.newRequestQueue(context);
    }

    public void Get(String url, Response.Listener<String> callbackExito, Response.ErrorListener callbackError){
        StringRequest request = new StringRequest(Request.Method.GET, url, callbackExito, callbackError);

        cola.add(request);
    }

    public void GetJson(String url, Response.Listener<JSONObject> callbackExito, Response.ErrorListener callbackError){
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, callbackExito, callbackError);

        request.setRetryPolicy(new DefaultRetryPolicy(
                5 * 1000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        cola.add(request);
    }

    public void GetJsonArray(String url, Response.Listener<JSONArray> callbackExito, Response.ErrorListener callbackError){
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, callbackExito, callbackError);

        cola.add(request);
    }
}


















