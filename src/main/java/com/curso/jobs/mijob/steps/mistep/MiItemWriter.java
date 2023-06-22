package com.curso.jobs.mijob.steps.mistep;

import com.curso.items.MiItemProcesado;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MiItemWriter implements ItemWriter<MiItemProcesado>{

    @Override //No aporta nada funcional.
    // Es una validación que hace el compilador para asegurarnos que realmente estamos
    // Sobreescribiendo la función que viene por defecto en la interfaz
    public void write(List<? extends MiItemProcesado> list) throws Exception {
        list.forEach( System.out::println ); // Operador :: Me permite referencia a una función
                                             // Programación funcional
    }
}
