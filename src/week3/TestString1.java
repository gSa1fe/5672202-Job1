import java.util.Scanner;

public class TestString1 {
    public static void main(String[] args) {
        // สร้างตัวรับค่าจาก Keybord
        Scanner sc = new Scanner(System.in);

        // ตัวแปรเก็บชื่อกับนามสกุล
        String firstName;
        String lastName;

        // ขึ้นหัวโปรแกรม
        System.out.println("=====================================");
        System.out.println("   โปรแกรมจัดการข้อความด้วย String");
        System.out.println("=====================================");

        // รับชื่อ อาจจะมีช่องว่างได้เลยใช้ nextLine()
        System.out.print("กรุณาป้อนชื่อ: ");
        firstName = sc.nextLine();

        // รับนามสกุล
        System.out.print("กรุณาป้อนนามสกุล: ");
        lastName = sc.nextLine();

        // 1. ต่อชื่อกับนามสกุล โดยเว้นช่องว่างตรงกลาง
        //    fullName จะได้ประมาณ Nattapong Somdee
        String fullName = firstName + " " + lastName;

        // 2. ความยาวของชื่อเต็ม ทั้งหมดกี่ตัวอักษร รวมช่องว่างด้วย
        int length = fullName.length();

        // 3. ตัวแรกของชื่อ ใช้ charAt(0) ดึงตัวที่ตำแหน่ง 0 ออกมา
        //    แต่ต้องเช็คก่อนว่าชื่อไม่ใช่ค่าว่าง จะได้ไม่พัง
        char firstChar;
        if (firstName.length() > 0) {
            firstChar = firstName.charAt(0);
        } else {
            firstChar = ' '; // ถ้าไม่ใส่ชื่อก็ให้เป็นช่องว่างไป
        }

        // 4. แปลงชื่อเต็มเป็นตัวพิมพ์ใหญ่ทั้งหมด
        String upperFull = fullName.toUpperCase();

        // 5. แปลงชื่อเต็มเป็นตัวพิมพ์เล็กทั้งหมด
        String lowerFull = fullName.toLowerCase();

        // 6. ดึง 3 ตัวแรกของชื่อมาแสดง
        //    ใช้ substring(0, 3) คือเอาตัวที่ 0,1,2 มา
        //    แต่ถ้าชื่อสั้นกว่า 3 ตัว ก็ใช้ชื่อที่มีอยู่เลย ไม่ต้องไปดัก error
        String firstThree;
        if (firstName.length() >= 3) {
            firstThree = firstName.substring(0, 3);
        } else {
            firstThree = firstName; // ถ้าสั้นก็เอาทั้งหมด
        }

        // ----- แสดงผลตามโจทย์ต้องการ -----
        System.out.println("\n==============");
        System.out.println("ชื่อเต็ม: " + fullName);
        System.out.println("ความยาวของชื่อเต็ม: " + length);
        System.out.println("ตัวอักษรตัวแรกของชื่อ: " + firstChar);
        System.out.println("ชื่อเต็มตัวพิมพ์ใหญ่: " + upperFull);
        System.out.println("ชื่อเต็มตัวพิมพ์เล็ก: " + lowerFull);
        System.out.println("ชื่อ 3 ตัวแรก: " + firstThree);
        System.out.println("==============");

        // ปิด Scanner
        sc.close();
        System.out.println("\nจบโปรแกรม");
    }
}