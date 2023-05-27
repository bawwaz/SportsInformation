package com.example.sportinformation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private Context context;

    private ContactsAdapterListener listener;

    private List<EPLTeamModel> contactList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvname, tvphone, tvgenre;
        public ImageView imgimage;

        public MyViewHolder(@NonNull View view) {
            super(view);

            tvname = view.findViewById(R.id.tvname);
            tvphone = view.findViewById(R.id.tvdate);
            tvgenre = view.findViewById(R.id.tvgenre);
            imgimage = view.findViewById(R.id.imgImage);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onContactSelected(contactList.get(getAdapterPosition()));
                }
            });

            view.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    PopupMenu popupMenu = new PopupMenu(v.getContext(), v);
                    popupMenu.inflate(R.menu.delete_menu);

                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            switch (item.getItemId()) {
                                case R.id.menu_delete:
                                    deleteItem(getAdapterPosition());
                                    return true;
                                default:
                                    return false;
                            }
                        }
                    });
                    popupMenu.show();
                    return false;
                }

            });
        }
    }


    public Adapter(Context context, List<EPLTeamModel> contactList, ContactsAdapterListener listener) {
        this.context = context;
        this.contactList = contactList;
        this.listener = listener;
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

    private void deleteItem(int position){
        contactList.remove(position);
        notifyItemRemoved(position);
    }

    public interface ContactsAdapterListener{
        void onContactSelected (EPLTeamModel contact);
    }
}