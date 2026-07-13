package week2;// โปรแกรมนี้รับตัวเลขจำนวนเต็ม 2 ตัวจากผู้ใช้ แล้วคำนวณผลลัพธ์ทางคณิตศาสตร์
// แสดงผลรวม ผลต่าง ผลคูณ ผลหาร (เป็นทศนิยม) และเศษจากการหาร

import java.util.Scanner;  // ใช้รับข้อมูลจากkeybord
public class TestOperator {
    public static void main(String[] args) {
        // สร้าง Scanner สำหรับรับข้อมูล
        Scanner sc = new Scanner(System.in);

        // ประกาศตัวแปรชนิด int สำหรับเก็บตัวเลข 2 จำนวน
        int a, b;

        // แสดงหัวข้อโปรแกรม
        System.out.println("=====================================");
        System.out.println("   โปรแกรมคำนวณผลทางคณิตศาสตร์");
        System.out.println("=====================================");

        // รับค่าตัวเลขที่ 1
        System.out.print("ป้อนตัวเลขที่ 1 (a): ");
        a = sc.nextInt();

        // รับค่าตัวเลขที่ 2
        System.out.print("ป้อนตัวเลขที่ 2 (b): ");
        b = sc.nextInt();

        // แสดงผลลัพธ์การคำนวณ
        System.out.println("\n--- ผลลัพธ์ ---");
        System.out.println("a = " + a + ", b = " + b);
        System.out.println("ผลรวม (a + b) = " + (a + b));
        System.out.println("ผลต่าง (a - b) = " + (a - b));
        System.out.println("ผลคูณ (a * b) = " + (a * b));

        // ตรวจสอบการหารด้วยศูนย์ เพื่อป้องกันข้อผิดพลาด (Division by zero)
        if (b != 0) {
            // ใช้ (double) เพื่อแปลง a ให้เป็นทศนิยม เพื่อให้ผลหารเป็นทศนิยม
            System.out.println("ผลหาร (a / b) = " + ((double) a / b));
            // ใช้เครื่องหมาย % สำหรับการหาเศษ (mod) เหมาะกับจำนวนเต็ม
            System.out.println("เศษจากการหาร (a % b) = " + (a % b));
        } else {
            System.out.println("ไม่สามารถหารด้วยศูนย์ได้ (b = 0)");
        }

        // ปิด Scanner
        sc.close();
        System.out.println("\nจบโปรแกรม");
    }
}