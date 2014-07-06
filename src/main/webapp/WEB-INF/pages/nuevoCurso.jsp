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
        <link rel="stylesheet" href=<c:url value="css/nuevoCurso.css" /> >


        <title>Nuevo curso</title>
    </head>
    <body>
  
<div ng-controller="CursoController">
    
    <div class="container" id="contenedor">
          
        <form>
        
                <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
                    
                        <h2>Nuevo Curso <small>Creación de un nuevo curso</small></h2>
                        <hr class="colorgraph">
                        
                        <div class="row">
                            <h2>
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    Activo
                                </div>
                            </div>
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <input type="checkbox" ng-model="cursonuevo.activo" tabindex="2">
                                </div>
                            </div>
                                </h2>
                        </div>
                        
                        <div class="row">
                            <h2>
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    Profesor
                                </div>
                            </div>
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    
                                    <select class="form-control" name="profesor" ng-model="cursonuevo.idprofesor">
                                        <option ng-repeat="profe in profesores" value="{{profe.idprofesor}}">{{profe.nombreprofesor}}</option> 
                                   </select>
                                    
                                </div>
                            </div>
                                </h2>
                        </div>
                        
                        
                        
                        <div class="row">
                            <h2>
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    Título
                                </div>
                            </div>
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <input type="text"  class="form-control input-lg" placeholder="Título" ng-model="cursonuevo.titulo" tabindex="1" >
                                </div>
                            </div>
                                </h2>
                        </div>
                        
                        
                        
                        <div class="row">
                            <h2>
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    Nivel
                                </div>
                            </div>
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    
                                    <select class="form-control" ng-model="cursonuevo.nivel">
                                        <option value="básico" selected="selected">básico</option> 
                                        <option value="intermedio">intermedio</option> 
                                        <option value="avanzado">avanzado</option>
                                      
                                     </select>
                                    
                                </div>
                            </div>
                                </h2>
                        </div>
                        
                        
                        
                        <div class="row">
                            <h2>
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    Horas
                                </div>
                            </div>
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <input  type="number" min="1" max="9999" class="form-control" placeholder="0" required ng-model="cursonuevo.numhoras">
                                </div>
                            </div>
                                </h2>
                        </div>
                        
          
                        
                        <hr class="colorgraph">
                        <div class="row">
                            
                            <div class="col-xs-6 col-md-6">
                                <button type=submit" ng-click="addNewCurso()" class="btn btn-primary btn-block btn-lg">nuevo curso</button>
                            </div>
                            <div class="col-xs-6 col-md-6">
                                <a href=<c:url value="/catalogo" /> class="btn btn-success btn-block btn-lg" tabindex="10" >ver catalogo</a>
                            </div>
                             </div>
                    
                           
                            
                            
                            <p class="correcto mensaje" ng-show="correcto">
                                Curso insertado correctamente
                            </p>
                            <p class="fallo mensaje" ng-show="fallo">
                                Por favor, rellene todos los campos
                            </p>
                            
                            
                </div>
                            
                            </form> 
            </div>
        </div>

</body>
</html>