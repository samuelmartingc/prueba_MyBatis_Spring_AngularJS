package sam.pruebaautentia.model;


public class Curso {

	private int idcurso;
	private String titulo;
	private int numhoras;
	private String nivel;
        private boolean activo;
        private int idprofesor;
        private int idtemario;
	
	
	public Curso(int idcurso, String titulo, int numhoras, String nivel, boolean activo, int idprofesor, int idtemario) {
		super();
		this.idcurso = idcurso;
		this.titulo = titulo;
		this.numhoras = numhoras;
		this.nivel = nivel;
                this.activo = activo;
                this.idprofesor = idprofesor;
                this.idtemario = idtemario;
	}
	
	public Curso() {}

    public int getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(int idcurso) {
        this.idcurso = idcurso;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getNumhoras() {
        return numhoras;
    }

    public void setNumhoras(int numhoras) {
        this.numhoras = numhoras;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getIdprofesor() {
        return idprofesor;
    }

    public void setIdprofesor(int idprofesor) {
        this.idprofesor = idprofesor;
    }

    public int getIdtemario() {
        return idtemario;
    }

    public void setIdtemario(int idtemario) {
        this.idtemario = idtemario;
    }

	
}
