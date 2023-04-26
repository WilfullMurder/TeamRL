package com.teamrl.app.components;
//lead auth:JacobFarrow(20007972)
import java.util.Comparator;

//@TODO: compares by ascii values so need to work out how to check between upper/lower case matches???
public class BeanComparator implements Comparator<Object> {
    //auth:JacobFarrow(20007972)
    private String getter;

    /**
     * @param field the desired field to sort by
     */
    public BeanComparator(String field)
    {
        // this.getter = getField
        this.getter = "get" + field.substring(0,1).toUpperCase() + field.substring(1);
    }

    @Override
    public int compare(Object o1, Object o2) {
        try {
            if (o1 != null && o2 != null) {
                //returns the underlying Method object of specified public member method of class objects, for comparison
                o1 = o1.getClass().getMethod(getter, new Class[0]).invoke(o1, new Object[0]);
                o2 = o2.getClass().getMethod(getter, new Class[0]).invoke(o2, new Object[0]);
            }
        }catch(Exception e)
        {
            //can't compare objects for some reason
            throw new RuntimeException("Cannot compare " + o1 + " with " + o2 + " on " + getter, e);
        }
        //nested ternary operator
        //Comparable returns -1,0,1 left <,=,> right
        //we want to sort nulls to the top (not that there should be any nulls) (every -1 to the left)
        //we can just copy/paste and move the negative for reverse order btw
        return (o1 == null) ? -1 : ((o2==null) ? 1 : ((Comparable<Object>)o1).compareTo(o2));
    }
}
