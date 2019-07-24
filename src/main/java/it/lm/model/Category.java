package it.lm.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Category
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-07-23T20:20:14.590Z")

@Entity
public class Category   {
  @JsonProperty("id")
  @Id
  private Integer id = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("taxRate")
  private Double taxRate = null;

  @JsonProperty("importTaxRate")
  private Double importTaxRate = null;

  public Category id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * type category identifier
   * @return id
  **/
  @ApiModelProperty(value = "type category identifier")


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Category description(String description) {
    this.description = description;
    return this;
  }

  /**
   * category description (ie food, general good)
   * @return description
  **/
  @ApiModelProperty(value = "category description (ie food, general good)")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Category taxRate(Double taxRate) {
    this.taxRate = taxRate;
    return this;
  }

  /**
   * tax rate applied to the category
   * @return taxRate
  **/
  @ApiModelProperty(value = "tax rate applied to the category")


  public Double getTaxRate() {
    return taxRate;
  }

  public void setTaxRate(Double taxRate) {
    this.taxRate = taxRate;
  }

  public Category importTaxRate(Double importTaxRate) {
    this.importTaxRate = importTaxRate;
    return this;
  }

  /**
   * import tax rate applied to the category
   * @return importTaxRate
  **/
  @ApiModelProperty(value = "import tax rate applied to the category")


  public Double getImportTaxRate() {
    return importTaxRate;
  }

  public void setImportTaxRate(Double importTaxRate) {
    this.importTaxRate = importTaxRate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Category category = (Category) o;
    return Objects.equals(this.id, category.id) &&
        Objects.equals(this.description, category.description) &&
        Objects.equals(this.taxRate, category.taxRate) &&
        Objects.equals(this.importTaxRate, category.importTaxRate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, description, taxRate, importTaxRate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Category {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    taxRate: ").append(toIndentedString(taxRate)).append("\n");
    sb.append("    importTaxRate: ").append(toIndentedString(importTaxRate)).append("\n");
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

