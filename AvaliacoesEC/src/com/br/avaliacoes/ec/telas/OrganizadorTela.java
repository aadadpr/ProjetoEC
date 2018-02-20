package com.br.avaliacoes.ec.telas;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JSeparator;

public class OrganizadorTela extends BaseOrgTela {

	/**
	 * Create the panel.
	 */
	public OrganizadorTela() {
		
		JTextArea textAreaAvaliacao = new JTextArea();
		textAreaAvaliacao.setBounds(10, 120, 721, 457);
		add(textAreaAvaliacao);
		
		JLabel lblStatus = new JLabel("Ultimas Avalia\u00E7\u00F5es");
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblStatus.setBounds(0, 52, 741, 24);
		add(lblStatus);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(-25, 107, 796, 2);
		add(separator_1);

		
		JLabel Imagem2 = new JLabel("New label");
		ImageIcon icone1 =new ImageIcon("C:/Users/PC/git/ProjetoEC/AvaliacoesEC/src/img/Fundo2.jpg");
		Imagem2.setBounds(0, 21, 741, 647);
		Image imagi = icone1.getImage().getScaledInstance(Imagem2.getWidth(),Imagem2.getHeight(), Image.SCALE_SMOOTH);
		
		Imagem2.setIcon(new ImageIcon(imagi));
		add(Imagem2);
		
		
		
		
		
		
	}

}
