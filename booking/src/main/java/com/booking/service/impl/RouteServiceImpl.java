package com.booking.service.impl;


import com.booking.entities.Route;
import com.booking.payload.RouteDTO;
import com.booking.repository.RouteRepository;
import com.booking.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Override
    public Route getRouteById(Long id) {
        return routeRepository.findById(id).orElse(null);
    }

    @Override
    public RouteDTO createRoute(RouteDTO routeDTO) {
      Route route= new Route();
        route.setCreatedAt(new Date());
        route.setUpdatedAt(new Date());
      route.setOrigin(routeDTO.getOrigin());
      route.setDestination(routeDTO.getDestination());
      route.setDistance(routeDTO.getDistance());
        Route save = routeRepository.save(route);
        RouteDTO dto= new RouteDTO();
        dto.setId(save.getId());
        dto.setDestination(save.getDestination());
        dto.setDistance(save.getDistance());
        dto.setOrigin(save.getOrigin());
        dto.setUpdatedAt(save.getUpdatedAt());
        dto.setCreatedAt(save.getCreatedAt());
        return dto;
    }
    @Override
    public Route updateRoute(Long id, Route route) {
        Route existingRoute = routeRepository.findById(id).orElse(null);
        if (existingRoute == null) {
            return null;
        }
        existingRoute.setOrigin(route.getOrigin());
        existingRoute.setDestination(route.getDestination());
        existingRoute.setDistance(route.getDistance());
        existingRoute.setUpdatedAt(route.getUpdatedAt());
        return routeRepository.save(existingRoute);
    }

    @Override
    public void deleteRoute(Long id) {
        Route route = routeRepository.findById(id).orElse(null);
        if (route != null) {
            routeRepository.delete(route);
        }
    }
}

