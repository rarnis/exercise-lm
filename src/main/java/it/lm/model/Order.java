package it.lm.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import it.lm.model.Good;

import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Order
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-07-23T20:20:14.590Z")

public class Order   {
  @JsonProperty("goods")
  @Valid
  private List<Good> goods = null;

  @JsonProperty("taxes")
  private Double taxes = null;

  @JsonProperty("total")
  private Double total = null;

  public Order goods(List<Good> goods) {
    this.goods = goods;
    return this;
  }

  public Order addGoodsItem(Good goodsItem) {
    if (this.goods == null) {
      this.goods = new ArrayList<Good>();
    }
    this.goods.add(goodsItem);
    return this;
  }

  /**
   * goods in order
   * @return goods
  **/
  @ApiModelProperty(value = "goods in order")

  @Valid

  public List<Good> getGoods() {
    return goods;
  }

  public void setGoods(List<Good> goods) {
    this.goods = goods;
  }

  public Order taxes(Double taxes) {
    this.taxes = taxes;
    return this;
  }

  /**
   * total taxes
   * @return taxes
  **/
  @ApiModelProperty(value = "total taxes")


  public Double getTaxes() {
    return taxes;
  }

  public void setTaxes(Double taxes) {
    this.taxes = taxes;
  }

  public Order total(Double total) {
    this.total = total;
    return this;
  }

  /**
   * total amount
   * @return total
  **/
  @ApiModelProperty(value = "total amount")


  public Double getTotal() {
    return total;
  }

  public void setTotal(Double total) {
    this.total = total;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Order order = (Order) o;
    return Objects.equals(this.goods, order.goods) &&
        Objects.equals(this.taxes, order.taxes) &&
        Objects.equals(this.total, order.total);
  }

  @Override
  public int hashCode() {
    return Objects.hash(goods, taxes, total);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Order {\n");
    
    sb.append("    goods: ").append(toIndentedString(goods)).append("\n");
    sb.append("    taxes: ").append(toIndentedString(taxes)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

