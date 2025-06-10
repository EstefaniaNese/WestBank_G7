// Clase que representa a un cliente del banco
public class Cliente {
    // Atributos privados para encapsulamiento
    private String rut;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String domicilio;
    private String comuna;
    private String telefono;
    private CuentaCorriente cuenta; // Asociación con la clase CuentaCorriente

    // Constructor con parámetros para inicializar todos los datos del cliente y su cuenta
    public Cliente(String rut, String nombre, String apellidoPaterno, String apellidoMaterno,
                   String domicilio, String comuna, String telefono, int numeroCuenta) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.domicilio = domicilio;
        this.comuna = comuna;
        this.telefono = telefono;
        // Al crear un cliente, se crea automáticamente su cuenta corriente con saldo 0
        this.cuenta = new CuentaCorriente(numeroCuenta);
    }

    // Métodos accesores (getters)
    public String getRut() { return rut; }
    public CuentaCorriente getCuenta() { return cuenta; }

    // Método para mostrar todos los datos del cliente, incluyendo los de la cuenta
    public void mostrarDatos() {
        System.out.println("Rut: " + rut);
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido paterno: " + apellidoPaterno);
        System.out.println("Apellido materno: " + apellidoMaterno);
        System.out.println("Domicilio: " + domicilio);
        System.out.println("Comuna: " + comuna);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Número de cuenta corriente: " + cuenta.getNumero());
        System.out.println("Saldo: " + cuenta.getSaldo() + " pesos");
    }
}
