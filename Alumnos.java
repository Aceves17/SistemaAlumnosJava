/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Alumnos;
import java.util.Scanner;
/**
 *
 * @author Timi3
 */
import java.util.Scanner;
public class Alumnos {
    //Atributos de Alumno
    private int matricula;
    private String nombre;
    private String carrera;
    private int edad;
    
    
    //Constructor vacio
    public Alumnos(){}
    
    //Metodos set y get
    
    public int getMatricula(){
        return this.matricula;
    }
    
    
    public void setMatricula(int matricula){
        this.matricula = matricula;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getCarrera(){
        return this.carrera;
    }
    
    public void setCarrera(String carrera){
        this.carrera = carrera;
    }
    
    public int getEdad(){
        return this.edad;
    }
    
    public void setEdad(int edad){
        this.edad = edad;
    }
    
    
   //Metodo mostrar Informacion
    public void mostrarInformacion(){
        System.out.printf("""
                        -----------------------------------------------------------------  
                        |  Matricula:%d |Nombre:%s|Carrera:%s|Edad:%d años|
                        -----------------------------------------------------------------%n%n"""
                            ,this.matricula,this.nombre,this.carrera,this.edad
        );
    
    }
        
    
    
    
    public static void main(String[] args) {
        //Creamos objeto de Scanner
        Scanner scanner = new Scanner(System.in);
        //Creare un arreglo de 150 alumnos
         Alumnos[] alumnos = new Alumnos[150];
        
        //Menu del sistema Alumnos
        var salida = false;
        while(!salida){
            System.out.println("***Menu de Alumnos***");
            System.out.print("""
                1.Crear un nuevo alumno
                2.Leer informacion alumno
                3.Cambiar informacion alumno
                4.Eliminar alumno
                5.Salir del sistema
                Selecciona una opcion:""");
        int opcion = Integer.parseInt(scanner.nextLine().trim());    
            
            //Respuesta al Menu
            
            switch(opcion){
                
            //Crear un nuevo alumno
                case 1:
                    System.out.print("\nCuantos alumnos nuevos quieres ingresar?:");
                    int alumnosNuevos = Integer.parseInt(scanner.nextLine());
                    if(alumnosNuevos > 0 ) {
                        //Esta variable sera la que haga que solo 2 alumnos se ingresen
                        int alumnosGuardados = 0;
                        for(var i = 0; i < alumnos.length && alumnosGuardados < alumnosNuevos ; i++){
                            if(alumnos[i] == null){
                                System.out.println("\n***Datos del Alumno Nuevo***");
                                //Creamos el objeto una vez vimos si hay espacio en el arreglo
                                alumnos[i] = new Alumnos();
                                System.out.print("Ingresa el nombre del Alumno[" + (i + 1) + "]:"); 
                                alumnos[i].setNombre(scanner.nextLine().trim().toLowerCase());
                                System.out.print("Ingresa la Carrera:");
                                alumnos[i].setCarrera(scanner.nextLine().trim().toLowerCase());
                                System.out.print("Ingresa su Edad:");
                                alumnos[i].setEdad(Integer.parseInt(scanner.nextLine().trim()));
                                //Matricula asignada
                                alumnos[i].setMatricula(i + 1);
                                alumnosGuardados++; //Aumnetamos 1 los alumnos ya ingresados.
                            }
                               
                        }
                    }
                    
                    else{
                        System.out.println("No puedes ingresar valores negativos");
                    }
                    
                break;
                
                //Leer informacion Alumno
                case 2:
                        System.out.print("""
                                    Escoge la opcion para mostrar la informacion:
                                        1.Mostrar todos los alumnos
                                        2.Mostrar uno
                                        opcion: """);
                        int mostrarAlumno = Integer.parseInt(scanner.nextLine());
                           
                            switch(mostrarAlumno){
                               case 1:
                                   boolean hayAlumnos = false;
                                   System.out.println("*** Informacion del Alumnado ***");
                                   for(var i = 0 ; i < alumnos.length ; i++){
                                       if(alumnos[i] != null){
                                       alumnos[i].mostrarInformacion();
                                        hayAlumnos = true; // Con que haya un registro
                                       }
                                   }
                                       
                                       if(!hayAlumnos){ //Conque no haya ningun registro muestra este mensaje
                                           System.out.println("No hay alumnos registrados actualmente");
                                           
                                       }   
                                     
                               break;
                               
                               
                               case 2:
                                   System.out.print("Ingrese la maricula del alumno a mostrar:");
                                   int matricula = Integer.parseInt(scanner.nextLine());
                                   boolean encontrado = false;
                                   for(var i = 0 ; i < alumnos.length ; i++){
                                       if(alumnos[i] != null && alumnos[i].matricula == matricula){
                                          alumnos[i].mostrarInformacion();
                                          encontrado = true;
                                          break;
                                       }
                                       
                                   }
                                   
                                   if(!encontrado){
                                       System.out.println("Matricula no encontrada");
                                   }
                                   
                                   
                                break;
                                
                                default:
                                    System.out.println("Opcion no encotrada!\n");
                                break;   // romper ciclo si no hay ningun alumno 
                           }
                            
                          
                break;
                
                
                //Cambiar informacion alumno
                case 3:
                        System.out.println("*** Modificador de Alumno ***");
                        System.out.print("Ingrese la matricula del alumno a modificar:");
                        int matriculaCambio = Integer.parseInt(scanner.nextLine().trim());
                        boolean encontrado = false;
                        for(var i = 0 ; i < alumnos.length ; i++){
                            if(alumnos[i] != null && alumnos[i].getMatricula()== matriculaCambio){
                                System.out.println("Informacion del alumno a modificar");
                                alumnos[i].mostrarInformacion();
                                System.out.print("Nuevo nombre:");
                                alumnos[i].setNombre(scanner.nextLine().trim().toUpperCase());
                                System.out.print("Nueva carrera:");
                                alumnos[i].setCarrera(scanner.nextLine().trim());
                                System.out.print("Edad:");
                                alumnos[i].setEdad(Integer.parseInt(scanner.nextLine()));
                                encontrado = true;
                                break;
                                
                            }
                            
                        }
                        
                        if(!encontrado){
                            System.out.println("Matricula no encontrada\n");
                                
                        }
                    
                break;   
                 
                
                //4.Eliminar alumno
                case 4 :
                        System.out.println("*** Eliminacion de Alumno ***");
                        System.out.print("Ingrese la matricula del alumno a Eliminar:");
                        int matriculaEliminar = Integer.parseInt(scanner.nextLine());
                        boolean eliminado = false;
                        for(var i = 0 ; i < alumnos.length ; i++){
                            if(alumnos[i] != null && alumnos[i].getMatricula() == matriculaEliminar){
                                System.out.println("Alumno Eliminado");
                                alumnos[i] = null;
                                eliminado = true;
                                break;
                            }  
                        }
                        
                        //Si despues de buscar en los 150 alumnos y no lo encontro
                        if(!eliminado){
                              System.out.println("Matricula no encontrada");
                          }  
                break;
                
                
                //5.Salir del sistema
                
                case 5:
                    System.out.println("Saliendo del Sistema...");
                    salida = true;
                break;
                
                
                default:
                    System.out.println("Opcion no encotrada");
                break;    
            
            }
            
                    
        
        
        }
        
    }
    
}
