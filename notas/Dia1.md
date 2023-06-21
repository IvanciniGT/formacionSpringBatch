# java

Hace 20 años era el futuro!

App Web:     Java
App Android: Java
App embebido: Java
App Desktop: Java

Hoy en día

App Web:
Backend     JAVA
Frontal     JS (AngularJS, ReactJS, Vue, Polymer) - > Typescript
App Android:    Kotlin
App embebido:   C++, Rust
App Desktop:    C#, Objective-C, VB


Java 1.8 ---> 11          | 20

# Spring

Framework de desarrollo en java que proporciona inversión de control.

# SpringBatch

Librería de Spring

# Inversión de control

Un patrón de desarrollo de software, por el cual delegamos el control del flujo de la app a un tercero (El framework... Spring)
Para qué? Para conseguir Inyección de dependencias.

# Inyección de dependencias

Es otro patrón de desarrollo de software (en el mundo de la POO) por el cúal, las clases no crean instancias de objetos, sino que le son suministradas.
Para qué? Para conseguir Inversión de dependencias.

# Inversión de dependencias

Principio de desarrollo de software (uno de los 5 grandes: SOLID) por el cual nos aseguramos que los componentes de alto nivel de un programa no dependan de la implementación de un componente de bajo nivel
sino de abstracciones (interfaces).
Para qué? Para conseguir un sistema con componentes sin ningún tipo de acoplamiento lo que favorece el mantenimiento y evolución de los sistema.

---

Librería en JAVA que me permita trabajar con "Diccionarios"... Es decir, que yo le pueda preguntar si una palabra existe en un determinado idioma.

    API
        com.diccionario.
                        interface Diccionario
                            boolean existe(String palabra)

                        interface SuministradorDeDiccionarios
                            boolean tienesDiccionarioDe(String idioma)
                            Optional<Diccionario> getDiccionario(String idioma)

    Implementación (quizás haya multiples implementaciones de esa librería)
        - BBDD
        com.diccionario.impl
                        class SuministradorDeDiccionariosDesdeBBDD implements SuministradorDeDicc...{
                        ...
                        }
                        class DiccionarioDesdeBBDD implements Diccionario{
                            ...
                        }
        - Fichero texto
  
---
    App... y esa app ... en un sitio dado... usa la librería

    import com.diccionario.Diccionario;
    import com.diccionario.SuministradorDeDiccionarios;
    //import com.diccionario.impl.SuministradorDeDiccionariosDesdeBBDD;
        // ^ Con esa linea nos acabamos de MEAR en el ppo de inversión de dependencias!
        // ESA LINEA DE AHI ES LA MAYOR RUINA POSIBLE EN UN PROYECTO DE SOFTWARE
    
    class App {

        ....
        public void miFuncion(SuministradorDeDiccionarios suministrador){ // Inyección de dependencias
            ...
            String palabra = "Perro";
            String idioma = "ES";
            boolean existe = false;
            // SuministradorDeDiccionarios suministrador = new SuministradorDeDiccionariosDesdeBBDD();
            if(suministrador.tienesDiccionarioDe(idioma)){
                DiccionarioEspañol diccionario = suministrador.getDiccionario(idioma).get();
                existe = diccionario.existe(palabra);
            }
            // Hago lo que sea con ese "existe"

        }
        ....
    }

// Como Spring es quién llamará a "miFuncion", mira a ver que necesita esa función... qué necesita?
SuministradorDeDiccionarios suministrador
Y entonces Spring Creará un suministrador de diccionarios... del tipo que pille por ahí

---

# Vamos a montar una aplicación batch

// Sin usar una sintaxis imperativa... más bien una sintaxis DECLARATIVA

- Leer datos de un fichero ... personas
  ItemReader

- CUANDO HAYAN SIDO PROCESADOS: Los quiero meter en una BBDD que tengo en la empresa
  ItemWriter

- CUANDO HAYA LEIDO UNA PERSONA: Los valido:
    - El DNI que esté bien
    - Me llega un email válido
      ItemProcessor

JobExecutionListener
- Cuando termines, manda un correo
  (Suceso)         respuesta
- Cuando empiece, manda un correo

- CUANDO HAYA LEIDO UNA PERSONA: guarda en otro campo la edad (que la necesito guardar en la BBDD)

^^^ Esto de ahí es un programa?  A mi más bien me parece la ESPECIFICACION / CONFIGURACION de un programa

Y quién escribe el programa pues? SPRING

// respuestas deseadas a sucesos

# Vamos a montar una aplicación batch

ESTO ES UN PROGRAMA USANDO UNA SINTAXIS IMPERATIVO

miro si existe el fichero:
SI existe:
CORREO !!!!
WHILE haya lineas en el fichero:
leo 50 lineas
FOR: cada uno de los 50:
valido datos:
- dni... IF no cuela? a por otro CONTINUE
- emial.... si no cuela CONTINUE
calculo la edad
guardo en BBDD
COMMIT !
CORREO !!!!

    // Tradicionalmente el programador especifica la secuencia de decisiones y procedimientos que pueden darse durante el ciclo de vida de un programa mediante llamadas a funciones

---

public class MiApp{

    public static void main(String[] args){
        Spring.ejecuta(MiApp);
        // Si vosotros fuerais Spring... qué diriais en este punto? 
        // Cómo es esa App que quieres que ejecute? Cual es su configuración?
    }

}

---

Java annotations
----------------- 

Comienza en JAVA 1.5

@Deprecated
@Override

Qué es una anotación?
Instrucciones que damos al compilador

.java ----> javac  --->  .class
byte-code

Y el compilador de java: javac, procesa las anotaciones... en la mayor parte los casos, hace 2 tipos de operaciones:
- Validaciones
- Inyección de código

Lombok

public class Persona {



}

---

# MAVEN

Herramienta de automatización.

Me permite automatizar tareas habituales del proyecto.:
- Compilar
- Empaquetar
- Pruebas
- Ejecutar el código
- Mandarlo a SonarQube
- Gestión de dependencias
