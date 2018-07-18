package com.qualiti.bank.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.math.BigDecimal;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import com.qualiti.bank.exceptions.BancoException;
import com.qualiti.bank.fachada.IFachada;
import com.qualiti.bank.model.Cliente;
import com.qualiti.bank.model.Endereco;
import com.qualiti.bank.model.TipoCliente;
import com.qualiti.bank.model.TipoPessoa;

public class TelaCadastrarCliente extends JPanel {
	
	private JFormattedTextField txtCpf;
	private JTextField txtNome;
	private JTextField txtLogradouro;
	private JTextField txtNumero;
	private JFormattedTextField txtCep;
	private JTextField txtComplemento;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JComboBox<String> cbUf;

	private JFrame framePrincipal;
	private JRadioButton rdbtnBasic;
	private JRadioButton rdbtnPremium;
	private JRadioButton rdbtnPlatinum;
	private JTextField txtLogin;
	private JPasswordField txtSenha;
	private JTextField txtSalario;
	
	private IFachada fachada;
	/**
	 * Create the panel.
	 */
	public TelaCadastrarCliente(JFrame framePrincipal, IFachada fachada) {
		setLayout(null);
		
		this.fachada = fachada;
		
		this.framePrincipal = framePrincipal;
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(52, 49, 46, 14);
		add(lblCpf);
		
		txtCpf = new JFormattedTextField();
		txtCpf.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				
				
				
			}
		});
		txtCpf.setBounds(108, 46, 121, 20);
		
		try {
			MaskFormatter mask = new MaskFormatter("###.###.###-##");
			mask.install(txtCpf);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		add(txtCpf);
		txtCpf.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(52, 86, 46, 14);
		add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(108, 83, 336, 20);
		add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(52, 191, 46, 14);
		add(lblTipo);
		
		rdbtnBasic = new JRadioButton("Basic");
		buttonGroup.add(rdbtnBasic);
		rdbtnBasic.setSelected(true);
		rdbtnBasic.setBounds(108, 187, 73, 23);
		add(rdbtnBasic);
		
		rdbtnPremium = new JRadioButton("Premium");
		buttonGroup.add(rdbtnPremium);
		rdbtnPremium.setBounds(190, 187, 84, 23);
		add(rdbtnPremium);
		
		rdbtnPlatinum = new JRadioButton("Platinum");
		buttonGroup.add(rdbtnPlatinum);
		rdbtnPlatinum.setBounds(284, 187, 89, 23);
		add(rdbtnPlatinum);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(40, 217, 422, 2);
		add(separator);
		
		JLabel lblEndereo = new JLabel("Endereço");
		lblEndereo.setBounds(50, 230, 103, 14);
		add(lblEndereo);
		
		JLabel lblNewLabel = new JLabel("Logradouro:");
		lblNewLabel.setBounds(52, 276, 73, 14);
		add(lblNewLabel);
		
		txtLogradouro = new JTextField();
		txtLogradouro.setBounds(135, 273, 309, 20);
		add(txtLogradouro);
		txtLogradouro.setColumns(10);
		
		JLabel lblNmero = new JLabel("Número:");
		lblNmero.setBounds(52, 318, 73, 14);
		add(lblNmero);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(182, 315, 103, 20);
		add(txtNumero);
		txtNumero.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(295, 318, 46, 14);
		add(lblCep);
		
		txtCep = new JFormattedTextField();
		txtCep.setBounds(340, 315, 104, 20);
		
		try {
			MaskFormatter mask = new MaskFormatter("######-###");
			mask.install(txtCep);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		add(txtCep);
		txtCep.setColumns(10);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(52, 361, 103, 14);
		add(lblComplemento);
		
		txtComplemento = new JTextField();
		txtComplemento.setBounds(182, 358, 103, 20);
		add(txtComplemento);
		txtComplemento.setColumns(10);
		
		JLabel lblUf = new JLabel("UF:");
		lblUf.setBounds(295, 361, 36, 14);
		add(lblUf);
		
		cbUf = new JComboBox<>();
		cbUf.setBounds(341, 358, 103, 20);
		
		cbUf.addItem("");
		cbUf.addItem("AC");
		cbUf.addItem("AM");
		cbUf.addItem("AL");
		cbUf.addItem("AP");
		
		add(cbUf);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(52, 392, 73, 14);
		add(lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(135, 389, 309, 20);
		add(txtBairro);
		txtBairro.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(52, 423, 73, 14);
		add(lblCidade);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(135, 420, 309, 20);
		add(txtCidade);
		txtCidade.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Cliente cliente = montarCliente();
					
					if(cliente != null) {
						fachada.cadastrarCliente(cliente);
						limparCampos();
						JOptionPane.showMessageDialog(null, "Cliente Cadastrado", "Cadastrar Cliente",
																				JOptionPane.INFORMATION_MESSAGE);
					}
					
					
				} catch (BancoException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Cadastrar Cliente",
							JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnCadastrar.setBounds(52, 499, 107, 23);
		add(btnCadastrar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				framePrincipal.setContentPane(new TelaHoraSistema());
				framePrincipal.repaint();
			
				
			}
		});
		btnSair.setBounds(419, 499, 103, 23);
		add(btnSair);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(52, 123, 46, 14);
		add(lblLogin);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(108, 120, 121, 20);
		add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(250, 123, 57, 14);
		add(lblSenha);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(295, 120, 109, 20);
		add(txtSenha);
		
		JLabel lblSalrio = new JLabel("Salário:");
		lblSalrio.setBounds(52, 163, 46, 14);
		add(lblSalrio);
		
		txtSalario = new JTextField();
		txtSalario.setBounds(108, 160, 121, 20);

		
		add(txtSalario);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String cpf = txtCpf.getText();
				
				try {
					Cliente cliente = fachada.procurarCliente(cpf);
					
					if(cliente != null) {
						
						txtNome.setText(cliente.getNome());
						txtLogin.setText(cliente.getLogin());
						txtSalario.setText(cliente.getSalario().toString());
						TipoCliente tipo = cliente.getTipo();
						
						if(tipo.equals(TipoCliente.BASIC)) {
							rdbtnBasic.setSelected(true);
						}else if(tipo.equals(TipoCliente.PLATINUM)) {
							rdbtnPlatinum.setSelected(true);
						}else {
							rdbtnPremium.setSelected(true);
						}
						
					}else {
						JOptionPane.showMessageDialog(null, "CPF não cadastrado", "Procurar Cliente",
								JOptionPane.INFORMATION_MESSAGE);
					}
					
				} catch (BancoException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Procurar Cliente",
							JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		btnProcurar.setBounds(271, 45, 89, 23);
		add(btnProcurar);
		
		JButton btnNewButton = new JButton("Remover");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String cpf = txtCpf.getText();
				
				int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir?", "Remover Cliente", 
													JOptionPane.YES_NO_OPTION);
				
				if(resposta == JOptionPane.YES_OPTION) {
					try {
						fachada.removerCliente(cpf);
						
						limparCampos();
						
						JOptionPane.showMessageDialog(null, "Cliente Removido com sucesso", "Remover Cliente",
								JOptionPane.INFORMATION_MESSAGE);
						
					} catch (BancoException e) {
						JOptionPane.showMessageDialog(null, e.getMessage(), "Remover Cliente",
								JOptionPane.ERROR_MESSAGE);
					}
					
				}
				
				
			}
		});
		btnNewButton.setBounds(295, 499, 99, 23);
		add(btnNewButton);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Cliente cliente = montarCliente();
					
					if(cliente != null) {
						fachada.atualizarCliente(cliente);
						limparCampos();
						JOptionPane.showMessageDialog(null, "Cliente Atualizado", "Atualizar Cliente",
																				JOptionPane.INFORMATION_MESSAGE);
					}
					
					
				} catch (BancoException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Atualizar Cliente",
							JOptionPane.ERROR_MESSAGE);
				}
				
				
				
				
			}
		});
		btnAtualizar.setBounds(182, 499, 97, 23);
		add(btnAtualizar);
		
		
		

	}
	
	
	private void limparCampos() {
		
		txtNome.setText("");
		txtCpf.setText("");
		txtBairro.setText("");
		txtCep.setText("");
		txtCidade.setText("");
		txtComplemento.setText("");
		txtLogin.setText("");
		txtLogradouro.setText("");
		txtNumero.setText("");
		txtSalario.setText("");
		txtSenha.setText("");
		
		rdbtnBasic.setSelected(true);
		cbUf.setSelectedIndex(0);
		
	}
	
	private Cliente montarCliente() {
		
		String cpf = txtCpf.getText();
		String nome = txtNome.getText();
		String login = txtLogin.getText();
		String senha = new String(txtSenha.getPassword());
		String salario = txtSalario.getText();
		
		String log = txtLogradouro.getText();
		String numero = txtNumero.getText();
		String complemento = txtComplemento.getText();
		String cep = txtCep.getText();
		String bairro = txtBairro.getText();
		String cidade = txtCidade.getText();
		
		String uf = (String) cbUf.getSelectedItem();
		
		double salarioDouble;
		
		try {
		
			salarioDouble = Double.parseDouble(salario);
		
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, 
					"Salario invalido", 
					"Cadastrar Cliente",
					JOptionPane.ERROR_MESSAGE);
			return null;
		}
		
		TipoCliente tipo = null;
		
		if(rdbtnBasic.isSelected()) {
			tipo = TipoCliente.BASIC;
		}else if(rdbtnPremium.isSelected()) {
			tipo = TipoCliente.PREMIUM;
		}else {
			tipo = TipoCliente.PLATINUM;
		}
		
		Endereco end = new Endereco();
		end.setLogradouro(log);
		end.setNumero(numero);
		end.setComplemento(complemento);
		end.setCidade(cidade);
		end.setBairro(bairro);
		end.setUf(uf);
		end.setCep(cep);
		end.setCpf(cpf);
		
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setCpf(cpf);
		cliente.setEndereco(end);
		cliente.setTipo(tipo);
		cliente.setTipoPessoa(TipoPessoa.CLIENTE);
		cliente.setLogin(login);
		cliente.setSenha(senha);
		cliente.setSalario(new BigDecimal(salarioDouble));
		
		
		return cliente;
		
	}
	
}
