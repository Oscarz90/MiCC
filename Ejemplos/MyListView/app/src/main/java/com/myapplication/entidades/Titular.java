package com.myapplication.entidades;

/**
 * Created by 430004587 on 25/08/2015.
 */
public class Titular {
  private String Titulo;
  private String Subtitulo;

  public Titular(String titulo, String subtitulo){
    this.Titulo=titulo;
    this.Subtitulo=subtitulo;
  }

  public String getTitulo(){
    return Titulo;
  }

  public String getSubtitulo(){
    return Subtitulo;
  }
}
