package Notas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
* Esta clase define el punto de ingreso al programa de operaciones
* sobre notas. Por lo tanto, cuenta con un método main de acceso al
* programa.
* @version 1.2/2020
*/
public class Principal {
/**
* Método main que sirve de punto de entrada al programa
*/
public static void main(String[] args) {
VentanaPrincipal miVentanaPrincipal; /* Define la ventana
principal */
miVentanaPrincipal= new VentanaPrincipal(); /* Crea la ventana
principal */
miVentanaPrincipal.setVisible(true); /* Establece la ventana
como visible */
}
}

class Notas {
double[] listaNotas; /* Atributo que identifica un array de notas de
tipo double */
/**
* Constructor de la clase Notas, instancia un array con 5 notas de
* tipo double
*/
public Notas() {
    listaNotas = new double[5]; // Crea un array de 5 notas
}
/**
* Método que calcula el promedio de notas
* @return El promedio de notas calculado
*/
double calcularPromedio() {
double suma = 0;
for(int i=1; i < listaNotas.length; i++) { // Se recorre el array
suma = suma + listaNotas[i]; // Suma las notas del array
}
/* Obtiene el promedio como la división de la suma de notas
sobre el total de notas */
return (suma / listaNotas.length);
}

double calcularDesviación() {
double prom = calcularPromedio(); /* Invoca el método para
calcular el promedio */
double suma = 0;
for(int i=0; i < listaNotas.length; i++) {
// Aplica fórmula para la sumatoria de elementos
suma += Math.pow(listaNotas[i] - prom, 2 );
}
return Math.sqrt (suma/listaNotas.length ); /* Retorna el cálculo
final de la desviación */
}
/**
* Método que calcula el valor menor del array de notas
* @return El valor menor del array de notas
*/
double calcularMenor() {
double menor = listaNotas[0]; /* Define una variable como la
nota menor */
for(int i=0; i < listaNotas.length; i++) { // Se recorre el array
if (listaNotas[i] < menor) {
/* Si un elemento del array es menor que el menor actual,
se actualiza su valor */
menor = listaNotas[i];
}
}
return menor;
}
/**
* Método que calcula el valor mayor del array de notas
* @return El valor mayor del array de notas
*/
double calcularMayor() {
double mayor = listaNotas[0]; /* Define una variable como la
nota mayor */
for(int i=0; i < listaNotas.length; i++) { // Se recorre el array
if (listaNotas[i] > mayor) {
    mayor = listaNotas[i];
}
}
return mayor;
}
}

