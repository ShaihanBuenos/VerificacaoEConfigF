package com.bcopstein.casosDeUso.Politicas;

import com.bcopstein.entidades.Bairro;
import com.bcopstein.entidades.Passageiro;
import com.bcopstein.entidades.Roteiro;
import com.bcopstein.entidades.geometria.Area;
import com.bcopstein.entidades.geometria.Ponto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculoCustoViagemBasicoTest {

    CalculoCustoViagemBasico calculoCustoViagemBasico;
    Passageiro passageiro;
    Area umaArea;
    Area outraArea;
    Bairro umBairro;
    Bairro outroBairro;
    List<Bairro> listaDeBairros;
    Roteiro roteiro;

    @BeforeEach
    void setUp() {
        calculoCustoViagemBasico = new CalculoCustoViagemBasico();
        passageiro = Passageiro.novoPassageiro("123", "Rodrigo");
        umaArea = new Area(new Ponto(5, 11), new Ponto(10, 10));
        outraArea = new Area(new Ponto(8, 12), new Ponto(10, 10));
        umBairro = new Bairro("Cristal", umaArea, 10.0);
        outroBairro = new Bairro("Teresopolis", outraArea, 20.0);
        listaDeBairros = new ArrayList<>();
        listaDeBairros.add(umBairro);
        listaDeBairros.add(outroBairro);
        roteiro = new Roteiro(umBairro, outroBairro, listaDeBairros);
        calculoCustoViagemBasico.defineRoteiro(roteiro);
        calculoCustoViagemBasico.definePassageiro(passageiro);
    }

    @Test
    void getRoteiroTest() {
        calculoCustoViagemBasico.defineRoteiro(roteiro);
        assertEquals(roteiro, calculoCustoViagemBasico.getRoteiro());
    }

    @Test
    void getPassageiroTest() {
        calculoCustoViagemBasico.definePassageiro(passageiro);
        assertEquals(passageiro, calculoCustoViagemBasico.getPassageiro());
    }

    @Test
    void calculoCustoBasicoTest() {
        assertEquals(30.0, calculoCustoViagemBasico.calculoCustoBasico());
    }

    @Test
    void descontoPontuacaoTest() {
        assertEquals(0.0, calculoCustoViagemBasico.descontoPontuacao());
    }

    @Test
    void descontoPromocaoSazonalTest() {
        assertEquals(0.0, calculoCustoViagemBasico.descontoPromocaoSazonal());
    }

    @Test
    void custoViagemTest() {
        assertEquals(30.0, calculoCustoViagemBasico.custoViagem());
    }
}