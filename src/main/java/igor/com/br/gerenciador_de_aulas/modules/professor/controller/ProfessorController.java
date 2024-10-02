package igor.com.br.gerenciador_de_aulas.modules.professor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/professor")
public class ProfessorController {
    
    @GetMapping("/")
    public String testAPI() {
        return "teste OK Hello Word Professor !!!!";
    }
}
