package com.example.demoRestaurant1.service;


import com.example.demoRestaurant1.Dto.BillDto;
import com.example.demoRestaurant1.model.Bill;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public interface BillService {
    public Bill saveBill(Bill bill);
    public Bill getBillById(int billId);
    public void deleteBill(int billId);
    public Bill updateBill(Bill bill);


    BillDto createBillByWaiter(BillDto billDto);
}
