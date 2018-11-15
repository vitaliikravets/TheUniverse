package com.alexaskill.service;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;

public class EnvironmentService {
    public Region getAwsRegion(){
        return Region.getRegion(Regions.fromName(System.getenv("AWS_REGION")));
    }
}
