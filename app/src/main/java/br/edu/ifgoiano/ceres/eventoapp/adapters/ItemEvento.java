package br.edu.ifgoiano.ceres.eventoapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.edu.ifgoiano.ceres.eventoapp.R;
import br.edu.ifgoiano.ceres.eventoapp.model.Item;

public class ItemEvento extends RecyclerView.Adapter<ItemEvento.ViewHolder> {

    private List<Item> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private Context context;


    // data is passed into the constructor
    public ItemEvento(Context context, List<Item> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.context = context;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.itens_evento_adapter, parent, false);
        return new ViewHolder(view);
    }

    public void atualizalista() {
        notifyDataSetChanged();
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Item item = mData.get(position);
        holder.periodo.setText(item.getPeriodo());
        holder.titulo.setText(item.getTitulo());
        holder.tipo.setText(item.getTipo());
        if (item.getLocal() != null) {
            holder.local.setText(item.getLocal());
        } else {
            holder.local.setText("");
            holder.local.setVisibility(View.GONE);
            holder.fixo.setVisibility(View.GONE);
        }

    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }

    // convenience method for getting data at click position
    public Item getItem(int id) {
        return mData.get(id);
    }

    // allows clicks ItemEventos to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click ItemEventos
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView titulo, tipo, local, periodo, fixo;

        ViewHolder(View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.tv_titulo);
            tipo = itemView.findViewById(R.id.tv_tipo);
            local = itemView.findViewById(R.id.tv_local);
            periodo = itemView.findViewById(R.id.tv_periodo);
            fixo = itemView.findViewById(R.id.tv_local_fixo);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }
}
