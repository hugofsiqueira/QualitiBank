package com.qualiti.bank.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.qualiti.bank.fachada.IFachada;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class TelaRelatorioClientes extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private JFrame framePrincipal;
	private IFachada fachada;
	private JTextArea textArea;
	
	public TelaRelatorioClientes(JFrame framePrincipal, IFachada fachada) {
		setLayout(null);
		this.framePrincipal = framePrincipal;
		this.fachada = fachada;
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 58, 341, 325);
		add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnBuscarClientes = new JButton("Buscar Clientes");
		btnBuscarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nomes = fachada.nomesClienteOrdemAlfabetica();
				textArea.setText(nomes);
				
			}
		});
		btnBuscarClientes.setBounds(49, 12, 182, 25);
		add(btnBuscarClientes);

	}
}
