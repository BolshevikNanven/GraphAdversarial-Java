package com.predict.javademo.services;

import com.predict.javademo.utils.PythonUtils;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class AttackImageService {
    private final String PYTHON_URL="C:\\Users\\BolshevikNanven\\Desktop\\scau大创\\NeuralNetworks_Attack-main\\";

    private final Map<String,String> attackModel=new HashMap<>(){{
        put("CW","CW\\AttackCW_tojpg");
        put("PGD","PGD\\AttackPGD_tojpg");
    }};

    public String attack(String originImageUrl,String model){
        String attackedImage= PythonUtils.run(PYTHON_URL,originImageUrl,attackModel.get(model));

        return attackedImage;
    }

}
