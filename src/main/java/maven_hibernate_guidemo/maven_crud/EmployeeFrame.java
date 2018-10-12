package maven_hibernate_guidemo.maven_crud;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EmployeeFrame extends JFrame {

	static JLabel lblEId,lblENm,lblEAdd;
	static JTextField txtEId,txtENm,txtEAdd;
	static JButton btnSave,btnDel,btnUpdate,btnFind,btnNew;
	JFrame f;
	JPanel p;
	public EmployeeFrame() {
		f=new JFrame("Employee Details");
		f.setSize(600, 400);
		f.setLayout(null);
		
		p=new JPanel();
		p.setLayout(null);
		p.setBounds(10, 10, 550, 400);
		f.add(p);
		
		lblEId=new JLabel("Employee Id:");
		lblEId.setBounds(10, 10, 120, 30);
		p.add(lblEId);
		
		txtEId=new JTextField();
		txtEId.setBounds(140, 10, 120, 30);
		p.add(txtEId);
		
		lblENm=new JLabel("Employee Name:");
		lblENm.setBounds(10, 60, 120, 30);
		p.add(lblENm);
		
		txtENm=new JTextField();
		txtENm.setBounds(140, 60, 120, 30);
		p.add(txtENm);
		
		lblEAdd=new JLabel("Employee Address:");
		lblEAdd.setBounds(10, 110, 120, 30);
		p.add(lblEAdd);
		
		txtEAdd=new JTextField();
		txtEAdd.setBounds(140, 110, 120, 30);
		p.add(txtEAdd);
		
		btnNew=new JButton("Add");
		btnNew.setBounds(20,160,60,30);
		p.add(btnNew);
		
		
		btnSave=new JButton("Save");
		btnSave.setBounds(100,160,80,30);
		p.add(btnSave);
		
		
		btnUpdate=new JButton("Update");
		btnUpdate.setBounds(200,160,80,30);
		p.add(btnUpdate);
		
		
		btnDel=new JButton("Delete");
		btnDel.setBounds(300,160,80,30);
		p.add(btnDel);
		
		
		btnFind=new JButton("Find");
		btnFind.setBounds(400,160,60,30);
		p.add(btnFind);
	
		
		
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
}
