package com.ecommerce.domingueti.shopping_api.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ecommerce.domingueti.shopping_api.dto.ShopDTO;
import com.ecommerce.domingueti.shopping_api.model.Shop;
import com.ecommerce.domingueti.shopping_api.repository.ShopRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor 
public class ShopService {
    private final ShopRepository shopRepository;

    public List<ShopDTO> getAll() {
        List<Shop> shops = shopRepository.findAll();
        return shops
            .stream()
            .map(ShopDTO::convert)
            .collect(Collectors.toList());
    }

    public List<ShopDTO> getByUser(String userIdentifier) {
        List<Shop> shops = shopRepository.findAllByUserIdentifier(userIdentifier);
        return shops
            .stream()
            .map(ShopDTO::convert)
            .collect(Collectors.toList());
    }

    public List<ShopDTO> getByDate(ShopDTO shopDtO) {
        List<Shop> shops = shopRepository.findAllByDateGreaterThan(shopDtO.getDate());
        return shops
            .stream()
            .map(ShopDTO::convert)
            .collect(Collectors.toList());
    }

    public ShopDTO findById(long ProductId) {
        Optional<Shop> shop = shopRepository.findById(ProductId);
        if (shop.isPresent()) {
            return ShopDTO.convert(shop.get());
        }
        return null;
    }

    public ShopDTO save(ShopDTO shopDTO) {
        shopDTO.setTotal(
            shopDTO.getItems()
            .stream()
            .map(x -> x.getPrice())
            .reduce((double) 0, Double::sum)
        );

        Shop shop = Shop.convert(shopDTO);
        shop.setDate(new Date());

        shop = shopRepository.save(shop);

        return ShopDTO.convert(shop);
    }
}
