/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos.Enum;

/**
 *
 * @author Damarate
 */
public enum TipoFuncionarioEnum{
	
    PROFESSOR("Professor"),
    AGENTEP("Agente penitênciario"),
    ASSSOCIAL("Assistente social"),
    MEDICO("Médico"),
    ENFERMEIRO("Enfermeiro"),
    PSICOLOGO("Psicologo"),
    POLICIAL("Policial"),
    TECNICOSAUDE("Tecnico de saúde");

    private String pessoa;

    private TipoFuncionarioEnum(String pessoa) {
        this.pessoa = pessoa;
    }

    public String getPessoa() {
            return pessoa;
    }
	
    public static TipoFuncionarioEnum getBy(char tipo){
        switch (tipo){
            case 'P':
                return PROFESSOR;
            case 'A':
                return AGENTEP;
            case 'S':
                return ASSSOCIAL;
            case 'M':
                return MEDICO;
            case 'E':
                return ENFERMEIRO;
            case 'L':
                return PSICOLOGO;
            case 'G':
                return POLICIAL;
            case 'T':
                return TECNICOSAUDE;
        }
        return null;
    }
    public static String getBy(TipoFuncionarioEnum tipo){
        switch (tipo){
            case PROFESSOR:
                return "P";
            case AGENTEP:
                return "A";
            case ASSSOCIAL:
                return "S";
            case MEDICO:
                return "M";
            case ENFERMEIRO:
                return "E";
            case PSICOLOGO:
                return "L";
            case POLICIAL:
                return "G";
            case TECNICOSAUDE:
                return "T";            
        }
        return null;
    }
    
        public static String getDocumentoBy(TipoFuncionarioEnum tipo){
        switch (tipo){
            case AGENTEP:
                return "Matrícula";
            case ASSSOCIAL:
                return "CRESS";
            case ENFERMEIRO:
                return "COREN";
            case MEDICO:
                return "CRM | especialidade";
            case PSICOLOGO:
                return "CRP";
            case POLICIAL:
                return "Numero de registro | Grau hierarquico";
        }
        return null;
    }
}