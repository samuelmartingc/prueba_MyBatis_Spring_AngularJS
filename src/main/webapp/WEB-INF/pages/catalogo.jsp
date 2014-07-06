<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html ng-app>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Cuestionario con AngularJS</title>
        <script src=<c:url value="js/angular.min.js" /> ></script>
        <script src=<c:url value="js/CursoController.js" /> ></script>
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

        <title>Catálogo de cursos</title>
    </head>
    <body>
        <div class="row">
                            
            <div class="col-xs-9 col-md-9">
             <h1>Catálogo de cursos  </h1>   
            </div>
        
            <div class="col-xs-3 col-md-3">
                <br>              
                <a href=<c:url value="/nuevoCurso" /> class="btn btn-default btn-block btn-lg"><h4>  <span class="glyphicon glyphicon-plus"></span> Nuevo curso</h4></a>
                            
            </div>
        </div>
                <br>
<div ng-controller="CursoController">
 
     <table   class="table table-striped table-bordered table-hover">
         <tr>
             <th><h3>Título</h3></th>
     <th><h3>Nivel</h3></th>
<th><h3>Horas</h3></th>
         </tr>
         <tbody>
<tr ng-repeat="curso in cursos[paginaActual]">
  <td>{{curso.titulo}}</td>
  <td>{{curso.nivel}}</td> 
  <td>{{curso.numhoras}}</td>
</tr>
</tbody>
</table>
     
     <div class="row">
         <div class="col-md-1  col-xs-1"></div>
  <div class="col-md-3 col-xs-3">
     <button type="button" class="btn btn-default btn-lg"  ng-click="primera()">
        <span class="glyphicon glyphicon-backward"></span> Primera
     </button>
  </div>
  <div class="col-md-3 col-xs-3">
      <button type="button" class="btn btn-default btn-lg" ng-click="anterior()">
        <span class="glyphicon glyphicon-arrow-left"></span> Anterior
      </button>
  </div>
  <div class="col-md-3 col-xs-3">
      <button type="button" class="btn btn-default btn-lg" ng-click="siguiente()">
        <span class="glyphicon glyphicon-arrow-right"></span> Siguiente
      </button>
  </div>
  <div class="col-md-2 col-xs-2">
      <button type="button" class="btn btn-default btn-lg" ng-click="ultima()">
        <span class="glyphicon glyphicon-forward"></span> Última
      </button>
  </div>
</div>
     
     
     

     </div>
</body>
</html>