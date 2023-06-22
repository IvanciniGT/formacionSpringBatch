package com.curso.jobs.mijob.steps.mistep.listener;

import com.curso.items.MiItem;
import com.curso.items.MiItemProcesado;
import org.springframework.batch.core.ItemProcessListener;
import org.springframework.stereotype.Component;

@Component
public class MiItemProcessorListener implements ItemProcessListener<MiItem, MiItemProcesado> {

    @Override
    public void beforeProcess(MiItem miItem) {
        System.out.println("Antes de procesar el item: "+miItem);
    }

    @Override
    public void afterProcess(MiItem miItem, MiItemProcesado miItemProcesado) {
        System.out.println("Después de procesar el item: "+miItem);
    }

    @Override
    public void onProcessError(MiItem miItem, Exception e) {
        System.out.println("Error al procesar el item: "+miItem);
        e.printStackTrace();
    }
}
