package com.curso.mappers;

import com.curso.items.MiItem;
import com.curso.items.MiItemProcesado;
import org.springframework.stereotype.Component;

@Component
public class MiItem2ItemProcesadoMapperImpl implements MiItem2ItemProcesadoMapper {

    @Override
    public MiItemProcesado getMiItemProcesado(MiItem miItem) {
        MiItemProcesado miItemProcesado = new MiItemProcesado();
        miItemProcesado.setNombre(miItem.getNombre());
        miItemProcesado.setApellidos(miItem.getApellidos());
        miItemProcesado.setDni(miItem.getDni());
        miItemProcesado.setEmail(miItem.getEmail());
        miItemProcesado.setNombreCompleto(miItem.getNombre() + " " + miItem.getApellidos());
        miItemProcesado.setFechaNacimiento(miItem.getFechaNacimiento());
        return miItemProcesado;
    }
}
