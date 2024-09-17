package it.iagica.learnig_rest.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.iagica.learnig_rest.repository.ArticleRepository;
import it.iagica.learnig_rest.repository.WareHouseRepository;


import it.iagica.learnig_rest.entity.Article;
import it.iagica.learnig_rest.entity.WareHouse;
import it.iagica.learnig_rest.service.ArticleService;
import it.iagica.learnig_rest.service.WareHouseService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;



@RestController
@RequestMapping("/api/warehouse")

public class WarehouseController {
	
	@Autowired
	WareHouseRepository wareHouseRepository;
	
	@Autowired
	WareHouseService wareHouseService;

	
	// lista warehouse
	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public  List<Map<Long,Object>> getAllWarehouses() {		
		
		//return wareHouseRepository.findAll();
		return wareHouseRepository.selectJoin();
		
	}
	
	// warehouse {id}
	@GetMapping("/{id}")
	public Optional<List<Map<Long, Object>>> getWareHouseById(@PathVariable Long id) {		
		
		//return wareHouseRepository.findById(id);
		return Optional.of(wareHouseRepository.selectJoinById(id));
		
	}
	
	//aggiunge warehouse
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<WareHouse> addWareHouse(@RequestParam Map params , HttpServletResponse response) {
						
		WareHouse wareHouse = wareHouseService.toEntity(params);
		
		wareHouseRepository.save(wareHouse);
		
		return new ResponseEntity("ok", HttpStatus.CREATED);		
				
	}
	
	//aggiornamento con query string per usare il form html
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<WareHouse> updateWareHouse(@RequestParam Map params, HttpServletResponse response) {
						
		WareHouse wh = wareHouseService.toEntity(params);
		
		Long id = ( Long.parseLong((String) params.get("id")) );		
		
		return new ResponseEntity( wareHouseService.updateWareHouse(wh, id), HttpStatus.OK);		
				
	}
	
	//aggiornamento con json
	@PutMapping("/{id}")// update
	public ResponseEntity<WareHouse> updateWareHouse(@PathVariable Long id, @RequestBody Article articolo) {
		
		
		System.out.println(articolo.toString() + "" +  id);
		
		WareHouse depDB = wareHouseRepository.findById(id).get();
        
         wareHouseRepository.save(depDB);
         
         return new ResponseEntity<WareHouse>(wareHouseRepository.save(depDB), HttpStatus.OK);	
		
	}
	
	// cancellazione con json
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity deleteWareHouse(@PathVariable Long id , HttpServletResponse response) {
						
		wareHouseService.deleteArticolo(id);
		
		return new ResponseEntity("ok", HttpStatus.OK);		
				
	}
	
	@RequestMapping(value = "/csv")
    public void downloadCSV(HttpServletResponse response) throws IOException {
 
        String csvFileName = "warehouse.csv";
 
        response.setContentType("text/csv");
 
        // creates mock data
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",
                csvFileName);
        response.setHeader(headerKey, headerValue);
 
        List<WareHouse> listWareHouse;
		listWareHouse = wareHouseRepository.findAll();
		
        // uses the Super CSV API to generate CSV data from the model data
		CsvPreference csvPreference = new CsvPreference.Builder('"', ':', "\r\n").build();
        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
                csvPreference);
 
  
        String[] header = { "Position"};
        
        csvWriter.writeHeader(header);
 
        for (WareHouse wareHouse : listWareHouse) {
        	
            csvWriter.write( wareHouse, header);
        }
        
        csvWriter.close();
    }
	
		

}
