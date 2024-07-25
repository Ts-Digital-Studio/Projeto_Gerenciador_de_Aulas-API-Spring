package igor.com.br.gerenciador_de_aulas.modules.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aula")
public class AulaController {
    
    @GetMapping("/")
    public String testAPI() {
        return "teste OK Hello Word Aula !!!!";
    }
}
