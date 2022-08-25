import java.io.IOException;
import java.io.*;

public class MainMethod {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, IOException, NullPointerException, NoSuchFieldException {
		// TODO Auto-generated method stub
		Employee employee=new Employee(1387,"Nagaraju",25000,"Trainee");
		AnnotationMethodDeclaration annotate=new AnnotationMethodDeclaration();
		//String jsonString=annotate.convertJson(employee);
		//System.out.println(jsonString);
		Employee employee1=(Employee) AnnotationMethodDeclaration.jsonObjectToObject(new Employee());
		System.out.println(employee1.toString());
		
		

	}

}
