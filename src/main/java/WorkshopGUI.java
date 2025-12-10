import javax.swing.*;

public class WorkshopGUI extends JFrame {
    private JPanel panelPrincipal;
    private JTabbedPane tabbedPane;

    // Pestaña Matemáticas
    private JPanel panelMatematicas;
    private JTextField txtNum1;
    private JTextField txtNum2;
    private JTextField txtNum3;
    private JButton btnSumar;
    private JButton btnMayor;
    private JButton btnFactorial;
    private JButton btnPrimo;
    private JButton btnFibonacci;
    private JTextArea txtResultadoMath;

    // Pestaña Arreglos
    private JPanel panelArreglos;
    private JTextField txtArreglo;
    private JButton btnSumaArray;
    private JButton btnPromedioArray;
    private JButton btnMayorArray;
    private JButton btnMenorArray;
    private JButton btnOrdenar;
    private JButton btnInvertir;
    private JTextArea txtResultadoArray;

    // Pestaña Cadenas
    private JPanel panelCadenas;
    private JTextField txtCadena;
    private JButton btnMayusculas;
    private JButton btnMinusculas;
    private JButton btnInvertirCadena;
    private JButton btnPalindromo;
    private JButton btnContarCaracteres;
    private JButton btnContarPalabras;
    private JButton btnValidarEmail;
    private JTextArea txtResultadoCadena;

    // Pestaña Juego
    private JPanel panelJuego;
    private JLabel lblEstadisticas;
    private JButton btnPiedra;
    private JButton btnPapel;
    private JButton btnTijera;
    private JButton btnLagarto;
    private JButton btnSpock;
    private JTextArea txtHistorialJuego;

    // Pestaña Conversiones
    private JPanel panelConversiones;
    private JTextField txtNumDecimal;
    private JButton btnConvertir;
    private JLabel lblDecimal;
    private JLabel lblBinario;
    private JLabel lblHexadecimal;

    private Workshop workshop;
    private int victorias = 0;
    private int derrotas = 0;
    private int empates = 0;

    public WorkshopGUI() {
        workshop = new Workshop();
        setContentPane(panelPrincipal);
        setTitle("Workshop - Programación Orientada a Objetos");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        configurarEventos();
    }

