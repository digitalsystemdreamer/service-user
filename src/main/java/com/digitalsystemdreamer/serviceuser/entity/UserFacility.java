package com.digitalsystemdreamer.serviceuser.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.envers.Audited;

@Entity
@Audited
@Data
@Table(name = "User_Facility",  schema = "Users")
public class UserFacility {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_USER_FACILITY")
    private Integer idUserFacility;

    @Column(name = "ID_FACILITY")
    private Integer idFacility;

    @ManyToOne
    @JoinColumn(name="ID_USER")
    private User user;



}
