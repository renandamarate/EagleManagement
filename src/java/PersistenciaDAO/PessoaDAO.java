/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PersistenciaDAO;

import Modelos.Abstract.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jeferson.zavaski
 */
public class PessoaDAO {
    
    private static PessoaDAO instance = new PessoaDAO();
    private static StringBuilder insertPessoaSQL = new StringBuilder()
		.append("insert into Pessoa")
		.append("(nome, documentoRG, documentoCPF, dataNascimento, sexo, enderecoId)")
		.append("values ")
		.append("(?, ?, ?, ?, ?, ?)");
    private static StringBuilder updatePessoaSQL = new StringBuilder()
		.append("update Pessoa")
		.append("(nome, documentoRG, documentoCPF, dataNascimento, sexo, enderecoId)")
		.append("values ")
		.append("(?, ?, ?, ?, ?, ?)");
    private static StringBuilder selectCPFPessoaSQL = new StringBuilder()
		.append("select * from Pessoa ")
		.append("where documentoCPF = ? ");
    private static StringBuilder selectRGPessoaSQL = new StringBuilder()
		.append("select * from Pessoa ")
		.append("where documentoRG = ? ");
    private static StringBuilder selectNomePessoaSQL = new StringBuilder()
		.append("select * from Pessoa ")
		.append("where nome = ? ");

    private PessoaDAO() {
    }

    public static PessoaDAO getInstance() {
        return instance;
    }
    
    ///////////////////////////////////////////////////////////////////
    // METODOS DE MODIFICACAO
    ///////////////////////////////////////////////////////////////////
    
    public Integer salvarPessoa(Pessoa pessoa) throws SQLException {
        //int idEndereco = EnderecoDAO.getInstance().salvarEndereco(preso.getEndereco());
        int cont = 1;
        Connection connection = null; //Conexao.getInstance().obterConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(insertPessoaSQL.toString(), Statement.RETURN_GENERATED_KEYS);
            ps.setString(cont++, pessoa.getNome());
            ps.setString(cont++, pessoa.getDocumentoRG());
            ps.setString(cont++, pessoa.getDocumentoCPF());
            ps.setDate(cont++, pessoa.getDataNascimento());
            ps.setString(cont++, String.valueOf(pessoa.getSexo()));
            ps.executeUpdate();
            pessoa.setId(retrievePrimaryKeygenerated(rs, ps));
            
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
        } finally {
            //Conexao.close(rs, ps, connection);
        }
        return pessoa.getId();
    }
    
    public void atualizarPessoa(Pessoa pessoa) throws SQLException {
        //int idEndereco = EnderecoDAO.getInstance().salvarEndereco(preso.getEndereco());
        int cont = 1;
        Connection connection = null; //Conexao.getInstance().obterConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(updatePessoaSQL.toString());
            ps.setString(cont++, pessoa.getNome());
            ps.setString(cont++, pessoa.getDocumentoRG());
            ps.setString(cont++, pessoa.getDocumentoCPF());
            ps.setDate(cont++, pessoa.getDataNascimento());
            ps.setString(cont++, String.valueOf(pessoa.getSexo()));
            ps.executeUpdate();
            pessoa.setId(retrievePrimaryKeygenerated(rs, ps));
            
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

    public Pessoa pesquisarPessoaCPF(Pessoa pessoa){
        Connection connection = null; //Conexao.getInstance().obterConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(selectCPFPessoaSQL.toString(), Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, pessoa.getId());
            obterObjeto(rs, pessoa);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //Conexao.close(rs, ps, connection);
        }
        return pessoa;
    }
    
    public Pessoa pesquisarPessoaNome(Pessoa pessoa){
        Connection connection = null; //Conexao.getInstance().obterConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(selectNomePessoaSQL.toString(), Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, pessoa.getId());
            obterObjeto(rs, pessoa);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //Conexao.close(rs, ps, connection);
        }
        return pessoa;
    }
    
    public Pessoa pesquisarPessoaRG(Pessoa pessoa){
        Connection connection = null; //Conexao.getInstance().obterConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(selectRGPessoaSQL.toString(), Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, pessoa.getId());
            obterObjeto(rs, pessoa);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //Conexao.close(rs, ps, connection);
        }
        return pessoa;
    }
    
    ///////////////////////////////////////////////////////////////////
    // METODOS DE AUXILIO
    ///////////////////////////////////////////////////////////////////
    
    public Pessoa obterObjeto(ResultSet rs, Pessoa pessoa) throws SQLException{
        pessoa.setNome(rs.getString("nome"));
        pessoa.setDocumentoRG(rs.getString("documentoRG"));
        pessoa.setDocumentoCPF(rs.getString("documentoCPF"));
        pessoa.setSexo(rs.getString("sexo").charAt(0));
        //pessoa.setEndereco(rs.getString("enderecoId"));
        return pessoa;
    }

    private Integer retrievePrimaryKeygenerated(ResultSet rs, PreparedStatement ps) throws SQLException {
        //Obtem o ID gerado pelo banco HSQLDB
        rs = ps.getGeneratedKeys();
        if(rs.next())
            return rs.getInt(1);
        return null;
    }
}
