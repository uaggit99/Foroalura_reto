package com.foro.api.topico;



import jakarta.validation.constraints.NotBlank;

public record DatosCurso(@NotBlank String nombreC, @NotBlank String categoria ) {

}