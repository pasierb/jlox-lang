package com.mpasierbski.lox;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScannerTest {
    @Test
    void shouldScanEquals() {
        var scanner = new Scanner("=");
        var tokens = scanner.scanTokens();

        assertEquals(2, tokens.size());
        assertEquals(TokenType.EQUAL, tokens.get(0).type);
    }

    @Test
    void shouldScanNumber() {
        var scanner = new Scanner("123");
        var tokens = scanner.scanTokens();

        assertEquals(2, tokens.size());

        var token = tokens.get(0);
        assertEquals(TokenType.NUMBER, token.type);
        assertEquals(123d, token.literal);
    }

    @Test
    void shouldScanIdentifier() {
        var scanner = new Scanner("mama");
        var tokens = scanner.scanTokens();

        assertEquals(2, tokens.size());
        assertEquals(TokenType.IDENTIFIER, tokens.get(0).type);
        assertEquals("mama", tokens.get(0).literal);
    }

    @Test
    void shouldScanKeyword() {
        var scanner = new Scanner("return");
        var tokens = scanner.scanTokens();

        assertEquals(2, tokens.size());
        assertEquals(TokenType.RETURN, tokens.get(0).type);
    }
}
