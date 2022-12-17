package com.binar.chapter5.controller;

import com.binar.chapter5.model.response.FilmsResponse;
import com.binar.chapter5.service.FilmsServiceImpl;
import com.binar.chapter5.service.InvoiceService;
import com.binar.chapter5.service.UsersServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @Operation(summary = "show generated invoice")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "request success",
                    content = @Content(mediaType = "application/pdf"))
    })
    @GetMapping("/get_invoice")
    public ResponseEntity getInvoice(HttpServletResponse response) {
        try {
            invoiceService.generateInvoice(response);
            return ResponseEntity.status(HttpStatus.OK).body("show success (CODE 200)");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("failed to show (CODE 502), caused by : " + e.getMessage());
        }
    }
}
