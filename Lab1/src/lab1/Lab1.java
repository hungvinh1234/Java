/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author duong
 */
public class Lab1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        
        Lab1 bt = new Lab1();
        bt.cau1();
        bt.cau2();
        bt.cau3();
        bt.cau4();
        bt.cau5();
        bt.cau6();
        bt.cau7();
        bt.cau8();
    }
    
    public void cau1(){
        System.out.println("Hello World");
    }
    
    public void cau2(){
        Scanner x1 = new Scanner(System.in);
        System.out.println("Nhập vào x  : ");
        float x = x1.nextFloat();
        Scanner n1 = new Scanner(System.in);
        System.out.println("Nhập vào n  : ");
        float n = n1.nextFloat();
        
        float sum = 0;
        int down = 0;
        for(int i = 1; i <= n; i++){
            double up = Math.pow(x, i);
            down += i;
            sum += up/down;
        }
        System.out.println("S(n) = " + sum);
    }
    
    public void cau3(){
        System.out.print("Nhập vào c1  : ");
        Scanner c1 = new Scanner(System.in);
        float n1 = c1.nextFloat();
        System.out.print("Nhập vào c2  : ");
        Scanner c2 = new Scanner(System.in);
        float n2 = c2.nextFloat();
        System.out.print("Nhập vào c3  : ");
        Scanner c3 = new Scanner(System.in);
        float n3 = c3.nextFloat();
        
        float cv = n1 + n2 + n3;
        double dt = Math.sqrt( Math.pow( Math.pow(n1,2) + Math.pow(n2,2) + Math.pow(n3,2), 2) - 2*( Math.pow(n1,4) + Math.pow(n2,4) + Math.pow(n3,4) ) ) / 4;
        System.out.println("Chu vi = " + cv);
        System.out.println("Diện tích = " + dt);
    }
    
    public void cau4(){
//        Liệt kê các ước số của n
        System.out.print("Nhập vào n  : ");
        Scanner n1 = new Scanner(System.in);
        int n = n1.nextInt();
        System.out.print("Danh sách ước số của " + n + ": ");
        for(int i = 1; i <= n/2; i++){
            if(n % i == 0){
                System.out.print(i + ", ");
            }
        }
        System.out.println(n);
        
//        Cho biết n có bao nhiêu chữ số
        int length = String.valueOf(n).length();
        System.out.println(n + " có " + length + " chữ số.");
        
//        Kiểm tra n phải là số đối xứng không?
        String temp = Integer.toString(n);
        int[] arrayNumber = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++)
        {
            arrayNumber[i] = temp.charAt(i) - '0';
        }
        int arrLength = arrayNumber.length;
        int index = arrLength-1;
        boolean isDx = true;
        for(int i = 0; i < arrLength/2; i++){
            if( arrayNumber[i] != arrayNumber[index--] ) {
                isDx = false; break;
            }
        }
        String dxConc = n + (isDx ? " là số đối xứng!" : " không phải số đối xứng!");
        System.out.println(dxConc);
        
