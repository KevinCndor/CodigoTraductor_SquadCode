/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.traductor.traductor;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kevin
 */
public class Traductor {
    public String traducir(int numero) {
        StringBuilder resultado = new StringBuilder();
        List<Integer> numSep = new ArrayList<>();
        int i = 2;
        if(numero > 9999){
            return "Error";
        }
        if(numero > 1000 && numero % 1000 != 0){
            if((numero / 1000) != 1){
                numSep.add((int)(numero / 1000));
            }
            numSep.add(1000);
            if(((numero % 1000) / 100) != 0){
                if(((numero % 1000) / 100) == 1){
                    numSep.add(100);
                }else{
                    numSep.add((int)((numero % 1000) / 100));
                    numSep.add(100);
                }
            }
            if(((numero % 100) / 10) != 0){
                if(((numero % 100) / 10) == 1){
                    numSep.add(10);
                }else{
                    numSep.add((int)((numero % 100) / 10));
                    numSep.add(10);
                }
            }
            if(numero % 10 != 0){
                numSep.add(numero % 10);
            }
            i = 0;
        // Reconocer los numeros terminados en 3 ceros (1000, 4000, ...)
        } else if (numero >= 1000 && numero % 1000 == 0) {
            if((numero / 1000) != 1){
                numSep.add((numero / 1000));
                numSep.add(1000);
                i = 0;
            }else{
                numSep.add(1000);
                i = 0;
            }
        }
        if(numero >= 100 && numero < 1000){ // Poner >= no es la mejor solucion para que reconozca al 100 !!!
            // No tomar en cuenta si el 1 esta al inicio
            if((numero / 100) != 1){
                numSep.add((int)(numero / 100));
            }
            numSep.add(100);
            // Si hay un cero intermedio no considerarlo como una decena
            if(((numero % 100) / 10) != 0){
                if(((numero % 100) / 10) == 1){
                    numSep.add(10);
                }else{
                    numSep.add((int)((numero % 100) / 10));
                    numSep.add(10);
                }
            }
            // Si hay un cero al final no considerarlo
            if(numero % 10 != 0){
                numSep.add(numero % 10);
            }
            i = 1;
        }
        if(numero > 10 && numero < 100){
            // No tomar en cuenta si el 1 esta al inicio
            if((numero / 10) != 1){
                numSep.add((int)(numero / 10));
            }
            numSep.add(10);
            numSep.add(numero % 10);
            i = 2;
        }
        for( Integer num: numSep){
            if(num >= 1 && i == 0){ // Traducir correctamente los numeros terminados en 1 entre 1001-9999
                resultado.append(verificar(num));
            }else if(num >= 1 && i == 1){ // Traducir correctamente los numeros terminados en 1 entre 101-999
                resultado.append(verificar(num));
            }else if(num >= 1 && i == 2){ // Traducir correctamente los numeros terminados en 1 entre 11-99
                resultado.append(verificar(num));
            }
        }
        if(numero <= 10){
            resultado.append(verificar(numero));
        }
        return resultado.toString();
    }
    
    private String verificar(int num){
        String k;
        switch (num) {
                case 0 -> k = "illak ";
                case 1 -> k = "shuk ";
                case 2 -> k = "ishkay ";
                case 3 -> k = "kimsa ";
                case 4 -> k = "chusku ";
                case 5 -> k = "pichka ";
                case 6 -> k = "sukta ";
                case 7 -> k = "kanchis ";
                case 8 -> k = "pusak ";
                case 9 -> k = "iskun ";
                case 10 -> k = "chunka ";
                case 100 -> k = "patsak ";
                case 1000 -> k = "waranka ";
                default -> // Si el número no coincide con ninguno de los casos anteriores, no se puede traducir
                    k = "Número no traducible";
            }
        return k;
    }
}
