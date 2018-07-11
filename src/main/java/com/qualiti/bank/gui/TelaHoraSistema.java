package com.qualiti.bank.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TelaHoraSistema extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4685905831294844031L;

	/**
	 * Create the panel.
	 */
	public TelaHoraSistema() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("20:10");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 39));
		lblNewLabel.setBounds(21, 24, 207, 55);
		add(lblNewLabel);
		
		int interval = 1000; 
		
		final DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		Calendar now = Calendar.getInstance();
        lblNewLabel.setText(dateFormat.format(now.getTime()));

	    new Timer(interval, new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            Calendar now = Calendar.getInstance();
	            lblNewLabel.setText(dateFormat.format(now.getTime()));
	        }
	    }).start();

	}

}