//        Kiểm tra n là số chính phương không?
        double sq = Math.sqrt(n);
        boolean isCp = true;
        if((sq - (int) sq) > 0){
            isCp = false;
        }
        String cpConc = n + (isCp ? " là số chính phương!" : " không phải số chính phương!");
        System.out.println(cpConc);
    }
    
    public void cau5(){
//        Cho biết tổng chiều dài 2 chuỗi s1 và s2.
        System.out.print("Nhập vào s1  : ");
        Scanner n1 = new Scanner(System.in);
        String s1 = n1.nextLine();
        System.out.print("Nhập vào s2  : ");
        Scanner n2 = new Scanner(System.in);
        String s2 = n2.nextLine();
        int sLength = s1.length() + s2.length();
        System.out.println("Tổng chiều dài s1 + s2: " + sLength);
        
//        Lấy 3 kí tự đầu tiên chuỗi s1.
        int s1Length = s1.length();
        if(s1Length >= 3){
            System.out.println("3 ký tự đầu chuỗi s1: " + s1.substring(0,3));
        } else {
            System.out.println("3 ký tự đầu chuỗi s1: " + s1.substring(0,s1Length));
        }
        
//        Lấy 3 kí tự cuối của chuỗi s2.
        int s2Length = s2.length();
        if(s2Length >= 3){
            System.out.println("3 ký tự cuối chuỗi s2: " + s2.substring(s2Length-3,s2Length));
        } else {
            System.out.println("3 ký tự cuối chuỗi s2: " + s2.substring(0,s2Length));
        }
        
//        Lấy kí tự thứ 6 của chuỗi x
        if(s1Length >= 6){
            System.out.println("Ký tự thứ 6 chuỗi s1: " + s1.substring(5,6));
        } else {
            System.out.println("Độ dài chuỗi s1 < 6!");
        }
        if(s2Length >= 6){
            System.out.println("Ký tự thứ 6 chuỗi s2: " + s2.substring(5,6));
        } else {
            System.out.println("Độ dài chuỗi s2 < 6!");
        }
        
//        Kiểm tra 2 chuỗi s1 và s2 có bằng nhau không?
        boolean cps = new String(s1).equals(s2);
        if(cps){
            System.out.println("Chuỗi s1 = s2");
        } else {
            System.out.println("Chuỗi s1 != s2");
        }
        
//        Cho biết s2 có xuất hiện trong s1 hay không? Nếu có thì đó là vị trí nào?
        boolean isXh = s1.contains(s2);
        String xhConc = isXh ? "Chuỗi s2 xuất hiện trong s1!" : "Chuỗi s2 KHÔNG xuất hiện trong s1!";
        System.out.println(xhConc);
    }
    
    public void cau6() throws ParseException{
        System.out.print("Nhập vào ngày a (dd/mm/yyyy): ");
        Scanner a1 = new Scanner(System.in);
        String a = a1.nextLine();
        System.out.print("Nhập vào ngày b (dd/mm/yyyy): ");
        Scanner b1 = new Scanner(System.in);
        String b = b1.nextLine();
        Calendar dateA = Calendar.getInstance();
        Calendar dateB = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        dateA.setTime(format.parse(a));
        dateB.setTime(format.parse(b));
        
//        So sánh 2 ngày a và b.
        String eqConc = dateA.equals(dateB) ? "Ngày a = ngày b!" : "Ngày a != ngày b";
        System.out.println(eqConc);
        
//        In ra ngày trước và ngày tiếp theo của ngày a
        Calendar fakeA = dateA;
        fakeA.add(Calendar.DATE, 1);
        String beforeA = format. format(dateA.getTime());
        fakeA.add(Calendar.DATE, -2);
        String afterA  = format. format(dateA.getTime());
        System.out.println("Ngày trước a: " + beforeA);
        System.out.println("Ngày sau a  : " + afterA);
        
//        Cho biết a là ngày thứ mấy trong năm.
        System.out.println("A là ngày thứ " + dateA.get(Calendar.DAY_OF_YEAR) + " trong năm!");
        
//        Cho biết tháng chứa a có bao nhiêu ngày
        int maxDay = dateA.getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.println(maxDay);
        
//        Cho biết năm chứa a có phải làm năm nhuần không
        int daysInYear = dateA.getActualMaximum(Calendar.DAY_OF_YEAR);
        String nhuanConc = (daysInYear > 365) ? "Năm chứa a là năm nhuần!" : "Năm chứa a ko là năm nhuần!";
        System.out.println(nhuanConc);
    }
    
    public void cau7(){
        int[] ArrayA = new int[10];
        for(int i = 0; i < 10; i++){
            ArrayA[i] = (int)(Math.random() * 1000);
        }
        System.out.println("Mang A: " + Arrays.toString(ArrayA));
        
//        Tạo mảng số nguyên B (kích thước m) với các giá trị ngẫu nhiên 
        System.out.print("Nhập số phần từ của mảng B: ");
        Scanner m1 = new Scanner(System.in);
        int m = m1.nextInt();
        int[] ArrayB = new int[m];
        for(int i = 0; i < m; i++){
            ArrayB[i] = (int)(Math.random() * 1000);
        }
        
//        Xuất toàn bộ các phần tử của B ra màn hình
        System.out.println("Mảng B: " + Arrays.toString(ArrayB));
        
//        Tạo mảng C từ mảng A
        int[] ArrayC = Arrays.copyOf(ArrayA,10);
        
//        Thay thế phần tử thứ 1 đến 3 của mảng C bằng 3 phần tử cuối của mảng B
        System.arraycopy(ArrayB, m-3, ArrayC, 0, 3);
        System.out.println("Mảng C: " + Arrays.toString(ArrayC));
        
//        Sắp xếp mảng C tăng dần và suất ra màn hình
        Arrays.sort(ArrayC);
        System.out.println("Mảng C (After sort): " + Arrays.toString(ArrayC));
    }
    
    public void cau8(){
        System.out.print("Nhập chiều dài m của ma trận mxn : ");
        Scanner m1 = new Scanner(System.in);
        int m = m1.nextInt();
        System.out.print("Nhập chiều rộng n của ma trận mxn: ");
        Scanner n1 = new Scanner(System.in);
        int n = n1.nextInt();
        float[][] MatrixM = new float[n][m];
        System.out.println("Nhap cac phan tu cua ma tran: ");
        for(int height = 0; height < n; height++){
            for(int width = 0; width < m; width++){
                Scanner i = new Scanner(System.in);
                MatrixM[height][width] = i.nextInt();
            }
        }
        System.out.println("Ma trận M: " + Arrays.deepToString(MatrixM));
        
//        Tìm giá trị nhỏ nhất và lớn nhất của ma trận
        float max = MatrixM[0][0]; float min = MatrixM[0][0];
        for(float[] row : MatrixM){
            for(float item : row){
                if(max < item){
                    max = item;
                }
                if(min > item){
                    min = item;
                }
            }
        }
        System.out.println("Max: " + max + ", Min: " + min);
        
//        In ra màn hình các giá trị nửa tam giác trên đường chéo chính.
        if(n != m){
            System.out.println("Ma trận VUÔNG mới có đường chéo chính!");
        } else {
            System.out.println("Các giá trị nửa tam giác trên đường chéo chính:");
            for(int height = 0; height < n; height++){
                String outputRow = "";
                for(int width = 0; width <= height; width++){
                    outputRow += MatrixM[height][width] + ",";
                }
                System.out.println(outputRow);
            }
        }
        
//        Tìm tất cả các số nguyên tố của ma trận.
        String listPrime = "";
        float sum = 0;
        for(float[] row : MatrixM){
            for(float item : row){
                sum += item;
                boolean isPrime = true;
                for(int i = 2; i <= item/2; i++){
                    if(item % i == 0.0) {
                        isPrime = false;
                        continue;
                    }
                }
                if(isPrime){
                    listPrime += item + " ";
                }
            }
        }
        System.out.println("Tất cả các số nguyên tố của ma trận: " + listPrime);
        
//        Tính tổng các giá trị của ma trận.
        System.out.println("Tổng các giá trị của ma trận: " + sum);
    }
}
