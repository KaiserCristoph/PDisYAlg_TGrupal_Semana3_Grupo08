import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.*;
import java.util.LinkedList;

//clase que muestra el contenido de una tabla de la BD utilizando una tabla
public class MostrarTodo extends JFrame {
	static JFrame frame;
	static DefaultTableModel modelo;
	static JTable tabla;
	static JPanel panel;
	static JScrollPane scrollPanel;
	
	public void mostrar(){
		//Se crean los elementos graficos
		creacionElementos();
		//Se cargan los datos obtenidos de la bd
		cargaElementos();
	}
	
	static void creacionElementos() {
		//Se inicializa el frame
		frame =new JFrame("Mostrar");
		//Se inicializa el modelo
		modelo= new DefaultTableModel();
		//Se inicializa la tabla añadiendo el modelo creado
		tabla = new JTable(modelo);
		//Se inicializa el ScrollPanel con los datos de la tabla
		scrollPanel = new JScrollPane(tabla);
		//Se inicializa el panel
		panel = new JPanel();
		
		//Seteamos propiedades del frame
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		//Setamos propiedades de la tabla
		tabla.setPreferredScrollableViewportSize(new Dimension(600, 110));

		//Agregamos el JScrollPane al contenedor
		panel.add(scrollPanel);		

		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}
	
	static void cargaElementos() {
		//crea un array que contiene los nombre de las columnas
		final String[] columnas = {"Nombre","Apellido","Cedula"};
		
		// insertamos las columnas
		for(int i = 0; i < columnas.length; i++){
			//agrega las columnas a la tabla
			modelo.addColumn(columnas[i]);
		}

		// Se crea un array que será una de las filas de la tabla. 
		Object [] fila = new Object[columnas.length]; 
		// Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
		LinkedList<Empleado> todosEmpleados = DAOEmpleados.findAll();
			
		for (int i=0;i<todosEmpleados.size();i++){
	
			String nombre=todosEmpleados.get(i).getNombre();
			String apellido=todosEmpleados.get(i).getApellido();
			String cedula=todosEmpleados.get(i).getCedula();
		
			fila[0] = nombre;
			fila[1] = apellido;
			fila[2] = cedula;
			modelo.addRow(fila); 
		}	
	}
}
