package br.com.osvaldsoza.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class ClienteDTO {

    @NotBlank
    private String nome;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    @JsonProperty("dataNascimento")
    private LocalDate dataNascimentopo;
}
