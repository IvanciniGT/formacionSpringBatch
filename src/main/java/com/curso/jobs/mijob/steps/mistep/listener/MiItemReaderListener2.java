package com.curso.jobs.mijob.steps.mistep.listener;

import com.curso.items.MiItem;
import org.springframework.batch.core.ItemReadListener;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("elItemReaderListener2")
public class MiItemReaderListener2 implements ItemReadListener<MiItem> {
    @Override
    public void beforeRead() {
        System.out.println("Antes de leer2");
    }

    @Override
    public void afterRead(MiItem miItem) {
        System.out.println("Después de leer el item2: " + miItem);
    }

    @Override
    public void onReadError(Exception e) {
        System.out.println("Error al leer");
        e.printStackTrace();
    }
}
