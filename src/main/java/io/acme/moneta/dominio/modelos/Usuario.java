package io.acme.moneta.dominio.modelos;


import io.acme.moneta.dominio.enums.Rol;
import jakarta.persistence.*;
import lombok.*;

// La siguiente anotacion es de lombok y nos crea automaticamente los constructores y los getters and setters
@Data

@Entity
@Table(name = "usuario")
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


}
