/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.traductor.traductor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kevin
 */
public class Traductor {
    public String traducir(int numero) {
        StringBuilder resultado = new StringBuilder();
        List<Integer> numSep = new ArrayList<>();
        if (numero > 9999) {
            return "Error: número fuera de rango";
        }
        int verificarM = verificarMiles(numero, numSep);
        int verificarC = verificarCentenas(numero, numSep);
        int verificarD = verificarDecimales(numero, numSep);
        for (Integer num : numSep) {
            if (num >= 1 && verificarM == 0) { // Traducir correctamente los numeros terminados en 1 entre 1001-9999
                resultado.append(traducirNum(num));
            } else if (num >= 1 && verificarC == 1) { // Traducir correctamente los numeros terminados en 1 entre 101-999
                resultado.append(traducirNum(num));
            } else if (num >= 1 && verificarD == 2) { // Traducir correctamente los numeros terminados en 1 entre 11-99
                resultado.append(traducirNum(num));
            }
        }
        if (numero <= 10) {
            resultado.append(traducirNum(numero));
        }
        return resultado.toString();
    }

    private static int verificarDecimales(int numero, List<Integer> numSep) {
        int i = 0;
        if (numero > 10 && numero < 100) {
            // No tomar en cuenta si el 1 esta al inicio
            if ((numero / 10) != 1) {
                numSep.add((numero / 10));
            }
            numSep.add(10);
            numSep.add(numero % 10);
            i = 2;
        }
        return i;
    }

    private static int verificarCentenas(int numero, List<Integer> numSep) {
        int i = 0;
        if (numero >= 100 && numero < 1000) {
            // No tomar en cuenta si el 1 esta al inicio
            if ((numero / 100) != 1) {
                numSep.add((numero / 100));
            }
            numSep.add(100);
            // Si hay un cero intermedio no considerarlo como una decena
            if (((numero % 100) / 10) != 0) {
                if (((numero % 100) / 10) == 1) {
                    numSep.add(10);
                } else {
                    numSep.add(((numero % 100) / 10));
                    numSep.add(10);
                }
            }
            // Si hay un cero al final no considerarlo
            if (numero % 10 != 0) {
                numSep.add(numero % 10);
            }
            i = 1;
        }
        return i;
    }

    private static int verificarMiles(int numero, List<Integer> numSep) {
        int i = -1;
        if (numero > 1000 && numero % 1000 != 0) {
            if ((numero / 1000) != 1) {
                numSep.add((numero / 1000));
            }
            numSep.add(1000);
            if (((numero % 1000) / 100) != 0) {
                if (((numero % 1000) / 100) == 1) {
                    numSep.add(100);
                } else {
                    numSep.add(((numero % 1000) / 100));
                    numSep.add(100);
                }
            }
            if (((numero % 100) / 10) != 0) {
                if (((numero % 100) / 10) == 1) {
                    numSep.add(10);
                } else {
                    numSep.add(((numero % 100) / 10));
                    numSep.add(10);
                }
            }
            if (numero % 10 != 0) {
                numSep.add(numero % 10);
            }
            i = 0;
            // Reconocer los numeros terminados en 3 ceros (1000, 4000, ...)
        } else if (numero >= 1000 && numero % 1000 == 0) {
            if ((numero / 1000) != 1) {
                numSep.add((numero / 1000));
                numSep.add(1000);
                i = 0;
            } else {
                numSep.add(1000);
                i = 0;
            }
        }
        return i;
    }

    private String traducirNum(int num) {
        String traduccion;
        switch (num) {
            case 0 -> traduccion = "illak ";
            case 1 -> traduccion = "shuk ";
            case 2 -> traduccion = "ishkay ";
            case 3 -> traduccion = "kimsa ";
            case 4 -> traduccion = "chusku ";
            case 5 -> traduccion = "pichka ";
            case 6 -> traduccion = "sukta ";
            case 7 -> traduccion = "kanchis ";
            case 8 -> traduccion = "pusak ";
            case 9 -> traduccion = "iskun ";
            case 10 -> traduccion = "chunka ";
            case 100 -> traduccion = "patsak ";
            case 1000 -> traduccion = "waranka ";
            default -> // Si el número no coincide con ninguno de los casos anteriores, no se puede traducir
                    traduccion = "Error: número fuera de rango";
        }
        return traduccion;
    }
}
