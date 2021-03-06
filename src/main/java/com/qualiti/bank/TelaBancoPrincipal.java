package com.qualiti.bank;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.qualiti.bank.fachada.IFachada;
import com.qualiti.bank.gui.TelaCadastrarCliente;
import com.qualiti.bank.gui.TelaCadastrarConta;
import com.qualiti.bank.gui.TelaHoraSistema;
import com.qualiti.bank.gui.TelaRelatorioClientes;
import com.qualiti.bank.gui.TelaTransacoesConta;

@SpringBootApplication
public class TelaBancoPrincipal {

	public JFrame frmQualitiBank;
	
	@Autowired
	private IFachada fachada;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		ConfigurableApplicationContext ctx = new SpringApplicationBuilder(TelaBancoPrincipal.class)
                .headless(false).run(args);
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaBancoPrincipal window = ctx.getBean(TelaBancoPrincipal.class);
					window.frmQualitiBank.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public TelaBancoPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmQualitiBank = new JFrame();
		frmQualitiBank.setTitle("Qualiti Bank");
		frmQualitiBank.setBounds(100, 100, 1036, 800);
		frmQualitiBank.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmQualitiBank.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		frmQualitiBank.setJMenuBar(menuBar);
		
		JMenu mnContas = new JMenu("Contas");
		menuBar.add(mnContas);
		
		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		mntmCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TelaCadastrarConta telaCadastrarConta = 
						new TelaCadastrarConta(frmQualitiBank, fachada);
				frmQualitiBank.setContentPane(telaCadastrarConta);
				frmQualitiBank.revalidate();
				
			}
		});
		mnContas.add(mntmCadastrar);
		
		JMenuItem mntmProcurar = new JMenuItem("Procurar");
		mnContas.add(mntmProcurar);
		
		JMenu mnClientes = new JMenu("Clientes");
		menuBar.add(mnClientes);
		
		JMenuItem mntmCadastrar_1 = new JMenuItem("Cadastrar");
		mntmCadastrar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TelaCadastrarCliente telaCadastrarCliente = 
							new TelaCadastrarCliente(frmQualitiBank, getFachada());
				frmQualitiBank.setContentPane(telaCadastrarCliente);
				frmQualitiBank.revalidate();
				
				
			}
		});
		mnClientes.add(mntmCadastrar_1);
		
		JMenuItem mntmProcurar_1 = new JMenuItem("Relatório");
		mntmProcurar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaRelatorioClientes telaCadastrarCliente = 
						new TelaRelatorioClientes(frmQualitiBank, getFachada());
				frmQualitiBank.setContentPane(telaCadastrarCliente);
				frmQualitiBank.revalidate();
				
			}
		});
		mnClientes.add(mntmProcurar_1);
		
		JMenu mnTransaes = new JMenu("Transações");
		menuBar.add(mnTransaes);
		
		JMenuItem mntmMovimentaes = new JMenuItem("Lançamentos");
		mntmMovimentaes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TelaTransacoesConta telaTransacoesConta = 
						new TelaTransacoesConta(frmQualitiBank, getFachada());
				frmQualitiBank.setContentPane(telaTransacoesConta);
				frmQualitiBank.revalidate();
				
			}
		});
		mnTransaes.add(mntmMovimentaes);
		
		JMenuItem mntmExtrato = new JMenuItem("Extrato");
		mnTransaes.add(mntmExtrato);
		
		
		frmQualitiBank.setContentPane(new TelaHoraSistema());
		frmQualitiBank.revalidate();
		
		frmQualitiBank.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
		
		frmQualitiBank.setLocationRelativeTo(null);
	}

	public IFachada getFachada() {
		return fachada;
	}

	public void setFachada(IFachada fachada) {
		this.fachada = fachada;
	}
}
