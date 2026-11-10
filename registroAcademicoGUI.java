package registroacademico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class RegistroAcademicoGUI extends JFrame {

    private JTextField txtNombre;
    private JTextField txtMatricula;
    private JTextField txtCarrera;
    private JTextField txtPracticas;
    private JTextField txtParciales;
    private JTextField txtAsignaciones;
    private JTextField txtExamenFinal;
    private JButton btnCalcular;
    private JTextArea txtResultado;

    public RegistroAcademicoGUI() {
        setTitle("Registro Académico");
        setSize(500, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel panelCampos = new JPanel(new GridLayout(7, 2, 8, 8));
        panelCampos.setBorder(BorderFactory.createEmptyBorder(15, 15, 10, 15));

        panelCampos.add(new JLabel("Nombre completo:"));
        txtNombre = new JTextField();
        panelCampos.add(txtNombre);

        panelCampos.add(new JLabel("Matrícula:"));
        txtMatricula = new JTextField();
        panelCampos.add(txtMatricula);

        panelCampos.add(new JLabel("Carrera:"));
        txtCarrera = new JTextField();
        panelCampos.add(txtCarrera);

        panelCampos.add(new JLabel("Prácticas (Máx 40):"));
        txtPracticas = new JTextField();
        panelCampos.add(txtPracticas);

        panelCampos.add(new JLabel("Parciales (Máx 20):"));
        txtParciales = new JTextField();
        panelCampos.add(txtParciales);

        panelCampos.add(new JLabel("Asignaciones (Máx 20):"));
        txtAsignaciones = new JTextField();
        panelCampos.add(txtAsignaciones);

        panelCampos.add(new JLabel("Examen Final (Máx 20):"));
        txtExamenFinal = new JTextField();
        panelCampos.add(txtExamenFinal);

        btnCalcular = new JButton("Calcular Resultado");
        btnCalcular.addActionListener((ActionEvent e) -> calcular());
        JPanel panelBoton = new JPanel();
        panelBoton.add(btnCalcular);

        txtResultado = new JTextArea(8, 30);
        txtResultado.setEditable(false);
        JScrollPane scroll = new JScrollPane(txtResultado);
        scroll.setBorder(BorderFactory.createEmptyBorder(0, 15, 15, 15));

        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.add(panelCampos, BorderLayout.CENTER);
        panelSuperior.add(panelBoton, BorderLayout.SOUTH);

        add(panelSuperior, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
    }

    private void calcular() {
        String nombre = txtNombre.getText().trim();
        String matricula = txtMatricula.getText().trim();
        String carrera = txtCarrera.getText().trim();

        if (nombre.isEmpty() || matricula.isEmpty() || carrera.isEmpty() ||
            txtPracticas.getText().trim().isEmpty() || txtParciales.getText().trim().isEmpty() ||
            txtAsignaciones.getText().trim().isEmpty() || txtExamenFinal.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos deben estar completos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double practicas, parciales, asignaciones, examenFinal;

        try {
            practicas = Double.parseDouble(txtPracticas.getText().trim());
            parciales = Double.parseDouble(txtParciales.getText().trim());
            asignaciones = Double.parseDouble(txtAsignaciones.getText().trim());
            examenFinal = Double.parseDouble(txtExamenFinal.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Las calificaciones deben ser números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (practicas < 0 || practicas > 40) {
            JOptionPane.showMessageDialog(this, "Prácticas debe estar entre 0 y 40.", "Error de Rango", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (parciales < 0 || parciales > 20) {
            JOptionPane.showMessageDialog(this, "Parciales debe estar entre 0 y 20.", "Error de Rango", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (asignaciones < 0 || asignaciones > 20) {
            JOptionPane.showMessageDialog(this, "Asignaciones debe estar entre 0 y 20.", "Error de Rango", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (examenFinal < 0 || examenFinal > 20) {
            JOptionPane.showMessageDialog(this, "Examen Final debe estar entre 0 y 20.", "Error de Rango", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Estudiante est = new Estudiante(nombre, matricula, carrera, practicas, parciales, asignaciones, examenFinal);
        double total = est.calcularNotaFinal();
        String estado = est.obtenerEstado();

        txtResultado.setText(
            "Estudiante: " + est.getNombreCompleto() + "\n" +
            "Matrícula: " + est.getMatricula() + "\n" +
            "Carrera: " + est.getCarrera() + "\n" +
            "------------------------------------------\n" +
            "Nota Total: " + total + " / 100\n" +
            "Estado: " + estado
        );
    }
}