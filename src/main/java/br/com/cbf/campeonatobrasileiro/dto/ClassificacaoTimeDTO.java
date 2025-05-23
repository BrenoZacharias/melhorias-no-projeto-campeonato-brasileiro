package br.com.cbf.campeonatobrasileiro.dto;

import lombok.Data;

@Data
public class ClassificacaoTimeDTO implements Comparable<ClassificacaoTimeDTO>{
    private String time;
    private Integer idTime;
    private Integer posicao;
    private Integer pontos;
    private Integer jogos;
    private Integer vitorias;
    private Integer empates;
    private Integer derrotas;
    private Integer golsMarcados;
    private Integer golsSofridos;
    private Integer saldoGols;

    @Override
    public int compareTo(ClassificacaoTimeDTO o) {
        // Ordena por pontos

        int resultado = o.getPontos().compareTo(this.getPontos());

        if(resultado == 0){
            // Desempate por vitórias
            resultado = o.getVitorias().compareTo(this.getVitorias());
        }

        if (resultado == 0) {
            // Desempate por saldo de gols
            resultado = o.getSaldoGols().compareTo(this.getSaldoGols());
        }

        return resultado;
    }
}
