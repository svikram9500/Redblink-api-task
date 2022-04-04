package com.message.redblinkapitask.Adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.message.redblinkapitask.Model.Data;
import com.message.redblinkapitask.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ApiAdapter extends RecyclerView.Adapter<ApiAdapter.ApiViewHolder> {

    List<Data.Datum> dataList;
    Context context;

    public ApiAdapter(List<Data.Datum> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @Override
    public ApiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_layout,parent,false);
        return new ApiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ApiViewHolder holder, int position) {
        Data.Datum data = dataList.get(position);
            holder.id.setText(data.getId());
            holder.email.setText(data.getEmail());
            holder.first_name.setText(data.getFirstName());
            holder.last_name.setText(data.getLastName());
          //  holder.avatar.setImageResource(data.getAvatar());
        Picasso.with(context.getApplicationContext())
                .load(data.getAvatar())
                .placeholder(R.drawable.ic_launcher_background)
                .fit()
                .into(holder.avatar);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ApiViewHolder extends RecyclerView.ViewHolder {
        TextView id,email,first_name,last_name;
        ImageView avatar;
        public ApiViewHolder(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.userid);
            email = itemView.findViewById(R.id.email);
            first_name = itemView.findViewById(R.id.first_name);
            last_name = itemView.findViewById(R.id.last_name);
            avatar = itemView.findViewById(R.id.avatar);
        }
    }
}
