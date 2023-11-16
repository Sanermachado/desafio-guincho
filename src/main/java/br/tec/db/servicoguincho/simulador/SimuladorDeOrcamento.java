package br.tec.db.servicoguincho.simulador;


public class SimuladorDeOrcamento {
    public double calcularCustoTotal(Veiculo veiculo, Trajeto trajeto) {
        double custoDeslocamento = calcularCustoDeslocamento(veiculo, trajeto);
        double custoBase = 50.0; // Custo base para todos os orçamentos

        return custoBase + custoDeslocamento;
    }
    private double calcularCustoDeslocamento(Veiculo veiculo, Trajeto trajeto) {
        Guincho guincho = obterGuincho(veiculo);
        return guincho.calcularCustoDeslocamento(trajeto);
    }
    private Guincho obterGuincho(Veiculo veiculo) {
        switch (veiculo.getTipo()) {
            case CARRO:
            case MINIVAN:
                return new Guincho(2.0); // Caminhão de corrente e gancho
            case ONIBUS:
                return new Guincho(10.0); // Caminhão de reboque integrado
            case CAMINHAO:
                return new Guincho(5.0); // Caminhão guincho de plataforma
            default:
                throw new IllegalArgumentException("Tipo de veículo não suportado: " + veiculo.getTipo());
        }
    }
}
