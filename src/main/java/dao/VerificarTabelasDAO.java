package dao;

import db.Conexao;
import vo.TabelasVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VerificarTabelasDAO {

    public static boolean tabelaExiste(TabelasVO atualizarTabelasVO) throws SQLException, ClassNotFoundException {
        PreparedStatement st = null;
        ResultSet rs = null;
        try (Connection conexao = new Conexao().getConnection()) {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT to_regclass('" + atualizarTabelasVO.getTabela() + "');");
            st = conexao.prepareStatement(sql.toString());
            rs = st.executeQuery();
            if (rs.next()) {
                String resultado = rs.getString(1);
                return resultado != null;
            }
        }
        return false;
    }
}

