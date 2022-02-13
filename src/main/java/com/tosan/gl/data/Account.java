package com.tosan.gl.data;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
//@Table(name = "differentName")
public class Account {

    @Id
//    @Column(name = "")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String title;
    @ManyToOne // branch_id
//    @JoinColumn(name =)
    private Branch branch;
//    @ManyToOne // currency_id
//    private Currency currency;
//    @ManyToOne // glentry_id
//    private GlEntry glEntry;
    private Date openingDate;
    private Date closingDate;
    private BigDecimal balance;
    private AccountStatus status;
}
