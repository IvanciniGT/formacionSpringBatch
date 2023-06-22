package com.curso.jobs.mijob.steps.mistep;

import com.curso.items.MiItemProcesado;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MiItemWriter implements ItemWriter<MiItemProcesado>{

    @Override
    public void write(List<? extends MiItemProcesado> list) throws Exception {
        list.forEach( System.out::println ); // Operador :: Me permite referencia a una función
                                             // Programación funcional
    }
}
