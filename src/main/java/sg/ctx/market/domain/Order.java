package sg.ctx.market.domain;

public class Order {
    private Long number;
    private Integer orderBookIndex;
    private Long price;
    private Long quantity;
    private Character orderVerb;

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Integer getOrderBookIndex() {
        return orderBookIndex;
    }

    public void setOrderBookIndex(Integer orderBookIndex) {
        this.orderBookIndex = orderBookIndex;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Character getOrderVerb() {
        return orderVerb;
    }

    public void setOrderVerb(Character orderVerb) {
        this.orderVerb = orderVerb;
    }
}
