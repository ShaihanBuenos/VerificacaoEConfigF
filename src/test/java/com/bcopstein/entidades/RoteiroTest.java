package com.bcopstein.entidades;

import com.bcopstein.entidades.geometria.Area;
import com.bcopstein.entidades.geometria.Ponto;
import com.bcopstein.entidades.geometria.Reta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RoteiroTest {

    Area umaArea;
    Area outraArea;
    Roteiro roteiro;
    Bairro bairroOrigem;
    Bairro bairroDestino;
    List<Bairro> listaBairros;

    @BeforeEach
    void setUp() {
        umaArea = new Area(new Ponto(5, 11), new Ponto(10, 10));
        outraArea = new Area(new Ponto(8, 12), new Ponto(10, 10));
        bairroOrigem = new Bairro("Cristal", umaArea, 10.0);
        bairroDestino = new Bairro("Teresopolis", outraArea, 20.0);

        listaBairros = new ArrayList<>();
        listaBairros.add(bairroOrigem);
        listaBairros.add(bairroDestino);

        roteiro = new Roteiro(bairroOrigem, bairroDestino, listaBairros);
    }

    @Test
    void getRotaTest() {
        Reta reta = new Reta(new Ponto(7, 10), new Ponto(9, 11));
        assertEquals(reta, roteiro.getRota());
    }

    @Test
    void getBairroOrigemTest() {
        assertEquals(bairroOrigem, roteiro.getBairroOrigem());
    }

    @Test
    void getBairroDestinoTest() {
        assertEquals(bairroDestino, roteiro.getBairroDestino());
    }

    @Test
    void bairrosPercoridosTest() {
        assertEquals(listaBairros, roteiro.bairrosPercoridos());
    }

}