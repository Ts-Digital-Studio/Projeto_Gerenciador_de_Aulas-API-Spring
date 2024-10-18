package igor.com.br.gerenciador_de_aulas.modules.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/aula")
public class AulaController {
    
    @Operation(summary = "Testando as rotas de Aulas")
    @GetMapping("/")
    public String testAPI() {
        return "teste OK Hello Word Aula !!!!";
    }
}
