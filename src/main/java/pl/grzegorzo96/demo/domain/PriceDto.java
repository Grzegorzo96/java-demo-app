package pl.grzegorzo96.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PriceDto {
  private final double amount;
  private final String currency;

  public PriceDto(
      @JsonProperty("amount") double amount, @JsonProperty("currency") String currency) {
    this.amount = amount;
    this.currency = currency;
  }

  public double getAmount() {
    return amount;
  }

  public String getCurrency() {
    return currency;
  }

  @Override
  public String toString() {
    return "PriceDto{" + "amount=" + amount + ", currency='" + currency + '\'' + '}';
  }
}
