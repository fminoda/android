package br.eti.minoda.rotinapedagogica;

public class DaoAtividade {
	
	final String [] horario = 
		{"07:20 as 08:10", 
		 "08:10 as 09:00",
		 "09:00 as 09:50",
		 "09:50 as 10:10",
		 "10:10 as 11:00",
		 "11:00 as 11:45",
	     "11:45 as 12:30"};

		final String [] [] materia = 
			{{"Dormir", "Dormir", "Dormir", "Tomar cafe", "Brincar", "Brincar", "Almocar"}, 
			 {"Artes", "Espanhol", "Matematica I", "Intervalo", "Matematica I", "Ingles", "Ingles"}, 
			 {"Educacao Fisica", "Historia", "Historia", "Intervalo", "Ciencias", "Ciencias", "Matematica I"}, 
			 {"Espanhol", "Ciencias", "Literatura", "Intervalo", "Literatura", "Ingles","Ingles"}, 
			 {"Matematica I", "Matematica I", "Gramatica", "Intervalo", "Historia", "Geografia", "Educacao Fisica"}, 
			 {"Filosofia", "Musica", "Gramatica", "Intervalo", "Gramatica", "Geografia", "Geografia"}, 
			 {"Dormir", "Dormir", "Dormir", "Tomar cafe", "Brincar", "Brincar", "Almocar"}};
		
		
	public StringBuffer getRotinaDiaria(int diaDaSemana) {
        String quebraLinha = System.getProperty("line.separator");		
		StringBuffer sb = new StringBuffer();
		sb.append(horario[0] + " - " + materia [diaDaSemana] [0] + quebraLinha);
		sb.append(horario[1] + " - " + materia [diaDaSemana] [1] + quebraLinha);
		sb.append(horario[2] + " - " + materia [diaDaSemana] [2] + quebraLinha);
		sb.append(horario[3] + " - " + materia [diaDaSemana] [3] + quebraLinha);
		sb.append(horario[4] + " - " + materia [diaDaSemana] [4] + quebraLinha);
		sb.append(horario[5] + " - " + materia [diaDaSemana] [5] + quebraLinha);
		sb.append(horario[6] + " - " + materia [diaDaSemana] [6] + quebraLinha);
		
		return sb;	
	}
}
