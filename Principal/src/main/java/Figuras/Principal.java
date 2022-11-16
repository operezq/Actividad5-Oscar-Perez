package Figuras;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal {

    public static void main(String[] args) {
VentanaPrincipal miVentanaPrincipal; /* Define la ventana
principal */
miVentanaPrincipal= new VentanaPrincipal(); /* Crea la ventana
principal */
miVentanaPrincipal.setVisible(true); /* Establece la ventana
como visible */
// Establece que la ventana no puede cambiar su tamaño
miVentanaPrincipal.setResizable(false);
}
}

class FiguraGeométrica {
    private double volumen;
    private double superficie; 
    public void setVolumen(double volumen) {
        this.volumen = volumen;
        }
    public void setSuperficie(double superficie) {
        this.superficie = superficie;
        }

public double getVolumen() {
    return this.volumen;
    }

public double getSuperficie() {
    return this.superficie;
    }
}
class Cilindro extends FiguraGeométrica {
    private double radio; // Atributo que establece el radio de un cilindro
    private double altura;
    public Cilindro(double radio, double altura) {
        this.radio = radio;
        this.altura = altura;
        this.setVolumen(calcularVolumen());
        this.setSuperficie(calcularSuperficie()); 
    }

    public double calcularVolumen() {
        double volumen = Math.PI * altura * Math.pow(radio, 2.0);
        return volumen;
        }

public double calcularSuperficie() {
    double áreaLadoA = 2.0 * Math.PI * radio * altura;
    double áreaLadoB = 2.0 * Math.PI * Math.pow(radio, 2.0);
    return áreaLadoA + áreaLadoB;
    }
}
class Esfera extends FiguraGeométrica {
    private double radio;
    public Esfera(double radio) {
        this.radio = radio;
        this.setVolumen(calcularVolumen()); /* Calcula el volumen y
        establece su atributo */
        this.setSuperficie(calcularSuperficie()); 
        }

public double calcularVolumen() {
    double volumen = 1.333 * Math.PI * Math.pow(this.radio, 3.0);
    return volumen;
    }

public double calcularSuperficie() {
    double superficie = 4.0 * Math.PI * Math.pow(this.radio, 2.0);
    return superficie;
    }
}
class Piramide extends FiguraGeométrica {
    private double base; /* Atributo que identifica la base de una
    pirámide */
    private double altura;
    private double apotema; 
    public Piramide(double base, double altura, double apotema) {
        this.base = base;
        this.altura = altura;
        this.apotema = apotema;
        this.setVolumen(calcularVolumen());
        this.setSuperficie(calcularSuperficie());
    }

    public double calcularVolumen() {
        double volumen = (Math.pow(base, 2.0) * altura) / 3.0;
        return volumen;
    }

    public double calcularSuperficie() {
        double áreaBase = Math.pow(base, 2.0);
        double áreaLado = 2.0 * base * apotema;
        return áreaBase + áreaLado;
    }
}
class VentanaCilindro extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel radio, altura, volumen, superficie;
    private JTextField campoRadio, campoAltura;
    private JButton calcular;
    public VentanaCilindro() {
    inicio();
    setTitle("Cilindro");
    setSize(280,210);
    setLocationRelativeTo(null);
    setResizable(false); 
    }
