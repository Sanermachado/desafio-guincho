package br.tec.db.servicoguincho;

import br.tec.db.servicoguincho.simulador.SimuladorDeOrcamento;
import br.tec.db.servicoguincho.simulador.Trajeto;
import br.tec.db.servicoguincho.simulador.Veiculo;
import br.tec.db.servicoguincho.simulador.cargas.EstadoConservacao;
import br.tec.db.servicoguincho.simulador.cargas.TipoVeiculo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao simulador de orçamento de guincho!");

        System.out.println("Selecione o tipo de veículo (1 - Carro, 2 - MiniVan, 3 - Ônibus, 4 - Caminhão): ");
        int tipoVeiculoInput = scanner.nextInt();
        TipoVeiculo tipoVeiculo = obterTipoVeiculo(tipoVeiculoInput);

        System.out.println("Selecione o estado de conservação do veículo (1 - Novo, 2 - Quebrado): ");
        int estadoConservacaoInput = scanner.nextInt();
        EstadoConservacao estadoConservacao = obterEstadoConservacao(estadoConservacaoInput);

        System.out.println("Informe a distância do deslocamento em quilômetros: ");
        int distanciaEmKM = scanner.nextInt();
        Trajeto trajeto = new Trajeto(distanciaEmKM);

        Veiculo veiculo = new Veiculo(tipoVeiculo, estadoConservacao);

        SimuladorDeOrcamento simulador = new SimuladorDeOrcamento();
        double custoTotal = simulador.calcularCustoTotal(veiculo, trajeto);

        System.out.println("Custo Total do Orçamento: R$ " + custoTotal);

        scanner.close();
    }

    private static TipoVeiculo obterTipoVeiculo(int input) {
        switch (input) {
            case 1:
                return TipoVeiculo.CARRO;
            case 2:
                return TipoVeiculo.MINIVAN;
            case 3:
                return TipoVeiculo.ONIBUS;
            case 4:
                return TipoVeiculo.CAMINHAO;
            default:
                throw new IllegalArgumentException("Tipo de veículo não reconhecido: " + input);
        }
    }

    private static EstadoConservacao obterEstadoConservacao(int input) {
        switch (input) {
            case 1:
                return EstadoConservacao.NOVO;
            case 2:
                return EstadoConservacao.QUEBRADO;
            default:
                throw new IllegalArgumentException("Estado de conservação não reconhecido: " + input);
        }
    }
}
