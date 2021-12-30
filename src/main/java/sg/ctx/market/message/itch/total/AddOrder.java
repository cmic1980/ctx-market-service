package sg.ctx.market.message.itch.total;

import sg.ctx.market.message.itch.ItchMessage;

public class AddOrder extends ItchMessage {
    private Long orderNumber;
    private Character orderVerb;
    private Long quantity;
    private Integer orderBook;
    private Long price;

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Character getOrderVerb() {
        return orderVerb;
    }

    public void setOrderVerb(Character orderVerb) {
        this.orderVerb = orderVerb;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Integer getOrderBook() {
        return orderBook;
    }

    public void setOrderBook(Integer orderBook) {
        this.orderBook = orderBook;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
