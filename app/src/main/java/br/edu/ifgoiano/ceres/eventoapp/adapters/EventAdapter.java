package br.edu.ifgoiano.ceres.eventoapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import br.edu.ifgoiano.ceres.eventoapp.R;
import br.edu.ifgoiano.ceres.eventoapp.model.Event;

public class EventAdapter
        extends RecyclerView.Adapter<EventAdapter.ViewHolder> {

    private List<Event> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    public EventAdapter(Context context, List<Event> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
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
    public void onBindViewHolder(ViewHolder holder, int position) {
        Event event = mData.get(position);
        holder.titulo.setText(event.getTitle());
        holder.dataInicio.setText(event.getStart_date());
        holder.dataFinal.setText(event.getEnd_date());
        holder.inscricoesAberta.setText(event.getStart_date_registration());
        holder.inscricoesFechada.setText(event.getEnd_date_registration());
        holder.sumario.setText(event.getSummary());
        holder.descricao.setText(event.getDescription());
        holder.imagem.setText(event.getUrl_image());
        holder.creditoHoras.setText(String.valueOf(event.getCredit_hour()));
        holder.regiao.setText(event.getCountry());
        holder.estado.setText(event.getState());
        holder.cidade.setText(event.getCity());
        holder.venue.setText(event.getVenue());
        holder.latitude.setText(String.valueOf(event.getLatitude()));
        holder.longitude.setText(String.valueOf(event.getLongitude()));

        Glide.with(holder.itemView.getContext()).load(event.getUrl_image()).into(holder.img_banner);
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
                imagem, creditoHoras, regiao, estado, cidade, venue, latitude, longitude, banner;
        ImageView img_banner;

        ViewHolder(View itemView) {
            super(itemView);
            img_banner = itemView.findViewById(R.id.img_banner);
            titulo = itemView.findViewById(R.id.txt_titulo);
            dataInicio = itemView.findViewById(R.id.txt_data_inicio);
            dataFinal = itemView.findViewById(R.id.txt_data_final);
            inscricoesAberta = itemView.findViewById(R.id.txt_inscricoes_a);
            inscricoesFechada = itemView.findViewById(R.id.txt_inscricoes_f);
            sumario = itemView.findViewById(R.id.txt_sumario);
            descricao = itemView.findViewById(R.id.txt_descricao);
            imagem = itemView.findViewById(R.id.txt_imagem);
            creditoHoras = itemView.findViewById(R.id.txt_credito_horas);
            regiao = itemView.findViewById(R.id.txt_country);
            estado = itemView.findViewById(R.id.txt_state);
            cidade = itemView.findViewById(R.id.txt_city);
            venue = itemView.findViewById(R.id.txt_venue);
            latitude = itemView.findViewById(R.id.txt_lat);
            longitude = itemView.findViewById(R.id.txt_long);
            banner = itemView.findViewById(R.id.txt_banner);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }
}
