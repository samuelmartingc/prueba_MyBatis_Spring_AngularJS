package sam.pruebaautentia.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import sam.pruebaautentia.dao.CursoDAO;
import sam.pruebaautentia.dao.ProfesorDAO;
import sam.pruebaautentia.dao.TemarioDAO;
import sam.pruebaautentia.model.Curso;
import sam.pruebaautentia.model.Profesor;
import sam.pruebaautentia.model.Temario;

@Controller
public class CursosController {
    private int TAMPAGINA = 5;
    @Autowired
     CursoDAO cursoDAO;
    
    @Autowired
    ProfesorDAO profesorDAO;
    
    @Autowired
    TemarioDAO temarioDAO;
    
	@RequestMapping(value="/")
	public ModelAndView mainPage() {
		return new ModelAndView("home");
	}
        
        @RequestMapping(value="/index")
	public ModelAndView indexPage() {
		return new ModelAndView("home");
	}
        
        
        
        @RequestMapping("/download/{temarioId}")
    public String download(@PathVariable("temarioId")
            Integer temarioId, HttpServletResponse response) {
         
        Temario tem = temarioDAO.selectById(temarioId);
        try {
            response.setHeader("Content-Disposition", "inline;filename=\"" +tem.getNombre()+ "\"");
            OutputStream out = response.getOutputStream();
            //response.setContentType(tem.getContentType());
            response.setContentType("pdf");
            IOUtils.copy(tem.getArchivo().getBinaryStream(), out);
            out.flush();
            out.close();
         
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
         
         
        return null;
    }
        
        
        
        
        
        
        
        
        
        @RequestMapping("/catalogo.json")
        public @ResponseBody List<List<Curso>> getCatalogoList() {
            
            
            
            
            List<Curso> lista = cursoDAO.selectAllActivos(); // no coje los que no estan activos
            List<List<Curso>> listaDeListas = new ArrayList();
            int contadorLista = 0;
            List<Curso> aux = new ArrayList();
            for (Curso c:lista){
                if (contadorLista == 0){
                    aux = new ArrayList();
                }
                if (contadorLista < TAMPAGINA){
                    aux.add(c);
                    if (contadorLista < (TAMPAGINA-1)){
                        contadorLista++;
                    }
                    else{
                        contadorLista = 0;
                        listaDeListas.add(aux);
                    }
                }
            }
            if (!aux.isEmpty()){
                listaDeListas.add(aux);
            }
            return listaDeListas;
        }
        
        @RequestMapping("/profesores.json")
        public @ResponseBody List<Profesor> getProfesorList() {		
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
        public @ResponseBody void addcurso(@RequestBody Curso cursonuevo) {     
            cursonuevo = buscarIdVacio(cursonuevo);
            cursoDAO.insert(cursonuevo);
        }
        

        
        
        public Curso buscarIdVacio(Curso cursonuevo){
            List<Curso> listaCursos;
            listaCursos = cursoDAO.selectAll();
            int id = 1; // primer id
            for (Curso cur:listaCursos){
                if (cur.getIdcurso() == id){
                    id++;
                }
                else{ // hay un hueco entre los id
                    cursonuevo.setIdcurso(id);
                    return cursonuevo;
                }
            }
            // no hay huecos, se inserta al final
            cursonuevo.setIdcurso(id);
            return cursonuevo;
        }
       
}
