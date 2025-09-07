package com.yahya.task_tracker.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table
@Entity
public class Task {
    @Id
    @GeneratedValue
    private  Long id;
    @NotBlank
    @Column(
            nullable = false,
            length = 100,
            columnDefinition = "TEXT"
    )

    private String name;
    @Column(
            nullable = false,
            columnDefinition = "VARCHAR(500)"
    )
    @NotBlank
    private String description;
    @Column(
            nullable = false,
            length = 20,
            columnDefinition = "TEXT"
    )
    @NotBlank
    private String status;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
