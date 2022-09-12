package com.company;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class EncoderDecoder {
    private final ReferenceTable referenceTable;
    private char offset;

    public EncoderDecoder(char offset) {
        this.referenceTable = new ReferenceTable(offset);
        this.offset = offset;
    }

    public String encode(String plainText) {
        return encode(plainText, this.offset);
    }

    private String encode(String plainText, char offset) {
        StringBuilder encodedString = new StringBuilder();
        encodedString.append(offset);
        for (char c : plainText.toCharArray()) {
            char outputChar = referenceTable.getEncodedChar(c);
            encodedString.append(outputChar);
        }
        return encodedString.toString();
    }

    public String decode(String encodedText) {
        StringBuilder decodedString = new StringBuilder();
        ArrayList<Character> chars = encodedText.chars().mapToObj(e -> (char) e).collect(Collectors.toCollection(ArrayList::new));
        char offset = chars.remove(0);
        referenceTable.changeOffset(offset);
        for (char c : chars) {
            char outputChar = referenceTable.getDecodedChar(c);
            decodedString.append(outputChar);
        }
        return decodedString.toString();
    }

    public void changeOffset(char offset) {
        this.referenceTable.changeOffset(offset);
        this.offset = offset;
    }
}
