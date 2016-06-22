/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author Damarate
 */
public class Trabalho {
    private int id;
    private Date dataInicio;
    private Date dataFim;
    private Preso preso;
    
    //Dados referente ao registro
    //Preso não precisa bater ponto ahueashueuhaseuha
    private Timestamp horaInicio; //Será fixo para o preso.
    private Timestamp horaFim; //Será fixo para o preso.
}
