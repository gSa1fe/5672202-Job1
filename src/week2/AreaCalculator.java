package week2;// โปรแกรมนี้คำนวณพื้นที่สามเหลี่ยม

import java.util.Scanner;  // ใช้รับข้อมูลจากผู้ใช้

public class AreaCalculator {
    public static void main(String[] args) {
        // สร้างscanner สำหรับอ่านข้อมูลจากkeybord
        Scanner input = new Scanner(System.in);

        // แสดงหัวข้อโปรแกรม
        System.out.println("=====================================");
        System.out.println("   โปรแกรมคำนวณพื้นที่รูปทรง");
        System.out.println("=====================================");

        // แสดงเมนูให้เลือก
        System.out.println("เลือกประเภทที่ต้องการคำนวณ:");
        System.out.println("1. พื้นที่สามเหลี่ยม");
        System.out.println("2. พื้นที่วงกลม");
        System.out.print("กรุณาเลือก (1 หรือ 2): ");

        // รับตัวเลือกจากผู้ใช้ เก็บเป็นตัวแปร choice
        int choice = input.nextInt();

        // ใช้ if-else เพื่อแยกการทำงานตามตัวเลือก
        if (choice == 1) {
            // ---------- กรณีเลือกสามเหลี่ยม ----------
            System.out.println("\n--- คำนวณพื้นที่สามเหลี่ยม ---");

            // รับค่าฐาน
            System.out.print("ป้อนความยาวของฐาน (หน่วย: เซนติเมตร): ");
            double base = input.nextDouble();

            // รับค่าสูง
            System.out.print("ป้อนความสูง (หน่วย: เซนติเมตร): ");
            double height = input.nextDouble();

            // สูตรพื้นที่สามเหลี่ยม = (ฐาน x สูง) / 2
            double areaTriangle = (base * height) / 2;

            // แสดงผล
            System.out.println("--------------------------------");
            System.out.println("พื้นที่สามเหลี่ยม = " + areaTriangle + " ตารางเซนติเมตร");
            System.out.println("--------------------------------");

        } else if (choice == 2) {
            // ---------- กรณีเลือกวงกลม ----------
            System.out.println("\n--- คำนวณพื้นที่วงกลม ---");

            // รับค่ารัศมี
            System.out.print("ป้อนรัศมี (หน่วย: เซนติเมตร): ");
            double radius = input.nextDouble();

            // สูตรพื้นที่วงกลม = Pi x Radius2
            // ใช้ Math.PI ซึ่งเป็นค่าคงที่ของ Pi ในภาษา Java
            double areaCircle = Math.PI * radius * radius;

            // แสดงผล
            System.out.println("--------------------------------");
            System.out.println("พื้นที่วงกลม = " + areaCircle + " ตารางเซนติเมตร");
            System.out.println("--------------------------------");

        } else {
            // ถ้าผู้ใช้ป้อนตัวเลขอื่นที่ไม่ใช่ 1 หรือ 2
            System.out.println("\nคำเตือน: กรุณาเลือก 1 หรือ 2 เท่านั้น");
        }

        // ปิด Scanner
        input.close();

        // ข้อความจบโปรแกรม
        System.out.println("\nขอบคุณที่ใช้โปรแกรม");
    }
}