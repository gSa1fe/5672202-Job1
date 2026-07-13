package week2;// โปรแกรมนี้สาธิตการใช้ตัวดำเนินการทางตรรกะ (&&, ||, !)
// และตัวดำเนินการเปรียบเทียบ (>, <, >=, <=, ==, !=)
// แสดงผลลัพธ์ของนิพจน์ต่างๆ พร้อมคำอธิบาย

public class LogicDemo {
    public static void main(String[] args) {
        System.out.println("=====================================");
        System.out.println("   การทดสอบนิพจน์ทางตรรกะ");
        System.out.println("=====================================");

        // 1. นิพจน์ AND (&&) - จะเป็นจริงเมื่อทั้งสองเงื่อนไขเป็นจริง
        System.out.println("\n1. ตัวอย่าง AND (&&):");
        System.out.println("   (5 > 3) && (10 > 6) = " + ((5 > 3) && (10 > 6)));
        System.out.println("   อธิบาย: 5>3 เป็นจริง และ 10>6 เป็นจริง -> ผลลัพธ์เป็น true");
        System.out.println("   (5 > 3) && (2 > 4) = " + ((5 > 3) && (2 > 4)));
        System.out.println("   อธิบาย: 5>3 เป็นจริง แต่ 2>4 เป็นเท็จ -> ผลลัพธ์เป็น false");

        // 2. นิพจน์ OR (||) - จะเป็นจริงเมื่ออย่างน้อยหนึ่งเงื่อนไขเป็นจริง
        System.out.println("\n2. ตัวอย่าง OR (||):");
        System.out.println("   (5 > 3) || (2 > 4) = " + ((5 > 3) || (2 > 4)));
        System.out.println("   อธิบาย: 5>3 เป็นจริง จึงทำให้ผลลัพธ์เป็น true (ถึงแม้ 2>4 จะเป็นเท็จ)");

        // 3. นิพจน์ NOT (!) - กลับค่าความจริง
        System.out.println("\n3. ตัวอย่าง NOT (!):");
        System.out.println("   !(4 == 4) = " + (!(4 == 4)));
        System.out.println("   อธิบาย: 4==4 เป็นจริง แต่ ! กลับเป็นเท็จ -> false");
        System.out.println("   !(5 < 3) = " + (!(5 < 3)));
        System.out.println("   อธิบาย: 5<3 เป็นเท็จ แต่ ! กลับเป็นจริง -> true");

        // 4. นิพจน์ผสม
        System.out.println("\n4. ตัวอย่างนิพจน์ผสม:");
        System.out.println("   (8 >= 8) && (3 != 1) = " + ((8 >= 8) && (3 != 1)));
        System.out.println("   อธิบาย: 8>=8 เป็นจริง และ 3!=1 เป็นจริง -> true");

        // 5. การเปรียบเทียบกับตัวแปร
        int x = 10, y = 20;
        System.out.println("\n5. ตัวอย่างเปรียบเทียบตัวแปร (x=10, y=20):");
        System.out.println("   x == y -> " + (x == y) + " (10 ไม่เท่ากับ 20)");
        System.out.println("   x != y -> " + (x != y) + " (10 ต่างจาก 20)");
        System.out.println("   x < y  -> " + (x < y) + " (10 น้อยกว่า 20)");
        System.out.println("   x > y  -> " + (x > y) + " (10 ไม่มากกว่า 20)");
        System.out.println("   x <= y -> " + (x <= y) + " (10 น้อยกว่าหรือเท่ากับ 20)");
        System.out.println("   x >= y -> " + (x >= y) + " (10 มากกว่าหรือเท่ากับ 20)");

        System.out.println("\n=====================================");
        System.out.println("การวิเคราะห์ผลลัพธ์:");
        System.out.println("1. && (AND) จะให้ true ก็ต่อเมื่อทั้งสองข้างเป็น true");
        System.out.println("2. || (OR)  จะให้ true ถ้ามีอย่างน้อยข้างใดข้างหนึ่งเป็น true");
        System.out.println("3. ! (NOT)  เปลี่ยน true เป็น false และ false เป็น true");
        System.out.println("4. ตัวดำเนินการเปรียบเทียบใช้ตรวจสอบความสัมพันธ์ระหว่างค่า");
        System.out.println("=====================================");
    }
}