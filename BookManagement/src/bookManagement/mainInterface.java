package bookManagement;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class mainInterface {

	protected Shell shell;
	private String name;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Text text_6;
	private Label label_3;
	private Label label_4;
	private Label label_4_1;
	private Label label_4_2;
	private Label label_4_3;
	private Label label_4_4;
	private Label label_4_5;
	private Label label_5;
	private Label lblNewLabel;
	private Label label_6;
	private Button button_2;
	private Button button_2_1;
	private Button button_3;
	private Button button_4;
	private Button button_5;
	private Label lblAdmin;
	private Table table;
	private TableColumn tblclmnNewColumn;
	private TableColumn tblclmnNewColumn_1;
	private TableColumn tblclmnNewColumn_2;
	private TableColumn tblclmnNewColumn_3;
	private TableColumn tblclmnNewColumn_4;
	private TableColumn tblclmnNewColumn_5;
	private TableColumn tblclmnNewColumn_6;
	private TableItem tableItem;
	private Label lblNewLabel_1;
	private Label lblid;
	private Label label_8,label_9;
	private Text text;
	private Text text_9;
	private Text text_10;
	private Label label_10;
	private Text text_11;
	private Label label_11;
	private Text text_12;
	private Button btnNewButton_3;
	private Button button_8,btnRadioButton;
	private Table table_1;
	private TableColumn tblclmnNewColumn_7;
	private TableColumn tblclmnNewColumn_8;
	private TableColumn tblclmnNewColumn_9;
	private TableColumn tblclmnNewColumn_10;
	private TableColumn tblclmnNewColumn_11;
	private TableColumn tblclmnNewColumn_12;
	private TableColumn tblclmnNewColumn_13;
	private TableColumn tblclmnNewColumn_14;
	private TableColumn tblclmnNewColumn_15;
	private Button button_6,button_7_1,button_7;
	private Label label_7;
	private Label label_12;
	private Label label_13;
	private Label label_14,label_15,label_16,label_17,label_14_1;
	private Text text_7;
	private Text text_8;
	private Table table_2;
	private Text text_13;
	private Text text_14;
	private Table table_3;
	private Label label_18;
	private TableColumn tblclmnNewColumn_16;
	private TableColumn tblclmnNewColumn_17;
	private TableColumn tblclmnNewColumn_19;
	private TableColumn tblclmnNewColumn_20;
	private TableColumn tblclmnNewColumn_21;
	private TableColumn tblclmnNewColumn_22;
	private TableColumn tblclmnNewColumn_23;
	private TableColumn tblclmnNewColumn_24;
	private Button button_9;
	private TableColumn tblclmnNewColumn_18;

	mainInterface(String n){
		name = n;
	}
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			mainInterface window = new mainInterface("");
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
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setToolTipText("");
		shell.setSize(1328, 791);
		shell.setText("用户主界面");
		shell.setMaximumSize(1328, 791);
		shell.setMinimumSize(1328, 791);
		
		button_9 = new Button(shell, SWT.NONE);
		button_9.setText("修改图书信息");
		button_9.setBounds(890, 651, 98, 30);
		button_9.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				dlt window = new dlt();
				window.open();
			}
		});
		
		btnRadioButton = new Button(shell, SWT.RADIO);
		btnRadioButton.setBounds(1146, 225, 86, 20);
		btnRadioButton.setText("进货");
		
		button_8 = new Button(shell, SWT.RADIO);
		button_8.setBounds(1058, 225, 86, 20);
		button_8.setText("销售");
		
		label_18 = new Label(shell, SWT.NONE);
		label_18.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_NORMAL_SHADOW));
		label_18.setBounds(810, 301, 292, 20);
		label_18.setText("*输入格式需符合'yyyy-MM-dd HH:mm:ss'");
		
		label_17 = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		label_17.setBounds(782, 95, 2, 621);
		
		button_7_1 = new Button(shell, SWT.NONE);
		button_7_1.setText("操作查询");
		button_7_1.setBounds(1176, 638, 98, 30);
		button_7_1.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				table_3.removeAll();
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
				ResultSet rs = null;
				try {
					rs = sm.executeQuery("SELECT* from [order] WHERE ordertime between cast('"+text_13.getText()+
							"' as datetime) and cast('"+text_14.getText()+"' as datetime)");
				} catch (SQLException e2) {
					// TODO 自动生成的 catch 块
					e2.printStackTrace();
				}//SQL查询语句
				try {
					boolean c = true;
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					while (rs.next()) {
						String n1 = rs.getString(1);
						String n6 = rs.getString(6);
						String n7 = rs.getString(7);
						String n8 = rs.getString(8);
						Timestamp n9 = rs.getTimestamp(9);
						if(button_8.getSelection()&&n7.trim().equals(button_8.getText())) {
							tableItem = new TableItem(table_3, SWT.NONE);
							tableItem.setText(new String[] {n1.trim(),n6.trim(),n8.trim(),simpleDateFormat.format(n9)});
							c = false;
						}
						if(btnRadioButton.getSelection()&&n7.trim().equals(btnRadioButton.getText())) {
							tableItem = new TableItem(table_3, SWT.NONE);
							tableItem.setText(new String[] {n1.trim(),n6.trim(),n8.trim(),simpleDateFormat.format(n9)});
							c = false;
						}
					}
					if(c) {
						MessageBox dialog=new MessageBox(shell,SWT.OK|SWT.ICON_WORKING);
						dialog.setText("提示");
						dialog.setMessage("查询无结果");
						dialog.open();
					}
				} catch (SQLException e2) {
					// TODO 自动生成的 catch 块
					e2.printStackTrace();
				}
			}
		});
		
		button_7 = new Button(shell, SWT.NONE);
		button_7.setBounds(666, 638, 98, 30);
		button_7.setText("图书查询");
		button_7.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				table_2.removeAll();
				if(text_7.getText().trim().length()==0&&text_8.getText().trim().length()==0) {
					MessageBox dialog=new MessageBox(shell,SWT.OK|SWT.ICON_WORKING);
					dialog.setText("提示");
					dialog.setMessage("书名和作者不能都为空");
					dialog.open();
					return;
				}
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
				ResultSet rs = null;
				try {
					rs = sm.executeQuery("SELECT* FROM book");
				} catch (SQLException e2) {
					// TODO 自动生成的 catch 块
					e2.printStackTrace();
				}//SQL查询语句
				try {
					boolean c = true;
					while (rs.next()) {
						String n1 = rs.getString(1);
						String n2 = rs.getString(2);
						String n3 = rs.getString(3);
						int n6 = rs.getInt(6);
						float n7 = rs.getFloat(7);
						if(text_7.getText().trim().length()!=0&&text_8.getText().trim().length()!=0&&n2.trim().contains(text_7.getText().trim())&&
								n3.trim().contains(text_8.getText().trim())) {
							tableItem = new TableItem(table_2, SWT.NONE);
							tableItem.setText(new String[] {n1.trim(),n2.trim(),n3.trim(),String.valueOf(n6).trim(),String.valueOf(n7).trim()});
							c = false;
						}
						else if(text_7.getText().trim().length()!=0&&text_8.getText().trim().length()==0&&n2.trim().contains(text_7.getText().trim())) {
							tableItem = new TableItem(table_2, SWT.NONE);
							tableItem.setText(new String[] {n1.trim(),n2.trim(),n3.trim(),String.valueOf(n6).trim(),String.valueOf(n7).trim()});
							c = false;
						}
						else if(text_8.getText().trim().length()!=0&&text_7.getText().trim().length()==0&&n3.trim().contains(text_8.getText().trim())) {
							tableItem = new TableItem(table_2, SWT.NONE);
							tableItem.setText(new String[] {n1.trim(),n2.trim(),n3.trim(),String.valueOf(n6).trim(),String.valueOf(n7).trim()});
							c = false;
						}
					}
					if(c) {
						MessageBox dialog=new MessageBox(shell,SWT.OK|SWT.ICON_WORKING);
						dialog.setText("提示");
						dialog.setMessage("查询无结果");
						dialog.open();
					}
				} catch (SQLException e2) {
					// TODO 自动生成的 catch 块
					e2.printStackTrace();
				}
			}
		});
		
		table_3 = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table_3.setLinesVisible(true);
		table_3.setHeaderVisible(true);
		table_3.setBounds(810, 390, 479, 198);
		
		tblclmnNewColumn_21 = new TableColumn(table_3, SWT.NONE);
		tblclmnNewColumn_21.setWidth(119);
		tblclmnNewColumn_21.setText("记录ID");
		
		tblclmnNewColumn_22 = new TableColumn(table_3, SWT.NONE);
		tblclmnNewColumn_22.setWidth(85);
		tblclmnNewColumn_22.setText("客户姓名");
		
		tblclmnNewColumn_23 = new TableColumn(table_3, SWT.NONE);
		tblclmnNewColumn_23.setWidth(86);
		tblclmnNewColumn_23.setText("管理员");
		
		tblclmnNewColumn_24 = new TableColumn(table_3, SWT.NONE);
		tblclmnNewColumn_24.setWidth(184);
		tblclmnNewColumn_24.setText("操作时间");
		
		label_14_1 = new Label(shell, SWT.NONE);
		label_14_1.setText("查询结果：");
		label_14_1.setBounds(811, 345, 76, 20);
		
		text_14 = new Text(shell, SWT.BORDER);
		text_14.setBounds(1058, 269, 231, 26);
		
		text_13 = new Text(shell, SWT.BORDER);
		text_13.setBounds(807, 269, 231, 26);
		
		label_16 = new Label(shell, SWT.NONE);
		label_16.setBounds(811, 225, 240, 20);
		label_16.setText("查询在以下两个时间段之间的操作：");
		
		label_15 = new Label(shell, SWT.NONE);
		label_15.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND));
		label_15.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 20, SWT.NORMAL));
		label_15.setBounds(807, 130, 198, 43);
		label_15.setText("查询操作记录");
		
		table_2 = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table_2.setBounds(270, 390, 494, 198);
		table_2.setHeaderVisible(true);
		table_2.setLinesVisible(true);
		
		tblclmnNewColumn_16 = new TableColumn(table_2, SWT.NONE);
		tblclmnNewColumn_16.setWidth(120);
		tblclmnNewColumn_16.setText("图书ID");
		
		tblclmnNewColumn_17 = new TableColumn(table_2, SWT.NONE);
		tblclmnNewColumn_17.setWidth(130);
		tblclmnNewColumn_17.setText("书名");
		
		tblclmnNewColumn_18 = new TableColumn(table_2, SWT.NONE);
		tblclmnNewColumn_18.setWidth(100);
		tblclmnNewColumn_18.setText("作者");
		
		tblclmnNewColumn_19 = new TableColumn(table_2, SWT.NONE);
		tblclmnNewColumn_19.setWidth(78);
		tblclmnNewColumn_19.setText("剩余库存");
		
		tblclmnNewColumn_20 = new TableColumn(table_2, SWT.NONE);
		tblclmnNewColumn_20.setWidth(71);
		tblclmnNewColumn_20.setText("现价");
		
		label_14 = new Label(shell, SWT.NONE);
		label_14.setBounds(285, 345, 76, 20);
		label_14.setText("查询结果：");
		
		text_8 = new Text(shell, SWT.BORDER);
		text_8.setBounds(478, 282, 195, 26);
		
		text_7 = new Text(shell, SWT.BORDER);
		text_7.setBounds(478, 222, 195, 26);
		
		label_13 = new Label(shell, SWT.NONE);
		label_13.setBounds(375, 285, 76, 20);
		label_13.setText("图书作者：");
		
		label_12 = new Label(shell, SWT.NONE);
		label_12.setBounds(375, 225, 76, 20);
		label_12.setText("图书书名：");
		
		label_7 = new Label(shell, SWT.NONE);
		label_7.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND));
		label_7.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 20, SWT.NORMAL));
		label_7.setBounds(300, 130, 132, 43);
		label_7.setText("查询图书");
		
		button_6 = new Button(shell, SWT.NONE);
		button_6.setBounds(1146, 625, 128, 56);
		button_6.setText("更新记录");
		button_6.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				table_1.removeAll();
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
				ResultSet rs = null;
				try {
					rs = sm.executeQuery("SELECT* FROM [order]");
				} catch (SQLException e2) {
					// TODO 自动生成的 catch 块
					e2.printStackTrace();
				}//SQL查询语句
				try {
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					while (rs.next()) {
						String n1 = rs.getString(1);
						String n2 = rs.getString(2);
						String n3 = rs.getString(3);
						int n4 = rs.getInt(4);
						float n5 = rs.getFloat(5);
						String n6 = rs.getString(6);
						String n7 = rs.getString(7);
						String n8 = rs.getString(8);
						Timestamp n9 = rs.getTimestamp(9);
						tableItem = new TableItem(table_1, SWT.NONE);
						tableItem.setText(new String[] {n1.trim(),n2.trim(),n3.trim(),String.valueOf(n4).trim(),String.valueOf(n5).trim(),n6.trim(),
								n7.trim(),n8.trim(),simpleDateFormat.format(n9)});
					}
				} catch (SQLException e2) {
					// TODO 自动生成的 catch 块
					e2.printStackTrace();
				}
			}
		});
		
		table_1 = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table_1.setBounds(285, 179, 994, 394);
		table_1.setHeaderVisible(true);
		table_1.setLinesVisible(true);
		
		tblclmnNewColumn_7 = new TableColumn(table_1, SWT.NONE);
		tblclmnNewColumn_7.setWidth(122);
		tblclmnNewColumn_7.setText("订单ID");
		
		tblclmnNewColumn_8 = new TableColumn(table_1, SWT.NONE);
		tblclmnNewColumn_8.setWidth(122);
		tblclmnNewColumn_8.setText("书本ID");
		
		tblclmnNewColumn_9 = new TableColumn(table_1, SWT.NONE);
		tblclmnNewColumn_9.setWidth(118);
		tblclmnNewColumn_9.setText("联系方式电话");
		
		tblclmnNewColumn_10 = new TableColumn(table_1, SWT.NONE);
		tblclmnNewColumn_10.setWidth(83);
		tblclmnNewColumn_10.setText("图书数量");
		
		tblclmnNewColumn_11 = new TableColumn(table_1, SWT.NONE);
		tblclmnNewColumn_11.setWidth(76);
		tblclmnNewColumn_11.setText("交易价格");
		
		tblclmnNewColumn_12 = new TableColumn(table_1, SWT.NONE);
		tblclmnNewColumn_12.setWidth(87);
		tblclmnNewColumn_12.setText("客户姓名");
		
		tblclmnNewColumn_13 = new TableColumn(table_1, SWT.NONE);
		tblclmnNewColumn_13.setWidth(77);
		tblclmnNewColumn_13.setText("交易模式");
		
		tblclmnNewColumn_14 = new TableColumn(table_1, SWT.NONE);
		tblclmnNewColumn_14.setWidth(90);
		tblclmnNewColumn_14.setText("操作管理员");
		
		tblclmnNewColumn_15 = new TableColumn(table_1, SWT.NONE);
		tblclmnNewColumn_15.setWidth(203);
		tblclmnNewColumn_15.setText("操作时间");
		
		label_6 = new Label(shell, SWT.NONE);
		label_6.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 20, SWT.NORMAL));
		label_6.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND));
		label_6.setBounds(285, 113, 132, 43);
		label_6.setText("操作记录");
		
		button_5 = new Button(shell, SWT.NONE);
		button_5.setBounds(979, 593, 140, 68);
		button_5.setText("上交销售订单");
		button_5.addSelectionListener(new SelectionAdapter(){
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
					ResultSet rs;
					rs = sm.executeQuery("SELECT* FROM [order]");//SQL查询语句
					String n1 = null;
					while (rs.next()) {
						n1 = rs.getString(1);
					}
					String b = n1.trim().substring(1);
					int a = Integer.parseInt(b)+1;
					String c = "M";
					for(int i = 0; i < 9-Integer.toString(a).length(); i++) {
						c+="0";
					}
					c+=Integer.toString(a);
					rs = sm.executeQuery("SELECT* FROM book where bookID="+"'"+text.getText()+"'");//SQL查询语句
					int a2 = 0;
					while (rs.next()) {
						a2 = rs.getInt(6);
					}
					int a1 = a2-Integer.parseInt(text_10.getText());
					if(a1<0) {
						MessageBox dialog=new MessageBox(shell,SWT.OK|SWT.ICON_WORKING);
						dialog.setText("提示");
						dialog.setMessage("库存不够");
						dialog.open();
						return;
					}
					sm.executeUpdate("insert into [order] values('"+c+"','"+text.getText()+"','"+text_12.getText()+"','"+text_10.getText()+"','"
							+text_9.getText()+"','"+text_11.getText()+"','销售','"+name+"',GETDATE())");
					sm.executeUpdate("Update book set bookcount="+a1+" where bookID="+"'"+text.getText()+"'");
					MessageBox dialog=new MessageBox(shell,SWT.OK|SWT.ICON_WORKING);
					dialog.setText("提示");
					dialog.setMessage("订单提交成功");
					dialog.open();
					text.setText("");
					text_9.setText("");
					text_10.setText("");
					text_11.setText("");
					text_12.setText("");
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		
		btnNewButton_3 = new Button(shell, SWT.NONE);
		btnNewButton_3.setBounds(979, 593, 140, 68);
		btnNewButton_3.setText("上交进货订单");
		btnNewButton_3.addSelectionListener(new SelectionAdapter(){
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
					ResultSet rs;
					rs = sm.executeQuery("SELECT* FROM [order]");//SQL查询语句
					String n1 = null;
					while (rs.next()) {
						n1 = rs.getString(1);
					}
					String b = n1.trim().substring(1);
					int a = Integer.parseInt(b)+1;
					String c = "M";
					for(int i = 0; i < 9-Integer.toString(a).length(); i++) {
						c+="0";
					}
					c+=Integer.toString(a);
					sm.executeUpdate("insert into [order] values('"+c+"','"+text.getText()+"','"+text_12.getText()+"','"+text_10.getText()+"','"
					+text_9.getText()+"','"+text_11.getText()+"','进货','"+name+"',GETDATE())");
					rs = sm.executeQuery("SELECT* FROM book where bookID="+"'"+text.getText()+"'");//SQL查询语句
					int a2 = 0;
					while (rs.next()) {
						a2 = rs.getInt(6);
					}
					int a1 = a2+Integer.parseInt(text_10.getText());
					sm.executeUpdate("Update book set bookcount="+a1+" where bookID="+"'"+text.getText()+"'");
					MessageBox dialog=new MessageBox(shell,SWT.OK|SWT.ICON_WORKING);
					dialog.setText("提示");
					dialog.setMessage("订单提交成功");
					dialog.open();
					text.setText("");
					text_9.setText("");
					text_10.setText("");
					text_11.setText("");
					text_12.setText("");
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		
		text_12 = new Text(shell, SWT.BORDER);
		text_12.setBounds(600, 530, 262, 26);
		
		label_11 = new Label(shell, SWT.NONE);
		label_11.setBounds(500, 530, 76, 20);
		label_11.setText("批发商电话");
		
		text_11 = new Text(shell, SWT.BORDER);
		text_11.setText("");
		text_11.setBounds(600, 460, 262, 26);
		
		label_10 = new Label(shell, SWT.NONE);
		label_10.setBounds(500, 460, 76, 20);
		label_10.setText("批发商名");
		
		text_10 = new Text(shell, SWT.BORDER);
		text_10.setBounds(600, 390, 262, 26);
		
		text_9 = new Text(shell, SWT.BORDER);
		text_9.setBounds(600, 320, 262, 26);
		
		label_9 = new Label(shell, SWT.NONE);
		label_9.setBounds(500, 320, 76, 20);
		label_9.setText("价格");
		
		label_8 = new Label(shell, SWT.NONE);
		label_8.setBounds(500, 390, 76, 20);
		label_8.setText("数量");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(600, 250, 262, 26);
		
		lblid = new Label(shell, SWT.NONE);
		lblid.setBounds(500, 250, 76, 20);
		lblid.setText("图书ID");
		
		lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND));
		lblNewLabel_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 20, SWT.NORMAL));
		lblNewLabel_1.setBounds(300, 130, 132, 43);
		lblNewLabel_1.setText("进货订单");
		
		button_4 = new Button(shell, SWT.NONE);
		button_4.setBounds(1021, 651, 98, 30);
		button_4.setText("更新信息");
		button_4.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				table.removeAll();
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
				ResultSet rs = null;
				try {
					rs = sm.executeQuery("SELECT* FROM book");
				} catch (SQLException e2) {
					// TODO 自动生成的 catch 块
					e2.printStackTrace();
				}//SQL查询语句
				try {
					while (rs.next()) {
						String n1 = rs.getString(1);
						String n2 = rs.getString(2);
						String n3 = rs.getString(3);
						String n4 = rs.getString(4);
						String n5 = rs.getString(5);
						double n6 = rs.getDouble(6);
						String n7 = rs.getString(7);
						tableItem = new TableItem(table, SWT.NONE);
						tableItem.setText(new String[] {n1.trim(),n2.trim(),n3.trim(),n4.trim(),n5.trim(),String.valueOf(n6).trim(),n7.trim()});
					}
				} catch (SQLException e2) {
					// TODO 自动生成的 catch 块
					e2.printStackTrace();
				}
			}
		});
		
		button_3 = new Button(shell, SWT.NONE);
		button_3.setBounds(1160, 651, 98, 30);
		button_3.setText("添加图书信息");
		button_3.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				getmsg window = new getmsg();
				window.open();
			}
		});
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setHeaderForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_BLUE));
		table.setToolTipText("");
		table.setHeaderVisible(true);
		table.setBounds(300, 200, 958, 432);
		table.setLinesVisible(true);
		
		tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setMoveable(true);
		tblclmnNewColumn.setWidth(140);
		tblclmnNewColumn.setText("图书ID");
		
		tblclmnNewColumn_6 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_6.setWidth(198);
		tblclmnNewColumn_6.setText("书名");
		
		tblclmnNewColumn_5 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_5.setWidth(123);
		tblclmnNewColumn_5.setText("作者");
		
		tblclmnNewColumn_4 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_4.setWidth(187);
		tblclmnNewColumn_4.setText("出版社");
		
		tblclmnNewColumn_3 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_3.setWidth(100);
		tblclmnNewColumn_3.setText("图书类型");
		
		tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(100);
		tblclmnNewColumn_2.setText("图书数量");
		
		tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(101);
		tblclmnNewColumn_1.setText("图书现价");
		
		lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND));
		lblNewLabel.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 20, SWT.NORMAL));
		lblNewLabel.setBounds(300, 130, 132, 43);
		lblNewLabel.setText("图书信息");
		
		Label label = new Label(shell, SWT.NONE);
		label.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		label.setFont(SWTResourceManager.getFont("华文仿宋", 25, SWT.BOLD));
		label.setToolTipText("");
		label.setBounds(323, 14, 648, 47);
		label.setText("冻 梨 书 店 图 书 销 售 管 理 系 统");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		btnNewButton.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		btnNewButton.setBounds(20, 125, 211, 78);
		btnNewButton.setText("进货管理");
		btnNewButton.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				clear();
				lblNewLabel_1.setText("进货订单");
				label_10.setText("批发商名");
				label_11.setText("批发商电话");
				lblNewLabel_1.setVisible(true);
				lblid.setVisible(true);
				text.setVisible(true);
				label_9.setVisible(true);
				text_9.setVisible(true);
				label_8.setVisible(true);
				text_10.setVisible(true);
				label_10.setVisible(true);
				text_11.setVisible(true);
				label_11.setVisible(true);
				text_12.setVisible(true);
				btnNewButton_3.setVisible(true);
			}
		});
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.setText("销售管理");
		btnNewButton_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		btnNewButton_1.setBounds(20, 225, 211, 78);
		btnNewButton_1.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				clear();
				lblNewLabel_1.setText("销售订单");
				label_10.setText("顾客姓名");
				label_11.setText("顾客电话");
				lblNewLabel_1.setVisible(true);
				lblid.setVisible(true);
				text.setVisible(true);
				label_9.setVisible(true);
				text_9.setVisible(true);
				label_8.setVisible(true);
				text_10.setVisible(true);
				label_10.setVisible(true);
				text_11.setVisible(true);
				label_11.setVisible(true);
				text_12.setVisible(true);
				button_5.setVisible(true);
			}
		});
		
		Button btnNewButton_1_1 = new Button(shell, SWT.NONE);
		btnNewButton_1_1.setText("查询现有存货");
		btnNewButton_1_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		btnNewButton_1_1.setBounds(20, 325, 211, 78);
		btnNewButton_1_1.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				clear();
				lblNewLabel.setVisible(true);
				table.setVisible(true);
				button_3.setVisible(true);
				button_4.setVisible(true);
				button_9.setVisible(true);
			}
		});
		
		Button btnNewButton_1_1_1 = new Button(shell, SWT.NONE);
		btnNewButton_1_1_1.setText("入库出库记录");
		btnNewButton_1_1_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		btnNewButton_1_1_1.setBounds(20, 425, 211, 78);
		btnNewButton_1_1_1.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				clear();
				label_6.setVisible(true);
				table_1.setVisible(true);
				button_6.setVisible(true);
			}
		});
		
		Button button = new Button(shell, SWT.NONE);
		button.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 15, SWT.NORMAL));
		button.setBounds(1053, 14, 112, 50);
		button.setText("个人中心");
		button.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				clear();
				Statement sm = null;
				try {
					sm = new connect().cnt().createStatement();
				} catch (ClassNotFoundException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				ResultSet rs = null;
				try {
					rs = sm.executeQuery("SELECT* FROM adminis");
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}//SQL查询语句
				label_3.setVisible(true);
				label_4.setVisible(true);
				label_4_1.setVisible(true);
				label_4_2.setVisible(true);
				label_4_3.setVisible(true);
				label_4_4.setVisible(true);
				label_4_5.setVisible(true);
				label_5.setVisible(true);
				text_1.setVisible(true);
				text_2.setVisible(true);
				text_3.setVisible(true);
				text_4.setVisible(true);
				text_5.setVisible(true);
				text_6.setVisible(true);
				button_2.setVisible(true);
				String n1 = null;
				String n2 = null;
				String n3 = null;
				String n4 = null;
				int n5 = 0;
				String n6 = null;
				try {
					while (rs.next()) {
						n1 = rs.getString(1);
						n2 = rs.getString(2);
						n3 = rs.getString(3);
						n4 = rs.getString(4);
						n5 = rs.getInt(5);
						n6 = rs.getString(6);
						if(name.equals(n3.trim())) break;
					}
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				text_1.setText(n3.trim());
				text_2.setText(n1.trim());
				text_3.setText(n6.trim());
				text_4.setText(n2.trim());
				text_5.setText(n4.trim());
				text_6.setText(String.valueOf(n5).trim());
				text_1.setEditable(false);
				text_2.setEditable(false);
				text_3.setEditable(false);
				text_4.setEditable(false);
				text_5.setEditable(false);
				text_6.setEditable(false);
				button_2.addSelectionListener(new SelectionAdapter(){
					public void widgetSelected(SelectionEvent e){
						text_1.setEditable(true);
						text_3.setEditable(true);
						text_4.setEditable(true);
						text_5.setEditable(true);
						text_6.setEditable(true);
					}
				});
				button_2_1.setVisible(true);
				button_2_1.addSelectionListener(new SelectionAdapter(){
					public void widgetSelected(SelectionEvent e){
						if(!text_1.getEditable()) {
							MessageBox dialog=new MessageBox(shell,SWT.OK|SWT.ICON_WORKING);
							dialog.setText("提示");
							dialog.setMessage("信息未修改");
							dialog.open();
							return;
						}
						Statement sm = null;
						try {
							sm = new connect().cnt().createStatement();
						} catch (ClassNotFoundException e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						}
						try {
							sm.executeUpdate("update adminis set adminissex="+"'"+text_4.getText()+"'"+",adminisname="+"'"+
						    text_1.getText()+"'"+",administele="+"'"+text_5.getText()+"'"+",adminisage="+Integer.parseInt(text_6.getText())+
							",adminispw="+"'"+text_3.getText()+"'"+" where adminisID="+"'"+text_2.getText()+"'");
						} catch (NumberFormatException e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						}
						MessageBox dialog=new MessageBox(shell,SWT.OK|SWT.ICON_WORKING);
						dialog.setText("提示");
						dialog.setMessage("信息修改成功");
						dialog.open();
						text_1.setEditable(false);
						text_3.setEditable(false);
						text_4.setEditable(false);
						text_5.setEditable(false);
						text_6.setEditable(false);
					}
				});
			}
		});
		
		Button button_1 = new Button(shell, SWT.NONE);
		button_1.setText("退出登录");
		button_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 15, SWT.NORMAL));
		button_1.setBounds(1188, 14, 112, 50);
		button_1.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				MessageBox messageBox = new MessageBox(shell, SWT.OK|SWT.CANCEL|SWT.ICON_INFORMATION);
				messageBox.setText("确认");
				messageBox.setMessage("是否要登出当前账号？");
				if (messageBox.open() == SWT.OK)
				{
					shell.close();
					login window = new login();
					window.open();
				}
			}
		});
		
		Button btnNewButton_1_1_1_1 = new Button(shell, SWT.NONE);
		btnNewButton_1_1_1_1.setText("查询中心");
		btnNewButton_1_1_1_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		btnNewButton_1_1_1_1.setBounds(20, 525, 211, 78);
		btnNewButton_1_1_1_1.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				clear();
				label_7.setVisible(true);
				label_12.setVisible(true);
				label_13.setVisible(true);
				text_7.setVisible(true);
				text_8.setVisible(true);
				label_14.setVisible(true);
				table_2.setVisible(true);
				label_15.setVisible(true);
				label_16.setVisible(true);
				text_13.setVisible(true);
				text_14.setVisible(true);
				label_14_1.setVisible(true);
				table_3.setVisible(true);
				button_7.setVisible(true);
				button_7_1.setVisible(true);
				label_17.setVisible(true);
				label_18.setVisible(true);
				button_8.setVisible(true);
				btnRadioButton.setVisible(true);
			}
		});
		
		Button btnNewButton_1_1_1_2 = new Button(shell, SWT.NONE);
		btnNewButton_1_1_1_2.setText("使用说明");
		btnNewButton_1_1_1_2.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		btnNewButton_1_1_1_2.setBounds(20, 625, 211, 78);
		btnNewButton_1_1_1_2.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				clear();
			}
		});
		
		Label label_1 = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		label_1.setBounds(249, 0, 2, 757);
		
		Label label_2 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_2.setBounds(10, 87, 1290, 2);
		
		label_3 = new Label(shell, SWT.NONE);
		label_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND));
		label_3.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 20, SWT.NORMAL));
		label_3.setBounds(300, 130, 132, 43);
		label_3.setText("个人信息");
		
		label_4 = new Label(shell, SWT.NONE);
		label_4.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		label_4.setBounds(500, 250, 67, 26);
		label_4.setText("昵称：");
		
		label_4_1 = new Label(shell, SWT.NONE);
		label_4_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		label_4_1.setText("账号：");
		label_4_1.setBounds(500, 300, 67, 32);
		
		label_4_2 = new Label(shell, SWT.NONE);
		label_4_2.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		label_4_2.setText("密码：");
		label_4_2.setBounds(500, 350, 67, 26);
		
		label_4_3 = new Label(shell, SWT.NONE);
		label_4_3.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		label_4_3.setText("性别：");
		label_4_3.setBounds(500, 400, 67, 26);
		
		label_4_4 = new Label(shell, SWT.NONE);
		label_4_4.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		label_4_4.setText("电话：");
		label_4_4.setBounds(500, 450, 67, 26);
		
		label_4_5 = new Label(shell, SWT.NONE);
		label_4_5.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		label_4_5.setText("年龄：");
		label_4_5.setBounds(500, 500, 67, 26);
		
		label_5 = new Label(shell, SWT.NONE);
		label_5.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_NORMAL_SHADOW));
		label_5.setBounds(323, 656, 337, 20);
		label_5.setText("*账号不可修改，其他信息的更改条件与注册时一致");
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(572, 250, 381, 26);
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(572, 300, 381, 26);
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBounds(572, 350, 381, 26);
		
		text_4 = new Text(shell, SWT.BORDER);
		text_4.setBounds(572, 400, 381, 26);
		
		text_5 = new Text(shell, SWT.BORDER);
		text_5.setBounds(572, 450, 381, 26);
		
		text_6 = new Text(shell, SWT.BORDER);
		text_6.setBounds(572, 500, 381, 26);
		
		button_2 = new Button(shell, SWT.NONE);
		button_2.setBounds(710, 577, 98, 30);
		button_2.setText("修改");
		
		button_2_1 = new Button(shell, SWT.NONE);
		button_2_1.setText("确定");
		button_2_1.setBounds(855, 577, 98, 30);
		
		lblAdmin = new Label(shell, SWT.NONE);
		lblAdmin.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblAdmin.setBounds(20, 14, 211, 64);
		String s = "       你好，admin\r\n";
		for(int i = 0; i < 18-2*name.length(); i++) {
			s+=" ";
		}
		lblAdmin.setText(s+name);
		clear();
	}
	private void clear() {
		label_3.setVisible(false);
		label_4.setVisible(false);
		label_4_1.setVisible(false);
		label_4_2.setVisible(false);
		label_4_3.setVisible(false);
		label_4_4.setVisible(false);
		label_4_5.setVisible(false);
		label_5.setVisible(false);
		text_1.setVisible(false);
		text_2.setVisible(false);
		text_3.setVisible(false);
		text_4.setVisible(false);
		text_5.setVisible(false);
		text_6.setVisible(false);
		button_2.setVisible(false);
		button_2_1.setVisible(false);
		lblNewLabel.setVisible(false);
		table.setVisible(false);
		button_3.setVisible(false);
		button_4.setVisible(false);
		lblNewLabel_1.setVisible(false);
		lblid.setVisible(false);
		text.setVisible(false);
		label_9.setVisible(false);
		text_9.setVisible(false);
		label_8.setVisible(false);
		text_10.setVisible(false);
		label_10.setVisible(false);
		text_11.setVisible(false);
		label_11.setVisible(false);
		text_12.setVisible(false);
		btnNewButton_3.setVisible(false);
		button_5.setVisible(false);
		label_6.setVisible(false);
		table_1.setVisible(false);
		button_6.setVisible(false);
		label_7.setVisible(false);
		label_12.setVisible(false);
		label_13.setVisible(false);
		text_7.setVisible(false);
		text_8.setVisible(false);
		label_14.setVisible(false);
		table_2.setVisible(false);
		label_15.setVisible(false);
		label_16.setVisible(false);
		text_13.setVisible(false);
		text_14.setVisible(false);
		label_14_1.setVisible(false);
		table_3.setVisible(false);
		button_7.setVisible(false);
		button_7_1.setVisible(false);
		label_17.setVisible(false);
		label_18.setVisible(false);
		button_8.setVisible(false);
		btnRadioButton.setVisible(false);
		button_9.setVisible(false);
	}
}
