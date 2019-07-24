package it.lm.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Good
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-07-23T20:20:14.590Z")

public class Good   {
  @JsonProperty("categoryId")
  private Integer categoryId = null;

  @JsonProperty("quantity")
  private Integer quantity = null;

  @JsonProperty("price")
  private Double price = null;

  @JsonProperty("imported")
  private Boolean imported = false;

  public Good categoryId(Integer categoryId) {
    this.categoryId = categoryId;
    return this;
  }

  /**
   * category type id (as in good/category endpoint)
   * @return categoryId
  **/
  @ApiModelProperty(value = "category type id (as in good/category endpoint)")


  public Integer getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
  }

  public Good quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

  /**
   * good quantity
   * @return quantity
  **/
  @ApiModelProperty(value = "good quantity")


  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Good price(Double price) {
    this.price = price;
    return this;
  }

  /**
   * single item price
   * @return price
  **/
  @ApiModelProperty(value = "single item price")


  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Good imported(Boolean imported) {
    this.imported = imported;
    return this;
  }

  /**
   * imported flag
   * @return imported
  **/
  @ApiModelProperty(value = "imported flag")


  public Boolean isImported() {
    return imported;
  }

  public void setImported(Boolean imported) {
    this.imported = imported;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Good good = (Good) o;
    return Objects.equals(this.categoryId, good.categoryId) &&
        Objects.equals(this.quantity, good.quantity) &&
        Objects.equals(this.price, good.price) &&
        Objects.equals(this.imported, good.imported);
  }

  @Override
  public int hashCode() {
    return Objects.hash(categoryId, quantity, price, imported);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Good {\n");
    
    sb.append("    categoryId: ").append(toIndentedString(categoryId)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    imported: ").append(toIndentedString(imported)).append("\n");
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

