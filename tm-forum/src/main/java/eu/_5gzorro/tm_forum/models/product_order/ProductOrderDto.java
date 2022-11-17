package eu._5gzorro.tm_forum.models.product_order;

import java.util.Date;

public class ProductOrderDto {

    private final String seller;
    private final String orderDid;
    private final Date endDate;

    public ProductOrderDto(String seller, String orderDid, Date endDate) {
        this.seller = seller;
        this.orderDid = orderDid;
        this.endDate = endDate;
    }

    public String getSeller() {
        return seller;
    }

    public String getOrderDid() {
        return orderDid;
    }

    public Date getEndDate() {
        return endDate;
    }

}
