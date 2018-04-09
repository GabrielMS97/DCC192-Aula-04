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
                    <th>Editar</th>
                    <th>Excluir</th>
                </tr>    
                <%
                    for (int i = 0; i < ListaDeTarefas.getInstance().size(); i++) {
                        Tarefa tarefa = ListaDeTarefas.getInstance().get(i);
                %>  
                <tr>
                    <td><a href="estado.html?linha=<%=i%>"><%=tarefa.getConcluida()?"Concluída":"A fazer"%></a></td>
                    <td><%=tarefa.getTitulo()%></td>
                    <td><%=tarefa.getDescricao()%></td>
                    <td><a href="tarefas-editar.html?linha=<%=i%>">Editar</a></td>
                    <td><a href="excluir.html">Excluir</a></td>
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
