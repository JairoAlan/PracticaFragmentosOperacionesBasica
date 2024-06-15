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
 * Use the {@link divicion#newInstance} factory method to
 * create an instance of this fragment.
 */
public class divicion extends Fragment {

    // Rename parameter arguments
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    EditText etNumUnoD, etNumDosD;
    Button btnDiv;
    TextView tvResulD;

    View vista;

    public divicion() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment divicion.
     */
    // Rename and change types and number of parameters
    public static divicion newInstance(String param1, String param2) {
        divicion fragment = new divicion();
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
        vista = inflater.inflate(R.layout.fragment_divicion, container, false);
        etNumUnoD = vista.findViewById(R.id.etNumUnoD);
        etNumDosD = vista.findViewById(R.id.etNumDosD);
        btnDiv = vista.findViewById(R.id.btnDiv);
        tvResulD = vista.findViewById(R.id.tvResulD);

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numUnoStr = etNumUnoD.getText().toString();
                String numDosStr = etNumDosD.getText().toString();

                if (!numUnoStr.isEmpty() && !numDosStr.isEmpty()) {
                    int numUno = Integer.parseInt(numUnoStr);
                    int numDos = Integer.parseInt(numDosStr);

                    if (numDos != 0) {
                        int result = numUno / numDos;
                        tvResulD.setText(String.valueOf(result));
                    } else {
                        tvResulD.setText("El divisor no puede ser 0");
                    }
                } else {
                    tvResulD.setText("Por favor, ingrese ambos números");
                }
            }
        });

        return vista;
    }
}
