package com.example.cotizacion;

public class Cotizacion{
    private int id;
    private String descripcion;
    private int precio;
    private int porcentaje;
    private int plazo;

    public Cotizacion(){

    }
    public Cotizacion(int id, String descripcion, int precio, int porcentaje, int plazo){
        this.id = id;
        this.descripcion = descripcion;
        this.precio = precio;
        this.porcentaje = porcentaje;
        this.plazo = plazo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public int calculoInicial(){
        return this.precio*this.porcentaje/100;
    }

    public int totalFinanciar(){
        return this.precio-calculoInicial();
    }

    public int pagoMensual(){
        return totalFinanciar()/this.plazo;
    }

    @Override
    public String toString() {
        return "Numero de cotizacion: " + id +
                "\nDescripcion: " + descripcion +
                "\nPrecio: $" + precio +
                "\nPorcentaje inicial: %" + porcentaje +
                "\nPlazo (meses): " + plazo;
    }
}
