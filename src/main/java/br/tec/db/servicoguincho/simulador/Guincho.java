package br.tec.db.servicoguincho.simulador;


public class Guincho {
    private final double taxaDeslocamento;

    public Guincho(double taxaDeslocamento) {
        this.taxaDeslocamento = taxaDeslocamento;
    }

    public double calcularCustoDeslocamento(Trajeto trajeto) {
        // Lógica para considerar as distâncias específicas entre os bairros
        int distanciaEmKM = trajeto.getDistanciaEmKM();

        // Condições baseadas na tabela de deslocamento
        if (distanciaEmKM == 5 || distanciaEmKM == 8 || distanciaEmKM == 10 || distanciaEmKM == 15) {
            return taxaDeslocamento * distanciaEmKM;
        } else {
            throw new IllegalArgumentException("Distância de trajeto não suportada: " + distanciaEmKM + " km");
        }
    }
}
