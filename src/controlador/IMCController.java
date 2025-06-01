package controlador;

import modelo.IMC;
import vista.VentanaIMC;

public class IMCController {
    private VentanaIMC vista;

    public IMCController(VentanaIMC vista) {
        this.vista = vista;

        // Agregar evento al botón
        this.vista.getBtnCalcular().addActionListener(e -> calcularIMC());
    }

    private void calcularIMC() {
        try {
            String pesoTexto = vista.getTxtPeso().getText().trim();
            String alturaTexto = vista.getTxtAltura().getText().trim();

            if (pesoTexto.isEmpty() || alturaTexto.isEmpty()) {
                vista.getTxtResultado().setText("Debe completar ambos campos.");
                return;
            }

            double peso = Double.parseDouble(pesoTexto);
            double altura = Double.parseDouble(alturaTexto);

            if (peso <= 0 || altura <= 0) {
                vista.getTxtResultado().setText("Los valores deben ser positivos.");
                return;
            }

            IMC imc = new IMC(peso, altura);
            String resultado = String.format("IMC: %.2f\nEstado: %s\nConsejo: %s",
                    imc.calcularIMC(),
                    imc.obtenerEstado(),
                    imc.obtenerConsejo()
            );

            vista.getTxtResultado().setText(resultado);
            aplicarColorEstado(imc.obtenerEstado());

            
            vista.getTxtPeso().setText("");
            vista.getTxtAltura().setText("");

        } catch (NumberFormatException ex) {
            vista.getTxtResultado().setText("Ingrese solo números válidos.");
        }
    }

    private void aplicarColorEstado(String estado) {
        switch (estado) {
            case "Bajo peso":
                vista.getTxtResultado().setBackground(new java.awt.Color(255, 230, 204)); // naranja claro
                break;
            case "Peso saludable":
                vista.getTxtResultado().setBackground(new java.awt.Color(204, 255, 204)); // verde claro
                break;
            case "Sobrepeso":
                vista.getTxtResultado().setBackground(new java.awt.Color(255, 255, 153)); // amarillo
                break;
            case "Obesidad":
                vista.getTxtResultado().setBackground(new java.awt.Color(255, 153, 153)); // rojo claro
                break;
            default:
                vista.getTxtResultado().setBackground(java.awt.Color.WHITE);
        }
    }
}

