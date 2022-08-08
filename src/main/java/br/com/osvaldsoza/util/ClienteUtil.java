package br.com.osvaldsoza.util;

import java.time.LocalDate;
import java.time.Period;

public class ClienteUtil {

    public static Integer calcularIdadeEmAnos(LocalDate anoAniversario){
        LocalDate dataAtual = LocalDate.now();
       return Period.between(anoAniversario,dataAtual).getYears();
    }

    private ClienteUtil() {
        throw new IllegalStateException();
    }
}
