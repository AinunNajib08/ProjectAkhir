package com.kesehatan.klinikhusada;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kesehatan.klinikhusada.Model.Pasien;
import java.util.List;


public class PasienAdapter extends RecyclerView.Adapter<PasienAdapter.MyViewHolder>{
    List<Pasien> mPasienList;

    public PasienAdapter(List <Pasien> KontakList) {
        mPasienList = KontakList;
    }

    @Override
    public MyViewHolder onCreateViewHolder (ViewGroup parent,int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_pasien, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder (MyViewHolder holder,final int position){
        holder.mTextViewId.setText("Id = " + mPasienList.get(position).getNo_rm());
        holder.mTextViewNama.setText("Nama = " + mPasienList.get(position).getNama_pasien());
        holder.mTextViewNomor.setText("Nomor = " + mPasienList.get(position).getUsia());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), EditActivity.class);
                mIntent.putExtra("Id", mPasienList.get(position).getNo_rm());
                mIntent.putExtra("Nama", mPasienList.get(position).getNama_pasien());
                mIntent.putExtra("Nomor", mPasienList.get(position).getUsia());
                view.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount () {
        return mPasienList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewId, mTextViewNama, mTextViewNomor;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewId = (TextView) itemView.findViewById(R.id.no_rm);
            mTextViewNama = (TextView) itemView.findViewById(R.id.namapasien);
            mTextViewNomor = (TextView) itemView.findViewById(R.id.tvNomor);
        }
    }
}
