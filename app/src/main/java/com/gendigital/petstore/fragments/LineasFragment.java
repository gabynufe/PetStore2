package com.gendigital.petstore.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gendigital.petstore.PetInfo;
import com.gendigital.petstore.R;
import com.gendigital.petstore.adapters.MyAdapter;

import java.util.ArrayList;

/**
 * Created by Gaby on 18/06/2016.
 */
public class LineasFragment extends Fragment {
    private static final String TAG = "RecyclerViewFragment";
    public ArrayList<PetInfo> listaData;

    private RecyclerView.LayoutManager mLayoutManager;

    public LineasFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        cargaLista();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_lista, container, false);
        v.setTag(TAG);

        RecyclerView mRecyclerView = (RecyclerView) v.findViewById(R.id.rvListaPets);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(llm);
        //mRecyclerView.setHasFixedSize(true);
        //mLayoutManager = new LinearLayoutManager(getActivity());
        //mRecyclerView.setLayoutManager(mLayoutManager);
        MyAdapter mAdapter = new MyAdapter(listaData, getActivity());
        mRecyclerView.setAdapter(mAdapter);
        return v;
    }

    public void cargaLista() {
        listaData = new ArrayList<PetInfo>();

        listaData.add(new PetInfo("Perro", R.drawable.perro, 13));
        listaData.add(new PetInfo("Gato", R.drawable.gato, 15));
        listaData.add(new PetInfo("Loro", R.drawable.loro, 1));
        listaData.add(new PetInfo("Tortuga", R.drawable.tortuga, 2));
        listaData.add(new PetInfo("Pez", R.drawable.pez, 18));
        listaData.add(new PetInfo("Serpiente", R.drawable.serpiente));
        listaData.add(new PetInfo("Otro Perro", R.drawable.perro, 2));
        listaData.add(new PetInfo("Otro Gato", R.drawable.gato, 12));
        listaData.add(new PetInfo("Otro Loro", R.drawable.loro));
        listaData.add(new PetInfo("Otra Tortuga", R.drawable.tortuga, 10));
        listaData.add(new PetInfo("Otro Pez", R.drawable.pez, 2));
        listaData.add(new PetInfo("Otra Serpiente", R.drawable.serpiente));

        // para guardar el arreglo en la clase
        for (PetInfo pet : listaData) {
            PetInfo.setItem(pet);
        }
    }

}