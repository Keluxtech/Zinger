package com.food.ordering.zinger.service.impl;

import com.food.ordering.zinger.dao.impl.ShopDaoImpl;
import com.food.ordering.zinger.dao.interfaces.ShopDao;
import com.food.ordering.zinger.model.ConfigurationModel;
import com.food.ordering.zinger.model.RequestHeaderModel;
import com.food.ordering.zinger.model.Response;
import com.food.ordering.zinger.model.ShopConfigurationModel;
import com.food.ordering.zinger.service.interfaces.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    ShopDao shopDao;

    @Override
    public Response<String> insertShop(ConfigurationModel configurationModel, String oauthId, Integer id, String role) {
        RequestHeaderModel requestHeaderModel = new RequestHeaderModel(oauthId, id, role);
        return shopDao.insertShop(configurationModel, requestHeaderModel);
    }

    @Override
    public Response<List<ShopConfigurationModel>> getShopByPlaceId(Integer placeId, String oauthId, Integer id, String role) {
        RequestHeaderModel requestHeaderModel = new RequestHeaderModel(oauthId, id, role);
        return shopDao.getShopsByPlaceId(placeId, requestHeaderModel);
    }

    @Override
    public Response<String> updateShopConfiguration(ConfigurationModel configurationModel, String oauthId, Integer id, String role) {
        RequestHeaderModel requestHeaderModel = new RequestHeaderModel(oauthId, id, role);
        return shopDao.updateShopConfigurationModel(configurationModel, requestHeaderModel);
    }
}