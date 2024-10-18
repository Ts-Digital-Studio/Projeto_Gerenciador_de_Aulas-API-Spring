package igor.com.br.gerenciador_de_aulas.modules.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
@Schema(description = "Representa um Aluno")
public class AlunoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id_matricula;

    @NotBlank
    private String nome;

    @NotBlank
    private String email;

    private int cep;

    @ManyToOne
    @JoinColumn(name = "turma_id")
    private TurmaEntity turmaEntity;

    @CreationTimestamp
    private LocalDateTime dataDeCriacao;
}
