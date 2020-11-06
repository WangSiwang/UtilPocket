package com.sailing;

/**
 * @program: demo
 * @description:
 * @author: wangsw
 * @create: 2020-08-29 21:31
 */
public class Zimo {

    static int[] a1=new int[]{0x00,0x00,0x0E,0x70,0xFF,0xFF,0x0E,0x70,0x2E,0x70,0x70,0xEE,0x0F,0xFF,0x60,0xE0,
            0xF7,0xFE,0x36,0x66,0x1F,0xFE,0x3E,0x66,0x37,0xFE,0x76,0x66,0xE6,0x66,0x66,0x0C};
    static int[] a2=new int[]{0x00,0x00,0x01,0x80,0x01,0x80,0x01,0x80,0x7F,0xFE,0x7F,0xFE,0x71,0x8E,0x71,0x8E,
            0x71,0x8E,0x7F,0xFE,0x71,0x8E,0x01,0x80,0x01,0x80,0x01,0x80,0x01,0x80,0x03,0x80};
    static int[] a3=new int[]{0x00,0x00,0x33,0x9C,0x3B,0xB8,0x1D,0xB8,0x7F,0xFE,0x7F,0xFE,0x60,0x06,0x7F,0xFE,
            0x1F,0xF8,0x01,0xE0,0x7F,0xFE,0xFF,0xFF,0x01,0xC0,0x01,0xC0,0x07,0xC0,0x07,0x80};
    static int[] a4=new int[]{0x00,0x00,0x00,0x00,0x3F,0xFC,0x00,0x7C,0x00,0xF0,0x01,0xC0,0x01,0x80,0xFF,0xFF,
            0xFF,0xFF,0x01,0x80,0x01,0x80,0x01,0x80,0x01,0x80,0x03,0x80,0x07,0x80,0x07,0x00};

    static String c = "00000000000000000\n" +
                      "00011100000111000\n" +
                      "01111111011111110\n" +
                      "01111111111111110\n" +
                      "11111111111111111\n" +
                      "11111111111111111\n" +
                      "11111111111111111\n" +
                      "01111111111111110\n" +
                      "01111111111111110\n" +
                      "00111111111111100\n" +
                      "00111111111111100\n" +
                      "00011111111111000\n" +
                      "00001111111110000\n" +
                      "00000111111100000\n" +
                      "00000001110000000\n" +
                      "00000000100000000\n" +
                      "00000000000000000\n";
    public static void main(String[] args) {
        int x = t1(a1);
        int x1 = t1(a2);
        int x2 = t1(a3);
        int x3 = t1(a4);
        System.out.println(x);
        System.out.println(x1);
        System.out.println(x2);
        System.out.println(x3);
        System.out.println(x + x1 + x2 + x3);
    }

    private static void t2() {
        int e = 1;
        int f = 1;
        for (String s : c.split("\\n")) {
            System.out.println();
            System.out.print("第"+f+"行");
            for (byte aByte : s.getBytes()) {
                if (aByte==48){
                    System.out.print("第"+e+"个学生:黑");
                }else if (aByte==49){
                    System.out.print("第"+e+"个学生:白");
                }
                System.out.print("   ");
                e++;
            }
//            e = 1;
            f++;
        }
    }

    private static int t1(int[] a) {
        StringBuffer sb = new StringBuffer();
        int b = 0;
        for (int i : a) {
            if (i==0){
                System.out.print("        ");
            }else {
                String s = Integer.toBinaryString(i);
                while (s.length()!=8){
                    s = "0"+s;
                }
                for (byte aByte : s.getBytes()) {
                    if (aByte==49)
                        System.out.print(".");
                    else
                        System.out.print(" ");
                }

                sb.append(s);
            }
            b++;
            //每行的2的数量
            if (b%2==0){
                System.out.println();
            }
        }
        //返回所有1的数量
        int num = calc1(sb);
        return num;
    }

    private static int calc1(StringBuffer sb) {
        int num = 0;
        for (byte aByte : sb.toString().getBytes()) {
            if (aByte == 49){
                num++;
            }
        }
        return num;
    }
}