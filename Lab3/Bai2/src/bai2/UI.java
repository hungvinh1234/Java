/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author duong
 */
public class UI {
    public JLabel lblMssv, lblTenSV, lblNgaySinh;
    public JTextField txtMssv, txtTenSV, txtNgaySinh;
    public JButton btnThem, btnLuu, btnSua, btnXoa;
    public JButton btnMoFile, btnLuuFile, btnHuy, btnThoat;
    public JFrame frm;
    public JPanel pnl, pnlInfo, pnlList, pnlButton;
    public JTable table;
    public JScrollPane scrollPane;
    
    public void showUI(){
        init();
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pnl.setLayout(new BoxLayout(pnl, BoxLayout.Y_AXIS));
        frm.add(pnl);
        pnl.add(studentInfoPanel());
        pnl.add(studentListPanel());
        pnl.add(footerButtonPanel());
        addEventToButton();
        frm.setVisible(true);
    }
    
    private void init(){
        lblMssv     = new JLabel("Mã số sinh viên:");
        lblTenSV    = new JLabel("Tên sinh viên:");
        lblNgaySinh = new JLabel("Ngày sinh:");
        
        txtMssv     = new JTextField("", 20);
        txtTenSV    = new JTextField("", 20);
        txtNgaySinh = new JTextField("", 20);
        
        btnThem     = new JButton("Thêm");
        btnLuu      = new JButton("Lưu");
        btnSua      = new JButton("Sửa");
        btnXoa      = new JButton("Xóa");
        btnLuu.setEnabled(false);
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
//        btnThem.setPreferredSize(new Dimension(80, 30));
//        btnLuu.setPreferredSize(new Dimension(80, 30));
//        btnSua.setPreferredSize(new Dimension(80, 30));
//        btnXoa.setPreferredSize(new Dimension(80, 30));
        
        btnMoFile   = new JButton("Mở File");
        btnLuuFile  = new JButton("Lưu File");
        btnHuy      = new JButton("Hủy");
        btnThoat    = new JButton("Thoát");
        
        frm = new JFrame("Quản lý sinh viên");
        frm.setSize(650, 450);
        
        pnl         = new JPanel();
        pnlInfo     = new JPanel();
        pnlList     = new JPanel();
        pnlButton   = new JPanel();
    }
    
    private JPanel studentInfoPanel(){
        pnlInfo.setPreferredSize(new Dimension(650, 200));
        pnlInfo.setLayout(new GridBagLayout());
        pnlInfo.setBorder(BorderFactory.createTitledBorder("Thông tin sinh viên"));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridy = 0;
        gbc.gridx = 0;
        pnlInfo.add(lblMssv, gbc);
        gbc.gridx = 1;
        pnlInfo.add(txtMssv, gbc);
        
        gbc.gridy = 1;
        gbc.gridx = 0;
        pnlInfo.add(lblTenSV, gbc);
        gbc.gridx = 1;
        pnlInfo.add(txtTenSV, gbc);
        
        gbc.gridy = 2;
        gbc.gridx = 0;
        pnlInfo.add(lblNgaySinh, gbc);
        gbc.gridx = 1;
        pnlInfo.add(txtNgaySinh, gbc);
        gbc.gridx = 3;
        pnlInfo.add(new JLabel("(dd/mm/yy)"), gbc);
        
        gbc.gridy = 3;
        gbc.gridx = 1;
        JPanel pnlButtonHeader = new JPanel();
        pnlButtonHeader.add(btnThem);
        pnlButtonHeader.add(btnLuu);
        pnlButtonHeader.add(btnSua);
        pnlButtonHeader.add(btnXoa);
        pnlInfo.add(pnlButtonHeader, gbc);
        
        return pnlInfo;
    }
    
    private JPanel studentListPanel(){
        pnlList.setLayout(new FlowLayout());
        pnlList.setBorder(BorderFactory.createTitledBorder("Danh sách sinh viên"));
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Mã số sinh viên");
        model.addColumn("Tên sinh viên");
        model.addColumn("Ngày sinh");
        model.addRow(new Object[]{"123", "Na", "11/12/1997"});
        model.addRow(new Object[]{"124", "Chuoi", "21/12/1997"});
        model.addRow(new Object[]{"125", "Mang cau", "31/12/1997"});
        table = new JTable(model);
        table.setDefaultEditor(Object.class, null);
        table.setPreferredSize(new Dimension(600, 150));
        scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(600, 100));
        scrollPane.setSize(new Dimension(600, 200));
        pnlList.add(scrollPane);
        return pnlList;
    }
    
    private JPanel footerButtonPanel(){
        pnlButton.setPreferredSize(new Dimension(650, 50));
        
        JPanel pnlLeft = new JPanel();
        pnlLeft.setPreferredSize(new Dimension(500, 50));
        pnlLeft.setLayout(new BoxLayout(pnlLeft, BoxLayout.X_AXIS));
        pnlLeft.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        pnlLeft.add(btnMoFile);
        pnlLeft.add(Box.createRigidArea(new Dimension(10,0)));
        pnlLeft.add(btnLuuFile);
        pnlLeft.add(Box.createRigidArea(new Dimension(10,0)));
        pnlLeft.add(btnHuy);
        
        pnlButton.add(pnlLeft);
        
        JPanel pnlRight = new JPanel();
        pnlRight.add(btnThoat);
        pnlButton.add(pnlRight);
        return pnlButton;
    }
    
    private void addEventToButton(){
        btnThem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Action ac = new Action();
                ac.addNewStudent(UI.this);
            }
        });
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
                btnSua.setEnabled(true);
                btnXoa.setEnabled(true);
            }
        });
        btnXoa.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Action ac = new Action();
                ac.removeStudent(UI.this);
            }
        });
        btnSua.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Action ac = new Action();
                ac.updateStudent(UI.this);
            }
        });
        btnLuu.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Action ac = new Action();
                ac.saveStudent(UI.this);
            }
        });
        btnLuuFile.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Action ac = new Action();
                ac.writeFile(UI.this);
            }
        });
        btnMoFile.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Action ac = new Action();
                ac.openFile();
            }
        });
        btnHuy.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                frm.dispatchEvent(new WindowEvent(frm, WindowEvent.WINDOW_CLOSING));
            }
        });
        btnThoat.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                frm.dispatchEvent(new WindowEvent(frm, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
