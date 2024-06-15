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
 * Use the {@link suma#newInstance} factory method to
 * create an instance of this fragment.
 */
public class suma extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    View vista;

    EditText etNumUnoS,etNumDosS;
    Button btnSuma;

    TextView tvResulS;

    public suma() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment suma.
     */
    // TODO: Rename and change types and number of parameters
    public static suma newInstance(String param1, String param2) {
        suma fragment = new suma();
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
        vista = inflater.inflate(R.layout.fragment_suma, container, false);

        etNumUnoS = vista.findViewById(R.id.etNumUnoS);
        etNumDosS = vista.findViewById(R.id.etNumDosS);
        btnSuma = vista.findViewById(R.id.btnSuma);
        tvResulS = vista.findViewById(R.id.tvResulS);

        btnSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numUnoStr = etNumUnoS.getText().toString();
                String numDosStr = etNumDosS.getText().toString();


                if (!numUnoStr.isEmpty() && !numDosStr.isEmpty()) {

                    int numUno = Integer.parseInt(numUnoStr);
                    int numDos = Integer.parseInt(numDosStr);


                    int result = numUno + numDos;


                    tvResulS.setText(String.valueOf(result));
                } else {

                    tvResulS.setText("Por favor, ingrese ambos números");
                }
            }
        });

        return vista;
    }
}