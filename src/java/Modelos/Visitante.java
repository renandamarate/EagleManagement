package Modelos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Modelos.Abstract.Pessoa;
import Modelos.Enum.TipoRelacaoEnum;

/**
 *
 * @author Damarate
 */
public class Visitante extends Pessoa {
    private TipoRelacaoEnum tipoRelacaoEnum;
    private boolean necessidadeEspecial;
    private Visita visita;
    private Preso preso;
    
    
}
