package br.edu.ifgoiano.ceres.eventoapp.service;

import android.content.Context;
import android.util.Log;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import br.edu.ifgoiano.ceres.eventoapp.R;
import br.edu.ifgoiano.ceres.eventoapp.model.Event;
import br.edu.ifgoiano.ceres.eventoapp.model.Prices;
import br.edu.ifgoiano.ceres.eventoapp.model.Tickets;
import br.edu.ifgoiano.ceres.eventoapp.util.OkhttpManager;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class EventoService {

    private Context context;
    private ArrayList<Event> listaDeEventos = new ArrayList<>();

    public EventoService(Context context) {
        this.context = context;
        inicializaArray();
    }

    private void inicializaArray() {
        new OkhttpManager().getAsyncCall(
                "https://www.even3.com.br/api/v1/event",
                new String[]{"Authorization-Token",
                        this.context.getString(R.string.chave_api_eventox)},
                new Callback() {
                    @Override
                    public void onFailure(@NotNull Call call, @NotNull IOException e) {
                        Log.e("FAIL", e.getMessage());
                    }

                    @Override
                    public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                        ArrayList<Tickets> listaDeTickets = new ArrayList<>();
                        ArrayList<Prices> listaDePrices = new ArrayList<>();
                        if (response.isSuccessful()) try {
                            JSONObject eventoObject = new JSONObject(Objects.requireNonNull(response.body()).string());
                            JSONArray eventoArray = new JSONArray(eventoObject.getString("data"));
                            for (int i = 0; i < eventoArray.length(); i++) {
                                JSONObject dadosEventoJSONObject = eventoArray.getJSONObject(i);
                                JSONArray oJsonArrayTickets = new JSONArray(dadosEventoJSONObject.getString("tickets"));
                                for (int j = 0; j < oJsonArrayTickets.length(); j++) {
                                    JSONObject objectTickets = oJsonArrayTickets.getJSONObject(j);
                                    listaDeTickets.add(new Tickets(objectTickets.getString("title"), listaDePrices));
                                    for (int k = 0; k < oJsonArrayTickets.length(); k++) {
                                        JSONArray pricesJSONArray = objectTickets.getJSONArray("prices");
                                        for (int l = 0; l < pricesJSONArray.length(); l++) {
                                            JSONObject priceJSONObject = new JSONObject(pricesJSONArray.getString(l));
                                            listaDePrices.add(new Prices(
                                                    priceJSONObject.getInt("id_ticket"),
                                                    priceJSONObject.getInt("id_ticket_price"),
                                                    priceJSONObject.getDouble("price"),
                                                    priceJSONObject.getString("due_date"))
                                            );
                                        }
                                    }
                                }
                                listaDeEventos.add(new Event(
                                        dadosEventoJSONObject.getString("title"),
                                        dadosEventoJSONObject.getString("url"),
                                        dadosEventoJSONObject.getString("start_date"),
                                        dadosEventoJSONObject.getString("end_date"),
                                        dadosEventoJSONObject.getString("start_date_registration"),
                                        dadosEventoJSONObject.getString("end_date_registration"),
                                        dadosEventoJSONObject.getString("summary"),
                                        dadosEventoJSONObject.getString("description"),
                                        dadosEventoJSONObject.getString("url_image"),
                                        dadosEventoJSONObject.getDouble("credit_hour"),
                                        dadosEventoJSONObject.getString("country"),
                                        dadosEventoJSONObject.getString("state"),
                                        dadosEventoJSONObject.getString("city"),
                                        dadosEventoJSONObject.getString("venue"),
                                        dadosEventoJSONObject.getDouble("latitude"),
                                        dadosEventoJSONObject.getDouble("longitude"),
                                        dadosEventoJSONObject.getString("banner"),
                                        listaDeTickets)

                                );

                            }
                            //setListaDeEventos(listaDeEventos);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
    }

    public ArrayList<Event> getListaDeEventos() {
        return listaDeEventos;
    }

    private void setListaDeEventos(ArrayList<Event> listaDeEventos) {
        this.listaDeEventos = listaDeEventos;
    }
}
