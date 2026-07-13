package com.example.tehtava_3;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import java.util.List;

public class PeliFragment extends Fragment {

    private ImageView imageViewLippu;
    private RecyclerView rvVaihtoehdot;
    private Button btnSubmit;
    private TextView tvTulos;

    private String valittuMaa = "";
    private final String oikeaVastaus = "Suomi";

    public PeliFragment() {
        super(R.layout.peli_fragment);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imageViewLippu = view.findViewById(R.id.Lippu);
        rvVaihtoehdot = view.findViewById(R.id.rv_vaihtoehdot);
        btnSubmit = view.findViewById(R.id.btn_submit);
        tvTulos = view.findViewById(R.id.tv_tulos);

        imageViewLippu.setImageResource(R.drawable.suomi);

        List<String> maat = Arrays.asList("Suomi", "Ruotsi", "Norja", "Viro", "Tanska");

        ValintaAdapteri adapter = new ValintaAdapteri(maat, maa -> {
            valittuMaa = maa;
            tvTulos.setText("");
        });

        rvVaihtoehdot.setLayoutManager(new LinearLayoutManager(getContext()));
        rvVaihtoehdot.setAdapter(adapter);

        btnSubmit.setOnClickListener(v -> {
            if (valittuMaa.isEmpty()) {
                tvTulos.setTextColor(Color.GRAY);
                tvTulos.setText("Valitse ensin maa listasta!");
                return;
            }

            if (valittuMaa.equals(oikeaVastaus)) {
                tvTulos.setTextColor(Color.parseColor("#4CAF50")); // Vihreä
                tvTulos.setText("Oikein!");
            } else {
                tvTulos.setTextColor(Color.RED); // Punainen
                tvTulos.setText("Väärin, se oli Suomi.");
            }
        });
    }
}