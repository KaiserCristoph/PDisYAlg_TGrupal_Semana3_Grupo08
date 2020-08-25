import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Font;

public class Ventana {

	private JFrame frame;
	private JTextField textCedula;
	private JTextField textApellido;
	private JTextField textNombre;
	private JButton btnEliminar;
	private JButton btnBuscar;
	private JButton btnModificar;
	private JButton btnMostrarTodo;
	private JTextField txtCedula;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ventana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(119, 136, 153));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(50, 68, 189, 33);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtCedula = new JTextField();
		txtCedula.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtCedula.getText().equals("Cedula")) {
					txtCedula.setText("");
				}
				else {
					txtCedula.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtCedula.getText().equals("")) {
					txtCedula.setText("Cedula");
				}
			}
		});
		txtCedula.setText("Cedula");
		txtCedula.setBounds(0, 0, 189, 33);
		panel.add(txtCedula);
		txtCedula.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(50, 123, 189, 33);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtApellido = new JTextField();
		txtApellido.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtApellido.getText().equals("Apellido")) {
					txtApellido.setText("");
				}
				else {
					txtApellido.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtApellido.getText().equals("")) {
					txtApellido.setText("Apellido");
				}
			}
		});
		txtApellido.setText("Apellido");
		txtApellido.setColumns(10);
		txtApellido.setBounds(0, 0, 189, 33);
		panel_1.add(txtApellido);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(null);
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(50, 177, 189, 33);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtNombre.getText().equals("Nombre")) {
					txtNombre.setText("");
				}
				else {
					txtNombre.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtNombre.getText().equals("")) {
					txtNombre.setText("Nombre");
				}
			}
		});
		txtNombre.setText("Nombre");
		txtNombre.setColumns(10);
		txtNombre.setBounds(0, 0, 189, 33);
		panel_2.add(txtNombre);
		
		JLabel lblNewLabel = new JLabel("X");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Estas seguro que deseas salir?", "Confirmar", JOptionPane.YES_NO_OPTION) == 0);{			
						System.exit(0);	
						//Ventana.this.dispose();
				}
			}
			public void mouseEntered(MouseEvent e) {
				lblNewLabel.setForeground(Color.WHITE);
			}
			public void mouseExited(MouseEvent e) {
				lblNewLabel.setForeground(Color.BLACK);
			}
		});
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(418, 0, 32, 33);
		contentPane.add(lblNewLabel);
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);
		
		JButton btnAlta = new JButton("Alta");
		btnAlta.setBackground(new Color(255, 255, 255));
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					String ci=txtCedula.getText();
					String nombre=txtNombre.getText();
					String apellido=txtApellido.getText();
					if(verificarLargo(nombre.length(), apellido.length(), ci.length())) {
						Empleado e = new Empleado(ci,nombre,apellido);
						DAOEmpleados.insert(e);
						JOptionPane.showMessageDialog(null, "Exito","Exito", JOptionPane.INFORMATION_MESSAGE);
						
					}
			}
		});
		btnAlta.setBounds(285, 68, 116, 23);
		frame.getContentPane().add(btnAlta);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBackground(new Color(255, 255, 255));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ci=txtCedula.getText();
				String nombre=txtNombre.getText();
				String apellido=txtApellido.getText();
				Empleado e1 = new Empleado(ci,nombre,apellido);
				DAOEmpleados.delete(e1);
			}
		});
		btnEliminar.setBounds(285, 107, 116, 23);
		frame.getContentPane().add(btnEliminar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(new Color(255, 255, 255));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String ci=txtCedula.getText();
				
					Empleado re=DAOEmpleados.find(ci);
					txtNombre.setText(re.getNombre());
					txtApellido.setText(re.getApellido());
			}
		});
		btnBuscar.setBounds(285, 146, 116, 23);
		frame.getContentPane().add(btnBuscar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBackground(new Color(255, 255, 255));
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String ci=txtCedula.getText();
					String nombre=txtNombre.getText();
					String apellido=textApellido.getText();
					Empleado e1 = new Empleado(ci,nombre,apellido);
					DAOEmpleados.update(e1);
					
			}			
		});
		btnModificar.setBounds(285, 185, 116, 23);
		frame.getContentPane().add(btnModificar);
		
		btnMostrarTodo = new JButton("Mostrar Todo");
		btnMostrarTodo.setBackground(new Color(255, 255, 255));
		btnMostrarTodo.setForeground(new Color(0, 0, 0));
		btnMostrarTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				MostrarTodo mt=new MostrarTodo();
				mt.mostrar();
			}
		});
		btnMostrarTodo.setBounds(137, 251, 189, 33);
		frame.getContentPane().add(btnMostrarTodo);
		
		lblNewLabel_1 = new JLabel("Manejador de Empleados");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(113, 16, 229, 35);
		contentPane.add(lblNewLabel_1);
	}
	
	private boolean verificarLargo(int cantNombre, int cantApellido, int cantCedula) {
		boolean valido = true;
		if(cantNombre >= 50) {
			JOptionPane.showMessageDialog(null, "Se ha excedido la cantidad de caracteres para el nombre");
			valido = false;
		} else if(cantApellido >= 50) {
			JOptionPane.showMessageDialog(null, "Se ha excedido la cantidad de caracteres para el apellido");
			valido = false;
		} else if(cantCedula >= 12) {
			JOptionPane.showMessageDialog(null, "Se ha excedido la cantidad de caracteres para el documento");
			valido = false;
		}
		
		return valido;
	}
	
}
