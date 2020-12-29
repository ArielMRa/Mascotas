package com.aricode.integrandomaterialdesign;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas,Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    //Inflar el layout y lo pasara al viewholder para el obtenga los views
    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    //asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        mascotaViewHolder.tvraitingCV.setText(""+mascota.getRaiting());

        mascotaViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
               Toast.makeText(activity, "Diste like a " + mascota.getNombre(),Toast.LENGTH_SHORT).show();
               mascota.setRaiting(mascota.getRaiting()+1);
               mascotaViewHolder.tvraitingCV.setText(""+mascota.getRaiting());
            }
        });

    }

    @Override
    public int getItemCount() { //Cantidad de elementos que contiene mi lista de mascotas
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombreCV;
        private ImageButton btnLike;
        private TextView tvraitingCV;
        private ImageView imgRaiting;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto         = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV      = (TextView) itemView.findViewById(R.id.tvNombreCV);
            btnLike         = (ImageButton) itemView.findViewById(R.id.btnLike);
            tvraitingCV   = (TextView) itemView.findViewById(R.id.tvraitingCV);
            imgRaiting        = (ImageView) itemView.findViewById(R.id.imgRaiting);
        }
    }
}
