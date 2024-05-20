package org.example.coworkproject.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "workspaces")
public class WorkspaceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_workspace")
    private Long idWorkspace;

    @Column(name = "CITY")
    private Integer city;

    @Column(name = "COUNTRY")
    private Integer country;

    @Column(name = "IS_PUBLIC")
    private Boolean isPublic;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "PRICE")
    private Float price;
}
