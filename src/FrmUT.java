import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.*;

public class FrmUT {
	static JFrame app=new JFrame("Penghitung IP STMIK STIKOM Surabaya");
	static JLabel lblMK=new JLabel("Nama Mata Kuliah");
	static JLabel lblSKS=new JLabel("Jumlah SKS");
	static JLabel lblUTS=new JLabel("Nilai UTS");
	static JLabel lblUAS=new JLabel("Nilai UAS");
	static JLabel lblTGS=new JLabel("Nilai Tugas");
	static JTextField txtMK=new JTextField();
	static JTextField txtSKS=new JTextField();
	static JTextField txtUTS=new JTextField();
	static JTextField txtUAS=new JTextField();
	static JTextField txtTGS=new JTextField();
	static JButton btnAdd= new JButton("Tambah ke Daftar");
	static JButton btnRem= new JButton("Hapus dari Daftar");
	static DefaultTableModel md=new DefaultTableModel();
	static JTable tblMK=new JTable();
	static JScrollPane sp=new JScrollPane(tblMK);
	static JButton btnOK= new JButton("Hitung IP");
	static JButton btnClose= new JButton("Keluar");
	static JLabel lblIP=new JLabel();

	public static void main(String [] x) {
		mkWindow();
		klik();
	}
	
	private static void mkWindow(){
		app.setResizable(false);
		app.setLayout(null);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		app.add(lblMK);
		app.add(lblSKS);
		app.add(lblTGS);
		app.add(lblUAS);
		app.add(lblUTS);
		app.add(txtMK);
		app.add(txtSKS);
		app.add(txtTGS);
		app.add(txtUAS);
		app.add(txtUTS);
		app.add(btnAdd);
		app.add(btnRem);
		app.add(sp);
		app.add(btnOK);
		app.add(btnClose);
		app.add(lblIP);
				
		lblMK.setBounds(20, 0, 130, 20);
		lblSKS.setBounds(lblMK.getBounds().x+lblMK.getBounds().width+10, 0, 90, 20);
		lblTGS.setBounds(lblSKS.getBounds().x+lblSKS.getBounds().width+10, 0, 80, 20);
		lblUTS.setBounds(lblTGS.getBounds().x+lblTGS.getBounds().width+10, 0, 80, 20);
		lblUAS.setBounds(lblUTS.getBounds().x+lblUTS.getBounds().width+10, 0, 80, 20);
		
		txtMK.setBounds(lblMK.getBounds().x, 25, 130, 20);
		txtSKS.setBounds(lblSKS.getBounds().x, 25, 90, 20);
		txtTGS.setBounds(lblTGS.getBounds().x, 25, 80, 20);
		txtUTS.setBounds(lblUTS.getBounds().x, 25, 80, 20);
		txtUAS.setBounds(lblUAS.getBounds().x, 25, 80, 20);		
		
		btnAdd.setBounds(txtMK.getBounds().x, txtMK.getBounds().y+txtMK.getBounds().height+5, (txtUAS.getBounds().x+txtUAS.getBounds().width-25)/2, 20);
		btnRem.setBounds(btnAdd.getBounds().x+btnAdd.getBounds().width+5, txtMK.getBounds().y+txtMK.getBounds().height+5, (txtUAS.getBounds().x+txtUAS.getBounds().width-25)/2, 20);
		
		sp.setBounds(20,btnAdd.getBounds().y+btnAdd.getBounds().height+5,txtUAS.getBounds().x+txtUAS.getBounds().width-20,200);
		btnOK.setBounds(20,sp.getBounds().y+sp.getBounds().height+10,100,20);
		btnClose.setBounds(btnOK.getBounds().x+btnOK.getBounds().width+10,btnOK.getBounds().y,100,20);
		lblIP.setBounds(btnClose.getBounds().x+btnClose.getBounds().width+100,btnOK.getBounds().y,200,20);
		lblIP.setText("IP Anda: -");
		
		app.setSize(sp.getBounds().width+40, btnOK.getBounds().y+btnOK.getBounds().height+10);

		md.addColumn("Nama Matakuliah");
		md.addColumn("SKS");
		md.addColumn("Tugas");
		md.addColumn("UTS");
		md.addColumn("UAS");
		md.addColumn("Akhir");
		md.addColumn("Huruf");
		tblMK.setModel(md);
		tblMK.getColumnModel().getColumn(0).setPreferredWidth(200);
		tblMK.getColumnModel().getColumn(1).setPreferredWidth(30);
		tblMK.getColumnModel().getColumn(2).setPreferredWidth(30);
		tblMK.getColumnModel().getColumn(3).setPreferredWidth(30);
		tblMK.getColumnModel().getColumn(4).setPreferredWidth(30);
		tblMK.getColumnModel().getColumn(5).setPreferredWidth(30);
		tblMK.getColumnModel().getColumn(6).setPreferredWidth(30);
		tblMK.setVisible(true);
		
		app.setVisible(true);
		app.addWindowListener(new WindowAdapter() {
			  public void windowClosing(WindowEvent e) {
			    JOptionPane.showMessageDialog(null, "Terima kasih telah menggunakan program aplikasi ini.\n"
			    		+ "The programmer is >>H.San (13410100082)<< #Pamer Mode ON :D\n"
			    		+ "Terima kasih kepada:\n"
			    		+ "+Allah S.W.T.\n"
			    		+ "+Orang Tua\n"
			    		+ "+Mr.Teguh Sutanto, M.Kom\n"
			    		+ "+Mbah Google");
			  }
			});
	}
	
