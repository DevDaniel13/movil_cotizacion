package com.example.cotizacion;

public class Cotizacion{
    private int numCotizacion;
    private String descripcionAuto;
    private int precio;
    private int porcentajeInicial;
    private int plazo;

    public Cotizacion(){

    }
    public Cotizacion(int numCotizacion, String descripcionAuto, int precio, int porcentajeInicial, int plazo){
        this.numCotizacion=numCotizacion;
        this.descripcionAuto=descripcionAuto;
        this.precio=precio;
        this.porcentajeInicial=porcentajeInicial;
        this.plazo=plazo;
    }
    public Cotizacion(Cotizacion cotizacion){
        System.out.println("Numero de cotizacion: "+this.numCotizacion);
        System.out.println("Descripcion: "+this.descripcionAuto);
        System.out.println("Precio: "+this.precio);
        System.out.println("Porcentaje inicial: "+this.porcentajeInicial);
        System.out.println("Plazo: "+this.plazo);
    }

    public int getNumCotizacion() {
        return numCotizacion;
    }

    public void setNumCotizacion(int numCotizacion) {
        this.numCotizacion = numCotizacion;
    }

    public String getDescripcionAuto() {
        return descripcionAuto;
    }

    public void setDescripcionAuto(String descripcionAuto) {
        this.descripcionAuto = descripcionAuto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getPorcentajeInicial() {
        return porcentajeInicial;
    }

    public void setPorcentajeInicial(int porcentajeInicial) {
        this.porcentajeInicial = porcentajeInicial;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public int calculoInicial(){
        return this.precio*this.porcentajeInicial/100;
    }
    public int totalFinanciar(){
        return this.precio-calculoInicial();
    }
    public int pagoMensual(){
        return totalFinanciar()/this.plazo;
    }

    @Override
    public String toString() {
        return "Numero de cotizacion: " + numCotizacion +
                "\nDescripcion: " + descripcionAuto + '\'' +
                "\nPrecio: $" + precio +
                "\nPorcentaje inicial: %" + porcentajeInicial +
                "\nPlazo (meses): " + plazo;
    }
}
