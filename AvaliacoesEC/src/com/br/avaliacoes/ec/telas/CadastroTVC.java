package com.br.avaliacoes.ec.telas;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import com.br.avaliacoes.ec.excecoes.BancoException;
import com.br.avaliacoes.ec.fachada.FachadaImp;
import com.br.avaliacoes.ec.modelo.AreaAtuacao;
import com.br.avaliacoes.ec.modelo.Pessoa;
import com.br.avaliacoes.ec.modelo.TipoPessoa;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Label;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.ScrollPane;
import java.awt.Button;
import java.awt.Panel;
import java.awt.TextField;

public class CadastroTVC extends JPanel {
	private JTextField txtNome;
	private JTextField txtLogin;
	private JPasswordField txtSenha;
	private JPasswordField txtConfirma��oSenha;
	private JComboBox cbArea;
	private JLabel lblQualquermerda;

	/**
	 * Create the panel.
	 */
	public CadastroTVC() {
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setLayout(null);
		
		JLabel label = new JLabel("\u00C1rea de atua\u00E7\u00E3o:");
		label.setBounds(229, 367, 126, 14);
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(label);
		
		JLabel label_1 = new JLabel("Cadastro");
		label_1.setBounds(286, 106, 182, 37);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		add(label_1);
		
		JLabel label_2 = new JLabel("Nome e sobrenome:");
		label_2.setBounds(229, 173, 160, 14);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(label_2);
		
		txtNome = new JTextField();
		txtNome.setBounds(229, 198, 299, 20);
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNome.setColumns(10);
		add(txtNome);
		
		JLabel label_3 = new JLabel("Nome do usu\u00E1rio:");
		label_3.setBounds(229, 229, 144, 14);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(label_3);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(229, 254, 299, 20);
		txtLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtLogin.setColumns(10);
		add(txtLogin);
		
		JLabel label_4 = new JLabel("Senha:");
		label_4.setBounds(229, 298, 70, 14);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(label_4);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(229, 323, 126, 20);
		txtSenha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(txtSenha);
		
		JLabel label_5 = new JLabel("Confirmar senha:");
		label_5.setBounds(384, 298, 144, 14);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(label_5);
		
		txtConfirma��oSenha = new JPasswordField();
		txtConfirma��oSenha.setBounds(384, 323, 144, 20);
		txtConfirma��oSenha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(txtConfirma��oSenha);
		
		JButton button_1 = new JButton("Confirmar");
		button_1.setBounds(229, 520, 299, 41);
		button_1.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				String nome = txtNome.getText();
				String login = txtLogin.getText();
				int indexArea = cbArea.getSelectedIndex();
				String senha;
				
				if(new String(txtSenha.getPassword()).equals(new String(txtConfirma��oSenha.getPassword()))) {
					senha = new String(txtSenha.getPassword());
					Pessoa avaliador = new Pessoa();
					avaliador.setLogin(login);
					avaliador.setNome(nome);
					avaliador.setSenha(senha);
					avaliador.setTipo(TipoPessoa.AVALIADOR);
					switch (indexArea) {
					case 0:
						break;
					case 1:
						avaliador.setArea(AreaAtuacao.COORDENACAO);
						break;
					case 2:
						avaliador.setArea(AreaAtuacao.BIOLOGIA);
						break;
					case 3:
						avaliador.setArea(AreaAtuacao.HISTORIA);
						break;
					case 4:
						avaliador.setArea(AreaAtuacao.GEOGRAFIA);
						break;
					case 5:
						avaliador.setArea(AreaAtuacao.QUIMICA);
						break;
					case 6:
						avaliador.setArea(AreaAtuacao.FISICA);
						break;
					case 7:
						avaliador.setArea(AreaAtuacao.ROBOTICA);
						break;
					case 8:
						avaliador.setArea(AreaAtuacao.APOIOCORDENACAO);
						break;
					default:
						break;
					}
					
					limparCampos();
					JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
					try {
						FachadaImp.getInstanciaFachada().inserirPessoa(avaliador);
					} catch (BancoException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}else {
					txtSenha.setText("");
					txtConfirma��oSenha.setText("");
					JOptionPane.showMessageDialog(null, "Senhas diferentes");
				}

				
			}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(button_1);
		
		cbArea = new JComboBox();
		cbArea.setBounds(229, 392, 299, 20);
		//cbArea.setModel(new DefaultComboBoxModel(new String[] {"Biologia", "Cordena\u00E7\u00E3o", "F\u00EDsica", "Geografia", "Histor\u00EDa", "Matem\u00E1tica", "Qu\u00EDmica", "Recep\u00E7\u00E3o", "Rob\u00F3tica"}));
		cbArea.setMaximumRowCount(5);
		cbArea.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbArea.addItem("Selecionar area");
		cbArea.addItem("Coordena��o");
		cbArea.addItem("Biologia");
		cbArea.addItem("Historia");
		cbArea.addItem("Geografia");
		cbArea.addItem("Quimica");
		cbArea.addItem("Fisica");
		cbArea.addItem("Robotica");
		cbArea.addItem("Apoio Cord");
		add(cbArea);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(-15, 154, 796, 8);
		add(separator);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(-15, 285, 796, 8);
		add(separator_2);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(-15, 358, 796, 8);
		add(separator_1);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(-15, 508, 796, 8);
		add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(-15, 572, 796, 8);
		add(separator_4);
		

		

	}
	private void limparCampos() {
		txtConfirma��oSenha.setText("");
		txtLogin.setText("");
		txtNome.setText("");
		txtSenha.setText("");
		cbArea.setSelectedIndex(0);
	}
}
