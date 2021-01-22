package ec.ups.edu.g2.appdis.ExamenWSCuji.vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ec.ups.edu.g2.appdis.ExamenWSCuji.cliRest.CompraREST;
import ec.ups.edu.g2.appdis.ExamenWSCuji.modelo.Producto;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class RealizarCompra extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodProd;
	private JTextField txtProducto;
	private JTextField txtPrecio;
	private JTextField txtExistencias;
	private JTable table;
	DefaultTableModel modelo = new DefaultTableModel();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RealizarCompra frame = new RealizarCompra();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RealizarCompra() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 563, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtCodProd = new JTextField();
		txtCodProd.setBounds(110, 8, 131, 26);
		contentPane.add(txtCodProd);
		txtCodProd.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Codigo Producto: ");
		lblNewLabel.setBounds(10, 8, 96, 26);
		contentPane.add(lblNewLabel);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarProducto();
			}
		});
		btnBuscar.setBounds(251, 8, 89, 25);
		contentPane.add(btnBuscar);
		
		JLabel lblProducto = new JLabel("Producto:");
		lblProducto.setBounds(10, 57, 57, 26);
		contentPane.add(lblProducto);
		
		txtProducto = new JTextField();
		txtProducto.setEnabled(false);
		txtProducto.setColumns(10);
		txtProducto.setBounds(77, 57, 131, 26);
		contentPane.add(txtProducto);
		
		JLabel lblPrecio = new JLabel("Precio: $");
		lblPrecio.setBounds(218, 57, 57, 26);
		contentPane.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setEnabled(false);
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(270, 57, 74, 26);
		contentPane.add(txtPrecio);
		
		JLabel lblExistencias = new JLabel("Existencias:");
		lblExistencias.setBounds(357, 57, 67, 26);
		contentPane.add(lblExistencias);
		
		txtExistencias = new JTextField();
		txtExistencias.setEnabled(false);
		txtExistencias.setColumns(10);
		txtExistencias.setBounds(434, 57, 57, 26);
		contentPane.add(txtExistencias);
		
		JButton btnAgregar = new JButton("AGREGAR");
		btnAgregar.setBounds(17, 103, 89, 23);
		contentPane.add(btnAgregar);
		
		table = new JTable(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"PRODUCTO", "PRECIO", "EXISTENCIAS"
			}
		));
		table.setBounds(10, 161, 527, 135);
		contentPane.add(table);
	
		
	}
	
	void buscarProducto() {
		CompraREST  rest = new CompraREST();
		Producto p = new Producto();
		p = rest.buscarProducto(txtCodProd.getText());
		if(p!=null) {
			txtProducto.setText(p.getNombre());
			txtPrecio.setText(String.valueOf( p.getPrecio()));
			txtExistencias.setText(String.valueOf(p.getExistencias()));
			
		}else {
			JOptionPane.showMessageDialog(this, "El producto no se encuentra registrado");
		}
	}
}
