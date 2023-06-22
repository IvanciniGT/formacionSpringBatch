package com.curso.mappers;

import com.curso.items.MiItem;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;

@Component
public class MiItemMapper extends BeanWrapperFieldSetMapper<MiItem> {
                                                            // Interfaz

    public MiItemMapper(){
        setTargetType(MiItem.class);
                      // Clase que implementa esa interfaz
    }

    /// ESTO ME SOBRA ENTERO... YA QUE TRABAJO CON CAMPOS QUE SE LLAMAN IGUAL QUE LOS DE MI CLASE
    @Override
    public MiItem mapFieldSet(FieldSet fieldSet){
        MiItem item=new MiItem();
        item.setNombre(fieldSet.readString("nombre"));
        item.setApellidos(fieldSet.readString("apellidos"));
        item.setEmail(fieldSet.readString("email"));
        item.setDni(fieldSet.readString("dni"));
        item.setFechaNacimiento(LocalDate.ofInstant(fieldSet.readDate("fechaNacimiento").toInstant(),
                ZoneId.systemDefault()));
        return item;
    }

}