    private void configurarEventos() {
        // Eventos Matemáticas
        btnSumar.addActionListener(e -> {
            try {
                int a = Integer.parseInt(txtNum1.getText());
                int b = Integer.parseInt(txtNum2.getText());
                int resultado = workshop.sumarDosNumeros(a, b);
                txtResultadoMath.setText("Resultado: " + a + " + " + b + " = " + resultado);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese números válidos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnMayor.addActionListener(e -> {
            try {
                int a = Integer.parseInt(txtNum1.getText());
                int b = Integer.parseInt(txtNum2.getText());
                int c = Integer.parseInt(txtNum3.getText());
                int mayor = workshop.mayorDeTresNumeros(a, b, c);
                txtResultadoMath.setText("El mayor entre " + a + ", " + b + " y " + c + " es: " + mayor);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese los tres números", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnFactorial.addActionListener(e -> {
            try {
                int n = Integer.parseInt(txtNum1.getText());
                if (n > 20) {
                    JOptionPane.showMessageDialog(this, "El número debe ser ≤ 20", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                int factorial = workshop.factorial(n);
                txtResultadoMath.setText("Factorial de " + n + " = " + factorial);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese un número válido", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnPrimo.addActionListener(e -> {
            try {
                int n = Integer.parseInt(txtNum1.getText());
                boolean esPrimo = workshop.esPrimo(n);
                txtResultadoMath.setText(n + (esPrimo ? " ES un número primo" : " NO es un número primo"));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese un número válido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnFibonacci.addActionListener(e -> {
            try {
                int n = Integer.parseInt(txtNum1.getText());
                int[] fibonacci = workshop.serieFibonacci(n);
                StringBuilder sb = new StringBuilder("Serie de Fibonacci (" + n + " términos):\n");
                for (int i = 0; i < fibonacci.length; i++) {
                    sb.append(fibonacci[i]);
                    if (i < fibonacci.length - 1) sb.append(", ");
                }
                txtResultadoMath.setText(sb.toString());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese un número válido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Eventos Arreglos
        btnSumaArray.addActionListener(e -> {
            try {
                int[] arr = parseArray(txtArreglo.getText());
                int suma = workshop.sumaElementos(arr);
                txtResultadoArray.setText("Arreglo: " + arrayToString(arr) + "\n\nSuma total: " + suma);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al procesar el arreglo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnPromedioArray.addActionListener(e -> {
            try {
                int[] arr = parseArray(txtArreglo.getText());
                double promedio = workshop.promedioElementos(arr);
                txtResultadoArray.setText("Arreglo: " + arrayToString(arr) + "\n\nPromedio: " + String.format("%.2f", promedio));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al procesar el arreglo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnMayorArray.addActionListener(e -> {
            try {
                int[] arr = parseArray(txtArreglo.getText());
                int mayor = workshop.encontrarElementoMayor(arr);
                txtResultadoArray.setText("Arreglo: " + arrayToString(arr) + "\n\nElemento mayor: " + mayor);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al procesar el arreglo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnMenorArray.addActionListener(e -> {
            try {
                int[] arr = parseArray(txtArreglo.getText());
                int menor = workshop.encontrarElementoMenor(arr);
                txtResultadoArray.setText("Arreglo: " + arrayToString(arr) + "\n\nElemento menor: " + menor);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al procesar el arreglo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnOrdenar.addActionListener(e -> {
            try {
                int[] arr = parseArray(txtArreglo.getText());
                int[] ordenado = workshop.ordenarArreglo(arr);
                txtResultadoArray.setText("Arreglo original: " + arrayToString(arr) +
                        "\n\nArreglo ordenado: " + arrayToString(ordenado));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al procesar el arreglo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnInvertir.addActionListener(e -> {
            try {
                int[] arr = parseArray(txtArreglo.getText());
                int[] invertido = workshop.invertirArreglo(arr);
                txtResultadoArray.setText("Arreglo original: " + arrayToString(arr) +
                        "\n\nArreglo invertido: " + arrayToString(invertido));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al procesar el arreglo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Eventos Cadenas
        btnMayusculas.addActionListener(e -> {
            String resultado = workshop.convertirAMayusculas(txtCadena.getText());
            txtResultadoCadena.setText("Original: " + txtCadena.getText() + "\n\nEn MAYÚSCULAS: " + resultado);
        });

        btnMinusculas.addActionListener(e -> {
            String resultado = workshop.convertirAMinusculas(txtCadena.getText());
            txtResultadoCadena.setText("Original: " + txtCadena.getText() + "\n\nEn minúsculas: " + resultado);
        });

        btnInvertirCadena.addActionListener(e -> {
            String resultado = workshop.invertirCadena(txtCadena.getText());
            txtResultadoCadena.setText("Original: " + txtCadena.getText() + "\n\nInvertida: " + resultado);
        });

        btnPalindromo.addActionListener(e -> {
            boolean esPalindromo = workshop.esPalindromo(txtCadena.getText());
            txtResultadoCadena.setText("Texto: \"" + txtCadena.getText() + "\"\n\n¿Es palíndromo?: " +
                    (esPalindromo ? "SÍ ✓" : "NO ✗"));
        });

        btnContarCaracteres.addActionListener(e -> {
            int count = workshop.contarCaracteres(txtCadena.getText());
            txtResultadoCadena.setText("Texto: \"" + txtCadena.getText() + "\"\n\nCantidad de caracteres: " + count);
        });

        btnContarPalabras.addActionListener(e -> {
            int count = workshop.contarPalabras(txtCadena.getText());
            txtResultadoCadena.setText("Texto: \"" + txtCadena.getText() + "\"\n\nCantidad de palabras: " + count);
        });

        btnValidarEmail.addActionListener(e -> {
            boolean valido = workshop.validarCorreoElectronico(txtCadena.getText());
            txtResultadoCadena.setText("Email: " + txtCadena.getText() + "\n\nValidación: " +
                    (valido ? "✓ VÁLIDO" : "✗ INVÁLIDO"));
        });

        // Eventos Juego
        btnPiedra.addActionListener(e -> jugar("Piedra"));
        btnPapel.addActionListener(e -> jugar("Papel"));
        btnTijera.addActionListener(e -> jugar("Tijera"));
        btnLagarto.addActionListener(e -> jugar("Lagarto"));
        btnSpock.addActionListener(e -> jugar("Spock"));

        // Eventos Conversiones
        btnConvertir.addActionListener(e -> {
            try {
                int num = Integer.parseInt(txtNumDecimal.getText());
                String binario = workshop.convertirABinario(num);
                String hex = workshop.convertirAHexadecimal(num);

                lblDecimal.setText("Decimal: " + num);
                lblBinario.setText("Binario: " + binario);
                lblHexadecimal.setText("Hexadecimal: " + hex);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese un número válido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private void jugar(String eleccion) {
        String resultado = workshop.jugarPiedraPapelTijeraLagartoSpock(eleccion);

        if (resultado.equals("Ganaste")) victorias++;
        else if (resultado.equals("Perdiste")) derrotas++;
        else empates++;

        lblEstadisticas.setText("Victorias: " + victorias + " | Derrotas: " + derrotas + " | Empates: " + empates);

        String historialActual = txtHistorialJuego.getText();
        String emoji = resultado.equals("Ganaste") ? "✓" : resultado.equals("Perdiste") ? "✗" : "=";
        txtHistorialJuego.setText(emoji + " Jugaste: " + eleccion + " - " + resultado + "\n" + historialActual);
    }

    private int[] parseArray(String text) {
        String[] parts = text.split(",");
        int[] array = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            array[i] = Integer.parseInt(parts[i].trim());
        }
        return array;
    }

    private String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            WorkshopGUI gui = new WorkshopGUI();
            gui.setVisible(true);
        });
    }
}