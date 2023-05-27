package com.foro.api.topico;



import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DatosUsuario(@NotBlank String nombreU, @NotBlank @Email String email) {

}
