package com.example.demoRestaurant1.Controller;


import com.example.demoRestaurant1.Dto.UserMDto;
import com.example.demoRestaurant1.model.Menu;
import com.example.demoRestaurant1.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)

    public ResponseEntity<Menu> saveMenu(@RequestBody Menu menu) {
        return new ResponseEntity<Menu>(menuService.saveMenu(menu), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/find/{menuId}", method = RequestMethod.GET)

    public ResponseEntity<Menu> getMenuById(@PathVariable int menuId) {


        return new ResponseEntity<Menu>(menuService.getMenuById(menuId), HttpStatus.OK);

    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)

    public ResponseEntity<List<Menu>> getAllMenus() {

        return new ResponseEntity<List<Menu>>(menuService.getAllMenus(), HttpStatus.OK);

    }

    @RequestMapping(value = "/delete/{menuId}", method = RequestMethod.DELETE)

    public ResponseEntity<String> deleteMenu(@PathVariable int menuId) {

        menuService.deleteMenu(menuId);
        return new ResponseEntity<String>("Succes", HttpStatus.OK);

    }

    @RequestMapping(value = "/update/{menuId}", method = RequestMethod.PUT)

    public Menu Update(@PathVariable int menuId, @RequestBody Menu menu) {

        return menuService.updateMenu(menu);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<UserMDto> createMenuByAdmin(@RequestBody UserMDto menuDto) {
        return new ResponseEntity<UserMDto>(menuService.createMenuByAdmin(menuDto), HttpStatus.OK);
    }

}




