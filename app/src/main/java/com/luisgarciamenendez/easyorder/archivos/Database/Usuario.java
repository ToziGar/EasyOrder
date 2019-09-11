package com.luisgarciamenendez.easyorder.archivos.Database;


    public class Usuario  {

    private static String email;
    private String contrasena;
    private static String tipo;

    public Usuario() {

    }

    public Usuario(String email, String contrasena,String tipo) {
        this.email = email;
        this.contrasena = contrasena;
        this.tipo = tipo;
    }

    public static String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

        public static String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }
    }