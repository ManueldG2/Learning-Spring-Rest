package it.iagica.learnig_rest.controller;


import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.iagica.learnig_rest.repository.WareHouseRepository;
import it.iagica.learnig_rest.dto.WareHouseDto;
import it.iagica.learnig_rest.entity.WareHouse;
import it.iagica.learnig_rest.service.WareHouseService;
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
	WareHouseService<?, ?> wareHouseService;
	
	@Autowired
	ModelMapper modelMapper;
	
	// lista warehouse
	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public  List<Map<Long, Object>> getAllWarehouses() {		
		
		//return wareHouseRepository.findAll();
		
		//modificare struttura dei dati in json per ora da errore nella validazione null exception
		return wareHouseRepository.selectJoin();
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    private WareHouseDto convertToDto(@PathVariable Long id) {
		
		//sembra vada bene non credo che si possa togliere i campi che danno null 
		List<Map<Long, Object>> warehouse =  wareHouseRepository.selectJoinById(id);
		
		WareHouseDto wareHouseDto = modelMapper.map(warehouse, WareHouseDto.class);
		
		wareHouseDto.setId((Long) warehouse.get(0).get("id"));
		    
		wareHouseDto.setPosition((String) warehouse.get(0).get("position"));
		    
		wareHouseDto.setAmount((Integer) warehouse.get(0).get("quantita_totale"));		
		
		if (Objects.nonNull(warehouse.get(0).get("title"))) {
			
			wareHouseDto.setArticle(  warehouse );
		}			
				    
		return wareHouseDto;
		
    }
	
	//aggiunge warehouse
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<WareHouse> addWareHouse(@RequestParam Map<?, ?> params , HttpServletResponse response) {
						
		WareHouse wareHouse = wareHouseService.toEntity(params);		
		
		return new ResponseEntity<WareHouse>(wareHouseRepository.save(wareHouse), HttpStatus.CREATED);		
				
	}
	
	//aggiunge warehouse
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<WareHouse> addWareHouse(@RequestBody WareHouse wareHouse , HttpServletResponse response) {
							
		wareHouseRepository.save(wareHouse);
			
		return new ResponseEntity<WareHouse>(wareHouseRepository.save(wareHouse), HttpStatus.CREATED);		
					
		}
	
	//aggiornamento con query string per usare il form html
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<WareHouse> updateWareHouse(@RequestParam Map<?, ?> params, HttpServletResponse response) {
						
		WareHouse wh = wareHouseService.toEntity(params);
		
		Long id = ( Long.parseLong((String) params.get("id")) );		
		
		return new ResponseEntity<WareHouse>( wareHouseService.updateWareHouse(wh, id), HttpStatus.OK);		
				
	}
	
	//aggiornamento con json
	@PutMapping("/{id}")// update
	public ResponseEntity<WareHouse> updateWareHouse(@PathVariable Long id, @RequestBody WareHouse wareHouse) {
				
		WareHouse depDB = wareHouseRepository.findById(id).get();
		
		wareHouse.setId(id);
		        
		depDB.setAmount(wareHouse.getAmount());
		depDB.setPosition(wareHouse.getPosition());      
         
        return new ResponseEntity<WareHouse>(wareHouseRepository.save(depDB), HttpStatus.OK);	
		
	}
	
	// cancellazione con json
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<String> deleteWareHouse(@PathVariable Long id , HttpServletResponse response) {
						
		wareHouseService.deleteArticolo(id);
		
		return new ResponseEntity<String>("ok", HttpStatus.OK);		
				
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
		CsvPreference csvPreference = new CsvPreference.Builder('"', ';', "\r\n").build();
        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
                csvPreference);
 
  
        String[] header = { "Position", "Amount"};
        
        csvWriter.writeHeader(header);
 
        for (WareHouse wareHouse : listWareHouse) {
        	
            csvWriter.write( wareHouse, header);
        }
        
        csvWriter.close();
    }
	
	
	// warehouse {id}
	@GetMapping("all/{id}")
	public Optional<WareHouse> getWareHouseById(@PathVariable Long id) {		
			
		return wareHouseRepository.findById(id);					
			
		}
	
	// warehouse {id}
	@GetMapping("/all")
	public Optional<List<WareHouse>> getWareHouse() {		
				
		return Optional.of(wareHouseRepository.findAll());				
				
		}
		
		

}
