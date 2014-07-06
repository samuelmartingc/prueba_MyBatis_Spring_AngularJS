package sam.pruebaautentia.model;


public class Temario {

	private int idtemario;
	private String nombre;
	private byte[] archivo;

	
	
	public Temario(int idtemario, String nombre, byte[] archivo) {
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

        public byte[] getArchivo() {
            return archivo;
        }

        public void setArchivo(byte[] archivo) {
            this.archivo = archivo;
        }

}
