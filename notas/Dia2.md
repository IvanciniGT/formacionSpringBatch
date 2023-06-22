
# Proceso Batch

Spring Batch es una librería dentro del framework Spring que nos ayuda con estos temas.

## Nombres específicos de esta librería

JOB <- Proceso Batch
 |- Step 1 <- Etapas
 |- Step 2
        |- ItemReader       <- Listener (Me ayuda a capturar eventos) Cuando epiece el reader... o cuando acabe haz tal cosa
        |- ItemProcessor
        |- IterWriter

JobLauncher
JobRepository
JobBuilder
StepBuilder

Los JOBS operan sobre Items: Unidad de información sobre la que opero

---

# Ejemplo: Un proceso típico ETL 

Fichero             -->  Sobre las personas hacer:   -->    BBDD
Datos de personas           - Validar datos     
                            - Filtros
                            - Calcular campos

---

OPCIONES SPRINGBATCH:
- RAPIDA = MIERDA ! = Por todos los tutoriales cutres de internet !
- GUAY              = Os voy a enseñar yo... pero es dura de cojones !!!!

