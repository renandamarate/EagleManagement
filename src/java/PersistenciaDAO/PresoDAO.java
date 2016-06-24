/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PersistenciaDAO;

import Modelos.Abstract.Pessoa;
import Modelos.Enum.TipoEscolaridadeEnum;
import Modelos.Enum.TipoEtniaEnum;
import Modelos.Enum.TipoMotivadorEnum;
import Modelos.Enum.TipoNacionalidadeEnum;
import Modelos.Enum.TipoNaturalidadeEnum;
import Modelos.Enum.TipoRegimeEnum;
import Modelos.Enum.TipoReligiaoEnum;
import Modelos.Preso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jeferson.zavaski
 */
public class PresoDAO {
    
    private static PresoDAO instance = new PresoDAO();
    private static StringBuilder insertPessoaSQL = new StringBuilder()
		.append("insert into Preso")
		.append("(dataPrisao, necessidadeEspecial, altura, peso, tipoMotivador, tipoRegime"
                        + "tipoNacionalidade, tipoNaturalidade, tipoReligiao, tipoEtnia, tipoEscolaridade, Status)")
		.append("values ")
		.append("(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, true)");
    private static StringBuilder updatePessoaSQL = new StringBuilder()
		.append("insert into Preso")
		.append("(dataPrisao, necessidadeEspecial, altura, peso, tipoMotivador, tipoRegime"
                        + "tipoNacionalidade, tipoNaturalidade, tipoReligiao, tipoEtnia, tipoEscolaridade)")
		.append("values ")
		.append("(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
    private static StringBuilder selectIdPresoSQL = new StringBuilder()
		.append("select * from Preso ")
		.append("where presoId = ? ");

    private PresoDAO() {
    }

    public static PresoDAO getInstance() {
        return instance;
    }
    
    ///////////////////////////////////////////////////////////////////
    // METODOS DE MODIFICACAO
    ///////////////////////////////////////////////////////////////////
    
    public void salvarPreso(Preso preso) throws SQLException {
        
        PessoaDAO.getInstance().salvarPessoa(preso);
        
        int cont = 1;
        Connection connection = null; //Conexao.getInstance().obterConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(insertPessoaSQL.toString(), Statement.RETURN_GENERATED_KEYS);
            ps.setDate(cont++, preso.getDataPrisao());
            ps.setBoolean(cont++, preso.isNecessidadeEspecial());
            ps.setDouble(cont++, preso.getAltura());
            ps.setDouble(cont++, preso.getPeso());
            ps.setString(cont++, TipoMotivadorEnum.getBy(preso.getTipoMotivadorEnum()));
            ps.setString(cont++, TipoRegimeEnum.getBy(preso.getTipoRegimeEnum()));
            ps.setString(cont++, TipoNacionalidadeEnum.getBy(preso.getTipoNacionalidadeEnum()));
            ps.setString(cont++, TipoNaturalidadeEnum.getBy(preso.getTipoNaturalidadeEnum()));
            ps.setString(cont++, TipoRegimeEnum.getBy(preso.getTipoRegimeEnum()));
            ps.setString(cont++, TipoEtniaEnum.getBy(preso.getTipoEtniaEnum()));
            ps.setString(cont++, TipoEscolaridadeEnum.getBy(preso.getTipoEscolaridadeEnum()));
            ps.executeUpdate();
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
        } finally {
            //Conexao.close(rs, ps, connection);
        }
    }
    
    public void atualizarPreso(Preso preso) throws SQLException {
        
        PessoaDAO.getInstance().atualizarPessoa(preso);
        
        int cont = 1;
        Connection connection = null; //Conexao.getInstance().obterConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(updatePessoaSQL.toString());
            ps.setDate(cont++, preso.getDataPrisao());
            ps.setBoolean(cont++, preso.isNecessidadeEspecial());
            ps.setDouble(cont++, preso.getAltura());
            ps.setDouble(cont++, preso.getPeso());
            ps.setString(cont++, TipoMotivadorEnum.getBy(preso.getTipoMotivadorEnum()));
            ps.setString(cont++, TipoRegimeEnum.getBy(preso.getTipoRegimeEnum()));
            ps.setString(cont++, TipoNacionalidadeEnum.getBy(preso.getTipoNacionalidadeEnum()));
            ps.setString(cont++, TipoNaturalidadeEnum.getBy(preso.getTipoNaturalidadeEnum()));
            ps.setString(cont++, TipoRegimeEnum.getBy(preso.getTipoRegimeEnum()));
            ps.setString(cont++, TipoEtniaEnum.getBy(preso.getTipoEtniaEnum()));
            ps.setString(cont++, TipoEscolaridadeEnum.getBy(preso.getTipoEscolaridadeEnum()));
            ps.executeUpdate();
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
        } finally {
            //Conexao.close(rs, ps, connection);
        }
    }

    ///////////////////////////////////////////////////////////////////
    // METODOS DE BUSCA
    ///////////////////////////////////////////////////////////////////

    public Preso pesquisarPresoCPF(String filtro){
        Preso preso = new Preso();
        preso.setDocumentoCPF(filtro);
        PessoaDAO.getInstance().pesquisarPessoaCPF(preso);
        
        pesquisarPresoId(preso);
        return preso;
    }
    
    public Preso pesquisarPresoNome(String filtro){
        Preso preso = new Preso();
        preso.setNome(filtro);
        PessoaDAO.getInstance().pesquisarPessoaCPF(preso);
        
        pesquisarPresoId(preso);
        return preso;
    }
    
    public Preso pesquisarPresoRG(String filtro){
        Preso preso = new Preso();
        preso.setDocumentoRG(filtro);
        PessoaDAO.getInstance().pesquisarPessoaCPF(preso);
        
        pesquisarPresoId(preso);
        return preso;
    }
    
    public Preso pesquisarPresoId(Preso preso){
        Connection connection = null; //Conexao.getInstance().obterConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(selectIdPresoSQL.toString(), Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, preso.getId());
            obterObjeto(rs, preso);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //Conexao.close(rs, ps, connection);
        }
        return preso;
    }

    ///////////////////////////////////////////////////////////////////
    // METODOS AUXILIARES
    ///////////////////////////////////////////////////////////////////
    
    public Preso obterObjeto(ResultSet rs, Preso preso) throws SQLException{
        preso.setDataPrisao(rs.getDate("dataPrisao"));
        preso.setNecessidadeEspecial(rs.getBoolean("necessidadeEspecial"));
        preso.setAltura(rs.getDouble("altura"));
        preso.setPeso(rs.getDouble("peso"));
        preso.setTipoMotivadorEnum(TipoMotivadorEnum.getBy(rs.getString("tipoMotivador").charAt(0)));
        preso.setTipoRegimeEnum(TipoRegimeEnum.getBy(rs.getString("tipoRegime").charAt(0)));
        preso.setTipoNacionalidadeEnum(TipoNacionalidadeEnum.getBy(rs.getString("tipoNacionalidade").charAt(0)));
        preso.setTipoNaturalidadeEnum(TipoNaturalidadeEnum.getBy(rs.getString("tipoNaturalidade").charAt(0)));
        preso.setTipoReligiaoEnum(TipoReligiaoEnum.getBy(rs.getString("tipoReligiao").charAt(0)));
        preso.setTipoEtniaEnum(TipoEtniaEnum.getBy(rs.getString("tipoEtnia").charAt(0)));
        preso.setTipoEscolaridadeEnum(TipoEscolaridadeEnum.getBy(rs.getString("tipoEscolaridade").charAt(0)));
        return preso;
    }
}
