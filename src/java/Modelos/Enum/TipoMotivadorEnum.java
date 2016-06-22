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
public enum TipoMotivadorEnum{
	
    ASSALTO("Assalto"),
    AGRESSAO("Agressão"),
    CONTRABANDO("Contrabando");

    private String preso;

    private TipoMotivadorEnum(String preso) {
        this.preso = preso;
    }

    public String getPreso() {
            return preso;
    }
	
    public static TipoMotivadorEnum getBy(char tipo){
        switch (tipo){
            case 'A':
                return ASSALTO;
            case 'G':
                return AGRESSAO;
            case 'C':
                return CONTRABANDO;
        }
        return null;
    }
    public static String getBy(TipoMotivadorEnum tipoMotivadorEnum){
        switch (tipoMotivadorEnum){
            case ASSALTO:
                return "A";
            case AGRESSAO:
                return "G";
            case CONTRABANDO:
                return "C";
        }
        return null;
    }
}