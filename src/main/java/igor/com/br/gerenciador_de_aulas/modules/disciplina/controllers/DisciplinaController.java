package igor.com.br.gerenciador_de_aulas.modules.disciplina.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("disciplina")
public class DisciplinaController {
    
    @GetMapping("/")
    public String testAPI() {
        return "teste OK Hello Word Disciplina !!!!";
    }
}
