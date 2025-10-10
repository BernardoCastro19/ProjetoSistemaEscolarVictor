package br.cefetrj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.cefetrj.commons.ConnectionFactory;
import br.cefetrj.model.Professor;

public class ProfessorDAO {

    private Connection con;

    public ProfessorDAO() {
        con = ConnectionFactory.getConnection();
    }

    public void inserir(Professor professor) throws SQLException {

        String sql = "insert into Professor(nome,documento,diploma) values(?,?,?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, professor.nome);
        stmt.setString(2, professor.documento);
        stmt.setString(3, professor.diploma);
        stmt.executeUpdate();
        stmt.close();
        con.close();
    }

    public List<Professor> listarTodos() throws SQLException {

        String sql = "select id, nome, documento, diploma from Professor";
        PreparedStatement stmt = con.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();
        Professor professor= null;

        List<Professor> professores = new ArrayList<Professor>();
        while (rs.next()) {
            professor = new Professor(Integer.valueOf(rs.getInt("id")), rs.getString("nome"), rs.getString("documento"),rs.getString("diploma"));
            professores.add(professor);
        }

        stmt.close();
        con.close();
        return professores;
    }

}