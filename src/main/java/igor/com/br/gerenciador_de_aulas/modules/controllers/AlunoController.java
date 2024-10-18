package igor.com.br.gerenciador_de_aulas.modules.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
    
    @Operation(summary = "Testando as rotas de alunos")
    @GetMapping("/")
    public String testAPI() {
        return "teste OK Hello Word Aluno !!!!";
    }
    
}
