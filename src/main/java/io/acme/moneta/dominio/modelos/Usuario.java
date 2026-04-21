package io.acme.moneta.dominio.modelos;


import io.acme.moneta.dominio.enums.EstadoUsuario;
import io.acme.moneta.dominio.enums.Rol;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

// La siguiente anotacion es de lombok y nos crea automaticamente los constructores y los getters and setters
@Data

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String nombre;

    @Column (nullable = false)
    private String apellido;

    @Column (nullable = false, unique = true)
    private String email;

    @Column (nullable = false, unique = true)
    private String telefono;

    @Column (nullable = false)
    private String password;

    @Enumerated(EnumType.STRING) //Este es importante para poder guardar en User y no un numero identificador
    @Column (nullable = false)
    private Rol rol;

    @Column (nullable = false, updatable = false)
    private LocalDateTime fechaCreacion;

    @Enumerated (EnumType.STRING)
    @Column (nullable = false)
    private EstadoUsuario estado;


    // Metodo que se ejecuta automaticamente antes de guaradar en la BD
    @PrePersist
    protected  void enCreacion() {
        this.fechaCreacion = LocalDateTime.now();
        if (this.estado == null){
            this.estado = EstadoUsuario.ACTIVO;
        }
    }
}
