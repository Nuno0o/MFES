
package MFES;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JTabbedPane;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class GUI {

	private JFrame frmFrutaFeia;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmFrutaFeia.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFrutaFeia = new JFrame();
		frmFrutaFeia.setTitle("Fruta Feia");
		frmFrutaFeia.setBounds(100, 100, 450, 300);
		frmFrutaFeia.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFrutaFeia.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmFrutaFeia.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Consumer", null, panel, null);
		panel.setLayout(null);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(10, 11, 133, 23);
		panel.add(btnRegister);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(153, 11, 266, 211);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 11, 46, 14);
		panel_3.add(lblName);
		
		JLabel lblBasket = new JLabel("Basket");
		lblBasket.setBounds(10, 40, 46, 14);
		panel_3.add(lblBasket);
		
		textField = new JTextField();
		textField.setBounds(66, 8, 190, 20);
		panel_3.add(textField);
		textField.setColumns(10);
		
		JRadioButton rdbtnSmall = new JRadioButton("small");
		rdbtnSmall.setBounds(93, 36, 58, 23);
		panel_3.add(rdbtnSmall);
		
		JRadioButton rdbtnLarge = new JRadioButton("large");
		rdbtnLarge.setBounds(153, 36, 58, 23);
		panel_3.add(rdbtnLarge);
		
		JButton button = new JButton("See All Clients");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(10, 45, 133, 23);
		panel.add(button);
		
		JButton btnSeeLastBasket = new JButton("See Last Basket");
		btnSeeLastBasket.setBounds(10, 79, 133, 23);
		panel.add(btnSeeLastBasket);
		
		JButton btnFetchBasket = new JButton("Fetch Basket");
		btnFetchBasket.setBounds(10, 113, 133, 23);
		panel.add(btnFetchBasket);
		
		JButton btnCancelBasket = new JButton("Cancel Basket");
		btnCancelBasket.setBounds(10, 147, 133, 23);
		panel.add(btnCancelBasket);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Producer", null, panel_1, null);
		panel_1.setLayout(null);
		
		JButton button_1 = new JButton("Register");
		button_1.setBounds(10, 11, 133, 23);
		panel_1.add(button_1);
		
		JButton btnSeeAllProducts = new JButton("See All Producers");
		btnSeeAllProducts.setBounds(10, 45, 133, 23);
		panel_1.add(btnSeeAllProducts);
		
		JButton btnMakeProduct = new JButton("Make Product");
		btnMakeProduct.setBounds(10, 79, 133, 23);
		panel_1.add(btnMakeProduct);
		
		JButton btnSendToDelegation = new JButton("Send to Delegation");
		btnSendToDelegation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSendToDelegation.setBounds(10, 113, 133, 23);
		panel_1.add(btnSendToDelegation);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBounds(153, 11, 266, 211);
		panel_1.add(panel_4);
		
		JLabel label = new JLabel("Name");
		label.setBounds(10, 11, 46, 14);
		panel_4.add(label);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(66, 8, 190, 20);
		panel_4.add(textField_1);
		
		JButton btnViewProducts = new JButton("View Products");
		btnViewProducts.setBounds(10, 147, 133, 23);
		panel_1.add(btnViewProducts);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Delegation", null, panel_2, null);
		panel_2.setLayout(null);
		
		JButton btnMakeBasket = new JButton("Make Basket");
		btnMakeBasket.setBounds(10, 11, 133, 23);
		panel_2.add(btnMakeBasket);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBounds(153, 11, 266, 211);
		panel_2.add(panel_5);
		
		JLabel label_1 = new JLabel("Name");
		label_1.setBounds(10, 11, 46, 14);
		panel_5.add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(66, 8, 190, 20);
		panel_5.add(textField_2);
		
		JButton btnAddCostumer = new JButton("Add Costumer");
		btnAddCostumer.setBounds(10, 45, 133, 23);
		panel_2.add(btnAddCostumer);
		
		JButton btnRemoveCostumer = new JButton("Remove Costumer");
		btnRemoveCostumer.setBounds(10, 79, 133, 23);
		panel_2.add(btnRemoveCostumer);
		
		JButton btnSeeAllDelegations = new JButton("See All Delegations");
		btnSeeAllDelegations.setBounds(10, 113, 133, 23);
		panel_2.add(btnSeeAllDelegations);
		
		JButton btnView = new JButton("View products");
		btnView.setBounds(10, 147, 133, 23);
		panel_2.add(btnView);
		
		JButton btnViewBaskets = new JButton("View Baskets");
		btnViewBaskets.setBounds(10, 181, 133, 23);
		panel_2.add(btnViewBaskets);
	}
}
