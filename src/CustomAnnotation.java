import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class CustomAnnotation {
	private int empId;
	private int empName;
	private int empSalary;

	public static void main(String[] args) throws IOException {
		FileReader fr=new FileReader("C:\\programs\\CUSTOM_ANNOTATIOND_DEMO\\src\\Properties.properties");
		Properties prop=new Properties();
		prop.load(fr);
		
		System.out.println(prop.getProperty("empId"));
		System.out.println(prop.getProperty("empName"));
		System.out.println(prop.getProperty("empSalary"));

	}

}
