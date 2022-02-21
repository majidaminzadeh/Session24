package com.tosan.gl.data;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
//@Table(name = "differentName")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Account implements Serializable {

    @Id
//    @Column(name = "")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private Long id;
    @XmlElement
    private String code;
    @XmlElement
    private String title;
    @ManyToOne // branch_id
//    @JoinColumn(name =)
    @XmlElement
    private Branch branch;
//    @ManyToOne // currency_id
//    private Currency currency;
//    @ManyToOne // glentry_id
//    private GlEntry glEntry;

    @XmlElement
    private Date openingDate;

    @XmlTransient
    private Date closingDate;

    @XmlElement
    private BigDecimal balance;

    @XmlElement
    private AccountStatus status;
}
