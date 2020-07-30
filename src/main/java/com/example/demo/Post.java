package com.example.demo;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name = "posts")
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public
class Post {

    @Id
    private String id;
    @Column
    private String title;
    @Column
    private String content;
}