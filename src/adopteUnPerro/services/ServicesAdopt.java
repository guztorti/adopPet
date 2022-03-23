package adopteUnPerro.services;

import adopteUnPerro.enums.Raza;
import adopteUnPerro.enums.Tamanio;
import adopteUnPerro.instances.Persona;
import adopteUnPerro.instances.Perro;
import java.util.ArrayList;
import java.util.Scanner;

public class ServicesAdopt {

     private ArrayList<Perro> perros;
     private ArrayList<Persona> personas;
     Scanner scn;

     public ServicesAdopt() {
          perros = new ArrayList();
          personas = new ArrayList();
          scn = new Scanner(System.in).useDelimiter("\n");
          personas.add(new Persona("Gustavo", "Torti", 42, 27174360));
          personas.add(new Persona("Lorena", "Berrocal", 39, 34176239));
          personas.add(new Persona("Teodoro", "Torti", 9, 52890734));
          personas.add(new Persona("Matilda", "Torti", 8, 55347923));
          personas.add(new Persona("Alejandro", "Torti", 5, 57347568));
          personas.add(new Persona("Basilio", "Torti", 2, 59789328));

          perros.add(new Perro("Puki", Raza.CALLEJERO, 3, Tamanio.MINI));
          perros.add(new Perro("Camba", Raza.CALLEJERO, 1, Tamanio.PEQUENIO));
          perros.add(new Perro("Yoco", Raza.OVEJERO_ALEMAN, 9, Tamanio.GRANDE));

     }

     public Persona crearPersona() {
          System.out.println("Ingrese el nombre de la persona:");
          String nombrePersona = scn.next();
          System.out.println("Ingrese el apellido:");
          String apellidoPersona = scn.next();
          System.out.println("Ingrese la edad:");
          int edad = scn.nextInt();
          System.out.println("e ingrese el número de documento:");
          int documento = scn.nextInt();

          return new Persona(nombrePersona, apellidoPersona, edad, documento);
     }

     public Perro crearPerro() {
          System.out.println("Ingrese el nombre del perro:");
          String nombrePerro = scn.next();

          System.out.println("Ingrese la raza:");

          for (Raza value : Raza.values()) {
               System.out.println(value);
          }
          String eval = scn.next();
          Raza razaPerro = null;
          for (Raza raza : Raza.values()) {
               if (raza.name().equalsIgnoreCase(eval)) {
                    razaPerro = raza;
                    break;
               }
          }
          System.out.println("Ingrese la edad:");
          int edadPerro = scn.nextInt();
          System.out.println("e ingrese el tamaño de la raza:");
          for (Tamanio value : Tamanio.values()) {
               System.out.println(value);
          }
          eval = scn.next();
          Tamanio tamanio = null;
          for (Tamanio tam : Tamanio.values()) {
               if (tam.name().equalsIgnoreCase(eval)) {
                    tamanio = tam;
                    break;
               }
          }

          return new Perro(nombrePerro, razaPerro, edadPerro, tamanio);
     }

     public boolean elegirPerro() {
          boolean coincide = false;
          for (Persona persona : personas) {
               System.out.println(persona.getApellido() + ", " + persona.getNombre() + ": DNI:" + persona.getDocumento());
          }
          System.out.println("Ingrese el DNI de la persona que va a adoptar:");
          int dni = scn.nextInt();
          for (Persona persona : personas) {
               if (persona.getDocumento() == dni) {
                    coincide = true;
                    for (Perro perro : perros) {
                         System.out.println(perro);
                    }
                    System.out.println("Ingrese el nombre del perro elegido:");
                    String nombrePerro = scn.next();
                    for (Perro perro : perros) {
                         if (perro.getNombre().equalsIgnoreCase(nombrePerro)) {
                              persona.setPerro(perro);
                              perro.setDuenio(persona);
                              return true;
                         }
                    }
                    System.out.println("no se encuentra el perro");
                    break;
               }
               

          }
          if (!coincide) {
               System.out.println("el DNI no coincide, intente nuevamente");
          }
          return false;
     }

     public String mostrarPerros(boolean flag) {
          String salida = "Lista de perros a adoptar:\n";
          if (flag) {
               for (Perro perro : perros) {
                    if (perro.getDuenio() == null) {
                         salida += perro + "\n";
                    }

               }
               return salida;
          }
          salida = "Lista de perros:\n";
          for (Perro perro : perros) {
               salida += perro + "\n";

          }
          return salida;

     }

     public String mostrarPersonas() {
          String salida = "Lista de personas:\n";
          for (Persona persona : personas) {
               salida += persona + "\n";
          }
          return salida;
     }

     public String menu() {
          int opcion = 0;
          final String mensaje = "\tPrograma de adopcion de mascotas\n"
                  + "Ingrese la opción\n"
                  + "1\t Ingrese persona.\n"
                  + "2\t Ingrese perro.\n"
                  + "3\t Elegir perro.\n"
                  + "4\t Mostrar lista de perros.\n"
                  + "5\t Mostrar personas.\n\n"
                  + "9 -\t- SALIR";

          do {
               System.out.println(mensaje);
               opcion = scn.nextInt();
               switch (opcion) {
                    case 1:
                         personas.add(crearPersona());
                         break;
                    case 2:
                         perros.add(crearPerro());
                         break;
                    case 3:
                         System.out.println(elegirPerro() ? "perro adoptado" : "falló el proceso de adopción");
                         break;
                    case 4:
                         System.out.println("desear ver Todos los perros (T)\n"
                                 + "o solo los disponibles a adopción (D):");
                         String muestraTodos = scn.next();
                         if (muestraTodos.equalsIgnoreCase("T")) {
                              System.out.println(mostrarPerros(false));
                         } else if (muestraTodos.equalsIgnoreCase("D")) {
                              System.out.println(mostrarPerros(true));
                         } else {
                              System.out.println("No se conoce la opción");
                         }

                         break;
                    case 5:
                         System.out.println(mostrarPersonas());
                         break;
                    case 9:
                         System.out.println("gracias por utilizar el sistema");
                         break;
                    default:
                         System.out.println("no se conoce la opción, elija nuevamente");

               }

          } while (opcion != 9);
          return "programa finalizado...";
     }
}
