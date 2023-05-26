package com.example.sportinformation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private Context context;
    private List<EPLTeamModel> contactList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvname, tvphone, tvgenre;
        public ImageView imgimage;

        public MyViewHolder(View view) {
            super(view);

            tvname = view.findViewById(R.id.tvname);
            tvphone = view.findViewById(R.id.tvdate);
            tvgenre = view.findViewById(R.id.tvgenre);
            imgimage = view.findViewById(R.id.imgImage);
        }
    }

    public Adapter(Context context, List<EPLTeamModel> contactList, MainActivity recycle) {
        this.context = context;
        this.contactList = contactList;
    }

    @NonNull
    @Override
    public Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.MyViewHolder holder, int position) {
        final EPLTeamModel contact = this.contactList.get(position);
        holder.tvname.setText(contact.getTeamname());
        holder.tvphone.setText(contact.getDate());
        holder.tvgenre.setText(contact.getStadiun());
        Glide.with(holder.itemView.getContext()).load(contact.getStrTeamBadge()).into(holder.imgimage);
    }

    @Override
    public int getItemCount() {
        return this.contactList.size();
    }



}