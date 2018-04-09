package br.ufjf.dcc192;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletTarefas", urlPatterns = {"/listar.html", "/nova.html", "/estado.html", "/tarefas-editar.html", "/tarefas-excluir.html"})
public class ServletTarefas extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ("/listar.html".equals(request.getServletPath())) {
            listarTarefas(request, response);
        } else if ("/nova.html".equals(request.getServletPath())) {
            criarTarefas(request, response);
        } else if ("/estado.html".equals(request.getServletPath())) {
            concluirTarefas(request, response);
        } else if ("/tarefas-editar.html".equals(request.getServletPath())) {
            editarTarefas(request, response);
        } else if ("/tarefas-excluir.html".equals(request.getServletPath())) {
            excluirTarefas(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Boolean alteracao = (boolean) request.getAttribute("alteracao");

        if (request.getParameter("alteracao") != null) {
            int indice = Integer.parseInt(request.getParameter("alteracao"));
            String titulo = request.getParameter("titulo");
            String descricao = request.getParameter("descricao");
            ListaDeTarefas.getInstance().get(indice).setDescricao(descricao);
            ListaDeTarefas.getInstance().get(indice).setTitulo(titulo);
            response.sendRedirect("listar.html");
        } else {
            String titulo = request.getParameter("titulo");
            String descricao = request.getParameter("descricao");
            Tarefa novaTarefa = new Tarefa(titulo, descricao);
            ListaDeTarefas.getInstance().add(novaTarefa);
            response.sendRedirect("listar.html");
        }
    }

    private void listarTarefas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Tarefa> tarefas = ListaDeTarefas.getInstance();
        request.setAttribute("tarefas", tarefas);
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/tarefas-listar.jsp");
        despachante.forward(request, response);
    }

    private void criarTarefas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Tarefa> tarefas = ListaDeTarefas.getInstance();
        request.setAttribute("tarefas", tarefas);
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/tarefas-nome.jsp");
        despachante.forward(request, response);
    }

    private void concluirTarefas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int linha = Integer.parseInt(request.getParameter("linha"));
        ListaDeTarefas.getInstance().get(linha).setConcluida(!ListaDeTarefas.getInstance().get(linha).getConcluida());
        response.sendRedirect("listar.html");
    }

    private void editarTarefas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int linha = Integer.parseInt(request.getParameter("linha"));
        Tarefa tarefa = ListaDeTarefas.getInstance().get(linha);
        request.setAttribute("tarefa", tarefa);
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/tarefas-editar.jsp");
        despachante.forward(request, response);
    }

    private void excluirTarefas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int linha = Integer.parseInt(request.getParameter("linha"));
        ListaDeTarefas.getInstance().remove(linha);
        response.sendRedirect("listar.html");
    }
}
