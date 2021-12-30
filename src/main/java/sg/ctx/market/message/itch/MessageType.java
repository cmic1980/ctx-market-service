package sg.ctx.market.message.itch;

public class MessageType {
    public static final byte Timestamp = 'T';
    public static final byte SystemEvent = 'S';
    public static final byte PriceTickSize = 'L';
    public static final byte QuantityTickSize = 'M';
    public static final byte IndicativePriceQuantity = 'I';
    public static final byte OrderBookDirectory = 'R';
    public static final byte AddOrder = 'A';
    public static final byte OrderDelete = 'D';
    public static final byte OrderReplace = 'U';
    public static final byte OrderExecuted = 'E';
    public static final byte OrderExecutedWithPrice = 'C';
    public static final byte News = 'N';
}
