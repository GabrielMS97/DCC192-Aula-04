<%@page import="br.ufjf.dcc192.ListaDeTarefas"%>
<%@page import="br.ufjf.dcc192.Tarefa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nova tarefa</title>
    </head>
    <body>
        <h1>Editar tarefa</h1>
        <%
            Tarefa tarefa = (Tarefa)request.getAttribute("tarefa");
            int codigo = ListaDeTarefas.getInstance().indexOf(tarefa);
        %>
        <form method="post">
            <label>Título: <input name="titulo" value="<%=tarefa.getTitulo()%>"/></label><br/>
            <label>Descrição: <textarea name="descricao" rows="4" <%=tarefa.getDescricao()%>></textarea></label><br/>
            <input type="hidden" value="<%=codigo%>" name="alteracao">
            <input type="submit"/>
            <input type="reset"/>
        </form>
    </body>
</html>
