package com.MorrisonsDashboard.SalesOrder.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.MorrisonsDashboard.SalesOrder.Service.SalesOrderService;

@CrossOrigin(origins="*")
@RestController
public class SalesOrderController {
	private SalesOrderService salesOrderService=new SalesOrderService();
	@RequestMapping(value="/salesOrderData", method=RequestMethod.GET)
	public ResponseEntity<List<String[]>> getData()
	{
		ResponseEntity<List<String[]>> res=null;
		try {
			System.out.println(salesOrderService);
			List<String[]> temp=salesOrderService.getData();
			res=new ResponseEntity<List<String[]>>(temp, HttpStatus.OK);
			return res;
		} catch (IOException e) {
			e.printStackTrace();
			return res;
		}
		
	}

}
