<%@page import="java.util.List"%>
<%@page import="br.ufjf.dcc192.ListaDeTarefas"%>
<%@page import="br.ufjf.dcc192.Tarefa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Tarefas</title>
    </head>
    <body>
        <h1>Lista de Tarefas</h1>
        <table border = "2">
            <tbody>
                <tr>
                    <th>Status</th>
                    <th>Título</th>
                    <th>Descrição</th>
                </tr>    
                <%
                    for (Tarefa tarefa : (List<Tarefa>) request.getAttribute("tarefas")) {

                %>  
                <tr>
                    <td><%=tarefa.getConcluida()%></td>
                    <td><%=tarefa.getTitulo()%></td>
                    <td><%=tarefa.getDescricao()%></td>
                </tr>
                <%}%>
            </tbody>
            <tfoot>
                <tr>
                    <td><a href="nova.html">Adicionar Tarefas</a></td>
                </tr>
            </tfoot>
        </table>
    </body>
</html>