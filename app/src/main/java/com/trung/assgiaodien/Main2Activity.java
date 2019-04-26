package com.trung.assgiaodien;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class Main2Activity extends Base {
         private RecyclerView recyclerView;
         private LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
         private Apdapter apdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        list.clear();
        list=GetData(this);
        database=new DB(this);
        recyclerView=findViewById(R.id.recyclerview);
        apdapter=new Apdapter(list,this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(apdapter);
    }

    public void delete(int id,int i){
        database.delete(id);
        list.remove(i);
        apdapter.notifyDataSetChanged();

    }

    public void intentData(Model model){
        Intent intent=new Intent(this,MainActivity.class);
        intent.putExtra("name",model.getName());
        intent.putExtra("price",model.getPrice());
        intent.putExtra("id",model.getId());
        intent.putExtra("mid",model.getMid());
        startActivity(intent);
    }
}
