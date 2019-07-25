package it.lm.api;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;
import it.lm.model.Category;
import it.lm.model.Good;
import it.lm.model.Order;
import it.lm.service.CategoryService;
import it.lm.service.TaxService;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-07-23T20:20:14.590Z")

@Controller
public class GoodApiController implements GoodApi {

    private static final Logger log = LoggerFactory.getLogger(GoodApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    @Autowired
    private CategoryService cs;
    
    @Autowired
    private TaxService ts;

    @org.springframework.beans.factory.annotation.Autowired
    public GoodApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<Category>> getCategories() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
            	List<Category> data = (List<Category>) cs.findAll();
            	if(data==null || data.isEmpty())
            		return new ResponseEntity<List<Category>>(HttpStatus.NOT_FOUND);
            	else
            		return new ResponseEntity<List<Category>>(data, HttpStatus.OK);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                return new ResponseEntity<List<Category>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Category>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Order> getTaxes(@ApiParam(value = "good list for taxes computation" ,required=true )  @Valid @RequestBody List<Good> body, BindingResult errors) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
            	
            	GoodValidator validator = new GoodValidator(cs.findAll());
            	validator.validate(body, errors);
            	
            	if(errors.hasErrors()) {
            		log.warn("Validation Errors: "+errors);
            		return new ResponseEntity<Order>(HttpStatus.BAD_REQUEST);
            	}
            	
            	Order o = ts.buildOrder(body);
            	
                return new ResponseEntity<Order>(o,HttpStatus.OK);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                return new ResponseEntity<Order>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Order>(HttpStatus.NOT_IMPLEMENTED);
    }

}
