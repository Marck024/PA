package com.example.root.pa;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragBBinario extends Fragment {


    public FragBBinario() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_bbinaria, container, false);

        Button btnIte=(Button)v.findViewById(R.id.btnBinIte);
        Button btnRec=(Button)v.findViewById(R.id.btnBinRec);
        final EditText txtValores=(EditText) v.findViewById(R.id.txtValores);
        final EditText txtBuscar=(EditText) v.findViewById(R.id.txtBuscar);
        final TextView resTxt=(TextView) v.findViewById(R.id.resTxtBin);

        final BBinaria busqueda=new BBinaria();

        btnIte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nBuscar=txtBuscar.getText().toString();
                if(!nBuscar.equals("")){
                    int buscar=Integer.parseInt(nBuscar);
                    String nValores=txtValores.getText().toString();
                    if(!nValores.equals("")){
                        int[] var = preparValores(txtValores.getText().toString());
                        int[] res=busqueda.binIteractiva(var,buscar);
                        if(res[0]==-1){
                            resTxt.setText("No se encontro Valor, Ciclos:"+res[1]);
                        }else{
                            resTxt.setText("El valor se encontro en la posicion: "+(res[0]+1)+" Ciclos: "+res[1]);
                        }
                    }else{
                        Toast.makeText(getActivity().getBaseContext(),"Ingrese Valores",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getActivity().getBaseContext(),"Ingrese Valor para buscar",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnRec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nBuscar=txtBuscar.getText().toString();
                if(!nBuscar.equals("")){
                    int buscar=Integer.parseInt(nBuscar);
                    String nValores=txtValores.getText().toString();
                    if(!nValores.equals("")){
                        int[] var = preparValores(txtValores.getText().toString());
                        int[] res=busqueda.binRecursiva(var,buscar,0,var.length-1,0);
                        if(res[0]==-1){
                            resTxt.setText("No se encontro Valor, Ciclos:"+res[1]);
                        }else{
                            resTxt.setText("El valor se encontro en la posicion: "+(res[0]+1)+" Ciclos: "+res[1]);
                        }
                    }else{
                        Toast.makeText(getActivity().getBaseContext(),"Ingrese Valores",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getActivity().getBaseContext(),"Ingrese Valor para buscar",Toast.LENGTH_SHORT).show();
                }
            }
        });

        return v;
    }

    private int[] preparValores(String valores) {
        String[] tmp;
        tmp=valores.split(",");
        int[] tmp2=new int[tmp.length];
        int x=0;

        for (int i=0;i<tmp.length;i++){
            if(!tmp[i].equals("")){
                tmp2[x++]=Integer.parseInt(tmp[i]);
            }
        }
        return tmp2;
    }


}
