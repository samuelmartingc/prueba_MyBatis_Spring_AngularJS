<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
            <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
                <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
                <title>Índice</title>

                </head>
                <body style="text-align:center" >
                    <h1 class="page-header">010_Prueba_tecnica_MYBATIS_SPRING_ANGULARJS</h1>
                    <h2 class="lead">Samuel Martín Gómez-Calcerrada</h2>

                    <div class="col-xs-6 col-md-6">
                        <a href=<c:url value="/catalogo" /> class="btn btn-default btn-block btn-lg">Ver Catálogo</a>
                    </div>
                    <div class="col-xs-6 col-md-6">
                        <a href=<c:url value="/nuevoCurso" /> class="btn btn-default btn-block btn-lg">Nuevo curso</a>
                    </div>


                </body>
                </html>