private void inicio() {
    contenedor = getContentPane();
    contenedor.setLayout(null); 
    radio = new JLabel();
    radio.setText("Radio (cms):");
    radio.setBounds(20, 20, 135, 23); 
    campoRadio = new JTextField();
    campoRadio.setBounds(100, 20, 135, 23);
    altura = new JLabel();
    altura.setText("Altura (cms):");
    altura.setBounds(20, 50, 135, 23);
    campoAltura = new JTextField();
    campoAltura.setBounds(100, 50, 135, 23);
    calcular = new JButton();
    calcular.setText("Calcular");
    calcular.setBounds(100, 80, 135, 23); 
    calcular.addActionListener(this);
    volumen = new JLabel();
    volumen.setText("Volumen (cm3):");
    volumen.setBounds(20, 110, 135, 23);
    superficie = new JLabel();
    superficie.setText("Superficie (cm2):");
    superficie.setBounds(20, 140, 135, 23);
    contenedor.add(radio);
    contenedor.add(campoRadio);
    contenedor.add(altura);
    contenedor.add(campoAltura);
    contenedor.add(calcular);
    contenedor.add(volumen);
    contenedor.add(superficie);
    }

    public void actionPerformed(ActionEvent event) {
        boolean error = false; /* Se inicializa variable para determinar si
        ocurre un error */
        double radio = 0;
        double altura = 0;
        try {
            radio = Double.parseDouble(campoRadio.getText());
            altura = Double.parseDouble(campoAltura.getText());
            Cilindro cilindro = new Cilindro(radio, altura); 
            volumen.setText("Volumen (cm3): " + String.format(".2f",cilindro.calcularVolumen()));
            
            superficie.setText("Superficie (cm2): " + String.format("%.2f",cilindro.calcularSuperficie()));
            } catch (Exception e){
                error = true;
            } finally {
                if(error) { 
                JOptionPane.showMessageDialog(null,"Campo nulo o error en formato de numero","Error", JOptionPane.ERROR_MESSAGE);
                }
        }
    }
}
class VentanaEsfera extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel radio, volumen, superficie;
    private JTextField campoRadio;
    private JButton calcular;
    
    public VentanaEsfera() {
    inicio();
    setTitle("Esfera");
    setSize(280,200); 
    setLocationRelativeTo(null);
    setResizable(false); 
    }
    private void inicio() {
    contenedor = getContentPane();
    contenedor.setLayout(null); 
    radio = new JLabel();
    radio.setText("Radio (cms):");
    radio.setBounds(20, 20, 135, 23);
    campoRadio = new JTextField();
    campoRadio.setBounds(100, 20, 135, 23);
    calcular = new JButton();
    calcular.setText("Calcular");
    calcular.setBounds(100, 50, 135, 23);
    calcular.addActionListener(this);
    volumen = new JLabel();
    volumen.setText("Volumen (cm3):");
    volumen.setBounds(20, 90, 135, 23);
    superficie = new JLabel();
    superficie.setText("Superficie (cm2):");
    superficie.setBounds(20, 120, 135, 23);
    contenedor.add(radio);
    contenedor.add(campoRadio);
    contenedor.add(calcular);
    contenedor.add(volumen);
    contenedor.add(superficie);
    }
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == calcular) { /* Si se pulsa el botón
        Calcular */
            boolean error = false;
            try {
            double radio = Double.parseDouble(campoRadio.getText());
            Esfera esfera = new Esfera(radio); 
            volumen.setText("Volumen (cm3): " + String.format("%.2f", esfera.calcularVolumen()));
            superficie.setText("Superficie (cm2): " + String.format("%.2f",esfera.calcularSuperficie()));
            } catch (Exception e) {
                error = true; // Si ocurre una excepción
            } finally {
                if(error) {
                    JOptionPane.showMessageDialog(null,"Campo nulo o error en formato de número","Error", JOptionPane.ERROR_MESSAGE);
                    }
            }
        }                    
    }
}
class VentanaPirámide extends JFrame implements
    ActionListener {
    private Container contenedor;
    private JLabel base, altura, apotema, volumen, superficie;
    private JTextField campoBase, campoAltura, campoApotema;
    private JButton calcular;

    public VentanaPirámide() {
    inicio();
    setTitle("Pirámide");  
    setSize(280,240);
    setLocationRelativeTo(null); 
    setResizable(false); 
    }
    
private void inicio() {
    contenedor = getContentPane();
    contenedor.setLayout(null);
    base = new JLabel();
    base.setText("Base (cms):");
    base.setBounds(20, 20, 135, 23);
    campoBase = new JTextField();
    campoBase.setBounds(120, 20, 135, 23);
    altura = new JLabel();
    altura.setText("Altura (cms):");
    altura.setBounds(20, 50, 135, 23);
    campoAltura = new JTextField();
    campoAltura.setBounds(120, 50, 135, 23);
    apotema = new JLabel();
    apotema.setText("Apotema (cms):");
    apotema.setBounds(20, 80, 135, 23);
    campoApotema = new JTextField();
    campoApotema.setBounds(120, 80, 135, 23);
    calcular = new JButton();
    calcular.setText("Calcular");
    calcular.setBounds(120, 110, 135, 23);
    calcular.addActionListener(this);
    volumen = new JLabel();
    volumen.setText("Volumen (cm3):");
    volumen.setBounds(20, 140, 135, 23);
// Establece la etiqueta y el valor de la superficie de la pirámide
    superficie = new JLabel();
    superficie.setText("Superficie (cm2):");
    superficie.setBounds(20, 170, 135, 23);
    contenedor.add(base);
    contenedor.add(campoBase);
    contenedor.add(altura);
    contenedor.add(campoAltura);
    contenedor.add(apotema);
    contenedor.add(campoApotema);
    contenedor.add(calcular);
    contenedor.add(volumen);
    contenedor.add(superficie);
    }
    public void actionPerformed(ActionEvent event) {
    Piramide pirámide;
    boolean error = false;
    double base = 0;
    double altura = 0;
    double apotema = 0;
    try {
    // Se obtiene y convierte el valor numérico de la base
    base = Double.parseDouble(campoBase.getText());
    // Se obtiene y convierte el valor numérico de la altura
    altura = Double.parseDouble(campoAltura.getText());
    // Se obtiene y convierte el valor numérico del apotema
    apotema = Double.parseDouble(campoApotema.getText());
    // Se crea un objeto Pirámide
    pirámide = new Piramide(base, altura, apotema);
    // Se muestra el volumen
    volumen.setText("Volumen (cm3): " + String.format("%.2f",pirámide.calcularVolumen()));
    superficie.setText("Superficie (cm2): " + String.format("%.2f",pirámide.calcularSuperficie()));
    } catch (Exception e) {
        error = true;
    } finally {
        if (error) {
        JOptionPane.showMessageDialog(null, "Campo nulo o error en formato de número","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
class VentanaPrincipal extends JFrame implements
    ActionListener {
    private Container contenedor;
    private JButton cilindro, esfera, pirámide;
    public VentanaPrincipal(){
        inicio();
        setTitle("Figuras");
        setSize(350,160); 
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void inicio() {
        contenedor = getContentPane(); 
        contenedor.setLayout(null); 
        cilindro = new JButton();
        cilindro.setText("Cilindro");
        cilindro.setBounds(20, 50, 80, 23);
        cilindro.addActionListener(this);
        esfera = new JButton();
        esfera.setText("Esfera");
        esfera.setBounds(125, 50, 80, 23);
        esfera.addActionListener(this);
        pirámide = new JButton();
        pirámide.setText("Pirámide");
        pirámide.setBounds(225, 50, 100, 23);
    pirámide.addActionListener(this);
    contenedor.add(cilindro);
    contenedor.add(esfera);
    contenedor.add(pirámide);
    }
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == esfera) { // Si se pulsa el botón esfera
            VentanaEsfera esfera = new VentanaEsfera();
            esfera.setVisible(true);
            }
        if (evento.getSource() == cilindro) {
            VentanaCilindro cilindro = new VentanaCilindro();
            cilindro.setVisible(true);
            }
        if (evento.getSource() == pirámide) {
        VentanaPirámide pirámide = new VentanaPirámide();
        pirámide.setVisible(true); 
        }
    }
}