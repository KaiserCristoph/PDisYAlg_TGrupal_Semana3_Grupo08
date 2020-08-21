import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

public class DatabaseManager {
	
	private static Connection databaseConnection;
	
	private static String Connection_String = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String usuario = "system";
	private static String contraseña = "12345";
	
	
	static{
			//se agrego 
			databaseConnection = null;
			
		try {
			
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				System.out.println("Esta el driver para conectar Oracle, La libreira esta referenciada");
				
				try {//se agrega instanciar el objeto conectio
					
					//Locale.setDefault(new Locale("es","ES"));
					databaseConnection = DriverManager.getConnection(Connection_String, usuario, contraseña);
					//se agrega impresion de mensaje conexion realizada
					System.out.println("Conexion creada con exito");
			
				} catch (SQLException e) {
					System.out.println("Error al conectarse a la Base de datos");
					//se elimino el System.out.println, no corresponde
					e.printStackTrace();
				}
				//se agrega excepcion donde no el msj imprime que no se tiene los driver para realizar la conexion
		}catch (ClassNotFoundException e) {
		
		System.out.println("Tu build-path no cuneta con el driver?");
		e.printStackTrace();
	}
		
	}//se agrega corchete
	
	public static Connection getConnection(){
		return databaseConnection;
	}

}
