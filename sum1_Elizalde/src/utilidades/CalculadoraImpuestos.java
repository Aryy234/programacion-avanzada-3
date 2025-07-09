package utilidades;

public class CalculadoraImpuestos {
    private double tasaIVA;
    private double tasaServicio;

    public CalculadoraImpuestos(double tasaIVA, double tasaServicio){
        this.tasaIVA = tasaIVA;
        this.tasaServicio = tasaServicio;
    }

    public double calcularTotalImperativa(double precioBase){
        double  iva = precioBase * tasaIVA;
        double servicio = precioBase * tasaServicio;
        return precioBase+iva+servicio;

    }

    public static Function<Double, 
        Function<Double, 
            Function<Double, Double>>>
            calcularTotalFuncional =
            tasaIVAfun -> tasaServiciofun -> precioBasefun ->
                    precioBasefun + (precioBasefun * tasaIVAfun) + (precioBasefun * tasaServiciofun);

    Function<CalculadoraImpuestos, 
            Function<Double, Double>>
            calcularTotalFuncional2 =
            calculadoraImpuestos -> precioBasefun ->
                    precioBasefun + (precioBasefun * calculadoraImpuestos.tasaIVA) + (precioBasefun * calculadoraImpuestos.tasaServicio);
                    

    @Override
    public String toString() {
        return "CalculadoraImpuestos{" +
                "tasaIVA=" + tasaIVA +
                ", tasaServicio=" + tasaServicio +
                '}';
    }






}
