/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pp3_josemario;

/**
 *
 * @author duart
 */

public class ListaDobleCircular {
    
    private NodoLista primero;
    private NodoLista ultimo;

    public ListaDobleCircular() {
        primero = null;
        ultimo = null;
    }

    public boolean estaVacia() {
        return primero == null;
    }

    public boolean existeCodigo(int codigo) {
        if (estaVacia()) {
            return false;
        }

        NodoLista aux = primero;

        do {
            if (aux.getProducto().getCodigo() == codigo) {
                return true;
            }
            aux = aux.getSiguiente();
        } while (aux != primero);

        return false;
    }

    public boolean insertarAlFinal(Producto producto) {
        if (existeCodigo(producto.getCodigo())) {
            return false;
        }

        NodoLista nuevo = new NodoLista(producto);

        if (estaVacia()) {
            primero = nuevo;
            ultimo = nuevo;
            primero.setSiguiente(primero);
            primero.setAnterior(primero);
        } else {
            nuevo.setAnterior(ultimo);
            nuevo.setSiguiente(primero);
            ultimo.setSiguiente(nuevo);
            primero.setAnterior(nuevo);
            ultimo = nuevo;
        }

        return true;
    }

    public String mostrarHaciaAdelante() {
        if (estaVacia()) {
            return "No hay productos en la lista.";
        }

        String texto = "";
        NodoLista aux = primero;

        do {
            texto = texto + aux.getProducto().mostrarDatos() + "\n-------------------\n";
            aux = aux.getSiguiente();
        } while (aux != primero);

        return texto;
    }

    public String mostrarHaciaAtras() {
        if (estaVacia()) {
            return "No hay productos en la lista.";
        }

        String texto = "";
        NodoLista aux = ultimo;

        do {
            texto = texto + aux.getProducto().mostrarDatos() + "\n-------------------\n";
            aux = aux.getAnterior();
        } while (aux != ultimo);

        return texto;
    }

    public boolean eliminarPorCodigo(int codigo) {
        if (estaVacia()) {
            return false;
        }

        NodoLista aux = primero;

        do {
            if (aux.getProducto().getCodigo() == codigo) {

                if (primero == ultimo) {
                    primero = null;
                    ultimo = null;
                    return true;
                }

                if (aux == primero) {
                    primero = primero.getSiguiente();
                    primero.setAnterior(ultimo);
                    ultimo.setSiguiente(primero);
                    return true;
                }

                if (aux == ultimo) {
                    ultimo = ultimo.getAnterior();
                    ultimo.setSiguiente(primero);
                    primero.setAnterior(ultimo);
                    return true;
                }

                aux.getAnterior().setSiguiente(aux.getSiguiente());
                aux.getSiguiente().setAnterior(aux.getAnterior());
                return true;
            }

            aux = aux.getSiguiente();
        } while (aux != primero);

        return false;
    }
}
