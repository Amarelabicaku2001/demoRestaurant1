package com.example.demoRestaurant1.Controller;


import com.example.demoRestaurant1.Dto.BillDto;
import com.example.demoRestaurant1.model.Bill;
import com.example.demoRestaurant1.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "bill")
public class BillController {
    @Autowired
    private BillService billService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)

    public ResponseEntity<Bill> saveBill(@RequestBody Bill bill) {

        return new ResponseEntity<Bill>(billService.saveBill(bill), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/find/{billId}", method = RequestMethod.GET)

    public ResponseEntity<Bill> getBillById(@PathVariable int billId) {


        return new ResponseEntity<Bill>(billService.getBillById(billId), HttpStatus.OK);

    }


    @RequestMapping(value = "/delete/{billId}", method = RequestMethod.DELETE)

    public ResponseEntity<String> deleteBill(@PathVariable int billId) {

        billService.deleteBill(billId);
        return new ResponseEntity<String>("Succes", HttpStatus.OK);

    }

    @RequestMapping(value = "/update/{billId}", method = RequestMethod.PUT)

    public ResponseEntity<Bill> update(@PathVariable int billId, @RequestBody Bill bill) {

        return new ResponseEntity<Bill>(billService.updateBill(bill), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)

    public ResponseEntity<BillDto> createBill(@RequestBody BillDto billDto) {

        return new ResponseEntity<BillDto>(billService.createBillByWaiter(billDto), HttpStatus.CREATED);
    }
}





