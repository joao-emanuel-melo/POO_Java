package com.example.demo.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity //Sobe automaticamente a tabela para o BD(Create Table)
@NoArgsConstructor //Cria construtor sem argumento
@AllArgsConstructor //Cria os construtores com argumentos
@Getter
@Setter
public class UserModel {
    long id;
    String username;
    String password;
    int age;
}
