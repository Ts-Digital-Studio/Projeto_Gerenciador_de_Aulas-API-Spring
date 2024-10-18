package igor.com.br.gerenciador_de_aulas.modules.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("disciplina")
public class DisciplinaController {
    
    @Operation(summary = "Teestando as rotas de disciplina")
    @GetMapping("/")
    public String testAPI() {
        return "teste OK Hello Word Disciplina !!!!";
    }
}
