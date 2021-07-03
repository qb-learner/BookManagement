package bookManagement;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;

public class dlt {

	protected Shell shlid;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			dlt window = new dlt();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlid.open();
		shlid.layout();
		while (!shlid.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlid = new Shell();
		shlid.setSize(566, 521);
		shlid.setText("修改图书信息");
		shlid.setMaximumSize(566, 521);
		shlid.setMinimumSize(566, 521);
		
		text = new Text(shlid, SWT.BORDER);
		text.setBounds(195, 69, 262, 26);
		
		Button button = new Button(shlid, SWT.NONE);
		button.setBounds(212, 412, 98, 30);
		button.setText("确定");
		
		Label lblid = new Label(shlid, SWT.NONE);
		lblid.setBounds(80, 72, 76, 20);
		lblid.setText("图书ID");
		
		Label label = new Label(shlid, SWT.NONE);
		label.setBounds(80, 125, 76, 20);
		label.setText("书名");
		
		Label label_1 = new Label(shlid, SWT.NONE);
		label_1.setBounds(80, 176, 76, 20);
		label_1.setText("作者");
		
		Label label_2 = new Label(shlid, SWT.NONE);
		label_2.setBounds(80, 229, 76, 20);
		label_2.setText("出版社");
		
		Label label_3 = new Label(shlid, SWT.NONE);
		label_3.setBounds(80, 282, 76, 20);
		label_3.setText("图书类型");
		
		Label lblNewLabel = new Label(shlid, SWT.NONE);
		lblNewLabel.setBounds(80, 329, 76, 20);
		lblNewLabel.setText("图书现价");
		
		text_1 = new Text(shlid, SWT.BORDER);
		text_1.setBounds(195, 125, 262, 26);
		
		text_2 = new Text(shlid, SWT.BORDER);
		text_2.setBounds(195, 170, 262, 26);
		
		text_3 = new Text(shlid, SWT.BORDER);
		text_3.setBounds(195, 229, 262, 26);
		
		text_4 = new Text(shlid, SWT.BORDER);
		text_4.setBounds(195, 276, 262, 26);
		
		text_5 = new Text(shlid, SWT.BORDER);
		text_5.setBounds(195, 329, 262, 26);
		button.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				Statement sm = null;
				try {
					sm = new connect().cnt().createStatement();
				} catch (ClassNotFoundException e2) {
					// TODO 自动生成的 catch 块
					e2.printStackTrace();
				} catch (SQLException e2) {
					// TODO 自动生成的 catch 块
					e2.printStackTrace();
				}
				try {
					int i = 0;
					ResultSet rs = null;
					rs = sm.executeQuery("SELECT* FROM book where bookID='"+text.getText().trim()+"'");//SQL查询语句
					while (rs.next()) {
						i++;
					}
					if(i==0) {
						MessageBox dialog=new MessageBox(shlid,SWT.OK|SWT.ICON_WORKING);
						dialog.setText("提示");
						dialog.setMessage("不存在该图书");
						dialog.open();
					}else {
						sm.executeUpdate("Update book set bookname='"+text_1.getText()+"',bookauthor='"+text_2.getText()+"',publisher='"+text_3.getText()+
								"',typeID='"+text_4.getText()+"',bookprice="+text_5.getText()+" where bookID='"+text.getText().trim()+"'");
						MessageBox dialog=new MessageBox(shlid,SWT.OK|SWT.ICON_WORKING);
						dialog.setText("提示");
						dialog.setMessage("图书信息修改成功");
						dialog.open();
						shlid.close();
					}
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
	}
}
