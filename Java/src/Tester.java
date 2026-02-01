package edu.diego.preciado.act_3.process;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ListsTest {

    @Test
    @DisplayName("Mover ceros a la derecha - caso mixto")
    void moverCerosDerecha_casoNormal() {
        List<Integer> input = new ArrayList<>(List.of(0, 2, 1, 4, 0, 2));
        List<Integer> esperado = List.of(2, 1, 4, 2, 0, 0);

        Lists.moverCerosDerecha(input); // método esperado en Lists
        assertEquals(esperado, input);
    }

    @Test
    @DisplayName("Contar pares - ejemplo dado")
    void contarPares_ejemplo() {
        List<Integer> input = List.of(3, 4, 5, 7, 6);
        int resultado = Lists.contarPares(input); // método esperado en Lists
        assertEquals(2, resultado);
    }

    @Test
    @DisplayName("Mover ceros a la derecha - lista sin ceros")
    void moverCerosDerecha_sinCeros() {
        List<Integer> input = new ArrayList<>(List.of(1,2,3));
        List<Integer> esperado = List.of(1,2,3);

        Lists.moverCerosDerecha(input);
        assertEquals(esperado, input);
    }
}

class StringUtilsTest {

    @Test
    @DisplayName("Palíndromo: cadena no palíndroma")
    void isPalindrome_false() {
        assertFalse(StringUtils.esPalindromo("hola mundo"));
    }

    @Test
    @DisplayName("Palíndromo: cadena palíndroma simple")
    void isPalindrome_true() {
        assertTrue(StringUtils.esPalindromo("ana"));
    }

    @Test
    @DisplayName("Contar vocales - ejemplo")
    void contarVocales_ejemplo() {
        assertEquals(2, StringUtils.contarVocales("hola"));
    }

    @Test
    @DisplayName("Invertir cadena sin usar reverse")
    void invertirCadena_ejemplo() {
        assertEquals("aloh", StringUtils.invertir("hola"));
    }

    @Test
    @DisplayName("Primera aparición de caracter - encontrado")
    void firstIndex_found() {
        boolean idx = StringUtils.esPalindromo("hola"); // método sin usar indexOf
        assertEquals(1, idx);
    }

    @Test
    @DisplayName("Primera aparición de caracter - no encontrado")
    void firstIndex_notFound() {
        boolean idx = StringUtils.esPalindromo("hola");
        assertEquals(-1, idx);
    }
}

class EmpleadosUtilsTest {

    private Empleados e(String n, double s, int edad, String dept) {
        return new Empleados(n, (int) s, edad, dept);
    }

    @Test
    @DisplayName("Mayor salario - devuelve empleado con mayor salario")
    void mayorSalario_basico() {
        List<Empleados> lista = List.of(
                e("A", 10000, 25, "ventas"),
                e("B", 30000, 40, "sistemas"),
                e("C", 25000, 30, "rrhh")
        );

        Empleados mayor = Acomodador.mayorSalario(lista); // o EmpleadosUtils.mayorSalario según tu diseño
        assertNotNull(mayor);
        assertEquals("B", mayor.getNombre());
    }

    @Test
    @DisplayName("Edad más común")
    void edadMasComun_test() {
        List<Empleados> lista = List.of(
                e("A", 10000, 25, "sistemas"),
                e("B", 12000, 30, "sistemas"),
                e("C", 11000, 25, "rrhh")
        );

        int edadComun = Acomodador.edadMasComun(lista);
        assertEquals(25, edadComun);
    }

    @Test
    @DisplayName("Promedio de edad")
    void promedioEdad_test() {
        List<Empleados> lista = List.of(
                e("A", 10000, 20, "sistemas"),
                e("B", 12000, 30, "sistemas"),
                e("C", 11000, 40, "rrhh")
        );

        double promedio = Acomodador.promedioEdad(lista);
        assertEquals((20 + 30 + 40) / 3.0, promedio, 0.0001);
    }

    @Test
    @DisplayName("Promedio de salario")
    void promedioSalario_test() {
        List<Empleados> lista = List.of(
                e("A", 10000, 20, "sistemas"),
                e("B", 20000, 30, "sistemas")
        );

        double promedio = EmpleadosUtils.promedioSalario(lista);
        assertEquals((10000 + 20000) / 2.0, promedio, 0.0001);
    }

    @Test
    @DisplayName("Promedio edad de empleados que ganan más de 25K")
    void promedioEdad_mayor25k() {
        List<Empleados> lista = List.of(
                e("A", 24000, 24, "sistemas"),
                e("B", 26000, 35, "sistemas"),
                e("C", 30000, 45, "rrhh")
        );

        double promedio = EmpleadosUtils.promedioEdadSalarioMayor25k(lista); // método esperado
        assertEquals((35 + 45) / 2.0, promedio, 0.0001);
    }

    @Test
    @DisplayName("Filtrar menores de 25 años")
    void filtrarMenores25() {
        List<Empleados> lista = List.of(
                e("A", 10000, 22, "sistemas"),
                e("B", 20000, 26, "sistemas"),
                e("C", 15000, 24, "rrhh")
        );

        List<Empleados> menores = EmpleadosUtils.filtrarMenores25(lista);
        assertEquals(2, menores.size());
        assertTrue(menores.stream().anyMatch(x -> x.getNombre().equals("A")));
        assertTrue(menores.stream().anyMatch(x -> x.getNombre().equals("C")));
    }

    @Test
    @DisplayName("Contar empleados del departamento sistemas")
    void contarDepartamentoSistemas() {
        List<Empleados> lista = List.of(
                e("A", 10000, 22, "sistemas"),
                e("B", 20000, 26, "sistemas"),
                e("C", 15000, 24, "rrhh")
        );

        long count = EmpleadosUtils.contarDepartamentoSistemas(lista);
        assertEquals(2, count);
    }

    @Test
    @DisplayName("Mayor salario con edad > 30")
    void mayorSalario_mayor30() {
        List<Empleados> lista = List.of(
                e("A", 40000, 31, "sistemas"),
                e("B", 50000, 29, "sistemas"),
                e("C", 45000, 35, "rrhh")
        );

        Empleados mayor = EmpleadosUtils.mayorSalarioMayor30(lista);
        assertNotNull(mayor);
        assertEquals("C", mayor.getNombre()); // 45000 vs 40000 -> C es mayor
    }

    @Test
    @DisplayName("Menor salario cuya edad es la menos común")
    void menorSalario_edadMenosComun() {
        List<Empleados> lista = List.of(
                e("A", 10000, 20, "sistemas"),
                e("B", 9000, 30, "sistemas"),
                e("C", 8000, 20, "rrhh"),
                e("D", 7000, 40, "rrhh"),
                e("E", 6000, 50, "ventas") // edad 50 aparece una vez -> menos común
        );

        Empleados resultado = EmpleadosUtils.menorSalarioEdadMenosComun(lista);
        assertNotNull(resultado);
        assertEquals("E", resultado.getNombre());
    }
}
