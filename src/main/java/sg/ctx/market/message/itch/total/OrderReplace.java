package sg.ctx.market.message.itch.total;

import sg.ctx.market.message.itch.ItchMessage;

public class OrderReplace extends ItchMessage {
    private Long originalOrderNumber;
    private Long newOrderNumber;
    private Long quantity;
    private Long price;

    public Long getOriginalOrderNumber() {
        return originalOrderNumber;
    }

    public void setOriginalOrderNumber(Long originalOrderNumber) {
        this.originalOrderNumber = originalOrderNumber;
    }

    public Long getNewOrderNumber() {
        return newOrderNumber;
    }

    public void setNewOrderNumber(Long newOrderNumber) {
        this.newOrderNumber = newOrderNumber;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
