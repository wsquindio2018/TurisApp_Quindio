package com.example.worldskills.turisapp.fragments;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.worldskills.turisapp.R;
import com.example.worldskills.turisapp.adapter.AdapterSitios;
import com.example.worldskills.turisapp.entidades.LugaresVo;
import com.example.worldskills.turisapp.entidades.MapasGenerales;
import com.example.worldskills.turisapp.entidades.Puente;
import com.example.worldskills.turisapp.utilidades.Conexion;
import com.example.worldskills.turisapp.utilidades.Utilidades;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HotelesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HotelesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HotelesFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public HotelesFragment() {
        // Required empty public constructor
    }

    Puente miPuente;
    Activity activity;
    LugaresVo lugaresVo;
    ArrayList<LugaresVo> listaLugares;
    View view;
    RecyclerView recyclerView;
    Conexion conn;
    SQLiteDatabase bd;
    FloatingActionButton actionButton;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HotelesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HotelesFragment newInstance(String param1, String param2) {
        HotelesFragment fragment = new HotelesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_hoteles, container, false);
        conn = new Conexion(getContext(), "LUGARES", null, 1);
        recyclerView = view.findViewById(R.id.recyclerHoteles);
        actionButton = view.findViewById(R.id.mapaGeneral);

        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MapasGenerales.id = 2;
                MapasGenerales.zoom=11;
                miPuente.cambio();
            }
        });
        MapasGenerales.lista.clear();
        HashMap<Integer ,Drawable> list=new HashMap<>();

        list.put(1, getResources().getDrawable(R.drawable.hotelcontinentals));
        list.put(2, getResources().getDrawable(R.drawable.hoteltequendama));
        list.put(3, getResources().getDrawable(R.drawable.hotelmarriot));
        list.put(4, getResources().getDrawable(R.drawable.hotelhilton));
        list.put(5, getResources().getDrawable(R.drawable.hotelnh));

        MapasGenerales.lista=list;
        consultar();



        return view;
    }


    private void consultar() {
        listaLugares = new ArrayList<>();
        bd = conn.getReadableDatabase();

        Cursor cursor = bd.rawQuery("SELECT * FROM " + Utilidades.NOMBRE_TABLA + " WHERE " + Utilidades.TIPO + " =2 ", null);

        while (cursor.moveToNext()) {
            lugaresVo = new LugaresVo();
            lugaresVo.setNombre(cursor.getString(0));
            lugaresVo.setDescripcioncorta(cursor.getString(1));
            lugaresVo.setDescripcion(cursor.getString(2));
            lugaresVo.setUbicacion(cursor.getString(3));
            lugaresVo.setLatitud(cursor.getString(4));
            lugaresVo.setLongitud(cursor.getString(5));
            listaLugares.add(lugaresVo);
        }

        AdapterSitios adapterSitios = new AdapterSitios(listaLugares);

        recyclerView.setAdapter(adapterSitios);

        adapterSitios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MapasGenerales.nombre=listaLugares.get(recyclerView.getChildAdapterPosition(v)).getNombre();
                MapasGenerales.Descripcion=listaLugares.get(recyclerView.getChildAdapterPosition(v)).getDescripcion();
                miPuente.detalle();
            }
        });
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof Activity) {
            this.activity = (Activity) context;
            this.miPuente = (Puente) activity;
        }
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
