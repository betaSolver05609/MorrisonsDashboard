package com.MorrisonsDashboard.SalesOrder.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class SalesOrderService {
	@Autowired
	private ServiceInstance instance;
	@Autowired
	private LoadBalancerClient DC;
	
	private String filePath="C:\\Users\\Dell inspiron\\Desktop\\Machine Learning A-Z Template Folder\\Part 1 - Data Preprocessing\\Data.csv";
	public List<String[]> getData()throws IOException
	{
		try {
			System.out.println("I am here");
			FileReader fileReader=new FileReader(filePath);
			CSVReader csvReader=new CSVReaderBuilder(fileReader).withSkipLines(1).build();
			List<String[]> allData=csvReader.readAll();
			System.out.println(allData);
			return allData;
			
		}catch(Exception e)
		{
			return null;
		}
	}
}
