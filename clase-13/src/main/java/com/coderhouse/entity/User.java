package com.coderhouse.entity;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String id;
    private String nombre;
    private String apellido;
    private String email;
}

