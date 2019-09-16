package br.edu.ifgoiano.ceres.eventoapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.maps.MapView;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import br.edu.ifgoiano.ceres.eventoapp.R;
import br.edu.ifgoiano.ceres.eventoapp.model.Event;
import br.edu.ifgoiano.ceres.eventoapp.util.Cronometro;

public class EventAdapter
        extends RecyclerView.Adapter<EventAdapter.ViewHolder> {

    private List<Event> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private Context context;


    // data is passed into the constructor
    public EventAdapter(Context context, List<Event> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.context = context;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recycler_view_item, parent, false);
        return new ViewHolder(view);
    }

    public void atualizalista() {
        notifyDataSetChanged();
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Event event = mData.get(position);
        holder.titulo.setText(event.getTitle());
        holder.dataInicio.setText(event.getStart_date());
        //   holder.dataFinal.setText(event.getEnd_date());
        holder.inscricoesAberta.setText(event.getStart_date_registration());
        //   holder.inscricoesFechada.setText(event.getEnd_date_registration());
        holder.sumario.setText(event.getSummary());
        //    holder.descricao.setText(event.getDescription());
        //     holder.imagem.setText(event.getUrl_image());
        //   holder.creditoHoras.setText(String.valueOf(event.getCredit_hour()));
        //    holder.regiao.setText(event.getCountry());
        //   holder.estado.setText(event.getState());
        //  holder.cidade.setText(event.getCity());
//        holder.venue.setText(event.getVenue());
//        holder.latitude.setText(String.valueOf(event.getLatitude()));
//        holder.longitude.setText(String.valueOf(event.getLongitude()));

        //  Glide.with(holder.itemView.getContext()).load("http://integra.ifgoiano.edu.br/images/banners/inscricoes/bp.png").into(holder.img_banner);

        //   System.out.println("asdasdad"+a);
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                try {
                    String a = new Cronometro().tempoParaoEvento();
                    holder.contador.setText(a);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 0, 1000);

        holder.inscricao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.even3.com.br/integraifgoiano/";
                view.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
            }
        });

    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }

    // convenience method for getting data at click position
    public Event getItem(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView titulo, dataInicio, dataFinal, inscricoesAberta, inscricoesFechada, sumario, descricao,
                imagem, creditoHoras, regiao, estado, cidade, venue, latitude, longitude, banner, contador;
        ImageView img_banner;
        Button inscricao;
        MapView local;

        ViewHolder(View itemView) {
            super(itemView);
            img_banner = itemView.findViewById(R.id.img_banner);
            titulo = itemView.findViewById(R.id.txt_titulo);
            dataInicio = itemView.findViewById(R.id.txt_data_inicio);
            //    dataFinal = itemView.findViewById(R.id.txt_data_final);
            inscricoesAberta = itemView.findViewById(R.id.txt_inscricoes_a);
            //   inscricoesFechada = itemView.findViewById(R.id.txt_inscricoes_f);
            sumario = itemView.findViewById(R.id.txt_sumario);
            //   descricao = itemView.findViewById(R.id.txt_descricao);
            //  imagem = itemView.findViewById(R.id.txt_imagem);
            // creditoHoras = itemView.findViewById(R.id.txt_credito_horas);
            // regiao = itemView.findViewById(R.id.txt_country);
            // estado = itemView.findViewById(R.id.txt_state);
//           // venue = itemView.findViewById(R.id.txt_venue);
            // latitude = itemView.findViewById(R.id.txt_lat);
            // longitude = itemView.findViewById(R.id.txt_long);
            // banner = itemView.findViewById(R.id.txt_banner);
            local = itemView.findViewById(R.id.mapViewLocalizacao);
            contador = itemView.findViewById(R.id.txt_contador);
            inscricao = itemView.findViewById(R.id.btn_inscricao);


            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }
}
