<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, modelos.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Lista de Notas</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }

        h1 {
            text-align: center;
            color: #333;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
            border: 1px solid #ddd;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 10px;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #ddd;
        }

        .cabecera {
            font-weight: bold;
        }

        .accion {
            text-align: center;
        }

        .boton {
            background-color: #333;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
        }

        .boton:hover {
            background-color: #555;
        }

        .contenedor-boton {
            text-align: center;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
<h1>Lista de Notas</h1>

<%
// Obtener los productos del controlador (servlet)
List<Notas> lasNotas = (List<Notas>) request.getAttribute("LISTANOTAS");
%>

<table>
    <tr>
        <th style="background-color: #555; color: #fff; border: 1px solid #ddd;">ID NOTA</th>
        <th style="background-color: #555; color: #fff; border: 1px solid #ddd;">ID ALUMNO</th>
        <th style="background-color: #555; color: #fff; border: 1px solid #ddd;">REGISTRO</th>
        <th style="background-color: #555; color: #fff; border: 1px solid #ddd;">NOTA</th>
        <th colspan="2" style="background-color: #555; color: #fff; border: 1px solid #ddd;">ACCIÓN</th>
    </tr>

    <%
    int count = 1;
    for (Notas tempNotas: lasNotas) {
    %>

    <tr>
        <td style="border: 1px solid #ddd;"><%= tempNotas.getIdNota() %></td>
        <td style="border: 1px solid #ddd;"><%= tempNotas.getIdAlumno() %></td>
        <td style="border: 1px solid #ddd;"><%= tempNotas.getRegistro() %></td>
        <td style="border: 1px solid #ddd;"><%= tempNotas.getNota() %></td>
        <td class="accion" style="background-color: #333; border: 1px solid #ddd;"><a href="ControladorNotas?instruccion=cargar&CNota=<%=tempNotas.getIdNota()%>" style="color: #fff;">Modificar</a></td>
        <td class="accion" style="background-color: #333; border: 1px solid #ddd;"><a href="ControladorNotas?instruccion=eliminar&CNota=<%=tempNotas.getIdNota()%>" style="color: #fff;">Eliminar</a></td>
    </tr>

    <%
    count++;
    }
    %>
</table>

<div class="contenedor-boton">
    <input type="button" value="Insertar Nota" onclick="window.location.href='insertaNotas.jsp'" class="boton"/>
</div>
</body>
</html>
