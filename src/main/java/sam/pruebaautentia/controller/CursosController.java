package sam.pruebaautentia.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import sam.pruebaautentia.dao.CursoDAO;
import sam.pruebaautentia.dao.ProfesorDAO;
import sam.pruebaautentia.model.Curso;
import sam.pruebaautentia.model.Profesor;

@Controller
public class CursosController {

    private int TAMPAGINA = 5;
    @Autowired
    CursoDAO cursoDAO;

    @Autowired
    ProfesorDAO profesorDAO;

    @RequestMapping(value = "/")
    public ModelAndView mainPage() {
        return new ModelAndView("home");
    }

    @RequestMapping(value = "/index")
    public ModelAndView indexPage() {
        return new ModelAndView("home");
    }

    @RequestMapping("/catalogo.json")
    public @ResponseBody
    List<List<Curso>> getCatalogoList() {

        List<Curso> lista = cursoDAO.selectAllActivos(); // no coje los que no estan activos
        List<List<Curso>> listaDeListas = new ArrayList();
        int contadorLista = 0;
        List<Curso> aux = new ArrayList();
        for (Curso c : lista) {
            if (contadorLista == 0) {
                aux = new ArrayList();
            }
            if (contadorLista < TAMPAGINA) {
                aux.add(c);
                if (contadorLista < (TAMPAGINA - 1)) {
                    contadorLista++;
                } else {
                    contadorLista = 0;
                    listaDeListas.add(aux);
                }
            }
        }
        if (!aux.isEmpty()) {
            listaDeListas.add(aux);
        }
        return listaDeListas;
    }

    @RequestMapping("/profesores.json")
    public @ResponseBody
    List<Profesor> getProfesorList() {
        return profesorDAO.selectAll();
    }

    @RequestMapping("/catalogo")
    public String getCatalogoPartialPage() {
        return "catalogo";
    }

    @RequestMapping("/nuevoCurso")
    public String nuevoCurso() {
        return "nuevoCurso";
    }

    @RequestMapping(value = "/addcurso", method = RequestMethod.POST)
    public @ResponseBody
    void addcurso(@RequestBody Curso cursonuevo) {
        cursonuevo = buscarIdVacio(cursonuevo);
        cursoDAO.insert(cursonuevo);
    }

    public Curso buscarIdVacio(Curso cursonuevo) {
        List<Curso> listaCursos;
        listaCursos = cursoDAO.selectAll();
        int id = 1; // primer id
        for (Curso cur : listaCursos) {
            if (cur.getIdcurso() == id) {
                id++;
            } else { // hay un hueco entre los id
                cursonuevo.setIdcurso(id);
                return cursonuevo;
            }
        }
        // no hay huecos, se inserta al final
        cursonuevo.setIdcurso(id);
        return cursonuevo;
    }

}
