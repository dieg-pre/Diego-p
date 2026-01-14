package edu.diego.preciado.act1.ui;

import edu.diego.preciado.act1.proces.Switch;

public class CLI{
    public static void start(){
        Switch switch_wifi=new Switch();
        System.out.println("bienvenido al programa");
        System.out.println("el switch esta"+switch_wifi.isOn());
        if(switch_wifi.isOn()){
            System.out.println("desea apagar el switch");
        }
        else{
            System.out.println("desea prender el switch");
        }
        System.out.println("el switch esta"+switch_wifi.isOn());
    }

}
