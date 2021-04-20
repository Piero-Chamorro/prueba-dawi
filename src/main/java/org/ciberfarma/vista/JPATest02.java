package org.ciberfarma.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.ciberfarma.modelo.Usuario;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JPATest02 extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtClave;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtUsuario;
	private JTextField txtFecha;
	private JTextField txtTipo;
	private JTextField txtEstado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JPATest02 frame = new JPATest02();
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
	public JPATest02() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 383, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Mantenimiento de Usuarios");
		lblTitle.setBounds(10, 25, 148, 26);
		contentPane.add(lblTitle);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo:");
		lblCodigo.setBounds(10, 62, 46, 14);
		contentPane.add(lblCodigo);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 87, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(10, 112, 46, 14);
		contentPane.add(lblApellido);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(10, 137, 46, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblClave = new JLabel("Clave:");
		lblClave.setBounds(10, 162, 46, 14);
		contentPane.add(lblClave);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(10, 187, 46, 14);
		contentPane.add(lblFecha);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(10, 212, 46, 14);
		contentPane.add(lblTipo);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(10, 237, 46, 14);
		contentPane.add(lblEstado);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(66, 59, 86, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtClave = new JTextField();
		txtClave.setBounds(66, 159, 86, 20);
		contentPane.add(txtClave);
		txtClave.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(66, 84, 160, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(66, 109, 160, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(66, 134, 86, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtFecha = new JTextField();
		txtFecha.setBounds(66, 184, 86, 20);
		contentPane.add(txtFecha);
		txtFecha.setColumns(10);
		
		txtTipo = new JTextField();
		txtTipo.setBounds(66, 209, 86, 20);
		contentPane.add(txtTipo);
		txtTipo.setColumns(10);
		
		txtEstado = new JTextField();
		txtEstado.setBounds(66, 234, 86, 20);
		contentPane.add(txtEstado);
		txtEstado.setColumns(10);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrar();
			}
		});
		btnRegistrar.setBounds(265, 53, 89, 23);
		contentPane.add(btnRegistrar);
		
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(265, 78, 89, 23);
		contentPane.add(btnActualizar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(265, 103, 89, 23);
		contentPane.add(btnEliminar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(265, 128, 89, 23);
		contentPane.add(btnConsultar);
	}
	void registrar() {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager em = fabrica.createEntityManager();
		
		// Crear un objeto de Usuario a grabar
		Usuario u = new Usuario();
		//u.setCodigo(6);
		u.setNombre(txtNombre.getText());
		u.setApellido(txtApellido.getText());
		u.setUsuario(txtUsuario.getText());
		u.setClave(txtClave.getText());
		u.setFnacim(txtFecha.getText());
		u.setTipo(Integer.parseInt(txtTipo.getText()));
		u.setEstado(Integer.parseInt(txtEstado.getText()));
		
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();
	}
}
