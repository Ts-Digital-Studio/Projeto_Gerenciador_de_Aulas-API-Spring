package igor.com.br.gerenciador_de_aulas.modules.turma.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/turma")
public class TurmaController {
    
    @GetMapping("/")
    public String testAPI() {
        return "teste OK Hello Word Turma !!!!";
    }
}
