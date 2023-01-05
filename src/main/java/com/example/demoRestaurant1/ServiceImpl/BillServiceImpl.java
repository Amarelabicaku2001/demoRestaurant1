package com.example.demoRestaurant1.ServiceImpl;


import com.example.demoRestaurant1.Dto.BillDto;
import com.example.demoRestaurant1.exception.NotFound;
import com.example.demoRestaurant1.model.Bill;
import com.example.demoRestaurant1.model.Order;
import com.example.demoRestaurant1.service.BillService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class BillServiceImpl implements BillService {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public Bill saveBill(Bill bill) {

        entityManager.persist(bill);
        return  bill;
    }

    @Override
    public Bill getBillById(int billId) {
        Bill bill=(Bill) entityManager.find(Bill.class,billId) ;
        if(bill==null)
            throw new NotFound("Bill","billId",billId);
        return bill;
    }

    @Override
    public void deleteBill(int billId) {
        Bill bill=(Bill) entityManager.find(Bill.class,billId) ;
        if(bill==null)
            throw new NotFound("Bill","billId",billId);
        entityManager.remove(bill);
    }

    @Override
    public Bill updateBill(Bill bill) {
        return entityManager.merge(bill);
    }

    @Override
    @Transactional
    public BillDto createBillByWaiter(BillDto billDto) {

       Order order = entityManager.find(Order.class, billDto.getOrder().getOrderId());
        billDto.setOrder(order);
        if (order == null) {
            throw new RuntimeException("order not found");
        }
      Bill bill=new Bill();
        mapDtoToEntity(billDto, bill);
        entityManager.persist(bill);
        return mapEntiyToDto(bill);
    }

    private BillDto mapEntiyToDto(Bill bill) {
        BillDto billDto=new BillDto();
       billDto.setBillId(bill.getBillId());
       billDto.setName(bill.getName());
       billDto.setDate(bill.getDate());
       billDto.setTotalPrice(bill.getTotalPrice());
       billDto.setOrder(bill.getOrder());
        return billDto;
    }

    private Bill mapDtoToEntity(BillDto billDto, Bill bill) {
        bill.setBillId(billDto.getBillId());
        bill.setName(billDto.getName());
        bill.setDate(billDto.getDate());
        bill.setTotalPrice(billDto.getTotalPrice());
        bill.setOrder(billDto.getOrder());
        return bill;
    }
}


