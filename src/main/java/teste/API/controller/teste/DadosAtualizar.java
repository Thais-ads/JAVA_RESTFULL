package teste.API.controller.teste;

import jakarta.validation.constraints.NotNull;
import teste.API.controller.endereco.DadosEndereco;
import teste.API.controller.model.Endereco;

public record DadosAtualizar(

        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {


}
