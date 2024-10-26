<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insertar Registros</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }

        h1 {
            text-align: center;
            color: #333;
        }

        form {
            width: 50%;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }

        table {
            width: 100%;
            margin-bottom: 20px;
        }

        td {
            padding: 10px;
        }

        input[type="text"] {
            width: 100%;
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type="submit"],
        input[type="reset"] {
            background-color: #333;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
        }

        input[type="submit"]:hover,
        input[type="reset"]:hover {
            background-color: #555;
        }
    </style>
</head>
<body>
<h1>Insertar Registros</h1>
<form name="form1" method="get" action="ControladorNotas">
    <input type="hidden" name="instruccion" value="insertarBBDD">
    <table>
        <tr>
            <td width="27%">Código Nota</td>
            <td width="73%"><input type="text" name="idNota" id="idNota"></td>
        </tr>

        <tr>
            <td width="27%">Alumno</td>
            <td width="73%"><input type="text" name="idAlumno" id="idAlumno"></td>
        </tr>

        <tr>
            <td width="27%">Registro</td>
            <td width="73%"><input type="text" name="registro" id="registro"></td>
        </tr>

        <tr>
            <td width="27%">Nota</td>
            <td width="73%"><input type="text" name="nota" id="nota"></td>
        </tr>

        <tr>
            <td><input type="submit" name="envio" id="envio" value="Enviar"></td>
            <td><input type="reset" name="borrar" id="borrar" value="Restablecer"></td>
        </tr>
    </table>
</form>
</body>
</html>
