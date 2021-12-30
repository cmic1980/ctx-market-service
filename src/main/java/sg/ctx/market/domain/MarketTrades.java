package sg.ctx.market.domain;

import java.util.Date;
import java.util.List;

public class MarketTrades {
    private String symbol;
    private Date ts;
    private List<Trade> list;

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }

    public List<Trade> getList() {
        return list;
    }

    public void setList(List<Trade> list) {
        this.list = list;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
