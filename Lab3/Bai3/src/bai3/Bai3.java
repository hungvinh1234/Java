/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai3;

import java.io.*;
import java.util.*;

/**
 *
 * @author duong
 */
public class Bai3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Bai3 b3 = new Bai3();
//        b3.a1_1_a();
//        b3.a1_1_b();
//        b3.a1_1_c();
//        b3.a1_2_a();
//        b3.a1_2_b();
//        b3.a1_3_a();
//        b3.a1_3_b();
//        b3.a2_1_a();
//        b3.a2_1_b();
//        b3.a2_2_a();
//        b3.a2_2_b();
//        b3.a2_3();
    }
    
    public void a1_1_a(){
        File file = new File("b1.txt");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            int content;
            while ((content = fis.read()) != -1) {
                System.out.print((int)content + " - " + (char) content + "\n");
            }
        } catch (IOException e) {
                e.printStackTrace();
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException ex) {
                    ex.printStackTrace();
            }
        }
    }
    
    public void a1_1_b(){
        String content = "We are the best group";
        new FileCustom().writeFile(content, "b2.txt");
    }
    
    public void a1_1_c(){
        File file = new File("b1.txt");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            int readCount = 0;
            byte byte2read[] = new byte[10];
            while ((readCount = fis.read(byte2read)) > 0) {
                String value = new String(byte2read, 0, readCount-1);
                System.out.print(value + "\n");
            }
        } catch (IOException e) {
                e.printStackTrace();
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException ex) {
                    ex.printStackTrace();
            }
        }
    }
    
    public void a1_2_a(){
        String content = "Hello Students and Pupils\n";
        Student tungMoutain = new Student("Sơn Tùng", "M-TP");
        content += tungMoutain.getFirstName() + " " + tungMoutain.getLastName() + "\n";
        content += new Pupil("Minh Mạng").getFullName() + "\n";
        Student bt = new Student("Bảo", "Thy");
        content += bt.getFirstName() + " " + bt.getLastName() + "\n";
        new FileCustom().writeFile(content, "student.txt");
    }
    
    public void a1_2_b(){
        new FileCustom().readFile("student.txt");
    }
    
    public void a1_3_a(){
        Random rand = new Random();
        String content = "";
        
        System.out.println("Nhập số phần tử: ");
        Scanner scanner = new Scanner(System.in);
        int scn = scanner.nextInt();
        for(int i = 0; i < scn; i++){
            content += rand.nextInt(100) + 1 + "\n";
        }
        new FileCustom().writeFile(content, "bufftest.txt");
    }
    
    public void a1_3_b(){
        new FileCustom().readFile("bufftest.txt");
    }
    
    public void a2_1_a(){
        String content = "";
        
        System.out.println("Nhập số phần tử: ");
        Scanner scanner = new Scanner(System.in);
        int scn = scanner.nextInt();
        System.out.println("Nhập mảng A: ");
        for(int i = 0; i < scn; i++){
            int value = scanner.nextInt();
            content += value + "\n";
        }
        new FileCustom().writeFile(content, "A2.txt");
    }
    
    public void a2_1_b(){
        new FileCustom().readFile("A2.txt");
    }
    
    public void a2_2_a(){
        String content = "Danh sách sinh viên:\n";
        System.out.println("Nhập số lượng sinh viên: ");
        Scanner scanner = new Scanner(System.in);
        int scn = scanner.nextInt();
        for(int i = 1; i <= scn; i++){
            System.out.println("Nhập SV " + i + " :\nNhập MSSV: ");
            Scanner s2 = new Scanner(System.in);
            String mssv = s2.nextLine();
            System.out.println("Nhập họ tên: ");
            String hoten = s2.nextLine();
            System.out.println("Nhập lớp: ");
            String lop = s2.nextLine();
            System.out.println("Nhập điểm: ");
            String diem = s2.nextLine();
            content += mssv + "\t" + hoten + "\t" + lop + "\t" + diem + "\n";
        }
        new FileCustom().writeFile(content, "sinhvien.txt");
    }
    
    public void a2_2_b() throws FileNotFoundException, IOException{
        File inputFile = new File("sinhvien.txt");
        File tempFile = new File("myTempFile.txt");
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        System.out.println("Nhập mssv muốn xóa:");
        Scanner scanner = new Scanner(System.in);
        String lineToRemove = scanner.nextLine();
        String currentLine;

        while((currentLine = reader.readLine()) != null) {
            // trim newline when comparing with lineToRemove
            String trimmedLine = currentLine.trim();
            String arr[] = trimmedLine.split("\t", 2);
            String firstWord = arr[0];
            System.out.println(firstWord);
            if(firstWord.equals(lineToRemove)) continue;
            writer.write(currentLine + System.getProperty("line.separator"));
        }
        writer.close(); 
        reader.close(); 
        tempFile.renameTo(inputFile);
    }
    
    public void a2_3(){
        System.out.println("Nhập số hàng n của ma trận (nxm): ");
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        System.out.println("Nhập số cột m của ma trận (nxm): ");
        Scanner scanner2 = new Scanner(System.in);
        int col = scanner2.nextInt();
        int matrix[][] = new int[row][col];
        Random rand = new Random();
        String content = "";
        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                matrix[r][c] = rand.nextInt(100) + 1;
                content += matrix[r][c] + "\t";
            }
            content += "\n";
        }
        new FileCustom().writeFile(content, "btvn.txt");
        
        // Read file
        System.out.println("Ma trận " + row + "*" + col);
        new FileCustom().readFile("btvn.txt");
    }
}
