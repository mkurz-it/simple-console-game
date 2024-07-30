package org.kurzit.game.draw;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Console {
    private static final Terminal terminal = createTerminal();

    private Console() {
    }

    /**
     * @return Provides information about pressed keys (none blocking).
     */
    public static KeyStroke getKey() {
        try {
            return terminal.pollInput();
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Set the position on the screen.
     * After the position is set writeChar will write a character at this position.
     *
     * @param x .
     * @param y .
     */
    public static void setPosition(final int x, final int y) {
        try {
            terminal.setCursorPosition(x, y);
            terminal.setCursorVisible(false);
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Writes a character to the screen.
     *
     * @param ch character, which should be drawn.
     */
    public static void writeChar(final char ch) {
        try {
            terminal.putCharacter(ch);
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Clears the character at the given position (writes a blank).
     *
     * @param x .
     * @param y .
     */
    public static void clearPosition(final int x, final int y) {
        setBackgroundColor(TextColor.ANSI.BLACK);
        setPosition(x, y);
        writeChar(' ');
    }

    /**
     * Creates one beep sound.
     */
    public static void beep() {
        try {
            terminal.bell();
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Change the text color for the next character.
     *
     * @param color new text color.
     */
    public static void setColor(final TextColor color) {
        try {
            terminal.setForegroundColor(color);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Set the background color of the next character.
     *
     * @param color New background color.
     */
    public static void setBackgroundColor(final TextColor color) {
        try {
            terminal.setBackgroundColor(color);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Clears the screen.
     */
    public static void clearScreen() {
        try {
            terminal.clearScreen();
            terminal.resetColorAndSGR();
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Terminal createTerminal() {
        try {
            final var term = new DefaultTerminalFactory().createTerminal();
            term.setCursorVisible(false);
            return term;
        } catch (final IOException e) {
            throw new RuntimeException("Creating terminal failed! " + e.getMessage(), e);
        }
    }
}
