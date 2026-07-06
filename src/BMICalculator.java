// โปรแกรมนี้คำนวณค่า BMI (ดัชนีมวลกาย) จากน้ำหนักและส่วนสูงที่ผู้ใช้ป้อน
// สูตร: BMI = น้ำหนัก(kg) / (ส่วนสูง(m) * ส่วนสูง(m))

import java.util.Scanner;
import java.util.InputMismatchException;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ตัวแปรเก็บน้ำหนักและส่วนสูง
        double weight;  // หน่วย kg
        double height;  // หน่วย เมตร

        System.out.println("=====================================");
        System.out.println("      โปรแกรมคำนวณค่า BMI");
        System.out.println("=====================================");

        // ----- รับน้ำหนัก (double) พร้อมตรวจสอบข้อผิดพลาด -----
        while (true) {
            try {
                System.out.print("ป้อนน้ำหนักของคุณ (กิโลกรัม): ");
                weight = sc.nextDouble();
                // ตรวจสอบค่าน้ำหนักต้องมากกว่า 0
                if (weight <= 0) {
                    System.out.println("น้ำหนักต้องมากกว่า 0 กรุณาป้อนใหม่");
                    continue;
                }
                break; // อ่านสำเร็จและค่าถูกต้อง
            } catch (InputMismatchException e) {
                System.out.println("โปรดป้อนน้ำหนักเป็นตัวเลข (เช่น 65.5)");
                sc.nextLine(); // เคลียร์บัฟเฟอร์
            }
        }

        // ----- รับส่วนสูง (double) พร้อมตรวจสอบข้อผิดพลาด -----
        while (true) {
            try {
                System.out.print("ป้อนส่วนสูงของคุณ (เมตร): ");
                height = sc.nextDouble();
                if (height <= 0) {
                    System.out.println("ส่่วนสูงต้องมากกว่า 0 กรุณาป้อนใหม่");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("โปรดป้อนส่วนสูงเป็นตัวเลข (เช่น 1.75)");
                sc.nextLine();
            }
        }

        // ----- คำนวณ BMI -----
        double bmi = weight / (height * height);

        // ----- แสดงผลลัพธ์ -----
        System.out.println("\n=====================================");
        System.out.println("          ผลลัพธ์ BMI");
        System.out.println("=====================================");
        System.out.printf("น้ำหนัก: %.2f kg\n", weight);
        System.out.printf("ส่วนสูง: %.2f m\n", height);
        System.out.printf("ค่า BMI ของคุณ = %.2f\n", bmi);

        // แสดงเกณฑ์มาตรฐาน (สำหรับผู้ใหญ่)
        System.out.println("\n--- เกณฑ์มาตรฐาน (สำหรับผู้ใหญ่) ---");
        if (bmi < 18.5) {
            System.out.println("น้ำหนักน้อยกว่ามาตรฐาน (ผอม)");
        } else if (bmi < 23.0) {
            System.out.println("น้ำหนักปกติ (สุขภาพดี)");
        } else if (bmi < 27.5) {
            System.out.println("น้ำหนักเกิน (เสี่ยงต่อโรค)");
        } else {
            System.out.println("โรคอ้วน (ควรปรึกษาแพทย์)");
        }
        System.out.println("=====================================");

        sc.close();
        System.out.println("\nขอบคุณที่ใช้โปรแกรม");
    }
}