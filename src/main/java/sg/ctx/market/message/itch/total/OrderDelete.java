package sg.ctx.market.message.itch.total;

import sg.ctx.market.message.itch.ItchMessage;

public class OrderDelete extends ItchMessage {
    private Long orderNumber;

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }
}
