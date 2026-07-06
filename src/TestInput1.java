// โปรแกรมนี้รับข้อมูลนักศึกษา (ชื่อ อายุ คะแนนสอบ) จากผู้ใช้ แล้วแสดงผล

// นำเข้า Scanner และคลาสที่ใช้จัดการข้อผิดพลาด
import java.util.Scanner;
import java.util.InputMismatchException;

public class TestInput1 {
    public static void main(String[] args) {
        // สร้างScanner สำหรับรับข้อมูลจากkeybord
        Scanner sc = new Scanner(System.in);

        // ประกาศตัวแปรสำหรับเก็บข้อมูล
        String name;     // ชื่อนักศึกษา
        int age;         // อายุ
        double score;    // คะแนนสอบ

        // แสดงหัวข้อโปรแกรม
        System.out.println("=====================================");
        System.out.println("   โปรแกรมรับข้อมูลนักศึกษา");
        System.out.println("=====================================");

        // ----- รับข้อมูลชื่อ (ใช้ nextLine() เพื่อรับข้อความที่มีช่องว่าง) -----
        System.out.print("ป้อนชื่อนักศึกษา: ");
        name = sc.nextLine();  // รับทั้งบรรทัด (รวมช่องว่าง)

        // ----- รับข้อมูลอายุ (int) พร้อมตรวจสอบข้อผิดพลาด -----
        while (true) {
            try {
                System.out.print("ป้อนอายุ (ปี): ");
                age = sc.nextInt();   // พยายามอ่านจำนวนเต็ม
                break;  // ถ้าอ่านสำเร็จ ให้ออกจากloop
            } catch (InputMismatchException e) {
                // ถ้าผู้ใช้ป้อนไม่ใช่ตัวเลข จะเข้า catch
                System.out.println("โปรดป้อนอายุเป็นตัวเลขเท่านั้น");
                sc.nextLine(); // เคลียร์บัฟเฟอร์ (ลบข้อมูลที่ผิดออก)
            }
        }

        // ----- รับข้อมูลคะแนน (double) กับตรวจสอบข้อผิดพลาด -----
        while (true) {
            try {
                System.out.print("ป้อนคะแนนสอบ (0-100): ");
                score = sc.nextDouble();
                // ตรวจสอบว่าคะแนนอยู่ในช่วงที่ถูกต้องหรือไม่
                if (score < 0 || score > 100) {
                    System.out.println("คะแนนต้องอยู่ระหว่าง 0 ถึง 100 กรุณาป้อนใหม่");
                    continue; // กลับไปถามใหม่ โดยไม่ break
                }
                break; // ถ้าถูกต้องก็ออกจากลูป
            } catch (InputMismatchException e) {
                System.out.println("โปรดป้อนคะแนนเป็นตัวเลข (เช่น 85.5)");
                sc.nextLine(); // เคลียร์บัฟเฟอร์
            }
        }

        // ----- แสดงผลข้อมูลทั้งหมด -----
        System.out.println("\n-------------------------------------");
        System.out.println("        ข้อมูลนักศึกษา");
        System.out.println("-------------------------------------");
        System.out.println("ชื่อ: " + name);
        System.out.println("อายุ: " + age + " ปี");
        System.out.println("คะแนนสอบ: " + score + " คะแนน");
        System.out.println("-------------------------------------");

        // ปิด Scanner
        sc.close();
        System.out.println("\nจบการทำงานโปรแกรม");
    }
}