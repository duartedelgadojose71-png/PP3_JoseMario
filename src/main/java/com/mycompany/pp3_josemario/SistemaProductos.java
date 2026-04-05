/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pp3_josemario;
import javax.swing.JOptionPane;

/**
 *
 * @author duart
 */
public class SistemaProductos {

    public static void main(String[] args) {

        ListaDobleCircular lista = new ListaDobleCircular();
        ArbolBB arbol = new ArbolBB();

        int opcion = 0;

        do {
            String menu = "";
            menu = menu + "SISTEMA DE GESTION DE PRODUCTOS\n";
            menu = menu + "1. Insertar producto\n";
            menu = menu + "2. Mostrar lista hacia adelante\n";
            menu = menu + "3. Mostrar lista hacia atras\n";
            menu = menu + "4. Mostrar productos en orden (ABB)\n";
            menu = menu + "5. Buscar producto por codigo\n";
            menu = menu + "6. Eliminar producto de la lista y del ABB\n";
            menu = menu + "7. Salir\n";

            String entrada = JOptionPane.showInputDialog(menu);

            if (entrada == null) {
                opcion = 7;
            } else {
                opcion = Integer.parseInt(entrada);
            }

            if (opcion == 1) {
                int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite el codigo del producto:"));
                String nombre = JOptionPane.showInputDialog("Digite el nombre del producto:");
                double precio = Double.parseDouble(JOptionPane.showInputDialog("Digite el precio del producto:"));

                Producto producto = new Producto(codigo, nombre, precio);

                Producto existente = arbol.buscarPorCodigo(codigo);

                if (existente != null) {
                    JOptionPane.showMessageDialog(null, "Ese codigo ya existe. No se puede repetir.");
                } else {
                    boolean agregadoLista = lista.insertarAlFinal(producto);
                    boolean agregadoArbol = arbol.insertarProducto(producto);

                    if (agregadoLista && agregadoArbol) {
                        JOptionPane.showMessageDialog(null, "Producto insertado correctamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo insertar el producto.");
                    }
                }
            }

            if (opcion == 2) {
                JOptionPane.showMessageDialog(null, lista.mostrarHaciaAdelante());
            }

            if (opcion == 3) {
                JOptionPane.showMessageDialog(null, lista.mostrarHaciaAtras());
            }

            if (opcion == 4) {
                JOptionPane.showMessageDialog(null, arbol.mostrarInorden());
            }

            if (opcion == 5) {
                int codigoBuscar = Integer.parseInt(JOptionPane.showInputDialog("Digite el codigo a buscar:"));

                Producto encontrado = arbol.buscarPorCodigo(codigoBuscar);

                if (encontrado == null) {
                    JOptionPane.showMessageDialog(null, "Producto no encontrado.");
                } else {
                    JOptionPane.showMessageDialog(null, encontrado.mostrarDatos());
                }
            }

            if (opcion == 6) {
                int codigoEliminar = Integer.parseInt(JOptionPane.showInputDialog("Digite el codigo a eliminar:"));

                Producto encontrado = arbol.buscarPorCodigo(codigoEliminar);

                if (encontrado == null) {
                    JOptionPane.showMessageDialog(null, "No existe un producto con ese codigo.");
                } else {
                    boolean eliminadoLista = lista.eliminarPorCodigo(codigoEliminar);
                    boolean eliminadoArbol = arbol.eliminarPorCodigo(codigoEliminar);

                    if (eliminadoLista && eliminadoArbol) {
                        JOptionPane.showMessageDialog(null, "Producto eliminado correctamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo eliminar correctamente.");
                    }
                }
            }

            if (opcion == 7) {
                JOptionPane.showMessageDialog(null, "Fin del sistema.");
            }

        } while (opcion != 7);
    }
}
