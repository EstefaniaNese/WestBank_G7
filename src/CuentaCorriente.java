// Clase que representa una cuenta corriente bancaria
public class CuentaCorriente {
    // Atributos privados para encapsulamiento
    private int numero;
    private int saldo;

    // Constructor: recibe el número de cuenta y el saldo inicia en 0
    public CuentaCorriente(int numero) {
        this.numero = numero;
        this.saldo = 0;
    }

    // Métodos accesores (getters)
    public int getNumero() { return numero; }
    public int getSaldo() { return saldo; }

    // Método para depositar dinero en la cuenta
    public boolean depositar(int monto) {
        if (monto <= 0) {
            System.out.println("El monto debe ser mayor a cero.");
            return false;
        }
        saldo += monto;
        System.out.println("¡Depósito realizado de manera exitosa!");
        System.out.println("Usted tiene un saldo actual de " + saldo + " pesos");
        return true;
    }

    // Método para girar (retirar) dinero de la cuenta
    public boolean girar(int monto) {
        if (monto <= 0) {
            System.out.println("El monto debe ser mayor a cero.");
            return false;
        }
        if (monto > saldo) {
            System.out.println("No puede girar un monto mayor al saldo disponible.");
            return false;
        }
        saldo -= monto;
        System.out.println("¡Giro realizado de manera exitosa!");
        System.out.println("Usted tiene un saldo actual de " + saldo + " pesos");
        return true;
    }

    // Método para consultar el saldo actual de la cuenta
    public void consultarSaldo() {
        System.out.println("Saldo actual: " + saldo + " pesos");
    }
}
