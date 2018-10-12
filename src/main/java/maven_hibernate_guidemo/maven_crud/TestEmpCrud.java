package maven_hibernate_guidemo.maven_crud;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.transaction.Transactional.TxType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestEmpCrud implements ActionListener{
	SessionFactory sessionFactory;
	Session session;
	Transaction tr;
	int flag;
	void sessionStuff(){
		sessionFactory= new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		tr = session.beginTransaction();
	}
	
		void doListen() {
			EmployeeFrame.btnNew.addActionListener(this);
			EmployeeFrame.btnSave.addActionListener(this);
			EmployeeFrame.btnUpdate.addActionListener(this);
			EmployeeFrame.btnDel.addActionListener(this);
			EmployeeFrame.btnFind.addActionListener(this);
		}
	
	public static void main(String[] args) {
		new EmployeeFrame();
		TestEmpCrud t=new TestEmpCrud();
		t.disabledText();
		 EmployeeFrame.btnNew.setEnabled(true);
		 EmployeeFrame.btnFind.setEnabled(true);
		 EmployeeFrame.btnSave.setEnabled(false);
		 EmployeeFrame.btnUpdate.setEnabled(false);
		 EmployeeFrame.btnDel.setEnabled(false);
		 
		t.doListen();
	    
	}
	public void clrText(){
		EmployeeFrame.txtEId.setText("");
		EmployeeFrame.txtENm.setText("");
		EmployeeFrame.txtEAdd.setText("");
	}
	public void enabledText(){
		EmployeeFrame.txtEId.setEditable(true);
		EmployeeFrame.txtENm.setEditable(true);
		EmployeeFrame.txtEAdd.setEditable(true);
	}
	public void disabledText(){
		EmployeeFrame.txtEId.setEditable(false);
		EmployeeFrame.txtENm.setEditable(false);
		EmployeeFrame.txtEAdd.setEditable(false);
	}
	public void actionPerformed(ActionEvent ae){
		Employee e = null;
		
		if(ae.getSource()==EmployeeFrame.btnNew){
			flag=0;
			clrText();
			enabledText();
			EmployeeFrame.txtEId.requestFocus();
			 EmployeeFrame.btnSave.setEnabled(true);
			 EmployeeFrame.btnFind.setEnabled(true);
			 EmployeeFrame.btnUpdate.setEnabled(false);
			 EmployeeFrame.btnDel.setEnabled(false);
		}
		if(ae.getSource()==EmployeeFrame.btnSave){
			e=new Employee(Integer.parseInt(EmployeeFrame.txtEId.getText()), EmployeeFrame.txtENm.getText(), EmployeeFrame.txtEAdd.getText());
			if(flag==0){
				sessionStuff();
				session.save(e);
				session.flush();
				tr.commit();
				JOptionPane.showMessageDialog(null, "record saved");
				disabledText();
			
			}
			else if(flag==1){
				sessionStuff();
				session.saveOrUpdate(e);
				session.flush();
				tr.commit();
				JOptionPane.showMessageDialog(null, "record Updated");
				disabledText();
			}	
		    EmployeeFrame.btnSave.setEnabled(false);
		    EmployeeFrame.btnUpdate.setEnabled(false);
		    EmployeeFrame.btnDel.setEnabled(false);
		    
		}
		if(ae.getSource()==EmployeeFrame.btnUpdate){
			flag=1;
			enabledText();
			EmployeeFrame.txtEId.setEnabled(false);
			EmployeeFrame.btnSave.setEnabled(true);
		}
		if(ae.getSource()==EmployeeFrame.btnDel){
			sessionStuff();
			Employee e1 = new Employee();
			e1.seteId(Integer.parseInt(EmployeeFrame.txtEId.getText()));
			session.delete(e1);
			tr.commit();
			JOptionPane.showMessageDialog(null, "record Deleted");
			EmployeeFrame.btnUpdate.setEnabled(false);
			EmployeeFrame.btnDel.setEnabled(false);
			clrText();
		}
		if(ae.getSource()==EmployeeFrame.btnFind){
			int id=Integer.parseInt(JOptionPane.showInputDialog("Enter id of an employee wch u want to find.."));
			sessionStuff();
			e=(Employee)session.get(Employee.class, id);
			
			if(e==null){
				JOptionPane.showMessageDialog(null, "record not found");
			}
			else{
				EmployeeFrame.txtEId.setText(""+e.geteId());
				EmployeeFrame.txtENm.setText(e.geteName());
				EmployeeFrame.txtEAdd.setText(e.geteAdd());
			}
				
			 EmployeeFrame.btnUpdate.setEnabled(true);
			 EmployeeFrame.btnDel.setEnabled(true);
		}
	}

}
