# Implementación y Análisis de Complejidad de Listas, Pilas y Colas en Java

Este repositorio contiene el código fuente y el análisis empírico del proyecto de estructuras de datos lineales, desarrollado para el curso de Estructuras de Datos (2026-1) de la Universidad Nacional de Colombia.

## 🎯 Objetivo del Proyecto
Implementar desde cero y analizar la complejidad temporal (teórica y empírica) de las operaciones fundamentales de estructuras de datos lineales en Java. El estudio contrasta el rendimiento algorítmico teórico (notación Big-O) con pruebas de rendimiento real en la Máquina Virtual de Java (JVM).

## 🏗️ Estructuras Implementadas

### 1. Listas Enlazadas (`List<T>`)
Se implementó una interfaz genérica con cuatro variaciones basadas en nodos para evaluar el impacto de los punteros adicionales en la memoria y el tiempo de ejecución:
* **Singly Linked List (SLL):** Lista simplemente enlazada sin referencia al final.
* **Singly Linked List con Tail (SLLT):** Lista simplemente enlazada con puntero a la cola.
* **Doubly Linked List (DLL):** Lista doblemente enlazada sin referencia al final.
* **Doubly Linked List con Tail (DLLT):** Lista doblemente enlazada con puntero bidireccional y referencia a la cola.

### 2. Pilas y Colas (`MyStack<T>` y `MyQueue<T>`)
Se implementaron utilizando **Arreglos Dinámicos** como estructura subyacente para evaluar el rendimiento de bloques de memoria contiguos frente a la asignación dinámica de nodos:
* **ArrayStack:** Implementación de pila (LIFO) con redimensionamiento dinámico y complejidad amortizada constante.
* **ArrayQueue:** Implementación de cola (FIFO) estructurada lógicamente como un **arreglo circular** para garantizar operaciones de extracción eficientes y evitar desplazamientos lineales.

## 📊 Metodología de Pruebas (Análisis Empírico)
El rendimiento empírico de cada método se evaluó realizando múltiples iteraciones incrementales (desde 10 hasta 10.000.000 de datos). 
* **Medición:** Se utilizó `System.nanoTime()` para garantizar precisión a nivel de nanosegundos al medir operaciones de memoria a muy bajo nivel.
* **Manejo de variables:** Las pruebas se diseñaron teniendo en cuenta el comportamiento de recolección de basura (Garbage Collector) y la compilación Just-In-Time (JIT) de Java.

## 👥 Equipo de Desarrollo (Grupo 8)
* Sebastian Gonzalez Giraldo
* Jerónimo Quiñones Rueda
* Juan Diego Cardona Cortés
* Jesus David Pinillos Rojas

**Universidad Nacional de Colombia** Facultad de Ingeniería, Bogotá, Colombia  
2026
