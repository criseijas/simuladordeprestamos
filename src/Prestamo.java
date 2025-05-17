public class Prestamo {

    private double monto;
    private double tasaAnual;
    private int plazoMeses;

    public Prestamo(double monto, double tasaAnual, int plazoMeses) {
        this.monto = monto;
        this.tasaAnual = tasaAnual;
        this.plazoMeses = plazoMeses;
    }

    public double getMonto() {
        return monto;
    }

    public double getTasaAnual() {
        return tasaAnual;
    }

    public int getPlazoMeses() {
        return plazoMeses;
    }
}
