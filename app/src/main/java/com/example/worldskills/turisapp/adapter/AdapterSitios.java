package com.example.worldskills.turisapp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.worldskills.turisapp.R;
import com.example.worldskills.turisapp.entidades.LugaresVo;
import com.example.worldskills.turisapp.entidades.MapasGenerales;

import java.util.ArrayList;

public class AdapterSitios extends RecyclerView.Adapter<AdapterSitios.AdapterViewHolder> implements View.OnClickListener {


    ArrayList<LugaresVo> lugaresVos;
    View.OnClickListener listener;

    public AdapterSitios(ArrayList<LugaresVo> lugaresVos) {
        this.lugaresVos = lugaresVos;
    }

    @NonNull
    @Override
    public AdapterSitios.AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.modelo_sitios,null,false);
        view.setOnClickListener(this);
        return new AdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterSitios.AdapterViewHolder holder, int position) {
        holder.nombre.setText(lugaresVos.get(position).getNombre());
        holder.descripcion.setText("Descripcion :"+ lugaresVos.get(position).getDescripcioncorta());
        holder.ubicacion.setText("Ubicacion :"+lugaresVos.get(position).getUbicacion());
        holder.img.setImageDrawable(MapasGenerales.lista.get(position+1));
    }

    @Override
    public int getItemCount() {
        return lugaresVos.size();
    }

    @Override
    public void onClick(View v) {
        if (listener!=null){
            listener.onClick(v);
        }
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener=listener;
    }

    public class AdapterViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView nombre,descripcion,ubicacion;
        public AdapterViewHolder(View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.imagenModelo);
            nombre=itemView.findViewById(R.id.nombreModelo);
            descripcion=itemView.findViewById(R.id.descripcionModelo);
            ubicacion=itemView.findViewById(R.id.ubicacionModelo);
        }
    }
}
