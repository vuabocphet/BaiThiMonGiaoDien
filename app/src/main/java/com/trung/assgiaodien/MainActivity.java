package com.trung.assgiaodien;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Base {
        private EditText mid,mname,mprice;

        private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapped();
        list.clear();
        list=GetData(this);
        click();
    }

    //ánh xạ
    private void mapped(){
        mid=findViewById(R.id.mid);
        mname=findViewById(R.id.name);
        mprice=findViewById(R.id.price);
        btn=findViewById(R.id.btn);
        database=new DB(this);
    }

    private void click(){
        intent=getIntent();
        String data_name="";
                data_name=intent.getStringExtra("name");
        double data_price=0;
               data_price =intent.getDoubleExtra("price",0);
        String data_mid="";
                data_mid=intent.getStringExtra("mid");
         final int data_id;
                data_id=intent.getIntExtra("id",0);

        if (data_name==null && data_price==0 && data_mid==null && data_id==0){

            btn.setText("Thêm");
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    insertSQL();
                }
            });

         }  else  {

            btn.setText("Sửa");
            mid.setText(data_mid);
            mname.setText(data_name);
            mprice.setText(data_price+"");
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String id=mid.getText().toString().trim();
                    String name=mname.getText().toString().trim();
                    String price=mprice.getText().toString().trim();
                    boolean is=true;
                    list.clear();
                    list=GetData(MainActivity.this);
                    if (id.equals("")){
                        return;
                    }

                    if (name.equals("")){
                        return;
                    }

                    if (price.equals("")){
                        return;
                    }

                    if (!list.isEmpty()){
                        for (int i=0;i<list.size();i++){

                            if (id.equals(list.get(i).getMid())){
                                mid.setError(getString(R.string.errID));
                                is=false;
                                break;
                            }

                        }
                    }

                    if (is){
                        database.update(name,Double.valueOf(price),id,data_id);
                        list.clear();
                        list=GetData(MainActivity.this);
                        Toast.makeText(MainActivity.this, "UPDATE thành công", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this,Main2Activity.class));
                        finish();
                    }

                }
            });

        }



    }



    private void insertSQL(){

        String id=mid.getText().toString().trim();
        String name=mname.getText().toString().trim();
        String price=mprice.getText().toString().trim();
        boolean is=true;
        list.clear();
        list=GetData(this);
        if (id.equals("")){
            return;
        }

        if (name.equals("")){
            return;
        }

        if (price.equals("")){
            return;
        }

        if (!list.isEmpty()){
            for (int i=0;i<list.size();i++){

                if (id.equals(list.get(i).getMid())){
                    mid.setError(getString(R.string.errID));
                    is=false;
                    break;
                }

            }
        }

        if (is){
           database.insert(name,Double.valueOf(price),id);
            list.clear();
            list=GetData(this);
            Toast.makeText(this, "INSERT thành công", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this,Main2Activity.class));
            finish();
        }



    }
}
