package com.foro.api.controller;

import com.foro.api.modelo.Topico;
import com.foro.api.topico.DatosActualizarTopico;
import com.foro.api.topico.DatosListadoTopico;
import com.foro.api.topico.DatosRegistroTopico;
import com.foro.api.topico.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


//import java.util.List;

@RestController
@RequestMapping("/topicos")
public class topicoController {
    @Autowired
    private TopicoRepository topicoRepository;
    @PostMapping
    public void registroTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico){
        //System.out.println(datosRegistroTopico);
        topicoRepository.save(new Topico(datosRegistroTopico));

    }
    @GetMapping
    public Page<DatosListadoTopico> listadoTopicos(@PageableDefault(size=5,sort="titulo") Pageable paginacion){
        //return topicoRepository.findAll().stream().map(DatosListadoTopico::new).toList();
        return topicoRepository.findByActivoTrue(paginacion).map(DatosListadoTopico::new);

    }



    @PutMapping
    @Transactional
    public void modificarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
        topico.actualizardatos(datosActualizarTopico);

    }
    /*@DeleteMapping("/{id}")
    @Transactional
    public void deteteDatos(@PathVariable Long id){
        Topico topico=topicoRepository.getReferenceById(id);
        topicoRepository.delete(topico);

    }*/
    @DeleteMapping("/{id}")
    @Transactional
    public void deteteLogico(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        topico.desactivarTopico();
    }
}
