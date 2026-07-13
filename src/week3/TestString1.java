// รับชื่อ-นามสกุลจากผู้ใช้ แล้วแสดงผลลัพธ์การจัดการ String หลายรูปแบบ

import java.util.Scanner;

public class TestString1 {

    // เก็บเส้นคั่นไว้เป็น constant กันการพิมพ์ "=====" ซ้ำหลายที่
    // static final = ค่าคงที่ ใช้ร่วมกันได้ทั้งคลาส แก้ไขไม่ได้หลังประกาศ
    private static final String DIVIDER = "=====================================";

    public static void main(String[] args) {
        // try-with-resources: Scanner จะถูก .close() ให้อัตโนมัติ
        // เมื่อออกจากบล็อก try (ไม่ต้องเขียน sc.close() เองแบบเดิม
        // และปิดให้แน่นอนแม้เกิด exception ระหว่างทาง)
        try (Scanner sc = new Scanner(System.in)) {
            printHeader();

            System.out.print("กรุณาป้อนชื่อ (ไม่รวมนามสกุล): ");
            // .trim() ตัดช่องว่างหน้า-หลังที่ผู้ใช้พิมพ์เผลอเกินมาออก
            String firstName = sc.nextLine().trim();

            System.out.print("กรุณาป้อนนามสกุล: ");
            String lastName = sc.nextLine().trim();

            // ส่งค่าที่รับมาไปประมวลผลและแสดงผลในเมธอดแยก
            // ทำให้ main() อ่านง่าย
            printResult(firstName, lastName);
        }

        System.out.println("\nจบโปรแกรม");
    }

    /**
     * แสดงหัวโปรแกรม แยกออกมาเป็นเมธอดเพื่อไม่ให้ main() รก
     * และถ้าจะแก้หัวโปรแกรมทีหลัง ก็มาแก้ที่จุดเดียว
     */

    private static void printHeader() {
        System.out.println(DIVIDER);
        System.out.println("   โปรแกรมจัดการข้อความด้วย String");
        System.out.println(DIVIDER);
    }

    private static void printResult(String firstName, String lastName) {
        // 1. ต่อชื่อกับนามสกุล คั่นด้วยช่องว่าง
        String fullName = firstName + " " + lastName;

        // 3. ตัวอักษรตัวแรกของชื่อ
        // ternary (เงื่อนไข ? ค่าเมื่อจริง : ค่าเมื่อเท็จ) แทน if-else 5 บรรทัด
        // ถ้า firstName ว่าง -> ใช้ ' ' กันโปรแกรม error จาก charAt(0)
        // ถ้าไม่ว่าง -> ดึงตัวอักษรตำแหน่งที่ 0 มาใช้
        char firstChar = firstName.isEmpty() ? ' ' : firstName.charAt(0);

        // 6. ดึง 3 ตัวแรกของชื่อ
        // Math.min(3, firstName.length()) หาว่าจะตัดกี่ตัวโดยไม่เกินความยาวจริง
        // เช่นชื่อยาว 5 ตัว -> ตัดที่ 3 / ชื่อยาว 2 ตัว -> ตัดที่ 2 (เอาทั้งหมด) ไม่ error แน่นอน
        String firstThree = firstName.substring(0, Math.min(3, firstName.length()));

        System.out.println("\n==============");
        System.out.println("ชื่อเต็ม: " + fullName);

        // 2. ความยาวของชื่อเต็ม (นับทุกตัวอักษรรวมช่องว่างตรงกลาง)
        System.out.println("ความยาวของชื่อเต็ม (นับทุกตัวอักษรรวมช่องว่างตรงกลาง): " + fullName.length());

        System.out.println("ตัวอักษรตัวแรกของชื่อ: " + firstChar);

        // 4. แปลงเป็นตัวพิมพ์ใหญ่ทั้งหมด
        System.out.println("ชื่อเต็มตัวพิมพ์ใหญ่: " + fullName.toUpperCase());

        // 5. แปลงเป็นตัวพิมพ์เล็กทั้งหมด
        System.out.println("ชื่อเต็มตัวพิมพ์เล็ก: " + fullName.toLowerCase());

        System.out.println("ชื่อ 3 ตัวแรก: " + firstThree);
        System.out.println("==============");
    }
}