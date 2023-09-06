package com.example.produtoapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    private final ProdutoRepository produtoRepository;
    @Autowired
    public ProdutoController(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }
    @GetMapping("/selecionar")
    public List<Produto> listarProduto(){
        return produtoRepository.findAll();
    }
    @PostMapping("/inserir")
    public ResponseEntity<String> inserirProduto(@RequestBody Produto produto){
        produtoRepository.save(produto);
        return ResponseEntity.ok("Produto inserido");
    }
    @DeleteMapping("/remover/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id){
        produtoRepository.deleteById(id);
        return ResponseEntity.ok("Produto removido");
    }
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizarProduto(@PathVariable Long id, @RequestBody Produto produtoAtualizado){
        Optional<Produto> produtoExistente = produtoRepository.findById(id);
        if(produtoExistente.isPresent()){
            Produto produto = produtoExistente.get();
            produto.setNome(produtoAtualizado.getNome());
            produto.setDescricao(produtoAtualizado.getDescricao());
            produto.setPreco(produtoAtualizado.getPreco());
            produto.setQuantidadeEstoque(produtoAtualizado.getQuantidadeEstoque());
            produtoRepository.save(produto);
            return ResponseEntity.ok("Produto alterado");
        } else{
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/inserirForm")
    public ResponseEntity<String> inserirProduto(@RequestParam String nome, @RequestParam String descricao, @RequestParam float preco, @RequestParam int quantidade){
        Produto novoProduto = new Produto(nome, descricao, preco, quantidade);
        novoProduto.setId((int)Math.floor(Math.random()));
        try{
            produtoRepository.save(novoProduto);
            return ResponseEntity.ok("Produto inserido com sucesso");
        }catch (DataAccessException ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao inserir");
        }
    }
    @PostMapping("/alterarForm")
    public ResponseEntity<String> alterarProduto(@RequestParam Long id, @RequestBody Produto produtoAtualizado){
        Optional<Produto> produtoExistente = produtoRepository.findById(id);
        Produto produto = produtoExistente.get();
        produto.setNome(produtoAtualizado.getNome());
        produto.setDescricao(produtoAtualizado.getDescricao());
        produto.setPreco(produtoAtualizado.getPreco());
        produto.setQuantidadeEstoque(produtoAtualizado.getQuantidadeEstoque());
        produtoRepository.save(produto);
        return ResponseEntity.ok("Produto alterado");
    }
}
