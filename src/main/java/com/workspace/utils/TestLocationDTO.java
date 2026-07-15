package com.workspace.utils;

import com.workspace.dto.LocationDTO;

public class TestLocationDTO
{
    public static void main(String[] args)
    {
        LocationDTO location =
                new LocationDTO(1, "Bangalore", "India");

        System.out.println(location);

        location.setCountry("USA");

        System.out.println(location);

       // System.out.println(location.getLocationName());
        
       // System.out.println(location.getCountry());
    }
}