package com.vinaorm.utils;

import com.vinaorm.annotations.Column;
import com.vinaorm.annotations.OneToMany;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySQLMapper<T> extends Mapper<T> {

    private ResultSet rs;

    public MySQLMapper(Class<T> clazz, ResultSet rs) {
        super(clazz);
        this.rs = rs;
    }

    @Override
    public ArrayList<T> getEntities() throws NoSuchMethodException, SQLException, IllegalAccessException, InvocationTargetException, InstantiationException {
        ArrayList<T> result = new ArrayList<>();

        while(rs.next()) {
            T temp = clazz.getDeclaredConstructor().newInstance();

            Field[] fields = clazz.getFields();

            for(Field field : fields) {
                if(field.isAnnotationPresent(Column.class)) {
                    Column columnAnnotation = field.getAnnotation(Column.class);
                    String columnName = columnAnnotation.name();

                    switch(columnAnnotation.type()) {
                        case CHARACTER:
                            field.set(temp, rs.getString(columnName));
                            break;
                        case INTEGER:
                            field.set(temp, rs.getInt(columnName));
                            break;
                        case DECIMAL:
                            field.set(temp, rs.getDouble(columnName));
                            break;
                        default:
                            break;
                    }
                }
            }
            result.add(temp);
        }
        return result;

    }
}
