package br.cefetrj.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.cefetrj.dao.AlunoDAO;
import br.cefetrj.model.Usuario;
import br.cefetrj.model.Aluno;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Aluno")
public class AlunoServlet extends HttpServlet {
    private static final long serialVersionUID = 3L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String nome = request.getParameter("nome");
        String documento = request.getParameter("documento");

        Aluno aluno = new Aluno(null, nome, documento);
        // Aqui você pode adicionar o cliente a um banco de dados ou a uma lista
        AlunoDAO dao = new AlunoDAO();
        dao.salvar(aluno);
        RequestDispatcher rd = request.getRequestDispatcher("cadastro-sucesso.jsp");
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
        AlunoDAO dao = new AlunoDAO();
        List<Aluno> alunos;
        alunos = dao.listar();
        request.setAttribute("alunos", alunos);
        RequestDispatcher rd = request.getRequestDispatcher("lista-alunos.jsp");
        rd.forward(request, response);
    }

    private List<Aluno> criaAlunos() {
        List<Aluno> alunos = new ArrayList<>();
        Aluno aluno1 = new Aluno(1, "Aluno 1", "134515616");
        Aluno aluno2 = new Aluno(2, "Aluno 2", "132251511");
        Aluno aluno3 = new Aluno(3, "Aluno 3", "433564363");
        alunos.add(aluno1);
        alunos.add(aluno2);
        alunos.add(aluno3);
        return alunos;
    }
}
