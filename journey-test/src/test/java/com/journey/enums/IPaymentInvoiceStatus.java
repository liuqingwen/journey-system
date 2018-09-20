package com.journey.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * 货款开票状态
 * @author liuqingwen
 * @date 2018/9/20.
 */
public interface IPaymentInvoiceStatus {

    String combinationOperate();

    String operate();

    String baseOperate();

    default String append(String operate) {

        return StringUtils.isBlank(this.operate()) ? operate : new StringBuilder(1 << 5).append(this.operate()).append(" | ")
                .append(operate).toString();
    }

}
