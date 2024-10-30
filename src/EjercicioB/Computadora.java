package EjercicioB;

import java.util.HashSet;

public class Computadora {
    private String marca;
    private String modelo;
    private HashSet<ComponenteCPU> componentes;

    public Computadora(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
        this.componentes = new HashSet<>();    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void agregar_componente(ComponenteCPU componente) {
        this.componentes.add(componente);
    }

    public double calcular_costo_total() {
        double costoTotal = 0;
        for (ComponenteCPU componente : componentes) {
            costoTotal += componente.getPrecio() * componente.getCantidad();
        }
        return costoTotal;
    }

    public double calcular_precio_venta() {
        double costoTotal = calcular_costo_total();
        if (costoTotal < 50000) {
            return costoTotal * 1.4;
        } else {
            return costoTotal * 1.3;
        }
    }

    public void mostrarInformacion() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Componentes:");
        System.out.println("Componente\tMarca\tCantidad\tPrecio X Unidad\tSubTotal");
        for (ComponenteCPU componente : componentes) {
            System.out.println(componente.getComponente() + "\t" + componente.getMarca() + "\t" + componente.getCantidad() + "\t" + componente.getPrecio() + "\t" + (componente.getPrecio() * componente.getCantidad()));
        }
        System.out.println("Costo Total: " + calcular_costo_total());
        System.out.println("El precio sugerido de venta es: " + calcular_precio_venta());
    }
}

