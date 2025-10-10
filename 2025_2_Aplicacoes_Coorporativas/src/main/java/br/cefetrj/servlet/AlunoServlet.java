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

        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setDocumento(documento);
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

}
