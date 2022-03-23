package adopteUnPerro.instances;

import adopteUnPerro.enums.Raza;
import adopteUnPerro.enums.Tamanio;

public class Perro {

    private String nombre;

    private Raza raza;

    private Integer edad;

    private Tamanio tamanio;

    private Persona duenio;

     public Perro(String nombre, Raza raza, Integer edad, Tamanio tamanio) {
          this.nombre = nombre;
          this.raza = raza;
          this.edad = edad;
          this.tamanio = tamanio;
     }

     public String getNombre() {
          return nombre;
     }

     public void setNombre(String nombre) {
          this.nombre = nombre;
     }

     public Raza getRaza() {
          return raza;
     }

     public void setRaza(Raza raza) {
          this.raza = raza;
     }

     public Integer getEdad() {
          return edad;
     }

     public void setEdad(Integer edad) {
          this.edad = edad;
     }

     public Tamanio getTamanio() {
          return tamanio;
     }

     public void setTamanio(Tamanio tamanio) {
          this.tamanio = tamanio;
     }

     public Persona getDuenio() {
          return duenio;
     }

     public void setDuenio(Persona duenio) {
          this.duenio = duenio;
     }

     @Override
     public String toString() {
          if (duenio==null) {
               return "{" + "nombre=" + nombre + ", raza=" + raza + ", edad= " + edad + ", tamaño= " + tamanio +  ", no ha sido adoptado aún}";
          }
          return "{" + "nombre=" + nombre + ", raza=" + raza + ", edad= " + edad + ", tamaño= " + tamanio + ", dueño= " + duenio.getNombre()+" "+duenio.getApellido() + '}';
     }
    
    
}
