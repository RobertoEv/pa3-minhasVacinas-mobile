package com.betoe.minhasvacinas.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.betoe.minhasvacinas.R;
import com.betoe.minhasvacinas.model.Pet;

import org.w3c.dom.Text;

import java.util.List;

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.PetViewHolder> {

    private List<Pet> pets;
    private int rowLayout;
    private Context context;

    public PetAdapter(List<Pet> pets, int rowLayout, Context context) {
        this.pets = pets;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public PetAdapter.PetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(rowLayout, parent, false);
        return new PetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PetAdapter.PetViewHolder holder, int position) {
        holder.petName.setText(pets.get(position).getPetname());
        holder.petEspecie.setText(pets.get(position).getEspecie());
        holder.petRaca.setText(pets.get(position).getRaca());

    }

    @Override
    public int getItemCount() { return pets.size(); }

    public static class PetViewHolder extends RecyclerView.ViewHolder {
        CardView petCard;
        TextView petName;
        TextView petEspecie;
        TextView petRaca;

        public PetViewHolder(View v) {
            super(v);
            petCard = (CardView) v.findViewById(R.id.petItemCard);
            petName = (TextView) v.findViewById(R.id.petItemNameText);
            petEspecie = (TextView) v.findViewById(R.id.petItemEspecie);
            petRaca = (TextView) v.findViewById(R.id.petItemRaca);
        }
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public int getRowLayout() {
        return rowLayout;
    }

    public void setRowLayout(int rowLayout) {
        this.rowLayout = rowLayout;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
