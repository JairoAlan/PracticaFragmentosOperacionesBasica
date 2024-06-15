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
 * Use the {@link multiplicacion#newInstance} factory method to
 * create an instance of this fragment.
 */
public class multiplicacion extends Fragment {

    // Rename parameter arguments
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    EditText etNumUnoM, etNumDosM;
    Button btnMultiplicar;
    TextView tvResulM;

    View vista;

    public multiplicacion() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment multiplicacion.
     */
    public static multiplicacion newInstance(String param1, String param2) {
        multiplicacion fragment = new multiplicacion();
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
        vista = inflater.inflate(R.layout.fragment_multiplicacion, container, false);

        etNumUnoM = vista.findViewById(R.id.etNumUnoM);
        etNumDosM = vista.findViewById(R.id.etNumDosM);
        btnMultiplicar = vista.findViewById(R.id.btnMultiplicar);
        tvResulM = vista.findViewById(R.id.tvResulM);

        btnMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numUnoStr = etNumUnoM.getText().toString();
                String numDosStr = etNumDosM.getText().toString();

                if (!numUnoStr.isEmpty() && !numDosStr.isEmpty()) {
                    int numUno = Integer.parseInt(numUnoStr);
                    int numDos = Integer.parseInt(numDosStr);

                    int result = numUno * numDos;

                    tvResulM.setText(String.valueOf(result));
                } else {
                    tvResulM.setText("Por favor, ingrese ambos números");
                }
            }
        });

        return vista;
    }
}
