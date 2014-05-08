package br.eti.minoda.rotinapedagogica;

public class DiaSemana {

	private enum DiaSemanaEnum {
		DOMINGO (1, "Domingo"),
		SEGUNDA (2, "Segunda-feira"),
		TERCA   (3, "Terca-feira"),
		QUARTA  (4, "Quarta-feira"),
		QUINTA  (5, "Quinta-feira"),
		SEXTA   (6, "Sexta-feira"),
		SABADO  (7, "Sabado");

		private final int num;
		private final String descricao;           
	
		DiaSemanaEnum(Integer num, String descr) {
			this.num = num;
			this.descricao = descr;
		}
	
		private Integer getNum() {
			return num;
		}
	
		private String getDescricao() {
			return descricao;
		}                   
	}

	public static String getDescricaoDiaSemana(int diaSolicitado) {
		String descricao = null;
		for (DiaSemanaEnum dia : DiaSemanaEnum.values()) {
			if (dia.getNum() == diaSolicitado) {
				descricao = dia.getDescricao();
				break;
			}
		}

		return descricao;
	}
}
