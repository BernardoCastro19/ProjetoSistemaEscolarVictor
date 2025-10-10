package br.cefetrj.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.cefetrj.dao.AlunoDAO;
import br.cefetrj.dao.DisciplinaDAO;
import br.cefetrj.model.Usuario;
import br.cefetrj.model.Aluno;
import br.cefetrj.model.Disciplina;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Disciplina")
public class DisciplinaServlet extends HttpServlet {
     private static final long serialVersionUID = 3L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String nome = request.getParameter("nome");
        Integer horas = Integer.parseInt(request.getParameter("horas"));

        Disciplina disciplina = new Disciplina();
        disciplina.setNome(nome);
        disciplina.setHoras(0);
        // Aqui você pode adicionar o Disciplina a um banco de dados ou a uma lista
        DisciplinaDAO dao = new DisciplinaDAO();
        dao.salvar(disciplina);
        RequestDispatcher rd = request.getRequestDispatcher("cadastro-sucesso.jsp");

        rd.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        DisciplinaDAO dao = new DisciplinaDAO();
        List<Disciplina> disciplinas;
        
        disciplinas = dao.listar();
        request.setAttribute("disciplinas", disciplinas);
        RequestDispatcher rd = request.getRequestDispatcher("lista-disciplinas.jsp");
        rd.forward(request, response);
    }

}
