package NegocioBC;

import Modelos.Preso;
import PersistenciaDAO.PresoDAO;
import java.sql.SQLException;
import org.springframework.util.StringUtils;

public class PresoBC {
	
    private static PresoBC instance = new PresoBC();

    private PresoBC() {
    }

    public static PresoBC getInstance() {
            return instance;
    }

    ///////////////////////////////////////////////////////////////////
    // METODOS DE MODIFICACAO
    ///////////////////////////////////////////////////////////////////

    public void cadastrarPreso(Preso preso) throws Exception {
        validarPreso(preso);
        PresoDAO.getInstance().salvarPreso(preso);
    }

    public void atualizarPreso(Preso preso) throws Exception {
        validarPreso(preso);
        PresoDAO.getInstance().atualizarPreso(preso);
    }

    public void inativarPreso(Preso preso) throws SQLException {
        preso.setStatus(false);
        PresoDAO.getInstance().atualizarPreso(preso);
    }

    ///////////////////////////////////////////////////////////////////
    // METODOS DE BUSCA
    ///////////////////////////////////////////////////////////////////

    public Preso pesquisarPresoCPF(String filtro){
        return PresoDAO.getInstance().pesquisarPresoCPF(filtro);
    }
    
    public Preso pesquisarPresoNome(String filtro){
        return PresoDAO.getInstance().pesquisarPresoNome(filtro);
    }
    
    public Preso pesquisarPresoRG(String filtro){
        return PresoDAO.getInstance().pesquisarPresoRG(filtro);
    }
    
    ///////////////////////////////////////////////////////////////////
    // METODOS AUXILIARES
    ///////////////////////////////////////////////////////////////////
    private void validarPreso(Preso preso) throws Exception {
        if (preso == null)
            throw new Exception("O objeto é nulo.");
        if(!StringUtils.hasText(preso.getNome()))
            throw new Exception("Nome do preso nao preenchido");
        if(!StringUtils.hasText(preso.getDocumentoRG()))
            throw new Exception("Documento de RG do preso nao preenchido");
        if(!StringUtils.hasText(preso.getDocumentoCPF()))
            throw new Exception("Documento de CPF do preso nao preenchido");
        if(preso.getSexo() != 'M' || preso.getSexo() != 'F')
            throw new Exception("Sexo do preso nao preenchido");
        if(preso.getDataNascimento().getYear() < 1000)
            throw new Exception("Data de nascimento do preso inválido");
    }
}