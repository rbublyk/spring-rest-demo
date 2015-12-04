package com.dataart.rbublyk.controller;

import com.dataart.rbublyk.domain.AccountStatus;
import com.dataart.rbublyk.service.AccountStatusService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.UUID;

@RestController
@RequestMapping(value = "/accounts/status")
@Api(value = "Admin API", description = "Administrative operations")
public class AccountStatusController {

    @Inject
    private AccountStatusService accountStatusService;

    @RequestMapping(value = "{accountId}", method = RequestMethod.GET)
    @ApiOperation(value = "Account status", notes = "Account status and limits. The information should be cached for X minutes (clarify exact expiration value)")
    public ResponseEntity<?> get(@PathVariable UUID accountId){
        return new ResponseEntity<>(accountStatusService.findOneByAccountId(accountId), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(accountStatusService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody AccountStatus status){
        accountStatusService.save(status);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{accountStatusId}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody AccountStatus status, @PathVariable int accountStatusId){
        accountStatusService.update(status, accountStatusId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{accountStatusId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable int accountStatusId){
        accountStatusService.delete(accountStatusId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