	private static void updateTabel(JTable tbl){
		for(int i=0;i<tbl.getRowCount();i++){
			double akh=(Double.parseDouble(tbl.getValueAt(i, 2).toString())*0.4)+
					(Double.parseDouble(tbl.getValueAt(i, 3).toString())*0.3)+
					(Double.parseDouble(tbl.getValueAt(i, 4).toString())*0.3);
			tbl.setValueAt(akh, i, 5);
			tbl.setValueAt(getHuruf(akh), i, 6);
		}
	}
		
	private static void klik() {
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!txtMK.getText().equals("") &&
					!txtSKS.getText().equals("") && 
					!txtTGS.getText().equals("") &&
					!txtUTS.getText().equals("") &&
					!txtUAS.getText().equals("")){
						updateTabel(tblMK);
						double akh=(Double.parseDouble(txtTGS.getText())*0.4)+
								(Double.parseDouble(txtUTS.getText())*0.3)+
								(Double.parseDouble(txtUAS.getText())*0.3);
						
						md.addRow(new Object[]{txtMK.getText(),
								txtSKS.getText(),
								txtTGS.getText(),
								txtUTS.getText(),
								txtUAS.getText(),
								akh,
								getHuruf(akh)});
						tblMK.setModel(md);
						txtMK.setText("");
						txtSKS.setText("");
						txtTGS.setText("");
						txtUTS.setText("");
						txtUAS.setText("");
				}else{
					if(txtMK.getText().equals("")){
						txtMK.requestFocus();
					}

					if(txtSKS.getText().equals("")){
						txtSKS.requestFocus();
					}

					if(txtTGS.getText().equals("")){
						txtTGS.requestFocus();
					}

					if(txtUTS.getText().equals("")){
						txtUTS.requestFocus();
					}
					
					if(txtUAS.getText().equals("")){
						txtUAS.requestFocus();
					}
				}
			}
		});

		btnRem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(tblMK.getSelectedRow()!=-1){
					md.removeRow(tblMK.getSelectedRow());
					tblMK.setModel(md);
				}
			}
		});
				
		tblMK.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if((tblMK.getSelectedColumn()==6 || tblMK.getSelectedColumn()==5) && tblMK.isEditing()){
					tblMK.getCellEditor().cancelCellEditing();
				}
				updateTabel(tblMK);
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				updateTabel(tblMK);
			}
		});

		btnOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(tblMK.getRowCount()!=0){
					updateTabel(tblMK);
					lblIP.setText("IP Anda: "+hitungIP(tblMK));
				}else{
					lblIP.setText("IP Anda: -");
				}
			}
		});

		btnClose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			    JOptionPane.showMessageDialog(null, "Terima kasih telah menggunakan program aplikasi ini.\n"
			    		+ "The programmer is >>H.San (13410100082)<< #Pamer Mode ON :D\n"
			    		+ "Terima kasih kepada:\n"
			    		+ "+Allah S.W.T.\n"
			    		+ "+Orang Tua\n"
			    		+ "+Mr.Teguh Sutanto, M.Kom\n"
			    		+ "+Mbah Google");
				System.exit(0);
			}
		});
		
		txtSKS.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				char c = e.getKeyChar();
				if (c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE){  
					if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9')){
						e.consume();
		            }
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

		txtTGS.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				char c = e.getKeyChar();
				if (c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE){  
					if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9')){
						e.consume();
		            }
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

		txtUTS.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				char c = e.getKeyChar();
				if (c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE){  
					if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9')){
						e.consume();
		            }
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

		txtUAS.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				char c = e.getKeyChar();
				if (c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE){  
					if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9')){
						e.consume();
		            }
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public static String getHuruf(double nAkhir){
		String hrf="";
		int nAkh=(int)(nAkhir);
		if(nAkh<=100 && nAkh>=80){
			hrf="A";
		}else if(nAkh<=79 && nAkh>=75){
			hrf="B+";
		}else if(nAkh<=74 && nAkh>=65){
			hrf="B";
		}else if(nAkh<=64 && nAkh>=60){
			hrf="C+";
		}else if(nAkh<=59 && nAkh>=55){
			hrf="C";
		}else if(nAkh<=54 && nAkh>=40){
			hrf="D";
		}else if(nAkh<=39 && nAkh>=0){
			hrf="E";
		}
		return hrf;
	}
	
	public static String hitungIP(JTable tbl){
		String ip="";
		double mk=0;
		int sks=0;
		for(int i=0;i<tbl.getRowCount();i++){
			double bobot=0;
			sks+=Integer.parseInt(tbl.getValueAt(i, 1).toString());
			if(tbl.getValueAt(i, 6).equals("A")){
				bobot=4;
			}else if(tbl.getValueAt(i, 6).equals("B+")){
				bobot=3.5;
			}else if(tbl.getValueAt(i, 6).equals("B")){
				bobot=3;
			}else if(tbl.getValueAt(i, 6).equals("C+")){
				bobot=2.5;
			}else if(tbl.getValueAt(i, 6).equals("C")){
				bobot=2;
			}else if(tbl.getValueAt(i, 6).equals("D")){
				bobot=1;
			}else if(tbl.getValueAt(i, 6).equals("E")){
				bobot=0;
			}
			mk+=Integer.parseInt(tbl.getValueAt(i, 1).toString())*bobot;
		}
		ip=String.valueOf(mk/sks);
		return ip;
	}
}
