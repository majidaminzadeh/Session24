package com.tosan.gl.data;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class VoucherEntry {
    private Voucher voucher;
    private Account account;
    private BigDecimal currencyRate;
    private BigDecimal amount;
}
