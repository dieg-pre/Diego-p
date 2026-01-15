package edu.diego.preciado.act1.ui;

import edu.diego.preciado.act1.proces.Switch;

public class CLI{
    public static void start(){
        Switch switch_wifi=new Switch();
        System.out.println("bienvenido al programa");
        System.out.println("el switch esta"+switch_wifi.isOn());
        String respuesta;
        if(switch_wifi.isOn()) {
            System.out.println("desea apagar el switch: s/n");
            respuesta = scanner.nextLine();
            if (respuesta.equals("n")) switch_wifi.prenderSwitch();
        }else  {
            System.out.println("desea prender el switch");
            respuesta = scanner.nextLine();
            if(respuesta.equals("s")) switch_wifi.prenderSwitch();
        }
        System.out.println("el switch esta"+switch_wifi.isOn());
    }

}
