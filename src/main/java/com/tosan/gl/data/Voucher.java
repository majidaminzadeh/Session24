package com.tosan.gl.data;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class Voucher {
    private Long voucherNumber;
    private Branch branch;
    private List<VoucherEntry> voucherEntries;
    private Date issueDate;
    private Date applyDate;
}
