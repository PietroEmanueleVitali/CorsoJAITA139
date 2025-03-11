package utils;

import errorhandler.IErrorHandling;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public interface IMappable {

    default void mapper(Map<String, String> map)
    {
        try {
            Field[] fields = this.getClass().getDeclaredFields();
            
            for(var field : fields)
            {
                field.setAccessible(true);

                for (var key : map.keySet()) {

                    if(key.equalsIgnoreCase(field.getName()))
                    {
                        String setMethodName = "set" + key.substring(0, 1).toUpperCase() + key.substring(1);
                        Method setMethod = this.getClass().getMethod(setMethodName, field.getType());
                        
                        //Meglio mettere questi controlli in un metodo a parte
                        if(field.getType().getSimpleName().equalsIgnoreCase("int"))
                            setMethod.invoke(this, Integer.parseInt(map.get(key)));
                        else if(field.getType().getSimpleName().equalsIgnoreCase("string"))
                            setMethod.invoke(this, map.get(key));
                    }
                }
            }
            
        } catch (IndexOutOfBoundsException | SecurityException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            IErrorHandling.errorMessage();
        } catch (Exception e) {
            IErrorHandling.errorMessage();
            System.out.println(e.getMessage());
        }
    }
}
