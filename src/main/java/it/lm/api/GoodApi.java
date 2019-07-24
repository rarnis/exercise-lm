/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.7).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package it.lm.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.lm.model.Category;
import it.lm.model.Good;
import it.lm.model.Order;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-07-23T20:20:14.590Z")

@Api(value = "good", description = "the good API")
public interface GoodApi {

    @ApiOperation(value = "Returns good categories", nickname = "getCategories", notes = "Returns defined good categories", response = Category.class, responseContainer = "List", tags={ "category", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Category.class, responseContainer = "List"),
        @ApiResponse(code = 503, message = "Fatal Error") })
    @RequestMapping(value = "/good/category",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Category>> getCategories();


    @ApiOperation(value = "return given goods taxes", nickname = "getTaxes", notes = "", response = Order.class, tags={ "tax", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Order.class),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 503, message = "Fatal Error") })
    @RequestMapping(value = "/good/order",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Order> getTaxes(@ApiParam(value = "good list for taxes computation" ,required=true )  @Valid @RequestBody List<Good> body);

}
