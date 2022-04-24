/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gudang.utils;

/**
 *
 * @author Farhan Fadila
 */
public class Utils {
    static String objectToString(Object[] objects) { 
        String query = "(";
        for(int i = 0; i < objects.length; i++) {
            Object o = objects[i];
            boolean isLast = i == objects.length - 1;
            if(isLast) {
                query+= "'" + o + "')";
            } else {
                query+= "'" + o + "',";
            }
        }
        return query;
    }
}
