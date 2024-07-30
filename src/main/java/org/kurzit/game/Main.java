package org.kurzit.game;

import com.googlecode.lanterna.TextColor;
import org.kurzit.game.draw.Console;

public class Main {
    private static final char TL = '\u250C';
    private static final char TR = '\u2510';
    private static final char BL = '\u2514';
    private static final char BR = '\u2518';


    private static final char HL = '\u2500';
    private static final char VL = '\u2502';

    // First change on Alex PC
    public static void main(String[] args) {
        Console.clearScreen();
        Console.setColor(TextColor.ANSI.MAGENTA);
        Console.setPosition(0,0);

        Console.writeChar(TL);
        Console.writeChar(HL);
        Console.writeChar(HL);
        Console.writeChar(HL);
        Console.writeChar(TR);
        Console.writeChar('\n');

        Console.writeChar(VL);
        Console.writeChar(' ');
        Console.writeChar(' ');
        Console.writeChar(' ');
        Console.writeChar(VL);
        Console.writeChar('\n');

        Console.writeChar(BL);
        Console.writeChar(HL);
        Console.writeChar(HL);
        Console.writeChar(HL);
        Console.writeChar(BR);

    }
}
