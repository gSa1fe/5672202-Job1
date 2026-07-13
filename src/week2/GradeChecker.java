package week2;// โปรแกรมนี้รับคะแนนสอบ (score) และเปอร์เซ็นต์การเข้าเรียน (attend)
// จากนั้นตรวจสอบว่า ผ่านเกณฑ์หรือไม่ โดยใช้เงื่อนไข:
// ผ่านเมื่อ score >= 50 และ attend >= 80

import java.util.Scanner;

public class GradeChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=====================================");
        System.out.println("   โปรแกรมตรวจสอบเกณฑ์การผ่าน");
        System.out.println("   (คะแนน >= 50 และ เข้าเรียน >= 80%)");
        System.out.println("=====================================");

        // รับคะแนนสอบ
        System.out.print("ป้อนคะแนนสอบ (0-100): ");
        double score = sc.nextDouble();

        // รับเปอร์เซ็นต์การเข้าเรียน
        System.out.print("ป้อนเปอร์เซ็นต์การเข้าเรียน (0-100): ");
        double attend = sc.nextDouble();

        // ตรวจสอบเงื่อนไขโดยใช้ตัวดำเนินการ && (AND)
        // เงื่อนไขจะเป็นจริงเมื่อทั้งสองส่วนเป็นจริง
        boolean isPass = (score >= 50) && (attend >= 80);

        // แสดงผลลัพธ์
        System.out.println("\n--- ผลการตรวจสอบ ---");
        System.out.println("คะแนนสอบ: " + score);
        System.out.println("เปอร์เซ็นต์เข้าเรียน: " + attend + "%");

        // ใช้ if-else แสดงข้อความตามผลลัพธ์
        if (isPass) {
            System.out.println("✅ ผลลัพธ์: ผ่านเกณฑ์");
        } else {
            System.out.println("❌ ผลลัพธ์: ไม่ผ่านเกณฑ์");
        }

        // แสดงตารางตัวอย่าง (ตามโจทย์) เพื่อให้เห็นภาพ
        System.out.println("\n--- ตารางตัวอย่างการเปรียบเทียบ ---");
        System.out.println("คะแนน | เข้าเรียน | ผลลัพธ์");
        System.out.println("  60   |   85%    | " + ((60 >= 50 && 85 >= 80) ? "✅ ผ่าน" : "❌ ไม่ผ่าน"));
        System.out.println("  45   |   90%    | " + ((45 >= 50 && 90 >= 80) ? "✅ ผ่าน" : "❌ ไม่ผ่าน"));
        System.out.println("  70   |   70%    | " + ((70 >= 50 && 70 >= 80) ? "✅ ผ่าน" : "❌ ไม่ผ่าน"));

        sc.close();
    }
}