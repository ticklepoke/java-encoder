package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EncoderDecoder encoderDecoder = new EncoderDecoder('A');
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.print("Choose offset char:");
            char offset = in.next().charAt(0);
            encoderDecoder.changeOffset(offset);
            System.out.printf("Using offset %s\n", offset);

            System.out.print("Input message to encode:");
            String plainText = in.next();
            String encodedMessage = encoderDecoder.encode(plainText);
            System.out.printf("Encoded message: %s\n", encodedMessage);

            System.out.print("Input message to decode:");
            String inputMessage = in.next();
            String decodedMessage = encoderDecoder.decode(inputMessage);
            System.out.printf("Decoded message: %s\n", decodedMessage);
        }
    }
}
