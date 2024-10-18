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
@Schema(description = "Representa as aulas")
public class AulasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    private String horario;

    @ManyToOne(optional = false)
    @JoinColumn(name = "professor_id", nullable = false)
    private ProfessorEntity professorEntity;

    @ManyToOne(optional = false)
    @JoinColumn(name = "disciplina_id", nullable = false)
    private DisciplinaEntity disciplinaEntity;

    @ManyToOne(optional = false)
    @JoinColumn(name = "turma_id", nullable = false)
    private TurmaEntity turmaEntity;
    
    @CreationTimestamp
    private LocalDateTime dataDeCriacao;
}
