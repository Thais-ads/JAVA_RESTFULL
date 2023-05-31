package teste.API.controller.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import teste.API.controller.teste.DadosAtualizar;
import teste.API.controller.teste.DadosCadastro;
import teste.API.controller.teste.Especialidade;

@Table(name="Dados")
@Entity(name="Dados")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Dados {


    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String email;
    private String crm;
    private String telefone;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    public Dados(DadosCadastro dados) {
        this.ativo =true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco =new Endereco(dados.endereco());
    }

    public void atualizarinformacoes(DadosAtualizar dados) {

        if(dados.nome() != null){
            this.nome=dados.nome();
        }
        if(dados.telefone() != null){
            this.telefone=dados.telefone();
        }
        if(dados.endereco() != null){
            this.endereco.atualizarinformacoes(dados.endereco());

        }



    }

    public void excluir() {
        this.ativo = false;
    }
}
