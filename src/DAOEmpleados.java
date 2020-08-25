import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;


public class DAOEmpleados {
	
	private static final String ALL_EMPLEADOS = "SELECT * FROM EMPLEADO";
	private static final String INSERT_EMPLEADO = "INSERT INTO EMPLEADO (ID_EMPLEADO, CEDULA, NOMBRE, APELLIDO) VALUES (SEQ_ID_EMPLEADO.nextval,?,?,?)";
	private static final String UPDATE_EMPLEADO = "UPDATE EMPLEADO SET  NOMBRE=?, APELLIDO=? WHERE CEDULA =?";
	private static final String DELETE_EMPLEADO = "DELETE FROM EMPLEADO WHERE CEDULA=?";
	private static final String EMPLEADO_CI = "SELECT * FROM EMPLEADO WHERE CEDULA=?";
	
	
	public static boolean insert (Empleado empleado){
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(INSERT_EMPLEADO);
		
			statement.setString(1, empleado.getCedula());
			statement.setString(2, empleado.getNombre());
			statement.setString(3, empleado.getApellido());
		
			
			int retorno = statement.executeUpdate();
			
			return retorno>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public static boolean update (Empleado empleado){
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(UPDATE_EMPLEADO);
			
			statement.setString(1, empleado.getNombre());
			statement.setString(2, empleado.getApellido());
			statement.setString(3, empleado.getCedula());
			int retorno = statement.executeUpdate();
			
			return retorno>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public static boolean delete(Empleado empleado){
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(DELETE_EMPLEADO);
			statement.setString(1, empleado.getCedula());
			
			int retorno = statement.executeUpdate();
			return retorno>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}	
		
	}
	
	public static LinkedList<Empleado> findAll(){
		LinkedList<Empleado> empleados = new LinkedList<>();
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(ALL_EMPLEADOS);
			ResultSet resultado = statement.executeQuery();
			
			while(resultado.next()){
				Empleado empleado = getEmpleadoFromResultSet(resultado);
				empleados.add(empleado);
			}
			
			return empleados;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
			
	}

	public static Empleado find(String ciEmpleado){
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(EMPLEADO_CI);
			statement.setString(1, ciEmpleado);
			
			ResultSet resultado = statement.executeQuery();
			Empleado empleado = null;
			if(resultado.next()){
				empleado= getEmpleadoFromResultSet(resultado);
			}
			return empleado;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	private static Empleado getEmpleadoFromResultSet(ResultSet resultado) throws SQLException {
		
		String nombre = resultado.getString("NOMBRE");
		String apellido = resultado.getString("APELLIDO");
		String  cedula = resultado.getString("CEDULA");
		
		Empleado empleado = new Empleado(cedula,nombre, apellido);
		
		return empleado;
	
	}
	

	
}

