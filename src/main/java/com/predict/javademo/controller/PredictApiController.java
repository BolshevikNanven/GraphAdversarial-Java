package com.predict.javademo.controller;

import com.predict.javademo.entity.Result;
import com.predict.javademo.services.AttackImageService;
import com.predict.javademo.services.PredictImageService;
import com.predict.javademo.utils.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@Controller
@CrossOrigin
@ResponseBody
@RestController
public class PredictApiController {

    @Resource
    AttackImageService attackImageService;

    @Resource
    PredictImageService predictImageService;

    @PostMapping("/predict")
    public Result predict(@RequestParam("img") MultipartFile img,
                          @RequestParam("predictModel") String predictModel,
                          @RequestParam("attackModel") String attackModel) {
        String rootUrl = "C:\\Users\\BolshevikNanven\\Desktop\\scau大创\\images\\";

        String originImageUrl = FileUtils.write(rootUrl, img);
        String originalPredict = predictImageService.predict(originImageUrl, predictModel);

        String attackImageUrl = attackImageService.attack(originImageUrl, attackModel);
        String attackedPredict = predictImageService.predict(attackImageUrl, predictModel);
        String attackedImage = FileUtils.readAsBase64(attackImageUrl);


        FileUtils.delete(originImageUrl);
        FileUtils.delete(attackImageUrl);

        return new Result(originalPredict, attackedPredict, attackedImage);
    }
}
