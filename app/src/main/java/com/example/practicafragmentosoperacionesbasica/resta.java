package com.example.practicafragmentosoperacionesbasica;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link resta#newInstance} factory method to
 * create an instance of this fragment.
 */
public class resta extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private EditText etNumUnoR, etNumDosR;
    private Button btnResta;
    private TextView tvResulR;

    private View vista;

    public resta() {
        // Required empty public constructor
    }

    public static resta newInstance(String param1, String param2) {
        resta fragment = new resta();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_resta, container, false);

        etNumUnoR = vista.findViewById(R.id.etNumUnoR);
        etNumDosR = vista.findViewById(R.id.etNumDosR);
        btnResta = vista.findViewById(R.id.btnResta);
        tvResulR = vista.findViewById(R.id.tvResulR);

        btnResta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numUnoStr = etNumUnoR.getText().toString();
                String numDosStr = etNumDosR.getText().toString();

                if (!numUnoStr.isEmpty() && !numDosStr.isEmpty()) {
                    int numUno = Integer.parseInt(numUnoStr);
                    int numDos = Integer.parseInt(numDosStr);

                    int result = numUno - numDos;

                    tvResulR.setText(String.valueOf(result));
                } else {
                    tvResulR.setText("Por favor, ingrese ambos números");
                }
            }
        });

        return vista;
    }
}
