/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Modelos.Abstract.Pessoa;
import Modelos.Enum.TipoFuncionarioEnum;
import java.sql.Date;

/**
 *
 * @author Damarate
 */
public class Funcionario extends Pessoa {
    private Date dataEntrada;
    private double salário;
    private String documento1;
    private String documento2;
    private TipoFuncionarioEnum tipoFuncionarioEnum;
}
