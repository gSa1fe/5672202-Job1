// โปรแกรมนี้ใช้ทดสอบฟังก์ชันคณิตศาสตร์ (Math) และการเปรียบเทียบเชิงตรรกะ
// โดยรับตัวเลข 2 ตัวจากผู้ใช้ แล้วโชว์ผลลัพธ์ให้เห็นเป็นตัวอย่าง

import java.util.InputMismatchException; // exception ที่เกิดเมื่อผู้ใช้กรอกข้อมูลผิดชนิด (เช่น พิมพ์ตัวอักษรแทนตัวเลข)
import java.util.Scanner;                // ใช้สำหรับรับ input จาก keybord

public class TestMathBoolean {

    // ===== ค่าคงที่ (constant) =====
    // ใช้ในตัวอย่าง boolean expression แทนการฝังตัวเลขลอยๆ (magic number) ในโค้ด
    // ทำให้อ่านแล้วรู้ทันทีว่าตัวเลขนี้มีความหมายว่าอะไร และแก้ไขค่าได้จากจุดเดียว
    private static final double POSITIVE_THRESHOLD = 0.0;   // เกณฑ์ตรวจว่าค่าเป็นบวกหรือไม่
    private static final double UPPER_LIMIT = 10.0;         // ขีดจำกัดบนตัวอย่างที่ 1
    private static final double LOWER_LIMIT = 0.0;          // เกณฑ์ตรวจว่าค่าเป็นลบหรือไม่
    private static final double ALT_UPPER_LIMIT = 5.0;      // ขีดจำกัดบนตัวอย่างที่ 2

    public static void main(String[] args) {
        // สร้าง Scanner ไว้อ่านค่าจาก System.in (keybord)
        // note: ไม่ใช้ try-with-resources ครอบ Scanner ตัวนี้
        Scanner sc = new Scanner(System.in);

        System.out.println("=== TestMathBoolean ===");

        // เรียก method readDouble() เพื่อรับค่าตัวเลขจากผู้ใช้ทีละตัว
        // โดย method นี้จะวน loop ให้กรอกใหม่เองถ้าใส่ค่าที่ไม่ใช่ตัวเลข
        double num1 = readDouble(sc, "กรุณาป้อนตัวเลขตัวที่ 1 : ");
        double num2 = readDouble(sc, "กรุณาป้อนตัวเลขตัวที่ 2 : ");

        // แยกการแสดงผลออกเป็น 2 ส่วนตามหน้าที่ เพื่อให้ main() อ่านง่าย
        // และแต่ละ method มีความรับผิดชอบเดียว (Single Responsibility)
        printMathFunctions(num1, num2);
        printBooleanExpressions(num1, num2);

        sc.close(); // ปิด Scanner หลังใช้งานเสร็จแล้วเท่านั้น (ปิดท้ายโปรแกรม ไม่ใช่ระหว่างทาง)
        System.out.println("\nจบโปรแกรม");
    }

    /**
     * รับค่าตัวเลขจากผู้ใช้ พร้อม validate ว่าเป็นตัวเลขจริง
     * ถ้าผู้ใช้กรอกผิดจะแจ้งเตือนและให้กรอกใหม่ จนกว่าจะได้ค่าที่ถูกต้อง
     *
     * @param sc     ตัว Scanner ที่ใช้อ่านค่า (ส่งเข้ามาจาก main เพื่อใช้ตัวเดียวกันตลอดโปรแกรม)
     * @param prompt ข้อความที่จะแสดงก่อนให้ผู้ใช้กรอกค่า
     * @return       ค่า double ที่ผู้ใช้กรอกถูกต้องแล้ว
     */
    private static double readDouble(Scanner sc, String prompt) {
        // ใช้ loop ไม่จำกัดรอบ (while true) แล้ว return ออกทันทีเมื่อได้ค่าที่ถูกต้อง
        while (true) {
            System.out.print(prompt);
            try {
                // nextDouble() จะโยน InputMismatchException ถ้าสิ่งที่พิมพ์ไม่ใช่ตัวเลข
                return sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("กรุณาป้อนเป็นตัวเลขเท่านั้น กรุณาลองใหม่");
                // ต้องเรียก sc.next() เพื่อดึงข้อความที่กรอกผิดออกจากบัฟเฟอร์
                // ไม่อย่างนั้น Scanner จะอ่านค่าเดิมซ้ำแล้วโยน exception วนไม่รู้จบ
                sc.next();
            }
        }
    }

