package teste.API.controller.teste;

import teste.API.controller.model.Dados;

public record DadoslistagemCadastro(Long id,String nome, String email, String crm, Especialidade especialidade) {

    public DadoslistagemCadastro(Dados dados){

        this(dados.getId(),dados.getNome(),dados.getEmail(),dados.getCrm(), dados.getEspecialidade());
    }

}
