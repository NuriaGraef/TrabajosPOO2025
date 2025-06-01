import vista.VentanaIMC;
import controlador.IMCController;

public class Main {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            VentanaIMC vista = new VentanaIMC();
            new IMCController(vista); 
            vista.setVisible(true);
        });
    }
}
