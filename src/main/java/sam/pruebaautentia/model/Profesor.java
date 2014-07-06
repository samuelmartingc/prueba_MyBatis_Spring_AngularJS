package sam.pruebaautentia.model;


public class Profesor {

	private int idprofesor;
	private String nombreprofesor;

	public Profesor(int idprofesor, String nombreprofesor) {
		super();
		this.idprofesor = idprofesor;
		this.nombreprofesor = nombreprofesor;
	}
	
	public Profesor() {}


    public int getIdprofesor() {
        return idprofesor;
    }

    public void setIdprofesor(int idprofesor) {
        this.idprofesor = idprofesor;
    }

    public String getNombreprofesor() {
        return nombreprofesor;
    }

    public void setNombreprofesor(String nombreprofesor) {
        this.nombreprofesor = nombreprofesor;
    }
	
	
}
