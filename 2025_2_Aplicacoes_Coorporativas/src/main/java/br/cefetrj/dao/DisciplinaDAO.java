package br.cefetrj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.cefetrj.commons.ConnectionFactory;
import br.cefetrj.model.Disciplina;

public class DisciplinaDAO {

    private Connection con;

    public DisciplinaDAO() {
        con = ConnectionFactory.getConnection();
    }

    public void inserir(Disciplina disciplina) throws SQLException {

        String sql = "insert into Disciplina(nome,horas) values(?,?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, disciplina.nome);
        stmt.setInt(2, disciplina.horas);
        stmt.executeUpdate();
        stmt.close();
        con.close();
    }

    public List<Disciplina> listarTodos() throws SQLException {

        String sql = "select id, nome, horas from disciplina";
        PreparedStatement stmt = con.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();
        Disciplina disciplina = null;

        List<Disciplina> disciplinas = new ArrayList<Disciplina>();
        while (rs.next()) {
            disciplina = new Disciplina(Integer.valueOf(rs.getInt("id")), rs.getString("nome"), rs.getInt("horas"));
            disciplinas.add(disciplina);
        }

        stmt.close();
        con.close();
        return disciplinas;
    }

}
