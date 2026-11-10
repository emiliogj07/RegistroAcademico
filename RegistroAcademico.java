/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package registroacademico;
import javax.swing.SwingUtilities;
/**
 *
 * @author Emilio
 */
public class RegistroAcademico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new RegistroAcademicoGUI().setVisible(true);
        });
    }
    
}
