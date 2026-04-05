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


public class MainListaPrueba {

    public static void main(String[] args) {

        ListaDobleCircular lista = new ListaDobleCircular();
        int opcion = 0;

        do {
            String menu = "";
            menu = menu + "PRUEBA LISTA DOBLE CIRCULAR\n";
            menu = menu + "1. Insertar producto\n";
            menu = menu + "2. Mostrar hacia adelante\n";
            menu = menu + "3. Mostrar hacia atras\n";
            menu = menu + "4. Eliminar por codigo\n";
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

                boolean agregado = lista.insertarAlFinal(producto);

                if (agregado) {
                    JOptionPane.showMessageDialog(null, "Producto insertado correctamente en la lista.");
                } else {
                    JOptionPane.showMessageDialog(null, "Ese codigo ya existe en la lista.");
                }
            }

            if (opcion == 2) {
                JOptionPane.showMessageDialog(null, lista.mostrarHaciaAdelante());
            }

            if (opcion == 3) {
                JOptionPane.showMessageDialog(null, lista.mostrarHaciaAtras());
            }

            if (opcion == 4) {
                int codigoEliminar = Integer.parseInt(JOptionPane.showInputDialog("Digite el codigo a eliminar:"));

                boolean eliminado = lista.eliminarPorCodigo(codigoEliminar);

                if (eliminado) {
                    JOptionPane.showMessageDialog(null, "Producto eliminado de la lista.");
                } else {
                    JOptionPane.showMessageDialog(null, "No existe un producto con ese codigo.");
                }
            }

            if (opcion == 5) {
                JOptionPane.showMessageDialog(null, "Fin de la prueba de lista.");
            }

        } while (opcion != 5);
    }
}
