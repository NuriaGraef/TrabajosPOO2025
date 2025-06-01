package modelo;

public class IMC {
    private double peso;
    private double altura;

    public IMC(double peso, double altura) {
        this.peso = peso;
        this.altura = altura;
    }

    public double calcularIMC() {
        return peso / (altura * altura);
    }

    public String obtenerEstado() {
        double imc = calcularIMC();
        if (imc < 18.5) {
            return "Bajo peso";
        } else if (imc < 25.0) {
            return "Peso saludable";
        } else if (imc < 30.0) {
            return "Sobrepeso";
        } else {
            return "Obesidad";
        }
    }

    public String obtenerConsejo() {
        String estado = obtenerEstado();
        switch (estado) {
            case "Bajo peso":
                return "Deberías consultar con un nutricionista para aumentar de peso saludablemente.";
            case "Peso saludable":
                return "¡Buen trabajo! Mantén una dieta equilibrada y actividad física.";
            case "Sobrepeso":
                return "Se recomienda mejorar la alimentación y hacer ejercicio regular.";
            case "Obesidad":
                return "Es importante buscar ayuda médica y adoptar hábitos saludables.";
            default:
                return "";
        }
    }
}
