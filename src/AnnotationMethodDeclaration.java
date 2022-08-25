import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Properties;
import java.util.stream.Collectors;

public class AnnotationMethodDeclaration {

	public String convertJson(Object object) throws IllegalArgumentException, IllegalAccessException, IOException
	{
		//Finding Class of object
		Class<?> class1=object.getClass();
		//converting into Key value Pairs 
		HashMap<String,String> mapObject=new HashMap<>();
		
		for(Field field :class1.getDeclaredFields())
		{
			if(field.isAnnotationPresent(ChangeId.class))
			{
				field.setAccessible(true);
				mapObject.put(getValue(field),  field.get(object).toString());	
			}
			else
			{
				field.setAccessible(true);
				mapObject.put(field.getName(), field.get(object).toString());
			}
		}
		String jsonString = mapObject.entrySet().stream().map(entry -> "\n\t" + "\"" + entry.getKey() + "\":\"" + entry.getValue() + "\"").collect(Collectors.joining(","));
		FileWriter writer=new FileWriter("C:\\programs\\CUSTOM_ANNOTATIOND_DEMO\\src\\Properties.properties",true);
		writer.write("{" + jsonString + "}\n");
		writer.close();
		return jsonString;
      

	}
	//Annotation value getting Method
	 private String getValue(Field field){
	        return field.getAnnotation(ChangeId.class).value();
	 }
	 
	 //FileReader using
	 public static Object jsonObjectToObject(Object object) throws IOException, IllegalArgumentException, IllegalAccessException,NullPointerException
	 {
		 Class<?> class2 = object.getClass();
		 FileReader reader=new FileReader("C:\\programs\\CUSTOM_ANNOTATIOND_DEMO\\src\\Properties.properties");
		 Properties property=new Properties();
		 property.load(reader);
		 reader.close();
		  for(Field field : class2.getDeclaredFields())
		  {
	            field.setAccessible(true);
	            Class<?> type = field.getType();
	            String value;
	               if(field.isAnnotationPresent(ChangeId.class))
	               {
	                 value = field.getAnnotation(ChangeId.class).value();
	               }
	              else
	               {
	                value = field.getName();
	                }
	            if(type.equals(int.class))
	            {
	                int temp = Integer.parseInt(property.getProperty(value));
	                field.set(object,temp);
	            }
	            else if(type.equals(String.class))
	            {
	                String temp = property.getProperty(value);
	                field.set(object,temp);
	            }
	        }
			 
		 


		 return object;
		 
		 
	 }
}
