package Modelos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Modelos.Abstract.Pessoa;
import Modelos.Enum.TipoEscolaridadeEnum;
import Modelos.Enum.TipoEtniaEnum;
import Modelos.Enum.TipoMotivadorEnum;
import Modelos.Enum.TipoNacionalidadeEnum;
import Modelos.Enum.TipoNaturalidadeEnum;
import Modelos.Enum.TipoRegimeEnum;
import Modelos.Enum.TipoReligiaoEnum;
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

    public Date getDataPrisao() {
        return dataPrisao;
    }

    public void setDataPrisao(Date dataPrisao) {
        this.dataPrisao = dataPrisao;
    }

    public boolean isNecessidadeEspecial() {
        return necessidadeEspecial;
    }

    public void setNecessidadeEspecial(boolean necessidadeEspecial) {
        this.necessidadeEspecial = necessidadeEspecial;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Cela getCela() {
        return Cela;
    }

    public void setCela(Cela Cela) {
        this.Cela = Cela;
    }

    public TipoMotivadorEnum getTipoMotivadorEnum() {
        return tipoMotivadorEnum;
    }

    public void setTipoMotivadorEnum(TipoMotivadorEnum tipoMotivadorEnum) {
        this.tipoMotivadorEnum = tipoMotivadorEnum;
    }

    public TipoRegimeEnum getTipoRegimeEnum() {
        return tipoRegimeEnum;
    }

    public void setTipoRegimeEnum(TipoRegimeEnum tipoRegimeEnum) {
        this.tipoRegimeEnum = tipoRegimeEnum;
    }

    public TipoNacionalidadeEnum getTipoNacionalidadeEnum() {
        return tipoNacionalidadeEnum;
    }

    public void setTipoNacionalidadeEnum(TipoNacionalidadeEnum tipoNacionalidadeEnum) {
        this.tipoNacionalidadeEnum = tipoNacionalidadeEnum;
    }

    public TipoNaturalidadeEnum getTipoNaturalidadeEnum() {
        return tipoNaturalidadeEnum;
    }

    public void setTipoNaturalidadeEnum(TipoNaturalidadeEnum tipoNaturalidadeEnum) {
        this.tipoNaturalidadeEnum = tipoNaturalidadeEnum;
    }

    public TipoReligiaoEnum getTipoReligiaoEnum() {
        return tipoReligiaoEnum;
    }

    public void setTipoReligiaoEnum(TipoReligiaoEnum tipoReligiaoEnum) {
        this.tipoReligiaoEnum = tipoReligiaoEnum;
    }

    public TipoEtniaEnum getTipoEtniaEnum() {
        return tipoEtniaEnum;
    }

    public void setTipoEtniaEnum(TipoEtniaEnum tipoEtniaEnum) {
        this.tipoEtniaEnum = tipoEtniaEnum;
    }

    public TipoEscolaridadeEnum getTipoEscolaridadeEnum() {
        return tipoEscolaridadeEnum;
    }

    public void setTipoEscolaridadeEnum(TipoEscolaridadeEnum tipoEscolaridadeEnum) {
        this.tipoEscolaridadeEnum = tipoEscolaridadeEnum;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
    
    
}
