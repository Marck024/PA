package com.example.root.pa;

import android.util.Log;
import android.widget.Toast;

/**
 * Created by root on 16/04/17.
 */

public class BBinaria {
    public BBinaria(){
    }

    public int[] binIteractiva(int[] valores,int buscar){
        int izq=0,der=valores.length-1;
        int contar=0;

        while (izq<=der) {
            contar++;
            int posi=(izq+der)/2;
            Log.e("binario Iteractivo","izq: "+izq+" der: "+der+" posi: "+posi);
            if(valores[posi]==buscar){
                return new int[]{posi, contar};
            }else if(valores[posi]<buscar){
                izq=posi+1;
            }else{
                der=posi-1;
            }
        }
        return new int[]{-1,contar};
    }

    public int[] binRecursiva(int[] valores,int buscar,int izq,int der,int contar) {
        int posi = (izq + der) / 2;
        contar++;
        Log.e("binario Recusivo","izq: "+izq+" der: "+der+" posi: "+posi);
        if(izq>der){
            return new int[]{-1,contar};
        }else if(valores[posi]==buscar){
            return new int[]{posi,contar};
        }else if(valores[posi]<buscar){
            return binRecursiva(valores,buscar,posi+1,der,contar);
        }else{
            return binRecursiva(valores,buscar,izq,posi-1,contar);
        }
    }
}
