package com.foro.api.topico;


import com.foro.api.modelo.Topico;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DatosRegistroTopico(@NotBlank String titulo,
                                  @NotBlank
                                  String mensaje,
                                  //@NotBlank
                                  //@Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}$")
                                  String fecha_creacion,
                                  //@NotNull
                                  StatusTopico  Statuss ,
                                  @NotNull
                                  @Valid
                                  DatosUsuario autor,
                                  @NotNull
                                  @Valid
                                  DatosCurso curso
                                  ) {
}
