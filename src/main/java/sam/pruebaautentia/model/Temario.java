package sam.pruebaautentia.model;

import com.mysql.jdbc.Blob;


public class Temario {

	private int idtemario;
	private String nombre;
	private Blob archivo;

	
	
	public Temario(int idtemario, String nombre, Blob archivo) {
		super();
		this.idtemario = idtemario;
		this.nombre = nombre;
		this.archivo = archivo;
	}
	
	public Temario() {}

        public int getIdtemario() {
            return idtemario;
        }

        public void setIdtemario(int idtemario) {
            this.idtemario = idtemario;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public Blob getArchivo() {
            return archivo;
        }

        public void setArchivo(Blob archivo) {
            this.archivo = archivo;
        }

}
