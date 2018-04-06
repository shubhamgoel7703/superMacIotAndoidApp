package com.example.shubhamgoel.maciot;

/**
 * Created by shubhamgoel on 09/03/18.
 */

public class Object {

    String desc;

    public String getUnit() {
        return unit;
    }

    String unit;

    public void setValue(String value) {
        this.value = value;
    }

    String value;

    public Object(String desc, String value,String unit) {
        //  this.image = image;
        this.desc = desc;
        this.value = value;
        this.unit=unit;
    }

    public String getdesc() {
        return desc;
    }

    public String getvalue() {
        return value;
    }

}


