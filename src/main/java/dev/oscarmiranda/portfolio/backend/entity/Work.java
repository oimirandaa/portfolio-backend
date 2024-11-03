package dev.oscarmiranda.portfolio.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name="Work")
public class Work {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column()
    private String title;

    @Column()
    private String description;

    @Column()
    private String projectLink;

    @Column()
    private String codeLink;

    @Column()
    private String imageUrl;

    @Column()
    private String tags;
}
