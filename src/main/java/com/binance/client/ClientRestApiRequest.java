package com.binance.client;

import com.alibaba.fastjson.JSONObject;
import com.binance.client.impl.RestApiRequest;
import com.binance.client.model.ResponseResult;
import com.binance.client.model.enums.*;
import com.binance.client.model.market.*;
import com.binance.client.model.trade.*;

import java.util.List;

public interface ClientRestApiRequest {

  RestApiRequest<ExchangeInformation> getExchangeInformation();

  RestApiRequest<OrderBook> getOrderBook(String symbol, Integer limit);

  RestApiRequest<List<Trade>> getRecentTrades(String symbol, Integer limit);

  RestApiRequest<List<Trade>> getOldTrades(String symbol, Integer limit, Long fromId);

  RestApiRequest<List<AggregateTrade>> getAggregateTrades(
      String symbol, Long fromId, Long startTime, Long endTime, Integer limit);

  RestApiRequest<List<Candlestick>> getCandlestick(
      String symbol, CandlestickInterval interval, Long startTime, Long endTime, Integer limit);

  RestApiRequest<List<MarkPrice>> getMarkPrice(String symbol);

  RestApiRequest<List<FundingRate>> getFundingRate(
      String symbol, Long startTime, Long endTime, Integer limit);

  RestApiRequest<List<PriceChangeTicker>> get24hrTickerPriceChange(String symbol);

  RestApiRequest<List<SymbolPrice>> getSymbolPriceTicker(String symbol);

  RestApiRequest<List<SymbolOrderBook>> getSymbolOrderBookTicker(String symbol);

  RestApiRequest<List<LiquidationOrder>> getLiquidationOrders(
      String symbol, Long startTime, Long endTime, Integer limit);

  RestApiRequest<List<Object>> postBatchOrders(String batchOrders);

  RestApiRequest<Order> postOrder(
      String symbol,
      OrderSide side,
      PositionSide positionSide,
      OrderType orderType,
      TimeInForce timeInForce,
      String quantity,
      String price,
      String reduceOnly,
      String newClientOrderId,
      String stopPrice,
      WorkingType workingType,
      NewOrderRespType newOrderRespType);

  RestApiRequest<ResponseResult> changePositionSide(boolean dual);

  RestApiRequest<ResponseResult> changeMarginType(String symbolName, String marginType);

  RestApiRequest<JSONObject> addPositionMargin(
      String symbolName, int type, String amount, PositionSide positionSide);

  RestApiRequest<List<WalletDeltaLog>> getPositionMarginHistory(
      String symbolName, int type, long startTime, long endTime, int limit);

  RestApiRequest<JSONObject> getPositionSide();

  RestApiRequest<Order> cancelOrder(String symbol, Long orderId, String origClientOrderId);

  RestApiRequest<ResponseResult> cancelAllOpenOrder(String symbol);

  RestApiRequest<List<Object>> batchCancelOrders(
      String symbol, String orderIdList, String origClientOrderIdList);

  RestApiRequest<Order> getOrder(String symbol, Long orderId, String origClientOrderId);

  RestApiRequest<List<Order>> getOpenOrders(String symbol);

  RestApiRequest<List<Order>> getAllOrders(
      String symbol, Long orderId, Long startTime, Long endTime, Integer limit);

  RestApiRequest<List<AccountBalance>> getBalance();

  RestApiRequest<AccountInformation> getAccountInformation();

  RestApiRequest<Leverage> changeInitialLeverage(String symbol, Integer leverage);

  RestApiRequest<List<PositionRisk>> getPositionRisk(String symbol);

  RestApiRequest<List<MyTrade>> getAccountTrades(
      String symbol, Long startTime, Long endTime, Long fromId, Integer limit);

  RestApiRequest<List<Income>> getIncomeHistory(
      String symbol, IncomeType incomeType, Long startTime, Long endTime, Integer limit);

  RestApiRequest<String> startUserDataStream();

  RestApiRequest<String> keepUserDataStream(String listenKey);

  RestApiRequest<String> closeUserDataStream(String listenKey);

  RestApiRequest<List<OpenInterestStat>> getOpenInterestStat(
      String symbol, PeriodType period, Long startTime, Long endTime, Integer limit);

  RestApiRequest<List<CommonLongShortRatio>> getTopTraderAccountRatio(
      String symbol, PeriodType period, Long startTime, Long endTime, Integer limit);

  RestApiRequest<List<CommonLongShortRatio>> getTopTraderPositionRatio(
      String symbol, PeriodType period, Long startTime, Long endTime, Integer limit);

  RestApiRequest<List<CommonLongShortRatio>> getGlobalAccountRatio(
      String symbol, PeriodType period, Long startTime, Long endTime, Integer limit);

  RestApiRequest<List<TakerLongShortStat>> getTakerLongShortRatio(
      String symbol, PeriodType period, Long startTime, Long endTime, Integer limit);
}
