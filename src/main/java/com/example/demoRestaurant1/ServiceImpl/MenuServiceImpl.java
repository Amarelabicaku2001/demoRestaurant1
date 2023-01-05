package com.example.demoRestaurant1.ServiceImpl;


import com.example.demoRestaurant1.Dto.UserMDto;
import com.example.demoRestaurant1.exception.NotFound;
import com.example.demoRestaurant1.model.Dish;
import com.example.demoRestaurant1.model.Menu;
import com.example.demoRestaurant1.service.MenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public Menu saveMenu(Menu menu) {
        entityManager.persist(menu);
        return menu;
    }

    @Override
    @Transactional
    public Menu getMenuById(int menuId) {
        Menu response = entityManager.find(Menu.class, menuId);
        if (response == null)
            throw new NotFound("Menu", "menuId", menuId);
        return response;
    }

    ;


    @Override
    public List<Menu> getAllMenus() {
        return entityManager.createQuery("SELECT menus FROM Menu menus")
                .getResultList();
    }

    @Override
    public void deleteMenu(int menuId) {
        Menu response = (Menu) entityManager.find(Menu.class, menuId);
        if (response == null)
            throw new NotFound("Menu", "menuId", menuId);
        entityManager.remove(response);
    }


    @Override
    @Transactional
    public Menu updateMenu(Menu menu) {
        return entityManager.merge(menu);
    }

    @Transactional
    @Override
    public UserMDto createMenuByAdmin(UserMDto userMDto) {
//        User user=entityManager.find(User.class,userMDto.getUser().getUserId());
//        user.setUserId(user.getUserId());
//
//        if(user==null ){
//            throw new RuntimeException("This user doesnt exist or doesnt have dhe role admin");
//        }
        Dish dish=entityManager.find(Dish.class,userMDto.getDish().getDishId());
        userMDto.setDish(dish);
        if(dish==null){
            throw new RuntimeException("dish doesnt exist");
        }
        Menu menu=new Menu();
        mapDtoToEntityM(userMDto,menu);
        entityManager.persist(menu);
        return mapEntiyToDtoM(menu);

    }
    private UserMDto mapEntiyToDtoM(Menu menu) {
        UserMDto userMDto=new UserMDto();
        userMDto.setUser(menu.getUser());
        userMDto.setMenuId(menu.getMenuId());
        userMDto.setDay(menu.getDay());
        userMDto.setDescription(menu.getDescription());
       userMDto.setDish((Dish) menu.getDish());

        return userMDto;    }

    private Menu mapDtoToEntityM(UserMDto userMDto, Menu menu) {
       menu.setUser(userMDto.getUser());
        menu.setMenuId(userMDto.getMenuId());
        menu.setDay(userMDto.getDay());
        menu.setDescription(userMDto.getDescription());
     menu.setDish(menu.getDish());
        return menu;
    }

}


