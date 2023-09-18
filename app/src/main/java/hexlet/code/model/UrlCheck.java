package hexlet.code.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;


@Getter
@Setter
@Entity
@Table(name = "urlCheck")
public class UrlCheck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String name;
    @Column
    private Timestamp createdAt;
}
