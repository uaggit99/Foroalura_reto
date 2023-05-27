package com.foro.api.topico;

import com.foro.api.modelo.Curso;
import com.foro.api.modelo.Topico;
import com.foro.api.modelo.Usuario;


public record DatosListadoTopico(Long id, String titulo, String mensaje, String fecha_creacion, String Statuss,
                                 Usuario autor, Curso curso) {

    public DatosListadoTopico(Topico topico){
        this(topico.getId(),topico.getTitulo(),topico.getMensaje(),topico.getFecha_creacion(),topico.getStatuss().toString(),new Usuario(topico.getAutor().getNombreU(),topico.getAutor().getEmail()) ,new Curso(topico.getCurso().getNombreC(),topico.getCurso().getCategoria()));
    }
}
