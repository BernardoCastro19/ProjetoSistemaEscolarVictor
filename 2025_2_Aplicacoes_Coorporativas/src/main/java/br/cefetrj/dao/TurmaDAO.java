package br.cefetrj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.cefetrj.commons.ConnectionFactory;
import br.cefetrj.model.Aluno;
import br.cefetrj.model.Turma;

public class TurmaDAO {

    private Connection con;

    public TurmaDAO() {
        con = ConnectionFactory.getConnection();
    }

    public void inserir(Turma turma) throws SQLException {

        String sql = "insert into Turma(nome, numeroAlunos, disciplina) values(?,?,?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, turma.nome);
        stmt.setInt(2, turma.numeroAlunos);
        stmt.setString(3, turma.disciplina);
        stmt.execute();
        stmt.close();
        con.close();
    }

    public List<Turma> listarTodos() throws SQLException {

        String sql = "select id, nome, numeroAlunos, disciplina from turma";
        PreparedStatement stmt = con.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();
        Turma turma = null;

        List<Turma> turmas = new ArrayList<Turma>();
        while (rs.next()) {
            turma = new Turma(Integer.valueOf(rs.getInt("id")), rs.getString("nome"), rs.getInt("numeroAlunos"),rs.getString("disciplina"));
            turmas.add(turma);
        }

        stmt.close();
        con.close();
        return turmas;
    }

}
