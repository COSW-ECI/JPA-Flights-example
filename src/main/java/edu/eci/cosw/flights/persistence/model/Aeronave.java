package edu.eci.cosw.flights.persistence.model;
// Generated Aug 12, 2015 11:13:25 AM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Aeronaves generated by hbm2java
 */
@Entity
@Table(name="AERONAVES"
    ,catalog="bdprueba"
)
public class Aeronave  implements java.io.Serializable {


     private int idaeronave;
     private int anyoFabricacion;
     private String modelo;
     private int capacidad;

    public Aeronave() {
    }

	
    public Aeronave(int idaeronave, int anyoFabricacion, String modelo, int capacidad) {
        this.idaeronave = idaeronave;
        this.anyoFabricacion = anyoFabricacion;
        this.modelo = modelo;
        this.capacidad = capacidad;
    }

   
     @Id 
    @Column(name="IDAERONAVE", unique=true, nullable=false)
    public int getIdaeronave() {
        return this.idaeronave;
    }
    
    public void setIdaeronave(int idaeronave) {
        this.idaeronave = idaeronave;
    }

    
    @Column(name="ANYO_FABRICACION", nullable=false)
    public int getAnyoFabricacion() {
        return this.anyoFabricacion;
    }
    
    public void setAnyoFabricacion(int anyoFabricacion) {
        this.anyoFabricacion = anyoFabricacion;
    }

    
    @Column(name="MODELO", nullable=false, length=45)
    public String getModelo() {
        return this.modelo;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    
    @Column(name="CAPACIDAD", nullable=false)
    public int getCapacidad() {
        return this.capacidad;
    }
    
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }


}


