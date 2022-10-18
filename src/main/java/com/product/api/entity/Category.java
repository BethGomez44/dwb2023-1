package com.product.api.entity;
/**
* Clase que modela el ente Categoria definiendo su comportamiento y diversas operaciones de "control"
 *
 * @author Heidi Lizbeth Gómez de la Torre
 */

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category {

    /**
     * Atributos de una categoria
     */
    private int category_id;
    private String category;
    @JsonIgnore
    private int status;

    /**
     * Constructor por omisión de una Categoria
     */
    public Category() {
      this.category_id = 1;
      this.category = "Por defecto";
      this.status = 1;
    }

    /**
     * Constructor por parámetros de una Categoria
     */
    public Category(int id, String cadena) {
      this.category_id = id;
      this.category = cadena;
      this.status = 1;
    }

    public void setCategoryName(String name) {
      this.category = name;
    }

    public void setCategoryID(int id) {
      this.category_id = id;
    }

    public String getCategoryName() {
      return this.category;
    }

    public int getCategoryID() {
      return this.category_id;
    }
    
    public void setCategoryStatus(int st) {
        this.status = st;
      }
    
    @JsonIgnore
    public int getCategoryStatus() {
        return this.status;
    }

    @Override
    public String toString() {
      String cadena = "( " + this.category + ", " + this.category_id + " )";
      return cadena;
    }

    @Override
    public boolean equals(Object o) {
      Category aux = (Category) o;
      if (!this.category.equals(aux.category)) {
        return false;
      }
      if (this.category_id != aux.category_id) {
        return false;
      }
      return true;
    }
  }