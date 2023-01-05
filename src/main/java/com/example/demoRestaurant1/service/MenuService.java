package com.example.demoRestaurant1.service;


import com.example.demoRestaurant1.Dto.UserMDto;
import com.example.demoRestaurant1.model.Menu;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public interface MenuService {


        public Menu saveMenu(Menu menu);
        public Menu getMenuById(int menuId);
        public List<Menu> getAllMenus();
        public void deleteMenu(int menuId);
        public Menu updateMenu(Menu menu);



        UserMDto createMenuByAdmin(UserMDto userMDto);
}


