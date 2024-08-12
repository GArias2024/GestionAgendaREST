package com.contact.manag.agenda.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TABLE_CONTACTOS")
public class Contacto {

    @Id
    private int cod_id;
    private String val_nombre;
    private String val_apellidos;
    private String val_email;

    public int getCod_id() {
        return cod_id;
    }

    public void setCod_id(int cod_id) {
        this.cod_id = cod_id;
    }

    public String getVal_nombre() {
        return val_nombre;
    }

    public void setVal_nombre(String val_nombre) {
        this.val_nombre = val_nombre;
    }

    public String getVal_apellidos() {
        return val_apellidos;
    }

    public void setVal_apellidos(String val_apellidos) {
        this.val_apellidos = val_apellidos;
    }

    public String getVal_email() {
        return val_email;
    }

    public void setVal_email(String val_email) {
        this.val_email = val_email;
    }

}
