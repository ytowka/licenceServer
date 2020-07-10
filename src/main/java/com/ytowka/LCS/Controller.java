package com.ytowka.LCS;

import com.ytowka.LCS.responses.LicenceCheckResponse;
import com.ytowka.LCS.responses.LicenceRegisterResponse;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    public static LicenceCheckerServerApplication main;
    @PostMapping("/register")
    public LicenceRegisterResponse register(@RequestBody Config cfg){
        LicenceRegisterResponse response = new LicenceRegisterResponse();
        if(main.availableLicences.contains(cfg.key)){
            main.availableLicences.remove(cfg.key);
            main.licenses.put(cfg.key,cfg.signature);
            response.status = 0;
        }else{
            response.status = 1;
        }
        System.out.println("\n --registration-- \n config:\nkey: "+cfg.key+"\n signature: "+cfg.signature+"\n result: "+response.status);
        return response;
    }
    @PostMapping("/checkLicence")
    public LicenceCheckResponse check(@RequestBody Config cfg){
        LicenceCheckResponse response = new LicenceCheckResponse();
        if(main.licenses.containsKey(cfg.key)){
            if(main.licenses.get(cfg.key).equals(cfg.signature)){
                response.status = 0;
            }else{
                response.status = 2;
            }
        }else{
            response.status = 1;
        }
        System.out.println("\n --check-- \n config:\nkey: "+cfg.key+"\nsignature: "+cfg.signature+"\nresult: "+response.status);
        return response;
    }
}
