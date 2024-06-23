package com.example.recycleview;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context context;
    private ArrayList name_id,email_id,fname_id,mname_id,mobile_id;

    public MyAdapter(Context context, ArrayList name_id, ArrayList email_id, ArrayList fname_id, ArrayList mname_id, ArrayList mobile_id) {
        this.context = context;
        this.name_id = name_id;
        this.email_id = email_id;
        this.fname_id = fname_id;
        this.mname_id = mname_id;
        this.mobile_id = mobile_id;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View v = LayoutInflater.from(context).inflate(R.layout.userentry,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        holder.name_id.setText(String.valueOf(name_id.get(position)));
        holder.fname_id.setText(String.valueOf(fname_id.get(position)));
        holder.mname_id.setText(String.valueOf(mname_id.get(position)));
        holder.email_id.setText(String.valueOf(email_id.get(position)));
        holder.mobile_id.setText(String.valueOf(mobile_id.get(position)));

    }

    @Override
    public int getItemCount() {
        return name_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name_id,fname_id,mname_id,mobile_id,email_id;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name_id=itemView.findViewById(R.id.textname);
            fname_id=itemView.findViewById(R.id.textfname);
            mname_id=itemView.findViewById(R.id.textmname);
            mobile_id=itemView.findViewById(R.id.textph);
            email_id=itemView.findViewById(R.id.textemail);

        }
    }
}
