package sg.ctx.market.message.itch.total;

import sg.ctx.market.message.itch.ItchMessage;

public class OrderExecuted extends ItchMessage {
    private long orderNumber;
    private long executedQuantity;
    private long matchNumber;
    private char printable;

    public long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public long getExecutedQuantity() {
        return executedQuantity;
    }

    public void setExecutedQuantity(long executedQuantity) {
        this.executedQuantity = executedQuantity;
    }

    public long getMatchNumber() {
        return matchNumber;
    }

    public void setMatchNumber(long matchNumber) {
        this.matchNumber = matchNumber;
    }

    public char getPrintable() {
        return printable;
    }

    public void setPrintable(char printable) {
        this.printable = printable;
    }
}
