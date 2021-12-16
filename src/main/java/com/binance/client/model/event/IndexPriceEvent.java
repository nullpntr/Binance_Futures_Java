package com.binance.client.model.event;

import com.binance.client.constant.BinanceApiConstants;
import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class IndexPriceEvent {

  private String eventType;
  private Long eventTime;
  private String symbol;
  private BigDecimal indexPrice;

  public String getEventType() {
    return eventType;
  }

  public void setEventType(String eventType) {
    this.eventType = eventType;
  }

  public Long getEventTime() {
    return eventTime;
  }

  public void setEventTime(Long eventTime) {
    this.eventTime = eventTime;
  }

  public String getSymbol() {
    return symbol;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  public BigDecimal getIndexPrice() {
    return indexPrice;
  }

  public void setIndexPrice(BigDecimal indexPrice) {
    this.indexPrice = indexPrice;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
        .append("eventType", eventType)
        .append("eventTime", eventTime)
        .append("symbol", symbol)
        .append("indexPrice", indexPrice)
        .toString();
  }
}
