package com.tosan.gl.data;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Branch {
    @Id
    private Long id;
    private String code;
    private String title;
    @OneToMany(mappedBy = "branch")
    private List<Account> accounts;
}
