package edu.diego.preciado.act_1.process;

public class Auto {
    int auto;
    String carro;
    String prod;
    String hp;
    String color;
    Double precio;
    String Carro;

    public void seleccionar(int opcion) {
        this.auto = opcion;
    }
    public void escoger(String eleccion) {
        this.carro = eleccion;
    }

    public String getTipo(int segmento) {
        auto = segmento;
        switch (auto) {
            case 1: return "SUV";
            case 2: return "Automovil";
            case 3: return "Familiar";
            default: return "Ninguno";
        }
    }

    public String getProducto(String Producto) {
        carro = Producto;

        if(auto==1){
            switch (carro) {
                case "a": return "CR-V";
                case "b": return "HR-V";
                case "c": return "BR-V";
                default: return "Ninguno";
            }
        } else if (auto==2) {
            switch (carro) {
                case "a": return "Accord";
                case "b": return "Civic";
                case "c": return "City";
                default: return "Ninguno";
            }
        } else if (auto==3) {
            switch (carro) {
                case "a": return "Pilot";
                case "b": return "Odissey";
                default: return "Ninguno";
            }
        }
        return Producto;
    }

    public Double getPrecio(String Producto) {

        precio = 0.00;
        prod = Producto;

        if(auto==1) {
            switch (prod) {
                case "a": return 950000.00;
                case "b": return 900000.00;
                case "c": return 854000.00;
            }
        }
        if(auto==2) {
            switch (prod) {
                case "a": return 885000.00;
                case "b": return 850000.00;
                case "c": return 725000.00;
            }
        }
        if(auto==3) {
            switch (prod) {
                case "a": return 1100000.00;
                case "b": return 1150000.00;
            }
        }
        return precio;
    }

    public String getHp(String Producto) {
        // 150, 180, 200, 250, 280
        hp = Producto;

        if(auto==1) {
            switch (hp) {
                case "a": return "150";
                case "b": return "180";
                case "c": return "200";
            }
        }
        if(auto==2) {
            switch (hp) {
                case "a": return "250";
                case "b": return "280";
                case "c": return "150";
            }
        }
        if(auto==3) {
            switch (hp) {
                case "a": return "180";
                case "b": return "200";
            }
        }
        return hp;
    }

    public String getColor(String Producto) {
        // rojo, blanco, negro, azul
        color = Producto;

        if(auto==1) {
            switch (color) {
                case "a": return "rojo, blanco, negro, azul";
                case "b": return "rojo, blanco, negro, azul";
                case "c": return "rojo, blanco, negro, azul";
            }
        }
        if(auto==2) {
            switch (color) {
                case "a": return "rojo, blanco, negro, azul";
                case "b": return "rojo, blanco, negro, azul";
                case "c": return "rojo, blanco, negro, azul";
            }
        }
        if(auto==3) {
            switch (color) {
                case "a": return "rojo, blanco, negro, azul";
                case "b": return "rojo, blanco, negro, azul";
            }
        }
        return color;
    }

    public String getVehiculo(String Vehiculo){
        Carro=Vehiculo.toUpperCase();
        switch (Carro) {
            case "Y": return "Entendido desea generar su factura o comprar otro vehiculo";
            case "N": return "Entendido desea buscar otro vehiculo";
        }
        return Vehiculo;
    }

    public int getOtroVehiculo(int OtroVehiculo){
        int OtroVeh=OtroVehiculo;

        switch (OtroVeh) {
            case 1: return 1;
            case 2: return 2;
        }
        return OtroVeh;
    }

}