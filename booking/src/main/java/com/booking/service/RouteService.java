package com.booking.service;


import com.booking.entities.Route;
import com.booking.payload.RouteDTO;

public interface RouteService {
    Route getRouteById(Long id);
    RouteDTO createRoute(RouteDTO routeDTO);
    Route updateRoute(Long id, Route route);
    void deleteRoute(Long id);
}

