package com.curso.jobs.mijob.steps.mistep.listener;

import com.curso.items.MiItemProcesado;
import org.springframework.batch.core.ItemWriteListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MiItemWriterListener implements ItemWriteListener<MiItemProcesado> {

    @Override
    public void beforeWrite(List<? extends MiItemProcesado> list) {
        System.out.println("Antes de escribir: "+list);
    }

    @Override
    public void afterWrite(List<? extends MiItemProcesado> list) {
        System.out.println("Después de escribir: "+list);
    }

    @Override
    public void onWriteError(Exception e, List<? extends MiItemProcesado> list) {
        System.out.println("Error al escribir: "+list);
        e.printStackTrace();
    }
}
