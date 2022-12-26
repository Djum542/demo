public class Stockview {
    private Stockview sview = new Stockview();
    public void onModuleLoads() {
        // Create table for stock data.
        stocksFlexTable.setText(0, 0, "Symbol");
        stocksFlexTable.setText(0, 1, "Price");
        stocksFlexTable.setText(0, 2, "Change");
        stocksFlexTable.setText(0, 3, "Remove");
        stocksFlexTable.getRowFormatter().addStyleName(0, "watchListHeader");
        stocksFlexTable.addStyleName("watchList");
        stocksFlexTable.getRowFormatter().addStyleName(0, "watchListHeader");
stocksFlexTable.addStyleName("watchList");
stocksFlexTable.getCellFormatter().addStyleName(0, 1, "watchListNumericColumn");
stocksFlexTable.getCellFormatter().addStyleName(0, 2, "watchListNumericColumn");
stocksFlexTable.getCellFormatter().addStyleName(0, 3, "watchListRemoveColumn");
        // Add styles to elements in the stock list table.
        stocksFlexTable.getRowFormatter().addStyleName(0, "watchListHeader");
    newSymbolTextBox.setFocus(true);
    Timer refresherTimer = new Timer(){
        public void run(){
            refresherTimer();
        }
    };
    refresherTimer.scheduleRepeating(REFRESH_INTERVAL);
}
private void updateTable(StockPrice[] prices) {
    // TODO Auto-generated method stub
  for (int i = 0; i < prices.length; i++) {
        updateTable(prices[i]);
         // Make sure the stock is still in the stock table.
 if (!stocks.contains(price.getSymbol())) {
    return;
  }

  int row = stocks.indexOf(price.getSymbol()) + 1;

  // Format the data in the Price and Change fields.
  String priceText = NumberFormat.getFormat("#,##0.00").format(
      price.getPrice());
  NumberFormat changeFormat = NumberFormat.getFormat("+#,##0.00;-#,##0.00");
  String changeText = changeFormat.format(price.getChange());
  String changePercentText = changeFormat.format(price.getChangePercent());

  // Populate the Price and Change fields with new data.
  stocksFlexTable.setText(row, 1, priceText);
  stocksFlexTable.setText(row, 2, changeText + " (" + changePercentText
      + "%)");
      // Display timestamp showing last refresh.
  DateTimeFormat dateFormat = DateTimeFormat.getFormat(
    DateTimeFormat.PredefinedFormat.DATE_TIME_MEDIUM);
  lastUpdatedLabel.setText("Last update : " 
    + dateFormat.format(new Date()));
//        String changePercentText = changeFormat.format(price.getChangePercent());
    stocksFlexTable.setText(row, 1, priceText);
  }
}
}
