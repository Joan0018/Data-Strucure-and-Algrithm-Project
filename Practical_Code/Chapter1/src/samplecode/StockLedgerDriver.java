package samplecode;import java.util.*;/** * StockLedgerDriver.java A driver that demonstrates the class StockLedger. * * @author Frank M. Carrano * @version 2.0 */public class StockLedgerDriver {  public static void main(String[] args) {    StockLedger myStocks = new StockLedger();    System.out.println("Buy 20 shares @ $45 each.");    System.out.println("Buy 20 shares @ $75 each.");    myStocks.buy(20, 45);    myStocks.buy(20, 75);    System.out.println("\nSell 30 shares @ $65 each at a gain (loss) of $"            + myStocks.sell(30, 65));  // $300    System.out.println("\nSell 10 shares @ $65 each at a gain (loss) of $"            + myStocks.sell(10, 65));  // $300    System.out.println("\n\nBuy 100 shares @ $20 each.");    System.out.println("Buy 20 shares @ $24 each.");    System.out.println("Buy 200 shares @ $36 each.");    myStocks.buy(100, 20);    myStocks.buy(20, 24);    myStocks.buy(200, 36);    System.out.println("\n\nSell 10 shares @ $65 each at a gain (loss) of $"            + myStocks.sell(10, 65));  //  $450    System.out.println("\nSell 150 shares @ $65 each at a gain (loss) of $"            + myStocks.sell(150, 30)); //  $780    System.out.println("\n\nDone.");  }  }  