/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pp3_josemario;

/**
 *
 * @author duart
 */

public class ArbolBB {
    
    private NodoArbol raiz;

    public ArbolBB() {
        raiz = null;
    }

    public NodoArbol getRaiz() {
        return raiz;
    }

    public boolean insertarProducto(Producto producto) {
        if (raiz == null) {
            raiz = new NodoArbol(producto);
            return true;
        } else {
            return insertarRecursivo(raiz, producto);
        }
    }

    private boolean insertarRecursivo(NodoArbol actual, Producto producto) {
        if (producto.getCodigo() == actual.getProducto().getCodigo()) {
            return false;
        }

        if (producto.getCodigo() < actual.getProducto().getCodigo()) {
            if (actual.getIzquierda() == null) {
                actual.setIzquierda(new NodoArbol(producto));
                return true;
            } else {
                return insertarRecursivo(actual.getIzquierda(), producto);
            }
        } else {
            if (actual.getDerecha() == null) {
                actual.setDerecha(new NodoArbol(producto));
                return true;
            } else {
                return insertarRecursivo(actual.getDerecha(), producto);
            }
        }
    }

    public Producto buscarPorCodigo(int codigo) {
        return buscarRecursivo(raiz, codigo);
    }

    private Producto buscarRecursivo(NodoArbol actual, int codigo) {
        if (actual == null) {
            return null;
        }

        if (codigo == actual.getProducto().getCodigo()) {
            return actual.getProducto();
        }

        if (codigo < actual.getProducto().getCodigo()) {
            return buscarRecursivo(actual.getIzquierda(), codigo);
        } else {
            return buscarRecursivo(actual.getDerecha(), codigo);
        }
    }

    public String mostrarInorden() {
        String resultado = mostrarInordenRecursivo(raiz);
        if (resultado.equals("")) {
            return "No hay productos en el arbol.";
        }
        return resultado;
    }

    private String mostrarInordenRecursivo(NodoArbol actual) {
        if (actual == null) {
            return "";
        }

        String texto = "";

        texto = texto + mostrarInordenRecursivo(actual.getIzquierda());
        texto = texto + actual.getProducto().mostrarDatos() + "\n-------------------\n";
        texto = texto + mostrarInordenRecursivo(actual.getDerecha());

        return texto;
    }

    public boolean eliminarPorCodigo(int codigo) {
        if (buscarPorCodigo(codigo) == null) {
            return false;
        }

        raiz = eliminarRecursivo(raiz, codigo);
        return true;
    }

    private NodoArbol eliminarRecursivo(NodoArbol actual, int codigo) {
        if (actual == null) {
            return null;
        }

        if (codigo < actual.getProducto().getCodigo()) {
            actual.setIzquierda(eliminarRecursivo(actual.getIzquierda(), codigo));
        } else if (codigo > actual.getProducto().getCodigo()) {
            actual.setDerecha(eliminarRecursivo(actual.getDerecha(), codigo));
        } else {
            if (actual.getIzquierda() == null && actual.getDerecha() == null) {
                return null;
            }

            if (actual.getIzquierda() == null) {
                return actual.getDerecha();
            }

            if (actual.getDerecha() == null) {
                return actual.getIzquierda();
            }

            NodoArbol sucesor = obtenerMenor(actual.getDerecha());
            actual.setProducto(sucesor.getProducto());
            actual.setDerecha(eliminarRecursivo(actual.getDerecha(), sucesor.getProducto().getCodigo()));
        }

        return actual;
    }

    private NodoArbol obtenerMenor(NodoArbol actual) {
        while (actual.getIzquierda() != null) {
            actual = actual.getIzquierda();
        }
        return actual;
    }
}
