package com.curso.jobs.mijob.steps.mistep.listener;

import com.curso.items.MiItem;
import org.springframework.batch.core.ItemReadListener;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("elItemReaderListener1")
public class MiItemReaderListener implements ItemReadListener<MiItem> {
    @Override
    public void beforeRead() {
        System.out.println("Antes de leer");
    }

    @Override
    public void afterRead(MiItem miItem) {
        System.out.println("Después de leer el item: " + miItem);
    }

    @Override
    public void onReadError(Exception e) {
        System.out.println("Error al leer");
        e.printStackTrace();
    }
}
