package edu.diego.preciado.act1.ui;

import edu.diego.preciado.act1.proces.Switch;{

public class CLI{
    public static void start(){
            Switch switch_wifi=new Switch();
            System.out.println("Bienvenido al programa");
            System.out.println("El switch est"+switch_wifi.isOn();
            if(switch_wifi.isOn()){
                System.out.println("dese apagar el switch");
            }
            else{
                System.out.println("desea prender el switch");
            }
            System.out.println("el swotch esta"+switch_wifi.isOn ();}
    }

}
