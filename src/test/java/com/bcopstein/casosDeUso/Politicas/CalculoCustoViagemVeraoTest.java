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

class CalculoCustoViagemVeraoTest {

    CalculoCustoViagemVerao calculoCustoViagemVerao;
    Passageiro umPassageiro;
    Passageiro outroPassageiro;
    Area umaArea;
    Area outraArea;
    Bairro bairroUm;
    Bairro bairroDois;
    List<Bairro> listaDeBairros;
    Roteiro roteiro;

    @BeforeEach
    void setUp() {
        calculoCustoViagemVerao = new CalculoCustoViagemVerao();
        umPassageiro = new Passageiro("123", "Rodrigo", 475, 50);
        outroPassageiro = new Passageiro("456", "Matheus", 20, 5);
        umaArea = new Area(new Ponto(5, 11), new Ponto(10, 10));
        outraArea = new Area(new Ponto(8, 12), new Ponto(10, 10));
        bairroUm = new Bairro("Cristal", umaArea, 10.0);
        bairroDois = new Bairro("Teresopolis", outraArea, 20.0);
        listaDeBairros = new ArrayList<>();
        listaDeBairros.add(bairroUm);
        listaDeBairros.add(bairroDois);
        roteiro = new Roteiro(bairroUm, bairroDois, listaDeBairros);
        calculoCustoViagemVerao.defineRoteiro(roteiro);
    }

    @Test
    void descontoPontuacaoEntregueTest() {
        calculoCustoViagemVerao.definePassageiro(umPassageiro);
        assertEquals((10.0 + 20.0) * 0.9, calculoCustoViagemVerao.descontoPontuacao());
    }

    @Test
    void descontoPontuacaoNaoEntregueTest() {
        calculoCustoViagemVerao.definePassageiro(outroPassageiro);
        assertEquals(0.0, calculoCustoViagemVerao.descontoPontuacao());
    }

    @Test
    void descontoPromocaoSazonalEntregueTest() {
        Bairro bairroTres = new Bairro("Gloria", umaArea, 5.0);
        Bairro bairroQuatro = new Bairro("Menino Deus", outraArea, 15.0);
        listaDeBairros.add(bairroTres);
        listaDeBairros.add(bairroQuatro);
        Roteiro novoRoteiro = new Roteiro(bairroUm, bairroQuatro, listaDeBairros);
        calculoCustoViagemVerao.defineRoteiro(novoRoteiro);

        assertEquals((10.0 + 20.0 + 5.0 + 15.0) * 0.1, calculoCustoViagemVerao.descontoPromocaoSazonal());
    }

    @Test
    void descontoPromocaoSazonalNaoEntregueTest() {
        assertEquals(0.0, calculoCustoViagemVerao.descontoPromocaoSazonal());
    }
}