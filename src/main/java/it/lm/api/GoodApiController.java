package it.lm.api;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;
import it.lm.model.Category;
import it.lm.model.Good;
import it.lm.model.Order;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-07-23T20:20:14.590Z")

@Controller
public class GoodApiController implements GoodApi {

    private static final Logger log = LoggerFactory.getLogger(GoodApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public GoodApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<Category>> getCategories() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Category>>(objectMapper.readValue("[ {  \"taxRate\" : 6.027456183070403,  \"description\" : \"description\",  \"importTaxRate\" : 1.4658129805029452,  \"id\" : 0}, {  \"taxRate\" : 6.027456183070403,  \"description\" : \"description\",  \"importTaxRate\" : 1.4658129805029452,  \"id\" : 0} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Category>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Category>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Order> getTaxes(@ApiParam(value = "good list for taxes computation" ,required=true )  @Valid @RequestBody List<Good> body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Order>(objectMapper.readValue("{  \"total\" : 5.637376656633329,  \"goods\" : [ {    \"quantity\" : 6,    \"price\" : 1.4658129805029452,    \"imported\" : false,    \"categoryId\" : 0  }, {    \"quantity\" : 6,    \"price\" : 1.4658129805029452,    \"imported\" : false,    \"categoryId\" : 0  } ],  \"taxes\" : 5.962133916683182}", Order.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Order>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Order>(HttpStatus.NOT_IMPLEMENTED);
    }

}