class VentanaPrincipal extends JFrame implements
ActionListener {
// Un contenedor de elementos gráficos
private Container contenedor;
// Etiquetas estáticas de cada nota
private JLabel nota1, nota2, nota3, nota4, nota5, promedio,desviación, mayor, menor;
// Campos de ingreso de cada nota
private JTextField campoNota1, campoNota2, campoNota3,campoNota4, campoNota5;
// Botones para realizar cálculos y para borrar las notas
private JButton calcular, limpiar;
/**
* Constructor de la clase VentanaPrincipal
*/
public VentanaPrincipal(){
inicio();
setTitle("Notas"); // Establece el título de la ventana
setSize(280,380); // Establece el tamaño de la ventana
setLocationRelativeTo(null); /* La ventana se posiciona en el
centro de la pantalla */
// Establece que el botón de cerrar permitirá salir de la aplicación
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setResizable(false); /* Establece que el tamaño de la ventana no
se puede cambiar */
}
/**
* Método que crea la ventana con sus diferentes componentes
* gráficos
*/
private void inicio() {
contenedor = getContentPane(); /* Obtiene el panel de
contenidos de la ventana */
contenedor.setLayout(null); /* Establece que el contenedor no
tiene un layout */
// Establece la etiqueta y el campo de texto de la nota 1
nota1 = new JLabel();
nota1.setText("Nota 1:");
nota1.setBounds(20, 20, 135, 23); /* Establece la posición de la
etiqueta nota 1 */
campoNota1 = new JTextField();
// Establece la posición del campo de texto de la nota 1
campoNota1.setBounds(105, 20, 135, 23);
// Establece la etiqueta y el campo de texto de la nota 2
nota2 = new JLabel();
nota2.setText("Nota 2:");
nota2.setBounds(20, 50, 135, 23); /* Establece la posición de la
etiqueta nota 2 */
campoNota2 = new JTextField();
// Establece la posición del campo de texto de la nota 2
campoNota2.setBounds(105, 50, 135, 23);
// Establece la etiqueta y el campo de texto de la nota 3
nota3 = new JLabel();
nota3.setText("Nota 3:");
nota3.setBounds(20, 80, 135, 23); /* Establece la posición de la
etiqueta nota 3*/
campoNota3 = new JTextField();
campoNota3.setBounds(105, 80, 135, 23);
// Establece la etiqueta y el campo de texto de la nota 4
nota4 = new JLabel();
nota4.setText("Nota 4:");
nota4.setBounds(20, 110, 135, 23); /* Establece la posición de la
etiqueta nota 4 */
campoNota4 = new JTextField();
// Establece la posición del campo de texto de la nota 4
campoNota4.setBounds(105, 110, 135, 23);
// Establece la etiqueta y el campo de texto de la nota 5
nota5 = new JLabel();
nota5.setText("Nota 5:");
nota5.setBounds(20, 140, 135, 23); /* Establece la posición de la
etiqueta nota 5 */
campoNota5 = new JTextField();
// Establece la posición del campo de texto de la nota 5
campoNota5.setBounds(105, 140, 135, 23);
// Establece el botón Calcular
calcular = new JButton();
calcular.setText("Calcular");
calcular.setBounds(20, 170, 100, 23); /* Establece la posición
del botón Calcular */
/* Agrega al botón un ActionListener para que gestione eventos
del botón */
calcular.addActionListener(this);
// Establece el botón Limpiar
limpiar = new JButton();
limpiar.setText("Limpiar");
limpiar.setBounds(125, 170, 80, 23); /* Establece la posición del
botón Limpiar */
/* Agrega al botón un ActionListener para que gestione eventos
del botón */
limpiar.addActionListener(this);
// Establece la etiqueta del promedio con su valor numérico
promedio = new JLabel();
promedio.setText("Promedio = ");
promedio.setBounds(20, 210, 135, 23);
desviación = new JLabel();
desviación.setText("Desviación = ");
desviación.setBounds(20, 240, 200, 23); /* Establece la posición
de la etiqueta desviación */
// Establece la etiqueta de la nota mayor con su valor numérico
mayor = new JLabel();
mayor.setText("Nota mayor = ");
mayor.setBounds(20, 270, 120, 23); /* Establece la posición de
la etiqueta nota mayor */
// Establece la etiqueta de la nota menor con su valor numérico
menor = new JLabel();
menor.setText("Nota menor = ");
menor.setBounds(20, 300, 120, 23); /* Establece la posición de
la etiquete nota menor */
// Se añade cada componente gráfico al contenedor de la ventana
contenedor.add(nota1);
contenedor.add(campoNota1);
contenedor.add(nota2);
contenedor.add(campoNota2);
contenedor.add(nota3);
contenedor.add(campoNota3);
contenedor.add(nota4);
contenedor.add(campoNota4);
contenedor.add(nota5);
contenedor.add(campoNota5);
contenedor.add(calcular);
contenedor.add(limpiar);
contenedor.add(promedio);
contenedor.add(desviación);
contenedor.add(mayor);
contenedor.add(menor);
}
/**
* Método que gestiona los eventos generados en la ventana principal
*/
@Override
public void actionPerformed(ActionEvent evento) {
    if (evento.getSource() == calcular) { /* Si se pulsa el botón
Calcular */
Notas notas = new Notas(); // Se crea un objeto Notas
// Se obtiene y convierte el valor numérico de la nota 1
notas.listaNotas[0] = Double.parseDouble(campoNota1.
getText());
// Se obtiene y convierte el valor numérico de la nota 2
notas.listaNotas[1] = Double.parseDouble(campoNota2.
getText());
// Se obtiene y convierte el valor numérico de la nota 3
notas.listaNotas[2] = Double.parseDouble(campoNota3.
getText());
// Se obtiene y convierte el valor numérico de la nota 4
notas.listaNotas[3] = Double.parseDouble(campoNota4.
getText());
// Se obtiene y convierte el valor numérico de la nota 5
notas.listaNotas[4] = Double.parseDouble(campoNota5.
getText());
notas.calcularPromedio(); // Se calcula el promedio
notas.calcularDesviación(); // Se calcula la desviación
// Se muestra el promedio formateado
promedio.setText("Promedio = " + String.valueOf(String.
format("%.2f",
notas.calcularPromedio())));
double desv = notas.calcularDesviación();
// Se muestra la desviación formateada
desviación.setText("Desviación estándar = " + String.
format("%.2f", desv));
// Se muestra el valor mayor formateado
mayor.setText("Valor mayor = " + String.valueOf(notas.
calcularMayor()));
// Se muestra el valor menor formateado
menor.setText("Valor menor = " + String.valueOf(notas.
calcularMenor()));
}
/* Se se pulsa el botón Limpiar se dejan en blanco los campos de
notas */
if (evento.getSource() == limpiar) {
campoNota1.setText("");
campoNota2.setText("");
campoNota3.setText("");
campoNota4.setText("");
campoNota5.setText("");
}
}
}