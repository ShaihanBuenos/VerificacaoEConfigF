package com.bcopstein.entidades;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PassageiroTest {

    Passageiro passageiro;

    @BeforeEach
    void setUp() {
        passageiro = new Passageiro("12345678", "Pedro", 27, 3);
    }

    @Test
    void novoPassageiroTest() {
        Passageiro novoPassageiro = Passageiro.novoPassageiro("87654321", "Gustavo");

        assertEquals("87654321", novoPassageiro.getCPF());
        assertEquals("Gustavo", novoPassageiro.getNome());
        assertEquals(8, novoPassageiro.getPontuacaoAcumulada());
        assertEquals(1, novoPassageiro.getQtdadeAvaliacoes());
    }

    @Test
    void passageiroExistenteTest() {
        Passageiro passageiroExistente = Passageiro.passageiroExistente(
                "1234987", "Joao", 30, 4);

        assertEquals("1234987", passageiroExistente.getCPF());
        assertEquals("Joao", passageiroExistente.getNome());
        assertEquals(30, passageiroExistente.getPontuacaoAcumulada());
        assertEquals(4, passageiroExistente.getQtdadeAvaliacoes());
    }

    @Test
    void getCPFTest() {
        assertEquals("12345678", passageiro.getCPF());
    }

    @Test
    void getNomeTest() {
        assertEquals("Pedro", passageiro.getNome());
    }

    @Test
    void getPontuacaoMediaTest() {
        double pontuacaoMedia = passageiro.getPontuacaoAcumulada() / passageiro.getQtdadeAvaliacoes();
        assertEquals(pontuacaoMedia, passageiro.getPontuacaoMedia());
    }

    @Test
    void infoPontuacaoMaiorQueZeroTest() {
        Passageiro umPassageiro = Passageiro.novoPassageiro("123", "Emmanuel");
        umPassageiro.infoPontuacao(10);

        assertEquals(27, passageiro.getPontuacaoAcumulada());
        assertEquals(3, passageiro.getQtdadeAvaliacoes());
    }

    @Test
    void infoPontuacaoMenorQueZeroTest() {
        Passageiro umPassageiro = Passageiro.novoPassageiro("456", "Lucas");

        assertThrows(IllegalArgumentException.class,
                () -> umPassageiro.infoPontuacao(-10));
    }

    @Test
    void getPontuacaoAcumuladaTest() {
        assertEquals(27, passageiro.getPontuacaoAcumulada());
    }

    @Test
    void getQtdadeAvaliacoesTest() {
        assertEquals(3, passageiro.getQtdadeAvaliacoes());
    }
}