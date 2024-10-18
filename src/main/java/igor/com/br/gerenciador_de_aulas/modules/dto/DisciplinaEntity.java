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
import lombok.Data;

@Entity
@Data
@Schema(description = "Representa as diciplinas")
public class DisciplinaEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome; 
    
    private int cargaHoraria;

    private String assuntos;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private ProfessorEntity professorEntity;

    @CreationTimestamp
    private LocalDateTime dataDeCriacao;
}
