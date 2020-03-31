package me.alexbanper.calculadora;

import java.awt.EventQueue;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.awt.Button;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class calculadora {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calculadora window = new calculadora();
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
	public calculadora() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 469);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JTextArea consoleresults = new JTextArea();
		consoleresults.setEditable(false);
		consoleresults.setBounds(10, 11, 291, 79);
		panel.add(consoleresults);
		
		Button btn7 = new Button("7");
		btn7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				consoleresults.setText(consoleresults.getText()+"7");
			}
		});
		btn7.setBounds(10, 114, 93, 71);
		panel.add(btn7);
		
		Button btn8 = new Button("8");
		btn8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				consoleresults.setText(consoleresults.getText()+"8");
			}
		});
		btn8.setBounds(109, 114, 93, 71);
		panel.add(btn8);
		
		Button btn9 = new Button("9");
		btn9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				consoleresults.setText(consoleresults.getText()+"9");
			}
		});
		btn9.setBounds(208, 114, 93, 71);
		panel.add(btn9);
		
		Button btn4 = new Button("4");
		btn4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				consoleresults.setText(consoleresults.getText()+"4");
			}
		});
		btn4.setBounds(10, 191, 93, 71);
		panel.add(btn4);
		
		Button btn5 = new Button("5");
		btn5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				consoleresults.setText(consoleresults.getText()+"5");
			}
		});
		btn5.setBounds(109, 191, 93, 71);
		panel.add(btn5);
		
		Button btn6 = new Button("6");
		btn6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				consoleresults.setText(consoleresults.getText()+"6");
			}
		});
		btn6.setBounds(208, 191, 93, 71);
		panel.add(btn6);
		
		Button btn1 = new Button("1");
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				consoleresults.setText(consoleresults.getText()+"1");
			}
		});
		btn1.setActionCommand("1");
		btn1.setBounds(10, 268, 93, 71);
		panel.add(btn1);
		
		Button btn2 = new Button("2");
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				consoleresults.setText(consoleresults.getText()+"2");
			}
		});
		btn2.setBounds(109, 268, 93, 71);
		panel.add(btn2);
		
		Button btn3 = new Button("3");
		btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				consoleresults.setText(consoleresults.getText()+"3");
			}
		});
		btn3.setBounds(208, 268, 93, 71);
		panel.add(btn3);
		
		Button btnless = new Button("-");
		btnless.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				consoleresults.setText(consoleresults.getText()+"-");
			}
		});
		btnless.setBounds(337, 161, 70, 36);
		panel.add(btnless);
		
		Button btnmore = new Button("+");
		btnmore.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				consoleresults.setText(consoleresults.getText()+"+");
			}
		});
		btnmore.setBounds(337, 217, 70, 36);
		panel.add(btnmore);
		
		Button btndivide = new Button("/");
		btndivide.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				consoleresults.setText(consoleresults.getText()+"/");
			}
		});
		btndivide.setBounds(337, 268, 70, 36);
		panel.add(btndivide);
		
		Button btnmultiply = new Button("*");
		btnmultiply.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				consoleresults.setText(consoleresults.getText()+"*");
			}
		});
		btnmultiply.setBounds(337, 326, 70, 36);
		panel.add(btnmultiply);
		
		JTextArea results = new JTextArea();
		results.setEditable(false);
		results.setText("R:");
		results.setBounds(319, 41, 105, 49);
		panel.add(results);
		
		Button btninsert = new Button("CALCULAR");
		btninsert.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int operationResult = operation(consoleresults.getText());
				if(operationResult == -1)
				{
					consoleresults.setText("No se puede dividir entre cero.");
					results.setText(null);
					return;
				}
				results.setText("R: "+ operationResult);
			}
		});
		btninsert.setBounds(319, 387, 105, 29);
		panel.add(btninsert);
		
		JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setBounds(319, 16, 105, 14);
		panel.add(lblResultado);
		
		Button button = new Button("BORRAR");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				consoleresults.setText("");
				results.setText("");
			}
		});
		button.setBounds(319, 114, 105, 29);
		panel.add(button);
		
		Button btn0 = new Button("0");
		btn0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				consoleresults.setText(consoleresults.getText()+"0");
			}
		});
		btn0.setActionCommand("1");
		btn0.setBounds(10, 345, 291, 71);
		panel.add(btn0);
	}
	
	public int operation(String textForOperate)
	{
		if(textForOperate.contains("/0"))
		{
			return -1;
		}
		ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        Object result;
		try {
			result = engine.eval(textForOperate);
			return (int) result;
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return (int) 0;
	}
}
