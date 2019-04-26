package com.trung.assgiaodien;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Apdapter extends RecyclerView.Adapter<Apdapter.Hoder> {

    private ArrayList<Model> list;
    private Main2Activity context;

    public Apdapter(ArrayList<Model> list, Main2Activity context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Hoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.itemview,parent,false);
        return new Hoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Hoder holder, final int position) {
        final Model model=list.get(position);
        holder.id.setText("ID SẢN PHẨM:"+model.getMid());
        holder.name.setText("TÊN SẢN PHẨM:"+model.getName());
        holder.price.setText("GIÁ SẢN PHẨM:"+model.getPrice()+"");
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.delete(model.getId(),position);
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.intentData(model);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class Hoder extends RecyclerView.ViewHolder {
        public TextView id,name,price;
        public ImageView delete;
        public Hoder(View itemView) {
            super(itemView);
            id=itemView.findViewById(R.id.mid);
            name=itemView.findViewById(R.id.name);
            price=itemView.findViewById(R.id.price);
            delete=itemView.findViewById(R.id.delete);
        }
    }
}
