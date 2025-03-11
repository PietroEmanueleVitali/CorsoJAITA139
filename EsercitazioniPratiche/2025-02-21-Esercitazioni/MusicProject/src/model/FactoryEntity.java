package model;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;

public abstract class FactoryEntity implements IFactory<Entity, String>{

    public static <T extends Entity> T make(Class<Entity> type, String... params)
    {
        String className = type.getName();
        T newInstance = null;
        try {
            Class<?> entity = Class.forName(className);
            if (params.length == 0) {
                    newInstance = (T) entity.getDeclaredConstructor().newInstance();
            }
            else if(params.length > 0)
            {
                Constructor<T> constructor = FactoryEntity.getConstructor(entity, className);
                Parameter[] parameters = constructor.getParameters();

                Object[] elementList = new Object[params.length];

                    for(int i = 0; i < params.length; i++)
                    {
                        Class<?> paramType = parameters[i].getType();
                        elementList[i] = convertStringToType(params[i], paramType);
                    }

                    newInstance = (T) constructor.newInstance();
            }
            
        } catch (Exception e) {
            System.err.println("Class not found in FactoryEntity");
        }
        return newInstance;
    }

    public static <T extends Entity> Constructor<T> getConstructor(Class<?> entity, String className, String... params)
    {
        Constructor[] constructors = entity.getDeclaredConstructors();
        Constructor<T> theConstructor = null;

        for(var constructor : constructors)
        {
            if(constructor.getParameterCount() == params.length)
            {
                Parameter[] parameters = constructor.getParameters();
                boolean isMatch = true;
                
                for(int i = 0; i < params.length; i++ )
                {
                    Class<?> type = parameters[i].getType();
                    if (!canAssignStringTo(type)) {
                        isMatch = false;
                        break;
                    }
                }
                if(isMatch)
                    theConstructor = (Constructor<T>)constructor;
            }            

        }
        return theConstructor;
    }

    private static boolean canAssignStringTo(Class<?> type) {
        
        if (type == String.class) {
            return true;
        }
        
        
        if (type == int.class || type == Integer.class ||
            type == long.class || type == Long.class ||
            type == double.class || type == Double.class ||
            type == float.class || type == Float.class ||
            type == boolean.class || type == Boolean.class ||
            type == char.class || type == Character.class ||
            type == byte.class || type == Byte.class ||
            type == short.class || type == Short.class) {
            return true;
        }
        
        
        
        return false; 
    }

    private static Object convertStringToType(String value, Class<?> targetType) {
        if (targetType == String.class) {
            return value;
        } else if (targetType == int.class || targetType == Integer.class) {
            return Integer.parseInt(value);
        } else if (targetType == long.class || targetType == Long.class) {
            return Long.parseLong(value);
        } else if (targetType == double.class || targetType == Double.class) {
            return Double.parseDouble(value);
        } else if (targetType == boolean.class || targetType == Boolean.class) {
            return Boolean.parseBoolean(value);
        }
        throw new IllegalArgumentException("Cannot convert String to " + targetType.getName());
    }

}
