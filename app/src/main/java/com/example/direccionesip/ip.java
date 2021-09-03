package com.example.direccionesip;

public class ip{
    String[] octet;
    int oct1, oct2, oct3, oct4;

    private String strmsg1;
    private String errorp;
    private String sub;
    private String strmsg2;
    private String bit="";
    private int prefijo=0;
    private double r=0;
    /**
     *getter
     *@return string Devuelve un string
     **/

    public String getStrmsg1() {
        return strmsg1;
    }
    public int getPrefijo() {
        return prefijo;
    }
    /**
     *getter
     *@param  prefijo recibe el prefijo de la red
     **/

    public void setPrefijo(int prefijo) {
        this.prefijo = prefijo;
    }


    public void recibedatos(String rip){
        octet=rip.split("\\.");

        oct1=Integer.parseInt(octet[0]);
        oct2=Integer.parseInt(octet[1]);
        oct3=Integer.parseInt(octet[2]);
        oct4=Integer.parseInt(octet[3]);
    }
    public void validarip()
    {
        if (octet.length==4)
        {
            if((oct1>0 && oct1<256) && (oct2>0 && oct2<256) && (oct3>0 && oct3<256) && (oct4>0 && oct4<256))
            {
                strmsg1="Direccion valida";
            }
            else
            {
                strmsg1="Direccion invalida";
            }
        }
        else
        {
            strmsg1="Direccion incorrecta";
        }

    }

    public String clasedered()
    {

        if(oct1>0 && oct1<128 && octet.length==4)
        {
            strmsg2="Es de clase A";
        }
        else if(oct1>=129 && oct1<192 && octet.length==4)
        {
            strmsg2="Es de clase B";
        }
        else if (oct1 >= 192 && oct1 <= 223 && octet.length==4)
        {
            strmsg2="Es de clase C";
        }
        else if (oct1 >= 224 && oct1 <= 239 && octet.length==4)
        {
            strmsg2="Es de clase D";
        }
        else if (oct1 >= 240 && oct1 < 256 && octet.length==4)
        {
            strmsg2="Es de clase E";
        }
        return strmsg2;
    }


    public String calc (){

        for (int i=1;i<=32;i++){

            if (i <= prefijo) {
                bit += "1";
            } else {
                bit += "0";
            }
            if (i==8||i==16||i==24) {
                bit+= ".";
            }

        }
        return bit;
    }
    public double numSubRedes() {
        r= Math.pow(2, prefijo) - 2;
        return r;
    }

    public double numHost() {
        r= Math.pow(2, prefijo) - 2;
        return r;
    }
    public String validap(){
        if(prefijo >8&& prefijo <33){
            errorp="Prefijo valido";
        }
        else errorp="Prefijo no valido";
        return errorp;
    }
    public String subnet(){
        if(!(prefijo ==8|| prefijo ==16|| prefijo ==24)){
            sub="La red esta subneteada";
        }else sub="La red no esta subneteada";
        return sub;
    }

}



