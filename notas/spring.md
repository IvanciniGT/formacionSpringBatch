# Spring


# Inyección de dependencias

Que me pasen objetos

## OPCION 1:

Definiendo el dato que me interesa dentro de una clase como una propiedad... 
y añadiéndole la anotación @AUTOWIRE
    
    @Component
    public class MiClase {
    
        @Autowired
        private Dato elDatoQueMeInteresa;
    
    }

## OPCION 2:

Solicitando datos como argumentos en una función

    public class MiClase {
    
        @Bean
        public void miFuncion(Dato elDatoQueMeInteresa){
            /// Mi codigo que usa elDatoQueMeInteresa
        }
    
    }

### TRUCOS y notas

- Para que esto funcione, debe ser Spring el que cree la instancia... y no yo.
        new MiClase();              // RUINA 
  o el que llame a la función
        miClase.miFuncion();        // RUINA

- Cómo le digo a Spring que debe ser él el que genere una instancia de mi clase?
  Metiendo la anotación  @Component en mi clase.
    NOTA: @Component indica a Spring que una clase es un COMPONENTE de mi aplicación
  Opcionalmente puedo usar otras anotaciones que me aporten a mi (ser humano) más sentido.
    - @Service          Componente especializado en prestar servicios (LOGICA)
    - @Repository       Componente especializado en almacenar datos (PERSISTENCIA)
    - @Controller       Compoenente escpecializado en acceder a servicios (CONTROL/EXPOSICION)

- Cómo le digo a Spring que tiene que ser él, el que llame a una función?
    Poniendo a la función la anotación @Bean

- La anotación @Autowired está DESACONSEJADA DESDE HACE un tiempito!
  Alternativa:


    @Component
    public class MiClase {
    
        private Dato elDatoQueMeInteresa;

        public MiClase(Dato elDatoQueMeInteresa){
            this.elDatoQueMeInteresa = elDatoQueMeInteresa;
        }

        public void miFuncion(){    <<< La llamo yo
            // Hace lo que sea con elDatoQueMeInteresa 
        }
    }
    
  Ventaja: El objeto se inyecta desde el principio y está disponible en todo momento. 

---

# Y cómo sabe el Spring lo que tiene que dar?

## OPCION 1:

Jugamos siempre con Interfaces

    public interface ListenerAcabarMiProcesoBatch{
        onAcaba(Proceso p);
    }

    @Component       //  (@Repository     @Controller       @Service)
    public class MiListenerGenialDelProcesoQueHaceCosasGuays implements ListenerAcabarMiProcesoBatch {
        onAcaba(Proceso p){
            // Mandar email a tos los pringaos diciendo quel proceso p.getName() Acabó!!!!!
        }
    }

Cuando alguien pida un objeto de tipo ListenerAcabarMiProcesoBatch, 
Spring creará una instancia de la clase MiListenerGenialDelProcesoQueHaceCosasGuays (por llevar la anotación @Component)
Y será la instancia que se suministre (inyecte)

    @ComponentScan("com.curso.proceso1")
    public class ClaseQueNecesitaListener {

        public void configurarElListener(ListenerAcabarMiProcesoBatch listener){
            // QUE YO YA.... con el listener
        }        

    }

OJO, NOTA, CUIDAO, IMPORTANTE !!!!! MIRAR ESTO !!!!!

    @Component    
    public class MiClaseGuay{
        ...
    }

    public class ClaseQueNecesitaLaClaseGUAY {

        public ClaseQueNecesitaLaClaseGUAY(MiClaseGuay guay){
            // QUE YO YA.... con el guay
        }        

    }

Funcionaría? SI
    Pero... ME ACABO DE MEAR DE NUEVO EN EL Proncipio de Inversion de Dependencias, que decía?
    Las clases no pueden depender de IMPLEMENTACIONES... solo de Interfaces

NOTA: Queremos mucho al tio bob!!!! pero... los principios... bien sabido lo tenemos están para 
ROMPERLOS CUANDO ME SALGA DE LAS NARICES !

No siempre en la practica vamos a respetar este principio... HAbrá pequeñas licencias que nos tomaremos.
- Si estoy definiendo un POJO: Plain Old Java Object = Una clase pela' que solo tiene 4 propiedades y sus setter y sus getter.

## OPCION 2:

No siempre puedo usar la opción 1. Si puedes usar la opción 1, NO SIGAS LEYENDO LO QUE VIENE A CONTINUACION !!!

Imaginad que quiero que se suministre (inyecte) una instancia de una clase que no he creado yo.

    public class EtapaDeUnProcesoBatch {
    
        public void definirEtapa(ItemReader<Persona> lectorPersonas){
            // Que necesito aqui una instancia de esa clase LectorFicheroCSV
            // .... Step.reader(lectorPersonas)
        }

    }

    import springbatch.CSVFileItemReader;

    @Configuration
    public class LectorDePersonas {
        
        @Bean
        public ItemReader<Persona> configurarElItemReaderDePersonas(){
            return new CSVFileItemReader().setDelimiter(";");
        }
    
    }

Spring lo cierto es que no lee los ficheros que llevan funciones anotadas con @Bean
O si... pero... para ello, necesitamos anotar la clase que define funciones con @BEan, con la anotación @Configuration

Bueno.... podría ser TACHAN !!!! en este punto...
Pero... NOS FALTA UNA COSA MUY GORDA POR COMENTAR ACERCA DE SPRING

Cada vez que se solicite un objeto, Spring crea una instancia de ese objeto?

    @Component    
    public class MiClaseGuay{
        ...
    }

    public class ClaseQueNecesitaLaClaseGUAY {

        public ClaseQueNecesitaLaClaseGUAY(MiClaseGuay guay){
            // QUE YO YA.... con el guay
        }        

    }
    public class OtraClaseQueNecesitaLaClaseGUAY {

        public OtraClaseQueNecesitaLaClaseGUAY(MiClaseGuay guay){
            // QUE YO YA.... con el guay
        }        

    }

A la ClaseQueNecesitaLaClaseGUAY y a la OtraClaseQueNecesitaLaClaseGUAY, les va a mandar:
- La misma instancia de MiClaseGuay
- Distintas instancias de MiClaseGuay

La misma instancia.
Por defecto, Spring trata los @Component, @Service, @Controller, @Repositories como si fueran Singleton
Lo mismo pasa con las funciones @Bean... una vez que ha llamado a una funcion @Bean...guarda el resultado y no vuelve a llamar a esa función. 

## Singleton

Patrón de diseño que me asegura que de una clase solo se puede generar una instancia

    class MiSingleton {
    
        private static volatile instancia = null;
    
        private MiSingleton(){
        }
        public static MiSingleton getInstance(){
            if(instancia == null){
                synchronized(MiSingleton.class){
                    if(instancia == null)
                        instancia = new SMiSingleton();
                }
            }   
            return instancia;
        }
    }

Spring tiene otras 500 mil características y anotaciones
Esto es lo ultra-mínimo que necesito conocer para poder empezar a hacer cosas con SpringBatch.

----

Al crear mi app:

    @SpringBootApplication
    public class MiApp {
        public static void main(String [] args){
            SpringApplication.run(MiApp.class);
        }
    }

Esa anotación sustituye a otras 3 que usábamos antiguamente

    @ComponentScan
    @Configuration
    @EnableAutoConfiguration
