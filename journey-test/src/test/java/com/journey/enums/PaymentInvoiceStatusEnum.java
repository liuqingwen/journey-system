package com.journey.enums;

public enum PaymentInvoiceStatusEnum implements IPaymentInvoiceStatus{

    //    开票状态(0 未开票、1 已开票、2 已驳回、3 已确认和 4 已作废)
    UN_MAKE_OUT(0, "未开票") {
        @Override
        public String operate() {
            return "<a href=''>开票</a>";
        }
    }, MAKE_OUT(1, "已开票") {
        @Override
        public String operate() {
            return "<a href=''>作废</a>";
        }
    }, REJECTED(2, "已驳回") {
        @Override
        public String operate() {
            return UN_MAKE_OUT.operate();
        }
    }, CONFIRMED(3, "已确认") {
        @Override
        public String operate() {
            return null;
        }
    },
    CANCELLATION(4, "已作废") {
        @Override
        public String operate() {
            return null;
        }
    }
    ;

    public int code;
    private String description;

    PaymentInvoiceStatusEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public byte getByteCode() {
        return (byte) code;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "PaymentInvoiceStatusEnum{" +
                "code=" + code +
                ", description='" + description + '\'' +
                "} " + super.toString();
    }

    @Override
    public String combinationOperate() {
        return append(baseOperate());
    }

    @Override
    public String baseOperate() {
        return "<a href=''>查看</a>";
    }
}