/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai2;

import java.io.*;
import java.text.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author duong
 */
public class Action{
    //Click Them button
    public void addNewStudent(UI ui){
        String mssv        = ui.txtMssv.getText();
        String tenSV       = ui.txtTenSV.getText();
        String ngaySinh    = ui.txtNgaySinh.getText();
        SinhVien sv        = new SinhVien(mssv, tenSV, ngaySinh);
        if(validate(sv) && checkExists(sv, ui)){
            DefaultTableModel model = (DefaultTableModel) ui.table.getModel();
            Object[] objRow = {sv.mssv, sv.tenSv, sv.ngaySinh};
            model.addRow(objRow);
            resetTextField(ui);
        }
    }
    
    //Click Xoa button
    public void removeStudent(UI ui){
        DefaultTableModel model = (DefaultTableModel) ui.table.getModel();
        int rowIndex = ui.table.getSelectedRow();
        if(rowIndex == -1){
            JOptionPane.showMessageDialog(null, "Vui lòng chọn sinh viên trong danh sách!");
        } else {
            model.removeRow(rowIndex);
        }
        ui.btnXoa.setEnabled(false);
        ui.btnSua.setEnabled(false);
    }
    
    //Click Sua button
    public void updateStudent(UI ui){
        ui.btnLuu.setEnabled(true);
        DefaultTableModel model = (DefaultTableModel) ui.table.getModel();
        int rowIndex = ui.table.getSelectedRow();
        if(rowIndex == -1){
            JOptionPane.showMessageDialog(null, "Vui lòng chọn sinh viên trong danh sách!");
        } else {
            for (int i = 0; i < ui.table.getColumnCount(); i++){
                ui.txtMssv.setText(model.getValueAt(rowIndex, 0).toString());
                ui.txtTenSV.setText(model.getValueAt(rowIndex, 1).toString());
                ui.txtNgaySinh.setText(model.getValueAt(rowIndex, 2).toString());
            }
        }
    }
    
    //Click Luu button
    public void saveStudent(UI ui){
        String mssv        = ui.txtMssv.getText();
        String tenSV       = ui.txtTenSV.getText();
        String ngaySinh    = ui.txtNgaySinh.getText();
        SinhVien sv        = new SinhVien(mssv, tenSV, ngaySinh);
        if(validate(sv) && checkExists(sv, ui)){
            DefaultTableModel model = (DefaultTableModel) ui.table.getModel();
            int rowIndex = ui.table.getSelectedRow();
            for (int i = 0; i < ui.table.getColumnCount(); i++){
                model.setValueAt(sv.mssv, rowIndex, 0);
                model.setValueAt(sv.tenSv, rowIndex, 1);
                model.setValueAt(sv.ngaySinh, rowIndex, 2);
            }
        }
        ui.table.getSelectionModel().clearSelection();
        resetTextField(ui);
        ui.btnLuu.setEnabled(false);
        ui.btnSua.setEnabled(false);
        ui.btnXoa.setEnabled(false);
    }
    
    // Reset text field to default
    public void resetTextField(UI ui){
        ui.txtMssv.setText("");
        ui.txtTenSV.setText("");
        ui.txtNgaySinh.setText("");
    }
    
    // Validate text field
    public boolean validate(SinhVien sv){
        //Check empty
        if(sv.mssv.equals("") || sv.ngaySinh.equals("") || sv.tenSv.equals("")){
            JOptionPane.showMessageDialog(null, "Không được để trống!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        // Check valid date
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        boolean isOk = (sdf.parse(sv.ngaySinh, new ParsePosition(0)) != null);
        if(!isOk){
            JOptionPane.showMessageDialog(null, "Ngày sinh không đúng định dạng!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    // Check if mssv is exists
    public boolean checkExists(SinhVien sv, UI ui){
        DefaultTableModel model = (DefaultTableModel) ui.table.getModel();
        for (int count = 0; count < model.getRowCount(); count++){
            if(sv.mssv.equals(model.getValueAt(count, 0).toString())){
                JOptionPane.showMessageDialog(null, "Mssv đã tồn tại!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        }
        return true;
    }
    
    // Write list student to file
    public void writeFile(UI ui) {
        BufferedWriter writer = null;
        try {
            // Show choose folder to save dialog
            JFileChooser chooser = new JFileChooser(); 
            chooser.setCurrentDirectory(new java.io.File("."));
            chooser.setDialogTitle("Chọn nơi lưu!");
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            chooser.showOpenDialog(null);
            File dir2save = chooser.getSelectedFile();
            
            //Check file exists
            File f = new File(dir2save + "/SinhVien.txt");
            boolean canWrite = true;
            if(f.exists() && !f.isDirectory()) {
                int cf = JOptionPane.showConfirmDialog(null, 
                        "File SinhVien.txt đã tồn tại, bạn có muốn ghi đè lên không?", 
                        "Thông báo", 
                        JOptionPane.YES_NO_OPTION);
                if(cf == JOptionPane.NO_OPTION){
                    canWrite = false;
                }
            }
            if(canWrite){
                // Create new file
                File logFile = new File(dir2save, "SinhVien.txt");
                writer = new BufferedWriter(new FileWriter(logFile));
                DefaultTableModel model = (DefaultTableModel) ui.table.getModel();
                writer.write("Danh sách sinh viên:\n");
                for (int i = 0; i < ui.table.getRowCount(); i++){
                    for (int j = 0; j < ui.table.getColumnCount(); j++){
                        writer.write(model.getValueAt(i, j).toString() + "\t\t");
                    }
                    writer.write("\n");
                }
                writer.close();
                JOptionPane.showMessageDialog(null, "File SinhVien.txt đã được lưu!", "Message", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Open a file
    public void openFile() {
        try {
            // Show choose folder to save dialog
            JFileChooser chooser = new JFileChooser(); 
            chooser.setCurrentDirectory(new java.io.File("."));
            chooser.setDialogTitle("Chọn file!");
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            chooser.showOpenDialog(null);
            File fileOpen = chooser.getSelectedFile();
            JOptionPane.showMessageDialog(null, "Mở file " + fileOpen + " thành công!", "Message", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