    /**
     * แสดงผลลัพธ์จากฟังก์ชันคณิตศาสตร์ต่างๆ ของ Math class
     * ครอบคลุม: max, min, abs, sqrt, pow, random
     */
    private static void printMathFunctions(double num1, double num2) {
        System.out.println("\n---");
        System.out.println("ผลลัพธ์จาก Math Functions");

        // %.4f คือ format ทศนิยม 4 ตำแหน่ง ช่วยให้ผลลัพธ์อ่านง่ายและไม่ยาวเกินไป
        // %n คือขึ้นบรรทัดใหม่ (เทียบเท่า \n แต่รองรับ line separator ของแต่ละ OS)
        System.out.printf("ค่ามากที่สุด (max) : %.4f%n", Math.max(num1, num2));
        System.out.printf("ค่าน้อยที่สุด (min) : %.4f%n", Math.min(num1, num2));
        System.out.printf("ค่าสัมบูรณ์ของตัวแรก (abs) : %.4f%n", Math.abs(num1));

        // Math.sqrt() ของเลขติดลบจะได้ผลลัพธ์เป็น NaN (Not a Number)
        // ซึ่งถ้าปล่อยให้ print ตรงๆ ผู้ใช้จะงงว่า NaN คืออะไร
        // จึงเช็คเงื่อนไขก่อนแล้วแสดงข้อความอธิบายแทน
        if (num1 < 0) {
            System.out.printf("รากที่สองของ %.4f หาค่าไม่ได้ (จำนวนติดลบ)%n", num1);
        } else {
            System.out.printf("รากที่สองของ %.4f (sqrt) : %.4f%n", num1, Math.sqrt(num1));
        }

        // Math.pow(a, b) คือ a ยกกำลัง b
        System.out.printf("%.4f ยกกำลัง %.4f (pow) : %.4f%n", num1, num2, Math.pow(num1, num2));

        // Math.random() คืนค่า double แบบสุ่มในช่วง [0.0, 1.0)
        System.out.printf("เลขสุ่มระหว่าง 0.0 - 1.0 : %.4f%n", Math.random());
    }

    /**
     * แสดงผลลัพธ์จากการเปรียบเทียบเชิงตรรกะ (Boolean Expressions)
     * ครอบคลุม: ตัวดำเนินการเปรียบเทียบ (>, <, ==, !=, >=, <=)
     * และตัวดำเนินการตรรกะ (&&, ||, !)
     */
    private static void printBooleanExpressions(double num1, double num2) {
        System.out.println("\n---");
        System.out.println("ผลลัพธ์จาก Boolean Expressions");

        // ตัวดำเนินการเปรียบเทียบพื้นฐาน แต่ละบรรทัดคืนค่า true/false
        System.out.println(num1 + " > " + num2 + " : " + (num1 > num2));
        System.out.println(num1 + " < " + num2 + " : " + (num1 < num2));
        System.out.println(num1 + " == " + num2 + " : " + (num1 == num2));
        System.out.println(num1 + " != " + num2 + " : " + (num1 != num2));
        System.out.println(num1 + " >= " + num2 + " : " + (num1 >= num2));
        System.out.println(num1 + " <= " + num2 + " : " + (num1 <= num2));

        // && (AND) คืนค่า true ก็ต่อเมื่อเงื่อนไขทั้งสองฝั่งเป็น true พร้อมกัน
        // ตัวอย่าง: ตัวแรกเป็นบวก และ ตัวที่สองน้อยกว่า 10
        boolean andResult = (num1 > POSITIVE_THRESHOLD) && (num2 < UPPER_LIMIT);
        System.out.println("(" + num1 + " > 0) && (" + num2 + " < 10) : " + andResult);

        // || (OR) คืนค่า true ถ้ามีฝั่งใดฝั่งหนึ่งเป็น true ก็พอ
        // ตัวอย่าง: ตัวแรกเป็นลบ หรือ ตัวที่สองมากกว่า 5
        boolean orResult = (num1 < LOWER_LIMIT) || (num2 > ALT_UPPER_LIMIT);
        System.out.println("(" + num1 + " < 0) || (" + num2 + " > 5) : " + orResult);

        // ! (NOT) กลับค่าความจริง: ตรงนี้คือ "ไม่ใช่ว่า num1 เท่ากับ num2"
        boolean notResult = !(num1 == num2);
        System.out.println("!(" + num1 + " == " + num2 + ") : " + notResult);
    }
}