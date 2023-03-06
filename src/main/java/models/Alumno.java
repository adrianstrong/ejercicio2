package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="alumnado")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alumno implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String telefono;
    private String email;
    private Double ad;
    private Double di;

}
