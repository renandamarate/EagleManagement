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

public enum TipoRelacaoEnum{
	
    ADVOGADO("Advogado"),
    VOLUNTARIO("Voluntário"),
    CONJUGE("Conjuge"),
    EDUCADOR("Educador"),
    FASC("Familia - Ascendente"),
    FDESC("Familia - Descendente"),
    FOUTROS("Familia - Outros");

    private String visitante;

    private TipoRelacaoEnum(String visitante) {
        this.visitante = visitante;
    }

    public String getVisitante() {
            return visitante;
    }
	
    public static TipoRelacaoEnum getBy(char tipo){
        switch (tipo){
            case 'A':
                    return ADVOGADO;
            case 'V':
                    return VOLUNTARIO;
            case 'C':
                    return CONJUGE;
            case 'E':
                    return EDUCADOR;
            case 'F':
                    return FASC;
            case 'G':
                    return FDESC;
            case 'H':
                    return FOUTROS;
        }
        return null;
    }
    public static String getBy(TipoRelacaoEnum tipoEventoEnum){
        switch (tipoEventoEnum){
            case ADVOGADO:
                    return "A";
            case VOLUNTARIO:
                    return "V";
            case CONJUGE:
                    return "C";
            case EDUCADOR:
                    return "E";
            case FASC:
                    return "F";
            case FDESC:
                    return "G";
            case FOUTROS:
                    return "H";                
        }
        return null;
    }
}