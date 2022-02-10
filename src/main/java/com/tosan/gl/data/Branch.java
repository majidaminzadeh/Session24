package com.tosan.gl.data;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class Branch {
    @Id
    private Long id;
    private String code;
    private String title;
}
