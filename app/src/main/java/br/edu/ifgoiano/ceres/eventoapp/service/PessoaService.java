package br.edu.ifgoiano.ceres.eventoapp.service;

import android.content.Context;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import br.edu.ifgoiano.ceres.eventoapp.R;
import br.edu.ifgoiano.ceres.eventoapp.model.Pessoa;
import br.edu.ifgoiano.ceres.eventoapp.util.OkhttpManager;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class PessoaService {
    private ArrayList<Pessoa> pessoaArrayList = new ArrayList<>();
    private Context context;

    public PessoaService(Context context) {
        this.context = context;
        inicializaArray();
    }

    private void inicializaArray() {
        new OkhttpManager().getAsyncCall(
                "https://www.even3.com.br/api/v1/attendees/",
                new String[]{"Authorization-Token",
                        this.context.getString(R.string.chave_api_eventox)}, new Callback() {
                    @Override
                    public void onFailure(@NotNull Call call, @NotNull IOException e) {

                    }

                    @Override
                    public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

                        try {
                            if (response.isSuccessful()) {
                                JSONObject pessoasObject = new JSONObject(Objects.requireNonNull(response.body()).string());
                                JSONArray pessoasArray = new JSONArray(pessoasObject.getString("data"));
                                // System.out.println(pessoasArray.length());
                                for (int i = 0; i < pessoasArray.length(); i++) {
                                    JSONObject pessoaArray = pessoasArray.getJSONObject(i);
                                    pessoaArrayList.add(
                                            new Pessoa(
                                                    pessoaArray.getLong("id_attendees"),
                                                    pessoaArray.getLong("id_event"),
                                                    pessoaArray.getString("name"),
                                                    pessoaArray.getString("bagde_name"),
                                                    pessoaArray.getString("email"),
                                                    pessoaArray.getString("gender"),
                                                    pessoaArray.getString("photo"),
                                                    pessoaArray.getBoolean("confirmed")
                                            )
                                    );
                                }

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });
    }


    public ArrayList<Pessoa> getPessoaArrayList() {
        return pessoaArrayList;
    }

    public Context getContext() {
        return context;
    }

}
