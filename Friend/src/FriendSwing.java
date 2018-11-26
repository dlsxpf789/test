import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;

public class FriendSwing extends JFrame {

	private JPanel contentPane;
	private JSplitPane splitPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JTextField tfname;
	private JTextField tfbirth;
	private JTextField tfphone;
	private JTextField tfaddr;
	private JButton btninsert;
	private JButton btnview;
	private JSplitPane splitPane_1;
	private JPanel panel_1;
	private JComboBox comSel;
	private JTextField tfSearch;
	private JButton btnsearch;
	private JScrollPane scrollPane;
	FriendDBAImpl dba = new FriendDBAImpl();
	private JTextArea taview;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FriendSwing frame = new FriendSwing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FriendSwing() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getSplitPane());
	}

	private JSplitPane getSplitPane() {
		if (splitPane == null) {
			splitPane = new JSplitPane();
			splitPane.setBounds(5, 5, 708, 441);
			splitPane.setLeftComponent(getPanel());
			splitPane.setRightComponent(getSplitPane_1());
			splitPane.setDividerLocation(310);
		}
		return splitPane;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "\uAC1C\uC778\uC815\uBCF4\uB4F1\uB85D", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setLayout(null);
			panel.add(getLabel_1());
			panel.add(getLabel_2());
			panel.add(getLabel_1_1());
			panel.add(getLabel_2_1());
			panel.add(getTfname());
			panel.add(getTfbirth());
			panel.add(getTfphone());
			panel.add(getTfaddr());
			panel.add(getBtninsert());
			panel.add(getBtnview());
		}
		return panel;
	}
	private JLabel getLabel_1() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC774\uB984");
			lblNewLabel.setBounds(37, 58, 57, 15);
		}
		return lblNewLabel;
	}
	private JLabel getLabel_2() {
		if (label == null) {
			label = new JLabel("\uC0DD\uC77C");
			label.setBounds(37, 100, 57, 15);
		}
		return label;
	}
	private JLabel getLabel_1_1() {
		if (label_1 == null) {
			label_1 = new JLabel("\uC804\uD654\uBC88\uD638");
			label_1.setBounds(37, 145, 57, 15);
		}
		return label_1;
	}
	private JLabel getLabel_2_1() {
		if (label_2 == null) {
			label_2 = new JLabel("\uC8FC\uC18C");
			label_2.setBounds(37, 192, 57, 15);
		}
		return label_2;
	}
	private JTextField getTfname() {
		if (tfname == null) {
			tfname = new JTextField();
			tfname.setBounds(106, 55, 161, 21);
			tfname.setColumns(10);
		}
		return tfname;
	}
	private JTextField getTfbirth() {
		if (tfbirth == null) {
			tfbirth = new JTextField();
			tfbirth.setBounds(106, 97, 161, 21);
			tfbirth.setColumns(10);
		}
		return tfbirth;
	}
	private JTextField getTfphone() {
		if (tfphone == null) {
			tfphone = new JTextField();
			tfphone.setBounds(106, 142, 161, 21);
			tfphone.setColumns(10);
		}
		return tfphone;
	}
	private JTextField getTfaddr() {
		if (tfaddr == null) {
			tfaddr = new JTextField();
			tfaddr.setBounds(106, 189, 161, 21);
			tfaddr.setColumns(10);
		}
		return tfaddr;
	}
	private JButton getBtninsert() {
		if (btninsert == null) {
			btninsert = new JButton("\uCD94\uAC00");
			btninsert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
                    Friend f = new Friend();
					
					f.setName(tfname.getText());
					f.setBirth(tfbirth.getText());
					f.setPhone(tfphone.getText());
					f.setAddr(tfaddr.getText());
					
					dba.friendInsert(f);
				}
			});
			btninsert.setBounds(46, 286, 97, 23);
		}
		return btninsert;
	}
	private JButton getBtnview() {
		if (btnview == null) {
			btnview = new JButton("\uC804\uCCB4\uBCF4\uAE30");
			btnview.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ArrayList<Friend> arr=dba.friendView();
					taview.setText("");
					for(Friend f : arr) {
						taview.append("번호:" +f.getNum()+"\n");
						taview.append("이름:" +f.getName()+"\n");
						taview.append("생일:" +f.getBirth()+"\n");
						taview.append("전화번호:" +f.getPhone()+"\n");
						taview.append("주소:" +f.getAddr()+"\n\n");
				}
			}
			});
			btnview.setBounds(174, 286, 97, 23);
		}
		return btnview;
	}
	private JSplitPane getSplitPane_1() {
		if (splitPane_1 == null) {
			splitPane_1 = new JSplitPane();
			splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
			splitPane_1.setRightComponent(getPanel_1());
			splitPane_1.setLeftComponent(getScrollPane_2());
			splitPane_1.setDividerLocation(330);
		}
		return splitPane_1;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.add(getComSel());
			panel_1.add(getTfSearch());
			panel_1.add(getBtnsearch());
		}
		return panel_1;
	}
	private JComboBox getComSel() {
		if (comSel == null) {
			comSel = new JComboBox();
			comSel.setModel(new DefaultComboBoxModel(new String[] {"\uC120\uD0DD\uD558\uC138\uC694", "\uC774\uB984", "\uC8FC\uC18C"}));
			comSel.setToolTipText("\uC120\uD0DD");
			comSel.setBounds(12, 33, 74, 21);
		}
		return comSel;
	}
	private JTextField getTfSearch() {
		if (tfSearch == null) {
			tfSearch = new JTextField();
			tfSearch.setBounds(98, 33, 153, 21);
			tfSearch.setColumns(10);
		}
		return tfSearch;
	}
	private JButton getBtnsearch() {
		if (btnsearch == null) {
			btnsearch = new JButton("\uCC3E\uAE30");
			btnsearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					taview.setText("");
					String str="";
					if(comSel.getSelectedIndex()==1) {
						str="name";
					}else if(comSel.getSelectedIndex()==2) {
						str="addr";
					}
					ArrayList<Friend> arr=dba.friendsearch(str,tfSearch.getText());
					for(Friend f:arr) {
						taview.append("번호:" +f.getNum()+"\n");
						taview.append("이름:" +f.getName()+"\n");
						taview.append("생일:" +f.getBirth()+"\n");
						taview.append("전화번호:" +f.getPhone()+"\n");
						taview.append("주소:" +f.getAddr()+"\n\n");
				}
				}
			});
			btnsearch.setBounds(263, 32, 97, 23);
		}
		return btnsearch;
	}
	private JScrollPane getScrollPane_2() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTaview());
		}
		return scrollPane;
	}
	private JTextArea getTaview() {
		if (taview == null) {
			taview = new JTextArea();
		}
		return taview;
	}
}
