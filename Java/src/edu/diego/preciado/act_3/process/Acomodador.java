package edu.diego.preciado.act_3.process;

import java.util.*;

public class Acomodador {

    public static Empleados mayorSalario(List<Empleados> lista) {
        Empleados max = null;

        for (Empleados e : lista) {
            if (max == null || e.getSalario() > max.getSalario()) {
                max = e;
            }
        }
        return max;
    }

    public static double promedioEdad(List<Empleados> lista) {
        double suma = 0;

        for (Empleados e : lista) {
            suma += e.getEdad();
        }

        return lista.isEmpty() ? 0 : suma / lista.size();
    }

    public static int edadMasComun(List<Empleados> lista) {
        Map<Integer, Integer> conteo = new HashMap<>();

        for (Empleados e : lista) {
            conteo.put(e.getEdad(),
                    conteo.getOrDefault(e.getEdad(), 0) + 1);
        }

        int edad = 0, max = 0;

        for (var entry : conteo.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                edad = entry.getKey();
            }
        }
        return edad;
    }
}
