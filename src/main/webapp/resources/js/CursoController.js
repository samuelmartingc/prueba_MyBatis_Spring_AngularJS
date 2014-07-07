

/**
 * CursoController
 * @constructor
 */
var CursoController = function($scope, $http) {
    $scope.paginaActual = 0;
    $scope.correcto = '';
    $scope.fallo = '';
    $scope.cursonuevo.activo = false;

    $scope.fetchCursosList = function() {
        $http.get('catalogo.json').success(function(listaCursos) {
            $scope.cursos = listaCursos;
            $scope.nPag = $scope.cursos.length;
        });
    };


    $scope.siguiente = function() {
        if ($scope.paginaActual < ($scope.nPag - 1)) {
            $scope.paginaActual = $scope.paginaActual + 1;
        }
    };
    $scope.anterior = function() {
        if ($scope.paginaActual > 0) {
            $scope.paginaActual = $scope.paginaActual - 1;
        }
    };

    $scope.ultima = function() {
        $scope.paginaActual = $scope.nPag - 1;
    };

    $scope.primera = function() {
        $scope.paginaActual = 0;
    };

    $scope.fetchProfesoresList = function() {
        $http.get('profesores.json').success(function(listaProfesores) {
            $scope.profesores = listaProfesores;
        });
    };

    $scope.addNewCurso = function() {
        var cursoAuxiliar = {"idcurso": parseInt(1), "titulo": $scope.cursonuevo.titulo, "numhoras": parseInt($scope.cursonuevo.numhoras), "nivel": $scope.cursonuevo.nivel, "activo": $scope.cursonuevo.activo, "idprofesor": parseInt($scope.cursonuevo.idprofesor), "idtemario": parseInt(1)}
        $scope.setError = 'no hace nada';
        $http.post('addcurso', cursoAuxiliar).success(function() {
            $scope.fetchCursosList();
            $scope.cursonuevo.activo = false;
            $scope.cursonuevo.titulo = '';
            $scope.cursonuevo.nivel = '';
            $scope.cursonuevo.numhoras = '';
            $scope.cursonuevo.idprofesor = '';
            $scope.cursonuevo.idtemario = 1;
            $scope.correcto = 'bien';
            $scope.fallo = '';
        }).error(function() {
            $scope.fallo = 'mal';
            $scope.correcto = '';
        });
    };



    $scope.removeCurso = function(curso) {
        $http.delete('removeCurso' + curso).success(function() {
            $scope.fetchCursosList();
        });
    };

    $scope.removeAllCursos = function() {
        $http.delete('removeAllCursos').success(function() {
            $scope.fetchCursosList();
        });

    };

    $scope.fetchCursosList();
    $scope.fetchProfesoresList();
};