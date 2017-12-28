package com.javarush.task.task21.task2101;

/*
Определяем адрес сети
*/
public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] net = new byte[4];
        for (int i = 0; i < ip.length; i++) {
            net[i] = (byte) (ip[i] & mask[i]);
        }
        return net;
    }

    public static void print(byte[] bytes) {
        for (byte aByte : bytes) {
            int octet = aByte;
            byte[] binOctet = new byte[8];
            if (octet < 0) octet = 256 + octet;
            for (int j = 0; j < 8; j++) {
                binOctet[j] = (byte) (octet % 2);
                octet = octet / 2;
            }
            for (int i = binOctet.length - 1; i >= 0 ; i--) {
                System.out.print(binOctet[i]);
            }
            System.out.print(" ");
        }
        System.out.println();
    }
}
