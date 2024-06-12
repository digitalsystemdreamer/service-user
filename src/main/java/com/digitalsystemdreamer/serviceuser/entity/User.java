package com.digitalsystemdreamer.serviceuser.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.envers.Audited;

import java.time.LocalDate;
import java.util.List;

@Entity
@Audited
@Data
@Table(name = "User", schema = "Users")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID_USER")
    private Integer userId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "DOB")
    private LocalDate dob;

    @Column(name = "CONTACT_NO")
    private Integer contactNo;

    @Column(name = "EMERGCY_NO")
    private Integer emrgncyContactNo;

    @Column(name = "EMERGCY_PERS_RELATN")
    private String emrgncyPrsnRelatn;

    @Column(name = "BLOOD_GRP")
    private String bloodGroup;

    @Column(name = "WEIGHT")
    private Long weight;

    @Column(name = "HEIGHT")
    private Long height;

    @Column(name = "EMAIL_ADDR")
    private String emailAdress;

    @Column(name = "BATCH_TIMMING")
    private String batchTiming;


    /*@OneToMany
    private UserQuestionnaire userQuestionnaire;

    @OneToMany
    private UserGoals userGoals;

    @OneToMany
    private Condition userCondition;*/

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<UserFacility> userFacilities;

}
