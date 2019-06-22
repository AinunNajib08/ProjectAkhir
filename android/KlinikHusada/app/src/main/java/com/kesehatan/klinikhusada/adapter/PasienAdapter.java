package com.kesehatan.klinikhusada.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kesehatan.klinikhusada.EditActivity;
import com.kesehatan.klinikhusada.Model.Pasien;
import com.kesehatan.klinikhusada.R;

import java.util.List;


public class PasienAdapter extends RecyclerView.Adapter<PasienAdapter.MyViewHolder>{
    List<Pasien> mPasienList;

    public PasienAdapter(List <Pasien> PasienList) {
        mPasienList = PasienList;
    }

    @Override
    public MyViewHolder onCreateViewHolder (ViewGroup parent,int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_pasien, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder (MyViewHolder holder,final int position){
        holder.mTextViewNo_rm.setText("No_rm = " + mPasienList.get(position).getNo_rm());
        holder.mTextViewNama_pasien.setText("Nama_pasien = " + mPasienList.get(position).getNama_pasien());
        holder.mTextViewUsia.setText("Usia = " + mPasienList.get(position).getUsia());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), EditActivity.class);
                mIntent.putExtra("No_rm", mPasienList.get(position).getNo_rm());
                mIntent.putExtra("Nama_pasien", mPasienList.get(position).getNama_pasien());
                mIntent.putExtra("Usia", mPasienList.get(position).getUsia());
                view.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount () {
        return mPasienList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewNo_rm, mTextViewNama_pasien, mTextViewUsia;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewNo_rm = (TextView) itemView.findViewById(R.id.no_rm);
            mTextViewNama_pasien = (TextView) itemView.findViewById(R.id.namapasien);
            mTextViewUsia = (TextView) itemView.findViewById(R.id.tvNomor);
        }
    }
}
