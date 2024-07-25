package igor.com.br.gerenciador_de_aulas.modules.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class ProfessorEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id_matricula; 

    @NotBlank
    private String nome; 

    @NotBlank
    private String email;

    private int salario;

    @CreationTimestamp
    private LocalDateTime dataDeCriacao;
}
