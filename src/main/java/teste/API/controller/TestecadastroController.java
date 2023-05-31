package teste.API.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import teste.API.controller.Interface.DadosRepository;
import teste.API.controller.model.Dados;
import teste.API.controller.teste.DadosAtualizar;
import teste.API.controller.teste.DadosCadastro;
import teste.API.controller.teste.DadoslistagemCadastro;

import java.util.List;


@RestController
@RequestMapping("/cadastro")
@Api(tags = "Exemplo API")
public class TestecadastroController {

    //dizendo para o controller que o repository precisa persistir no banco de dados "criar"
    @Autowired
    private DadosRepository repository;


    @PostMapping
    @Transactional
    //public void cadastrar(  @RequestBody String json){
    //          System.out.println(json);

    //padroes dto, significa data trasnfer objecto, utilizada para receber e enviar os dados da api
    public void cadastrar(@RequestBody @Valid DadosCadastro dados) {

        repository.save(new Dados(dados));

    }

    @GetMapping(value ="/buscar")
    @ApiOperation("Descrição do endpoint")
    public Page<DadoslistagemCadastro> listar(@PageableDefault(size=10, page=0, sort={"nome"}) Pageable paginacao) {

        return repository.findAllByAtivoTrue(paginacao).map(DadoslistagemCadastro::new);
    }

    @Transactional
    @PutMapping("/atualizar")
    @ApiOperation("Descrição do endpoint")
    public void atualizar(@RequestBody @Valid DadosAtualizar dados){

        var  teste  = repository.getReferenceById(dados.id());
        teste.atualizarinformacoes(dados);


    }

    @Transactional
    @DeleteMapping("/{id}")
    public void excluir( @PathVariable Long id ){

        //aqui ele apaga do bd
        //repository.deleteById(id);

        var  teste  = repository.getReferenceById(id);
        teste.excluir();

    }




}
