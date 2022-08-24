package com.example.cuadratica.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.cuadratica.controller.Cuadratica;
import com.example.cuadratica.service.CuadraticaService;

@Service
public class CuadraticaServiceImpl implements CuadraticaService{

    @Override
    public Cuadratica entregarResultado() {
        LocalDateTime locaDate = LocalDateTime.now();
        int hours  = locaDate.getHour(); //15
        int minutes = locaDate.getMinute();//28
        int seconds = locaDate.getSecond();//59
        //System.out.println("Hora actual : " + hours  + ":"+ minutes +":"+seconds); 
        String hora = hours  + ":"+ minutes +":"+seconds;
        int a = hours % 10; // para obtener el residuo de la hora es decir en este caso el 5
        int b = minutes % 10; // para obtener el residuo de la hora es decir en este caso el 5
        int c = seconds % 10; // para obtener el residuo de la hora es decir en este caso el 5
        List<Integer> valoresUsados = new ArrayList<>();
        valoresUsados.add(a);
        valoresUsados.add(b);
        valoresUsados.add(c);
        Integer operacionInternaRaiz = (b*b) - (4 * (a*c));
        Integer resultadoDenominador = 2*a;
        String resultadoNumerador = "No se puede, porque raiz negativa";
        String resultado = "No se puede, porque raiz negativa o numerador igual a cero";
        Double resultadoRaiz;
        Double resultado1;
        Double resultado2;
        
        if (operacionInternaRaiz < 0) {
            String operacion = "La raiz es negativa "; 
            return new Cuadratica(operacion, hora, valoresUsados, String.valueOf(operacionInternaRaiz),resultadoNumerador, String.valueOf(resultadoDenominador), resultado);
        }
        if (resultadoDenominador == 0) {
            String operacion = "Denominador cero "; 
            resultadoRaiz = Math.sqrt(operacionInternaRaiz); // Raiz
            resultado1 = -b + Math.sqrt(operacionInternaRaiz);// Numerador
            return new Cuadratica(operacion, hora, valoresUsados, String.valueOf(resultadoRaiz),String.valueOf(resultado1), String.valueOf(resultadoDenominador), resultado);

        }
        String operacion = "Raiz cuadrática "; 
        resultadoRaiz = Math.sqrt(operacionInternaRaiz); // Raiz
        resultado1 = -b + resultadoRaiz;// Numerador
        resultado2 = resultado1 / resultadoDenominador; // Resultado
        resultado = String.valueOf(resultado2);// Resultado en String
        return new Cuadratica(operacion, hora, valoresUsados, String.valueOf(resultadoRaiz),String.valueOf(resultado1), String.valueOf(resultadoDenominador), resultado);
    }
    
}
