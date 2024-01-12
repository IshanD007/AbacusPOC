package com.vodafone.uc1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vodafone.uc1.domain.Operator;
import com.vodafone.uc1.dto.OperatorDto;
import com.vodafone.uc1.service.OperatorService;

@RestController(value = "Operator")
@RequestMapping("/api/operators")
public class OperatorController {
	@Autowired
    private OperatorService operatorService;

    @GetMapping("/{operatorId}")
    public ResponseEntity<Operator> findOperatorById(@PathVariable("operatorId") int operatorId) {
        Operator operator = operatorService.findByOperatorId(operatorId);

        return new ResponseEntity<>(operator,HttpStatus.OK);
    }
    
    @PostMapping("/addOperator")
    public ResponseEntity<Operator> addOperator(@RequestBody OperatorDto operatorDto) {
        Operator operator = operatorService.add(operatorDto);

        return new ResponseEntity<>(operator, HttpStatus.CREATED);
    }
    
    @GetMapping("/findOperators")
    public ResponseEntity<List<Operator>> findOperatorList() {
    	List<Operator> operatorList = operatorService.findAll();

        return new ResponseEntity<>(operatorList,HttpStatus.OK);
    }
    
    @DeleteMapping("/deleteOperator/{operatorId}")
    public ResponseEntity<String> deleteById(@PathVariable("operatorId") int operatorId) {
    	operatorService.deleteOperator(operatorId);;

        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }
    
    @PutMapping("/updateOperator")
    public ResponseEntity<Operator> updateOperator(@RequestBody OperatorDto operatorDto) {
    	Operator operator = operatorService.update(operatorDto);

        return new ResponseEntity<>(operator, HttpStatus.ACCEPTED);
    }
}
