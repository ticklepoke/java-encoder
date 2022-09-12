package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReferenceTable {
    private static final List<Character> chars = new ArrayList<>(List.of('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '(', ')', '*', '+', ',', '-', '.', '/'));
    private static final int numChars = 44;

    private final Map<Character, Character> plainToEncodedChar;
    private final Map<Character, Character> encodedToPlainChar;

    public ReferenceTable(char offset) {
        this.plainToEncodedChar = new HashMap<>();
        this.encodedToPlainChar = new HashMap<>();
        changeOffset(offset);
    }

    public char getDecodedChar(char c) {
        return encodedToPlainChar.getOrDefault(c, c);
    }

    public char getEncodedChar(char c) {
        return plainToEncodedChar.getOrDefault(c, c);
    }

    public void changeOffset(char offset) {
        int offsetIdx = chars.indexOf(offset);
        if (offsetIdx == -1) {
            throw new IllegalArgumentException("offset char does not exist");
        }

        for (int i = 0; i < numChars; i++) {
            int iOffset = (i + offsetIdx) % numChars;
            plainToEncodedChar.put(chars.get(iOffset), chars.get(i));
            encodedToPlainChar.put(chars.get(i), chars.get(iOffset));
        }
    }
}
