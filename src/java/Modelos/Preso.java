package Modelos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Modelos.Abstract.Pessoa;
import Modelos.Enum.TipoMotivadorEnum;
import Modelos.Enum.TipoRegimeEnum;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Damarate
 */
public class Preso extends Pessoa {
    private Date dataPrisao;
    private boolean necessidadeEspecial;
    private double altura;
    private double peso;
    private Cela Cela; //Com a cela podemos saber ala/presidio
    private TipoMotivadorEnum tipoMotivadorEnum;
    private TipoRegimeEnum tipoRegimeEnum;
    private TipoNacionalidadeEnum tipoNacionalidadeEnum;
    private TipoNaturalidadeEnum tipoNaturalidadeEnum;
    private TipoReligiaoEnum tipoReligiaoEnum;
    private TipoEtniaEnum tipoEtniaEnum;
    private TipoEscolaridadeEnum tipoEscolaridadeEnum;
    private List<Curso> cursos;
}
