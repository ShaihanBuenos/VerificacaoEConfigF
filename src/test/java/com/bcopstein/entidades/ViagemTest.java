package com.bcopstein.entidades;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class ViagemTest {

    Viagem viagem;
    LocalDateTime now;
    Roteiro roteiro;
    Passageiro passageiro;

    @BeforeEach
    void setUp() {
        now = LocalDateTime.now();
        roteiro = mock(Roteiro.class);
        passageiro = mock(Passageiro.class);
        viagem = new Viagem(1, now, roteiro, passageiro, 10);
    }

    @Test
    void getIdTest() {
        assertEquals(1, viagem.getId());
    }

    @Test
    void getDataHoraTest() {
        assertEquals(now, viagem.getDataHora());
    }

    @Test
    void getRoteiroTest() {
        assertEquals(roteiro, viagem.getRoteiro());
    }

    @Test
    void getPassageiroTest() {
        assertEquals(passageiro, viagem.getPassageiro());
    }

    @Test
    void getValorCobradoTest() {
        assertEquals(10, viagem.getValorCobrado());
    }
}