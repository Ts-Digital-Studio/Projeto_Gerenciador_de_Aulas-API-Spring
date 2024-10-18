package igor.com.br.gerenciador_de_aulas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Gerenciador de Aulas para escolas", description = "API responsavel por fazer os gerencimentos de aulas para escolas do brasil", version = "1.0"))
public class GerenciadorDeAulasApplication {
	public static void main(String[] args) {
		SpringApplication.run(GerenciadorDeAulasApplication.class, args);
	}
}
