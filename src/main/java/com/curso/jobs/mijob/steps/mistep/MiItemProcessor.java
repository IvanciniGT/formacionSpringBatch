package com.curso.jobs.mijob.steps.mistep;

import com.curso.items.MiItem;
import com.curso.items.MiItemProcesado;
import com.curso.mappers.MiItem2ItemProcesadoMapper;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
// Spring!! Empapate !!! 
// Si en algún momento alguien por ahí te pide ItemProcessor<MiItem, MiItemProcesado>
// devuelve una instancia de esta clase
public class MiItemProcessor implements ItemProcessor<MiItem, MiItemProcesado> {

    private MiItem2ItemProcesadoMapper mapeador;

    public MiItemProcessor(MiItem2ItemProcesadoMapper mapeador) { // Inyección de dependencias
        this.mapeador = mapeador;
    }

    @Override
    public MiItemProcesado process(MiItem miItem) throws Exception {
        // Filtro con una validación
        if( miItem.getDni().matches("^[a-zA-Z].*") ) 
            return null; // Este item pasas de él... filtrado... no lo procesamos
        if(!miItem.getEmail().contains("@"))
            return null;
        // Voy a montar el ItemProcesado qe devuelvo
        return  mapeador.getMiItemProcesado(miItem);
    }

}
