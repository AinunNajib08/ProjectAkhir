package com.kesehatan.klinikhusada;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.kesehatan.klinikhusada.utils.SharedPrefManager;

import butterknife.BindView;

public class DashboardFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        TextView tvResultNama = view.findViewById(R.id.tvResultNama);

        String namapasien = getArguments().getString("daar");

        tvResultNama.setText(namapasien);

        return view;
    }
}
