package com.bcopstein.entidades;

import com.bcopstein.entidades.geometria.Area;
import com.bcopstein.entidades.geometria.Ponto;
import com.bcopstein.entidades.geometria.Reta;
import com.bcopstein.entidades.geometria.SituacaoReta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BairroTest {

    Area area;
    Bairro bairro;

    @BeforeEach
    void setUp() {
        area = mock(Area.class);
        bairro = new Bairro("Nonoai", area, 10.0);
    }

    @Test
    void novoBairroQuadradoTest() {
        Area novaArea = new Area(new Ponto(5, 9), new Ponto(13, 1));
        Bairro bairroQuadrado = new Bairro("Moinhos", novaArea, 20.0);

        assertEquals(bairroQuadrado, Bairro.novoBairroQuadrado("Moinhos", new Ponto(5, 9), 8, 20.0));
    }

    @Test
    void novoBairroRetangularTest() {
        Area novaArea = new Area(new Ponto(5, 9), new Ponto(10, 1));
        Bairro bairroQuadrado = new Bairro("Moinhos", novaArea, 20.0);

        assertEquals(bairroQuadrado, Bairro.novoBairroRetangular("Moinhos", new Ponto(5, 9), 5, 8, 20.0));
    }

    @Test
    void getNomeTest() {
        assertEquals("Nonoai", bairro.getNome());
    }

    @Test
    void getAreaTest() {
        assertEquals(area, bairro.getArea());
    }

    @Test
    void getCustoTransporteTest() {
        assertEquals(10, bairro.getCustoTransporte());
    }

    @Test
    void alteraCustoTransporteMaiorQueZeroTest() {
        bairro.alteraCustoTransporte(20.0);

        assertEquals(20.0, bairro.getCustoTransporte());
    }

    @Test
    void alteraCustoTransporteMenorQueZeroTest() {

        assertThrows(IllegalArgumentException.class,
                () -> bairro.alteraCustoTransporte(-20.0));
    }

    @Test
    void getPontoCentralTest() {
        Ponto ponto = new Ponto(10, 10);
        when(bairro.getArea().pontoCentral()).thenReturn(ponto);

        assertEquals(ponto, bairro.getPontoCentral());
    }

    @Test
    void getClassificacaoTest() {
        Reta reta = new Reta(new Ponto(5, 11), new Ponto(10, 10));

        when(bairro.getArea().classifica(reta)).thenReturn(SituacaoReta.TODA_DENTRO);
        assertEquals(SituacaoReta.TODA_DENTRO, bairro.getClassificacao(reta));
    }

}