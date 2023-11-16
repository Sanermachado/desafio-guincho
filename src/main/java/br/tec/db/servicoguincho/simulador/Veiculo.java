package br.tec.db.servicoguincho.simulador;

import br.tec.db.servicoguincho.simulador.cargas.EstadoConservacao;
import br.tec.db.servicoguincho.simulador.cargas.TipoVeiculo;


public class Veiculo {
    private final TipoVeiculo tipo;
    private final EstadoConservacao estado;
    public Veiculo(TipoVeiculo tipo, EstadoConservacao estado) {
        this.tipo = tipo;
        this.estado = estado;
    }
    public TipoVeiculo getTipo() {
        return tipo;
    }
}
