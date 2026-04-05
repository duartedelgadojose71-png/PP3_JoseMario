/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pp3_josemario;

/**
 *
 * @author duart
 */

import javax.swing.JOptionPane;

public class MainABBPrueba {

    public static void main(String[] args) {

        ArbolBB arbol = new ArbolBB();
        int opcion = 0;

        do {
            String menu = "";
            menu = menu + "PRUEBA ABB\n";
            menu = menu + "1. Insertar producto\n";
            menu = menu + "2. Mostrar productos en orden\n";
            menu = menu + "3. Buscar producto por codigo\n";
            menu = menu + "4. Eliminar producto por codigo\n";
            menu = menu + "5. Salir\n";

            String entrada = JOptionPane.showInputDialog(menu);

            if (entrada == null) {
                opcion = 5;
            } else {
                opcion = Integer.parseInt(entrada);
            }

            if (opcion == 1) {
                int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite el codigo del producto:"));
                String nombre = JOptionPane.showInputDialog("Digite el nombre del producto:");
                double precio = Double.parseDouble(JOptionPane.showInputDialog("Digite el precio del producto:"));

                Producto producto = new Producto(codigo, nombre, precio);

                boolean agregado = arbol.insertarProducto(producto);

                if (agregado) {
                    JOptionPane.showMessageDialog(null, "Producto insertado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "El codigo ya existe. No se puede repetir.");
                }
            }

            if (opcion == 2) {
                JOptionPane.showMessageDialog(null, arbol.mostrarInorden());
            }

            if (opcion == 3) {
                int codigoBuscar = Integer.parseInt(JOptionPane.showInputDialog("Digite el codigo a buscar:"));

                Producto encontrado = arbol.buscarPorCodigo(codigoBuscar);

                if (encontrado == null) {
                    JOptionPane.showMessageDialog(null, "Producto no encontrado.");
                } else {
                    JOptionPane.showMessageDialog(null, encontrado.mostrarDatos());
                }
            }

            if (opcion == 4) {
                int codigoEliminar = Integer.parseInt(JOptionPane.showInputDialog("Digite el codigo a eliminar:"));

                boolean eliminado = arbol.eliminarPorCodigo(codigoEliminar);

                if (eliminado) {
                    JOptionPane.showMessageDialog(null, "Producto eliminado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "No existe un producto con ese codigo.");
                }
            }

            if (opcion == 5) {
                JOptionPane.showMessageDialog(null, "Fin de la prueba del ABB.");
            }

        } while (opcion != 5);
    }
}
