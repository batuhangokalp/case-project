import java.awt.EventQueue;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.image.ConvolveOp;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.lang.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import java.awt.SystemColor;

public class StockCard {

	private JFrame frame;
	private JTextField stokKoduTextField;
	private JTextField stokAdiTextField;
	private JTextField barkodTextField;
	private JTable table;
	private JTextField stokKoduTextField2; 

	/**
	 * Launch the application.
	 */
	
	DefaultTableModel model = new DefaultTableModel();
	
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StockCard window = new StockCard();
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
	public StockCard() {
		initialize();
		Baglan();
		tabloyaYukle();
	}
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
	public void Baglan() {
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/stokkarti", "root","");
			System.out.println("Baglanti basarili");
		} 
		
		catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("Baglanti basarisiz");
		}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Baglanti basarisiz");
		}
		
		
		
	}
	
	public void tabloyaYukle() {
		
		String query = "select * from stokkarticase order by OlusturmaTarih desc" ;
		try {
			pst=con.prepareStatement(query);
			rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1147, 629);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Stok Kart");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel.setBounds(475, -15, 233, 69);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 245, 220));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Kay\u0131tlar", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(35, 53, 481, 358);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Stok Kodu");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(12, 13, 130, 33);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Stok Ad\u0131");
		lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(12, 60, 130, 33);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Stok Tipi");
		lblNewLabel_1_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(12, 110, 130, 33);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Birim");
		lblNewLabel_1_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(12, 157, 130, 33);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Barkod");
		lblNewLabel_1_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_4.setBounds(12, 208, 130, 33);
		panel.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("KDV Tipi");
		lblNewLabel_1_5.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_5.setBounds(12, 254, 130, 33);
		panel.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("A\u00E7\u0131klama");
		lblNewLabel_1_6.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_6.setBounds(12, 300, 130, 33);
		panel.add(lblNewLabel_1_6);
		
		stokKoduTextField = new JTextField();
		stokKoduTextField.setBounds(231, 19, 208, 27);
		panel.add(stokKoduTextField);
		stokKoduTextField.setColumns(10);
		
		stokAdiTextField = new JTextField();
		stokAdiTextField.setColumns(10);
		stokAdiTextField.setBounds(231, 66, 208, 27);
		panel.add(stokAdiTextField);
		
		barkodTextField = new JTextField();
		barkodTextField.setColumns(10);
		barkodTextField.setBounds(231, 214, 208, 27);
		panel.add(barkodTextField);
		
		
		Integer [] stockType = {1,2,3};
		JComboBox stokTipiComboBox = new JComboBox(stockType);
		stokTipiComboBox.setBounds(231, 116, 208, 27);
		panel.add(stokTipiComboBox);
		this.add(stokTipiComboBox);
		
		
		Double [] kdvType= {1.0,8.0,18.0};
		JComboBox kdvTipiComboBox = new JComboBox(kdvType);
		kdvTipiComboBox.setBounds(231, 260, 208, 27);
		panel.add(kdvTipiComboBox);
		this.add(kdvTipiComboBox);
		
		
		String[] unit = {"A","B","C"};
		JComboBox birimComboBox = new JComboBox(unit);
		birimComboBox.setBounds(231, 163, 208, 27);
		panel.add(birimComboBox);
		this.add(birimComboBox);
		
		JTextArea aciklamaTextArea = new JTextArea();
		aciklamaTextArea.setLineWrap(true);
		aciklamaTextArea.setBackground(new Color(255, 255, 255));
		aciklamaTextArea.setBounds(231, 300, 208, 27);
		panel.add(aciklamaTextArea);
		
		JButton kaydetButton = new JButton("Ekle");
		kaydetButton.setBackground(new Color(102, 153, 255));
		kaydetButton.setForeground(new Color(255, 255, 255));
		kaydetButton.addActionListener(new ActionListener() {
			private PreparedStatement add;

			public void actionPerformed(ActionEvent arg0) {
				String stokKodu,stokAdi,barkod,birim,aciklama;
				int stokTipi;
				double kdvTipi;
				
				stokKodu=stokKoduTextField.getText();
				stokAdi=stokAdiTextField.getText();
				stokTipi=Integer.valueOf(stokTipiComboBox.getSelectedItem().toString());
				birim=birimComboBox.getSelectedItem().toString();
				barkod=barkodTextField.getText();
				kdvTipi=(double)kdvTipiComboBox.getSelectedItem();
				aciklama=aciklamaTextArea.getText();
				try {
					String query = " insert into stokkarticase (stokKodu, stokAdi, stokTipi, Birim, Barkod, KDVTip, Aciklama, OlusturmaTarih)"
					        + " values (?, ?, ?, ?, ?, ?, ?, ?)";
					pst=con.prepareStatement(query);
					pst.setString(1, stokKodu); 
					pst.setString(2, stokAdi); 
					pst.setInt(3,stokTipi);
					pst.setString(4,birim);
					pst.setString(5, barkod);
					pst.setDouble(6, kdvTipi);
					pst.setString(7, aciklama);
					pst.setTimestamp(8, java.sql.Timestamp.valueOf(LocalDateTime.now()));
					pst.execute();
					JOptionPane.showMessageDialog(null, "Eklendi"); 
					tabloyaYukle();
					
					stokKoduTextField.setText("");
					stokAdiTextField.setText("");
					birimComboBox.setName("");
					barkodTextField.setText("");
					aciklamaTextArea.setText("");
					stokKoduTextField.requestFocus();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		kaydetButton.setBounds(45, 434, 103, 38);
		frame.getContentPane().add(kaydetButton);
		
		JButton guncelleButton = new JButton("G\u00FCncelle");
		guncelleButton.setBackground(new Color(102, 153, 255));
		guncelleButton.setForeground(new Color(255, 255, 255));
		guncelleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String query = ("UPDATE stokkarticase SET stokAdi=?,stokTipi=?,Birim=?,Barkod=?,KDVTip=?,Aciklama=? WHERE stokKodu=?");
				
				
				try {
					pst=con.prepareStatement(query);
					pst.setString(1, stokAdiTextField.getText()); 
					pst.setInt(2, Integer.valueOf(stokTipiComboBox.getSelectedItem().toString()));
					pst.setString(3, (String) birimComboBox.getSelectedItem());
					pst.setString(4,barkodTextField.getText());
					pst.setDouble(5, (double) kdvTipiComboBox.getSelectedItem());
					pst.setString(6, (String)aciklamaTextArea.getText());
					pst.setString(7, stokKoduTextField.getText());
					pst.executeUpdate();
					tabloyaYukle();
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				

				
			}
		});
				
		guncelleButton.setBounds(223, 434, 103, 38);
		frame.getContentPane().add(guncelleButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(528, 53, 589, 358);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String stokKodu = (String) table.getValueAt(table.getSelectedRow(), 0);
				String stokAdi = (String) table.getValueAt(table.getSelectedRow(),1);
				int stokTipi = (Integer) table.getValueAt(table.getSelectedRow(), 2);
				String birim = (String) table.getValueAt(table.getSelectedRow(), 3);
				String barkod = (String) table.getValueAt(table.getSelectedRow(), 4);
				Double kdvTip = (Double) table.getValueAt(table.getSelectedRow(), 5);
				String aciklama = (String) table.getValueAt(table.getSelectedRow(), 6);
				
				stokKoduTextField.setText(stokKodu);
				stokAdiTextField.setText(stokAdi);
				stokTipiComboBox.setSelectedItem(stokTipi);
				birimComboBox.setSelectedItem(birim);
				barkodTextField.setText(barkod);
				kdvTipiComboBox.setSelectedItem(kdvTip);
				aciklamaTextArea.setText(aciklama);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Stok Kodu", "Stok Ad\u0131", "Stok Tipi", "Birim", "Barkod", "KDV Tipi", "A\u00E7\u0131klama", "Olu\u015Fturma Tarihi"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class, String.class, Integer.class, String.class, String.class, Double.class, Long.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		/*JButton listeleButton = new JButton("Listele");
		listeleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabloyaYukle();
				JOptionPane.showMessageDialog(null, "Listelendi.");
			}
		}); 
		listeleButton.setBounds(275, 434, 103, 38);
		frame.getContentPane().add(listeleButton); */
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 245, 220));
		panel_1.setBorder(new TitledBorder(null, "Arama", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(40, 485, 472, 69);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_7 = new JLabel("Stok Kodu");
		lblNewLabel_1_7.setBackground(new Color(230, 230, 250));
		lblNewLabel_1_7.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_7.setBounds(36, 23, 129, 30);
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_1.add(lblNewLabel_1_7);
		
		stokKoduTextField2 = new JTextField();
		stokKoduTextField2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
					
				try {
					String id = stokKoduTextField2.getText();
					if(id==null || id.equals("")) {
						tabloyaYukle();
						return;
					}
					String sql= "select * from stokkarticase where stokKodu LIKE ?" ;
					pst=con.prepareStatement(sql);
					pst.setString(1, "%" + id + "%"); 
				    rs =pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));

					
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		stokKoduTextField2.setColumns(10);
		stokKoduTextField2.setBounds(220, 26, 208, 27);
		panel_1.add(stokKoduTextField2);
		
		JButton cikisButton = new JButton("\u00C7\u0131k\u0131\u015F");
		cikisButton.setBackground(new Color(102, 153, 255));
		cikisButton.setForeground(new Color(255, 255, 255));
		cikisButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		cikisButton.setBounds(894, 502, 140, 38);
		frame.getContentPane().add(cikisButton);
		
		JButton silButton = new JButton("Sil");
		silButton.setBackground(new Color(102, 153, 255));
		silButton.setForeground(new Color(255, 255, 255));
		silButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = (String) table.getValueAt(table.getSelectedRow(), 0);
				String sql = "DELETE FROM stokkarticase WHERE stokKodu = ?";
				try {
					pst=con.prepareStatement(sql);
					pst.setString(1, id);
					pst.executeUpdate();
					tabloyaYukle();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.out.println("error:"+e1.getMessage());
					e1.printStackTrace();
				}
				
			}
		});
		silButton.setBounds(409, 434, 103, 38);
		frame.getContentPane().add(silButton);
		
	}

	private void add(JComboBox stokTipiComboBox) {
		// TODO Auto-generated method stub
		
	}
}
