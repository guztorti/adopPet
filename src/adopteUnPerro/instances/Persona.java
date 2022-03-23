package adopteUnPerro.instances;

import java.util.ArrayList;

public class Persona {

    private String nombre;

    private String apellido;

    private Integer edad;

    private Integer documento;

    private ArrayList<Perro> perros;

     public Persona(String nombre, String apellido, Integer edad, Integer documento) {
          this.nombre = nombre;
          this.apellido = apellido;
          this.edad = edad;
          this.documento = documento;
          this.perros = new ArrayList();
     }

     public String getNombre() {
          return nombre;
     }

     public void setNombre(String nombre) {
          this.nombre = nombre;
     }

     public String getApellido() {
          return apellido;
     }

     public void setApellido(String apellido) {
          this.apellido = apellido;
     }

     public Integer getEdad() {
          return edad;
     }

     public void setEdad(Integer edad) {
          this.edad = edad;
     }

     public Integer getDocumento() {
          return documento;
     }

     public void setDocumento(Integer documento) {
          this.documento = documento;
     }

     public ArrayList<Perro> getPerros() {
          return perros;
     }

//     @Override
     public void setPerro(Perro perros) {
          this.perros.add(perros);
     }

     @Override
     public String toString() {
          if (perros.isEmpty()) {
               return "Persona{" + nombre + ", " + apellido + ", edad=" + edad + ", DNI=" + documento + ", no ha adoptado perros";
          }
          return "Persona{" + nombre + ", " + apellido + ", edad=" + edad + ", DNI=" + documento + ", perro=" + perros.toString() + '}';
     }
    
}
