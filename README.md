# Kata 2 - Ingeniería de Software 2

## Objetivo
Practicar la entrada/salida de datos (I/O) en Java separando completamente la lógica del programa de los orígenes concretos de datos, utilizando programación 100% declarativa (Streams, Optional) sin usar bucles ni condicionales tradicionales.

## Dependencias y Entorno
* **Gestor:** Maven
* **JDK:** OpenJDK 27
* **Paquete:** `software.ulpgc.katas`

## Estructura de Clases
* **Modelo:** `Employee` (Record inmutable) y `Gender` (Enum).
* **Entrada (Loader):** `EmployeeLoader` (Interfaz) y `TsvEmployeeLoader` (Implementación declarativa que procesa un `InputStream` filtrando errores con `Optional`).
* **Salida (Writer):** `SummaryWriter` (Interfaz) y `TextSummaryWriter` (Escribe en cualquier `OutputStream`).
* **Main:** Conecta el InputStream, aplica una transformación declarativa agrupando los datos, y envía el resultado al OutputStream.

## Atajos de teclado utilizados
* **Alt + Insert:** Generación de código.
* **Alt + Enter:** Importación de clases y acciones rápidas.
* **Ctrl + Alt + L:** Formateo de código.
* **Shift + F10:** Compilación y ejecución rápida.
* **Ctrl + K / Ctrl + Shift + K:** Commit y Push.

## Repeticiones Deliberadas
La kata se ha repetido en 3 ramas distintas (`develop1`, `develop2` y `develop3`) antes de unirse a `master`:
1. **Repetición 1:** Fichero local (`FileInputStream`) a Consola (`System.out`), agrupando por departamento.
2. **Repetición 2:** Internet (`URL.openStream`) a Fichero (`FileOutputStream`), agrupando por género.
3. **Repetición 3:** Preparación final, verificación de control de errores y merge para el vídeo.

## Ejecución por terminal
1. Clonar: `git clone https://github.com/[TU-USUARIO]/kata2.git`
2. Compilar: `javac src/main/java/software/ulpgc/katas/**/*.java -d out`
3. Ejecutar: `java -cp out software.ulpgc.katas.Main`

## Vídeo Explicativo
https://drive.google.com/file/d/1N-g6WbwYFlR-TiFQvJSjkxyhwozWk3NZ/view?usp=drive_link
